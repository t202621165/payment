package com.cypay.pay.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.cypay.common.entity.Gallery;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Order;
import com.cypay.common.repository.impl.OrderRepository;
import com.cypay.common.service.impl.GroupService;
import com.cypay.common.service.impl.ReissueRecordService;
import com.cypay.common.service.impl.SystemSetService;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.DUtil;
import com.cypay.common.util.SnowflakeIdWorker;
import com.cypay.common.vo.PartitionVo;
import com.cypay.common.vo.ReissueRecordVo;
import com.cypay.common.vo.Result;
import com.cypay.pay.factory.GatewayFactory;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.payment.BasePayment;
import com.cypay.pay.vo.NoticeVo;
import com.cypay.pay.vo.NotifyVo;
import com.cypay.pay.vo.OrderVo;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;

@Service
public class RechargeService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	protected ApplicationContext applicationContext;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ReissueRecordService reissueRecordService;
	
	@Autowired
	private SystemSetService systemSetService;
	
	@Autowired
	private GatewayFactory gatewayFactory;
	
	@Autowired
	private SnowflakeIdWorker snowflakeIdWorker;
	
	@Autowired
	private GroupService groupService;
	
	/**
	 * 充值
	 * @param order
	 * @param recharge
	 * @param request
	 * @return
	 */
	@Transactional
	public Resultful recharge(OrderVo vo, PartitionVo partition, RechargeVo recharge, HttpServletRequest request) {
		// 创建订单
		Order order = vo.createOrder();	
		order.setGroupId(vo.getGuid() == null ? null : groupService.findByUuid(vo.getGuid()));
		order.setPlayerIp(CommonUtil.getIpAddr(request));
		order.setPartition(partition);
		order.setGallery(new Gallery(recharge.getGalleryId()));
		order.setMerchant(partition.getMerchant());
		order.setAgent(partition.getMerchant().getParent());
		order.setOrderNumber("C".concat(DUtil.format("yy")).concat(String.valueOf(snowflakeIdWorker.nextId())));
		order.setDiscription(partition.getName());
		if (systemSetService.findIsOpenTailAmount()){
			String scope = String.format("%.2f",systemSetService.findTailAmountScope());
			order.setTailAmount(CommonUtil.tailAmount(scope));
		}
		
		// 通道标识
		String galleryMark = recharge.getGalleryMark();
		// 订单金额
		recharge.setAmount(order.getAmount().add(order.getTailAmount()));
		// 订单号
		recharge.setOrderNumber(order.getOrderNumber());
		// 接口异步通知URL
		recharge.setNotifyUrl(CommonUtil.getBufferString(
				CommonUtil.getRequestDomain(request), "/pay/notify/", galleryMark));
		// 接口同步跳转URL
		recharge.setReturnUrl(CommonUtil.getBufferString(
				CommonUtil.getRequestDomain(request), "/pay/return/", galleryMark));
		// 客户端IP
		recharge.setClientIp(order.getPlayerIp());
		
		//当前请求域名
		recharge.setCurrentReqUrl(CommonUtil.getBufferString(CommonUtil.getRequestDomain(request)));
		
		// 根据通道标识获取对应支付接口-提交下单
		try {

			BasePayment payment = gatewayFactory.createPaymentInstance(galleryMark);
			
			orderRepository.save(order);
			logger.info(String.format("【%s--%s】：%s", recharge.getProductName(), galleryMark, order.getOrderNumber()));
			Resultful result = payment.placeOnOrder(recharge);
			if (result.isState()) {
				return result;
			}
			throw new RuntimeException(result.getMsg());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * 接口通知
	 * @param request
	 * @param response
	 * @param _gateway_type_
	 * 			接口类型
	 * @param type
	 * 			0：异步通知 1：同步跳转
	 * @return
	 */
	public NoticeVo gatewayNotice(HttpServletRequest request, HttpServletResponse response, String _gateway_type_, Integer type) {
		try {
			BaseNotice notify = gatewayFactory.createNotifyInstance(_gateway_type_);
			logger.info(String.format("【接口通知_%s】：%s", type, _gateway_type_));
			NoticeVo notice = notify.notice(request, response, type);
			
			if (notice != null) {
				
				if (notice.getIsRedirect()) {
					return notice;
				}
				
				NotifyVo notifyVo = (NotifyVo) notice;
				Integer result = -1;
				try {
					result = transactionTemplate.execute(new TransactionCallback<Integer>() {
						
						@Override
						public Integer doInTransaction(TransactionStatus arg0) {
							logger.info("【" + notifyVo.getOrderNumber() + "】更新订单信息和商户账户余额。");
							return orderService.updateOrderAndBankOverMoney(notifyVo);
						}
					});
					
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				
				response.getWriter().print(result == -1 ? "FAILED" : notifyVo.getResultCode());
				
				if (result == 1) {
					logger.info("【" + notifyVo.getOrderNumber() + "】订单信息和商户余额更新成功！准备与网关通讯。。。");
					ReissueRecordVo vo = new ReissueRecordVo(notifyVo.getOrderNumber(), notifyVo.getPayAmount(), 
							notifyVo.getPlayerAccount(), notifyVo.getProductId(), notifyVo.getPartitionId());
					vo.setMerchantId(notifyVo.getMerchantId());
					vo.setUuid(notifyVo.getUuid());
					vo.setContainRedPacket(true);
					// 启用网关通讯线程
					new Thread(new NotifyRunnable(notifyVo)).start();
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * -异步通知线程与网关通讯
	 * @author International
	 * @2019年1月12日 上午11:39:29
	 */
	private class NotifyRunnable implements Runnable {
		
		private NotifyVo notifyVo;
		
		public NotifyRunnable(NotifyVo notifyVo) {
			this.notifyVo = notifyVo;
		}

		@Override
		public void run() {
			ReissueRecordVo vo = new ReissueRecordVo(notifyVo.getOrderNumber(), notifyVo.getPayAmount(), 
					notifyVo.getPlayerAccount(), notifyVo.getProductId(), notifyVo.getPartitionId());
			vo.setMerchantId(notifyVo.getMerchantId());
			vo.setUuid(notifyVo.getUuid());
			vo.setContainRedPacket(true);
			try {
				int i = 0;
				boolean success = false;
				while (i < 6) {
					i++;
					// 与网关通讯
					Result result = reissueRecordService.reissue(vo, "manual", 1);
					
					logger.info("【网关通讯第_" + i + "_次】：" + (result.getState()?"成功":"失败") + "，【" + result.getMsg() + "】！");
					
					// 网关通讯成功
					if (result.getState()) {
						i = 6;
						success = true;
					}
					// 通讯失败-网关未授权
					if ("GATEWAY_UNAUTHORIZED".equals(result.getMsg())) {
						i = 6;
						logger.info("【网关通讯失败】：网关未授权！");
					}
					
					if (i < 6) {
						Thread.sleep(10000 * i);
					}
				}
				
				Order order = new Order();
				order.setId(notifyVo.getOrderId());
				order.setOrderNumber(notifyVo.getOrderNumber());
				order.setAmount(notifyVo.getPayAmount());
				order.setTailAmount(notifyVo.getTailAmount());
				order.setState(success ? 1 : 2);
				order.setPlayerAccount(notifyVo.getPlayerAccount());
				order.setOrderDate(notifyVo.getOrderDate());
				order.setMerchant(new Merchant(notifyVo.getMerchantId()));
				applicationContext.publishEvent(order);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
		
	}
}
