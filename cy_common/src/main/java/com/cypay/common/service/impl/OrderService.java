package com.cypay.common.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cypay.common.bo.MainBo;
import com.cypay.common.entity.Bank;
import com.cypay.common.entity.Gallery;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Order;
import com.cypay.common.repository.impl.MerchantRepository;
import com.cypay.common.repository.impl.OrderRepository;
import com.cypay.common.service.CriteriaData;
import com.cypay.common.util.DUtil;
import com.cypay.common.util.ExportTextUtil;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.OrderVo;
import com.cypay.common.vo.ReissueRecordVo;
import com.cypay.common.vo.Result;

import cn.hutool.core.date.DateUtil;

@Service
public class OrderService extends BaseServiceImpl<OrderRepository, Order, OrderVo> {

	@Autowired
	private MerchantRepository merchantRepository;
	
	private static BeanCopier copier = BeanCopier.create(OrderVo.class, OrderVo.class, false);
	
	public JSONObject findOrderData(OrderVo v, PageData pageData) {
		JSONObject json = null;
		try {
			// 查询当天充值统计
			Future<OrderVo> orderVo = futureTaskPool.submit(() -> {
				OrderVo order = new OrderVo();
				copier.copy(v, order, null);
				return orderTatalData(order);
			});
			// 查询前一天充值统计
			Future<OrderVo> orderVo2 = futureTaskPool.submit(() -> {
				OrderVo order = new OrderVo();
				copier.copy(v, order, null);
				Date date = DateUtil.offsetDay(new Date(), -1);
				order.setOrderDate(DateUtil.beginOfDay(date));
				order.setPayDate(date);
				return orderTatalData(order);
			});
			// 查询当天充值订单
			Future<JSONObject> order = futureTaskPool.submit(() -> {
				return JSON.parseObject(JSON.toJSONString(findVoPageList(v, pageData)));
			});
			
			json = order.get();
			json.put("today", orderVo.get());
			json.put("yesterday", orderVo2.get());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return json;
	}
	
	public OrderVo orderTatalData(OrderVo v) {
		List<OrderVo> list = findOrderTotalData(v);
		Long failedCount = 0L;
		OrderVo ov = new OrderVo(0L, 0, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
		for (OrderVo vo : list) {
			ov.setOrderCount(ov.getOrderCount() + vo.getOrderCount());
			ov.setAmount(ov.getAmount().add(vo.getAmount()));
			ov.setPayAmount(ov.getPayAmount().add(vo.getPayAmount()));
			ov.setMerchantProfit(ov.getMerchantProfit().add(vo.getMerchantProfit()));
			ov.setAgentProfit(ov.getAgentProfit().add(vo.getAgentProfit()));
			ov.setPlatformProfit(ov.getPlatformProfit().add(vo.getPlatformProfit()));
			if (vo.getState() == 0) {
				failedCount = vo.getOrderCount();
			} else if (vo.getState() == 1 || vo.getState() == 3) {
				ov.setTailAmount(ov.getTailAmount().add(vo.getTailAmount()));
				ov.setTailAmountProfit(ov.getTailAmountProfit().add(vo.getTailAmountProfit()));
				ov.setSuccessCount(vo.getOrderCount());
			} else if (vo.getState() == 2) {
				ov.setTailAmount(ov.getTailAmount().add(vo.getTailAmount()));
				ov.setTailAmountProfit(ov.getTailAmountProfit().add(vo.getTailAmountProfit()));
				ov.setWaitingCount(vo.getOrderCount());
			}
		}
		if (ov.getOrderCount() > 0) {
			double rate = 1 - (failedCount.doubleValue() / ov.getOrderCount().doubleValue());
			ov.setSuccessRate(new BigDecimal(rate * 100).setScale(2, RoundingMode.HALF_UP));
		}
		return ov;
	}
	
	@Override
	protected CriteriaData<Order, OrderVo> getCriteriaData(String name, OrderVo v) {
		name += v.getIsAdmin() ? "-plus" : "";
		CriteriaData<Order, OrderVo> cd = super.getCriteriaData(name, v);
		// 系统管理员查询
		if (v.getIsAdmin() && !cd.isCache()) {
			cd.addSelection(cd.getRoot().get("platformProfit"));
			cd.addSelection(cd.getRoot().get("gallery").get("name"));
			cd.addSelection(cd.getRoot().get("tailAmount"));
			cd.addSelection(cd.getRoot().get("tailAmountProfit"));
		}
		cd.getRoot().join("partition", JoinType.LEFT);
		cd.getRoot().join("agent",JoinType.LEFT);
		return cd;
	}
	
	@Override
	protected List<Predicate> additionalWhele(CriteriaData<Order, OrderVo> cd, List<Predicate> wheles, OrderVo v) {
		if (v.getIsAdmin()) {// 系统管理员查询
			// 根据通道查询订单
			Gallery gallery = v.getGallery();
			if (gallery != null && gallery.getId() != null) {
				wheles.add(cd.getCriteriaBuilder().equal(cd.getRoot().get("gallery"), gallery));
			}			
		}
		
		if (!StringUtils.isEmpty(v.getDiscription())){			
			wheles.add(cd.getCriteriaBuilder().like(cd.getRoot().get("discription"), "%"+v.getDiscription()+"%"));
		}
		
		return wheles;
	}
	
	/**
	 * 查询订单日交易统计
	 * @param v
	 * @return
	 */
	public List<OrderVo> findOrderTotalData(OrderVo v) {
		Assert.notNull(v, "V cannot be null.");
		v.setPayAmount(null);
		CriteriaData<Order, OrderVo> cd = getCriteriaData();
		CriteriaBuilder cb = cd.getCriteriaBuilder();
		Root<Order> root = cd.getRoot();
		// 系统管理员查询
		if (v.getIsAdmin()) {
			cd.getCriteriaQuery().multiselect(cb.count(root.get("id")), root.get("state"), cb.sum(root.get("amount")), 
					cb.sum(root.get("payAmount")), cb.sum(root.get("merchantProfit")), cb.sum(root.get("agentProfit")), 
					cb.sum(root.get("platformProfit")), cb.sum(root.get("tailAmount")),cb.sum(root.get("tailAmountProfit")));
		} else {
			cd.getCriteriaQuery().multiselect(cb.count(root.get("id")), root.get("state"), cb.sum(root.get("amount")), 
					cb.sum(root.get("payAmount")), cb.sum(root.get("merchantProfit")), cb.sum(root.get("agentProfit")));
		}
		cd.getCriteriaQuery().groupBy(root.get("state"));
		
		// 动态查询条件
		dynamicWhele(cd, v);
		return cd.getResultList();
	}

	public Order findDetail(String orderNumber) {
		return baseRepository.findOrderDetail(orderNumber);
	}
	
	/**
	 * 订单详情-管理员
	 * @param id
	 * @return
	 */
	public Map<String, Object> findAdminOrderDetail(Long id) {
		return baseRepository.findOrderDetail(id);
	}

	/**
	 * 订单详情-商户
	 * 
	 * @return
	 * @throws ParseException
	 */
	public Order findOrderDetail(Long id){
		return baseRepository.findDetail(id);
	}
	
	public MainBo findOrderSummary() {
		MainBo mainBo = new MainBo();
		OrderVo v = new OrderVo();
		v.setOrderDate(DUtil.beginOfToday());
		v.setPayDate(DUtil.endOfToday());
		OrderVo today = orderTatalData(v);
		mainBo.setPayAmountTotal(today.getAmount()); // 订单总金额
		mainBo.setCurrentProfit(today.getPlatformProfit()); // 平台利润
		mainBo.setPayAmount(today.getPayAmount()); // 付款总金额
		mainBo.setOrderCount(today.getSuccessCount()); // 成功订单笔数
		mainBo.setSendCount(today.getWaitingCount()); // 等待发送订单笔数
		
		// 昨日交易统计
		Date date = DateUtil.offsetDay(new Date(), -1);
		v.setOrderDate(DateUtil.beginOfDay(date));
		v.setPayDate(DateUtil.endOfDay(date));
		OrderVo yesterday = orderTatalData(v);
		mainBo.setZrOrderCount(yesterday.getSuccessCount());
		mainBo.setZrPayAmount(yesterday.getPayAmount());
		
		// 系统注册商户数
		mainBo.setMerchantCount(merchantRepository.count());
		return mainBo;
	}

	/**
	 * 退款
	 * 
	 * @param orderNumber
	 *            订单号
	 * @return
	 */
	@Transactional
	public Result refund(String orderNumber) {
		try{
			Order order = baseRepository.findByOrderNumber(orderNumber);
			List<Bank> banks = new ArrayList<>(order.getMerchant().getBanks());
			Bank bank = banks.get(0); // 银行信息
			if (bank.getOverMoney().subtract(order.getMerchantProfit()).compareTo(BigDecimal.ZERO) < 0) {
				return Result.error("余额不足,退款失败");
			} else {
				bank.setOverMoney(bank.getOverMoney().subtract(order.getMerchantProfit()));
				bank.setAllDeposit(bank.getOverMoney().subtract(order.getMerchantProfit()));
				order.setMerchantProfit(new BigDecimal("0.00"));
				order.setPlatformProfit(new BigDecimal("0.00"));
			}
			banks.set(0, bank);
			order.getMerchant().setBanks(new HashSet<>(banks));
			order.setState(3);
			this.update(order);
			return Result.success("退款 "+order.getAmount()+"元 成功");
		}catch (Exception e) {
			logger.error(e.getMessage());
			return Result.error("退款失败");
		}
	}

	/**
	 * 订单补发-查询等待发送订单
	 * @param id
	 * @param merchant
	 * @return
	 */
	public ReissueRecordVo findReissueRecordById(Long id, Merchant merchant) {
		return baseRepository.findReissueRecordById(id, merchant);
	}

	/**
	 * 更新订单状态
	 * @param state
	 * @param id
	 * @return
	 */
	public Result updateState(Integer state, Long id) {
		baseRepository.updateState(state, id);
		return Result.success("订单更新成功！");
	}
	
	/**
	 * 导出订单信息
	 * @param startDate
	 * @param endDate
	 * @param type
	 */
	public void exports(Date startDate,Date endDate,String type,HttpServletResponse response){
		if(type.equals("1")){
			Set<String> qqs = new HashSet<>(baseRepository.findQQByDate(startDate, endDate));
			ExportTextUtil.writeToTxt(response, qqs, "QQ");
		}
	}

	@Async
	public void updateOrderRemarks(ReissueRecordVo vo) {
		baseRepository.updateOrderRemarks(vo.getSerialNumber(), 
				vo.getGiveAmount(), vo.getRedPacketAmount(), vo.getRemarks());
	}
	
	/**
	 * @param v 订单日期参数
	 * @return 订单删除结果
	 */
	public Result clear(OrderVo v){
		int i = baseRepository.deleteOrderByDate(v.getOrderDate(), v.getPayDate());
		if (i > 0)
			return Result.success("订单数据清除成功");
		return Result.error("订单数据清除失败");
	}

	/**
	 * 获取商户当天订单利润
	 * @return
	 */
	public BigDecimal getTodayOrderMerchantProfit(Merchant merchant) {
		return baseRepository.getTodayOrderMerchantProfit(merchant, DateUtil.beginOfDay(new Date()), new Date());
	}
}
