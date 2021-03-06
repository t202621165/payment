package com.cypay.common.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Bank;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Order;
import com.cypay.common.entity.SettleMent;
import com.cypay.common.entity.SystemSet;
import com.cypay.common.repository.impl.BankRepository;
import com.cypay.common.repository.impl.SettleMentRepository;
import com.cypay.common.repository.impl.SystemSetRepository;
import com.cypay.common.service.CriteriaData;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.vo.BankVo;
import com.cypay.common.vo.Result;

import cn.hutool.core.util.StrUtil;

@Service
public class BankService extends BaseServiceImpl<BankRepository, Bank, BankVo>{

	@Value("${com.payment.mark}")
	private String mark;
	
//	@Autowired
//	private OrderService orderService;
	
	@Autowired
	private SettleMentRepository settleMentRepository;
	
	@Autowired
	private SystemSetRepository systemSetRepository;

	@Override
	protected CriteriaData<Bank, BankVo> getCriteriaData(String name, BankVo v) {
		Integer type = v.getType();
		name += (type != null && type == 1) ? "-plus" : "";
		CriteriaData<Bank, BankVo> cd = super.getCriteriaData(name, v);
		if (type != null && type == 1){
			CriteriaBuilder cb = cd.getCriteriaBuilder();
			Join<Bank,Merchant> merchant = cd.getRoot().join("merchant",JoinType.INNER);
			Join<Merchant,Set<Order>> o = merchant.join("orders",JoinType.LEFT);
			o.alias("orders");
			o.on(cb.greaterThanOrEqualTo(o.get("orderDate"), v.getStartDate()), 
					cb.lessThanOrEqualTo(o.get("orderDate"), v.getEndDate()), 
					cb.in(o.get("state")).value(Arrays.asList(1, 2)));
			
			if (!cd.isCache()) {
				cd.addSelection(cd.getCriteriaBuilder().sum(o.get("merchantProfit")));
			}
		}
		return cd;
	}
	
	@Override
	protected List<Predicate> additionalWhele(CriteriaData<Bank, BankVo> cd, List<Predicate> wheles,
			BankVo v) {
		cd.getCriteriaQuery().groupBy(cd.getRoot().get("merchant").get("id"));
		return wheles;
	}
	
	public Bank findByMerchantId(Long merchantId) {
		return baseRepository.findBankByMerchantId(merchantId);
	}
	
	public Result frozen(Long id){
		int i = baseRepository.updateState(id);
		if ( i > 0 ) 
			return Result.success("账户状态更改成功");
		else
			return Result.error("账户状态更改失败");
	}
	
	@Transactional
	public Result saveBank(Bank bank) {
		Result result = bank.validate();
		if (!result.getState()) {
			return result;
		}
		
		String banks = systemSetRepository.findSettlementBankByMark(mark);
		JSONArray array = JSON.parseArray(banks);
		array.parallelStream().forEach(a -> {
			JSONObject obj = (JSONObject) a;
			if (obj.get("mark").equals(bank.getBankMark())) {
				bank.setBankName(String.valueOf(obj.get("name")));
			}
		});
		
		if (StrUtil.isEmpty(bank.getBankName()))
			return Result.error("暂不支持该银行，请重新选择", "bankMark");
		
		Merchant merchant = ShiroManager.getMerchant();
		List<Bank> list = baseRepository.findAllByMerchant(merchant);
		Bank b;
		if (list != null && !list.isEmpty()) {
			b = list.get(0);
			b.merge(bank);
		}else {
			b = bank;
		}
		b.setMerchant(merchant);
		b.setActivated(true);
		baseRepository.save(b);
		return Result.success("银行账户绑定成功！");
	}

	public Bank findByMerchant(Merchant merchant) {
		return baseRepository.findByMerchant(merchant);
	}

	@Transactional
	public Result updateOverMoney(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) != 1) {
			return Result.error("请输入有效的提现金额！", "amount");
		}
		
		Merchant merchant = ShiroManager.getMerchant();
		Bank bank = baseRepository.findByMerchant(merchant);
		if (bank == null || !bank.getActivated())
			return Result.error("请先完善银行账户信息！");
		
		if (!bank.getState())
			return Result.error("账户已被冻结，无法进行提现操作！");
		
		Optional<SystemSet> sys = systemSetRepository.findByMark(mark);
		BigDecimal minAmount = new BigDecimal(0.00);
		Integer settleMentType = merchant.getSettlementType();
		if (sys.isPresent()) {
			if (settleMentType == 0)
				minAmount = sys.get().getT0MinAmount();
			else 
				minAmount = sys.get().getT1MinAmount();
		}
		
//		if (settleMentType == 1) {
//			BigDecimal frozen = orderService.getTodayOrderMerchantProfit(merchant);
//			if (frozen != null && frozen.compareTo(BigDecimal.ZERO) > 0) {
//				bank.setFrozen(frozen);
//			}
//		}
		
		BigDecimal fee = merchant.getFee();
		BigDecimal money = amount.add(fee);
		if (money.compareTo(bank.getOverMoney()) > 0)
			return Result.error("提现失败，可提现金额不足！", "amount");
		
		if (amount.compareTo(minAmount) < 0)
			return Result.error("最小提现金额为【"+minAmount+" 元】", "amount");
		
		String serialNumber = "C_" + snowflakeIdWorker.nextId();
		SettleMent settleMent = new SettleMent(serialNumber, amount, fee, 
				merchant, bank, 0, "商户自提【"+(settleMentType == 0?"T+0":"T+1")+"】");
		
		int i = baseRepository.updateOverMoney(bank.getId(), money, bank.getVersion());
		if (i == 1)
			settleMentRepository.save(settleMent);
		
		return Result.success(CommonUtil.getBufferString("提现成功！【金额：", amount, "元，手续费：",fee,"元】"));
	}
	
	public Bank findSumOverMoney(Integer settlementType){
		return baseRepository.findSumOverMoney(settlementType);
	}
	
}
