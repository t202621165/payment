package com.cypay.pay.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Order;
import com.cypay.common.repository.impl.BankRepository;
import com.cypay.common.repository.impl.VisitRepository;
import com.cypay.common.service.impl.BaseServiceImpl;
import com.cypay.common.service.impl.SystemSetService;
import com.cypay.pay.repository.OrderRepository;
import com.cypay.pay.vo.NotifyVo;
import com.cypay.pay.vo.OrderVo;
import com.cypay.pay.vo.ReturnVo;

@Service("pOrderService")
public class OrderService extends BaseServiceImpl<OrderRepository, Order, OrderVo> {

	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private VisitRepository visitRepository;
	
	@Autowired
	private SystemSetService systemSetService;

	@Override
	public List<Order> findAll(OrderVo v) {
		return baseRepository.findAll(getSpecification(v));
	}
	
	public NotifyVo findNotifyData(String orderNumber) {
		return baseRepository.findNotifyData(orderNumber);
	}
	
	public ReturnVo findReturnData(String orderNumber) {
		return baseRepository.findReturnData(orderNumber);
	}

	/**
	 * 更新订单信息和商户账户余额
	 * @param notify
	 * @param payAmount
	 * @return
	 */
	public int updateOrderAndBankOverMoney(NotifyVo notify) {
		int tailAmountRatio = 0;
		BigDecimal tailRate = BigDecimal.ZERO;
		if (systemSetService.findIsOpenTailAmount()){
			tailAmountRatio = systemSetService.findTailAmountRatio();
			if (tailAmountRatio > 0 && tailAmountRatio <= 100) {
				tailRate = new BigDecimal(tailAmountRatio);
			}
		}
		
		BigDecimal merchantProfit = notify.merchantProfit(tailRate);
		BigDecimal platformProfit = notify.platformProfit(tailRate);
		BigDecimal tailAmountProfit = notify.tailAmountProfit(tailRate);
		BigDecimal agentProfit = notify.agentProfit();
		BigDecimal payAmount = notify.getPayAmount();
		int i = baseRepository.updateOrderAmountAndProfit(notify.getOrderId(), payAmount, 
				notify.getSupNumber(), merchantProfit, platformProfit, agentProfit, tailRate,tailAmountProfit);
		
		if (i == 1) {
			// 更新商户利润
			bankRepository.updateOverMoney(new Merchant(notify.getMerchantId()), merchantProfit);
			
			// 更新代理利润
			if (notify.getAgentId() != null) {
				bankRepository.updateOverMoney(new Merchant(notify.getAgentId()), agentProfit);
			}
			
			// 更新统计数据订单信息
			visitRepository.updateOrderRecord(payAmount, merchantProfit, notify.getPlayerIp(), notify.getMerchantId());
		}
		return i;
	}
	
	public Long countByOrderNumber(String orderNumber) {
		return baseRepository.countByOrderNumber(orderNumber);
	}
	
	public Order findByOrderNumber(String orderNumber){
		return baseRepository.findByOrderNumber(orderNumber);
	}
}
