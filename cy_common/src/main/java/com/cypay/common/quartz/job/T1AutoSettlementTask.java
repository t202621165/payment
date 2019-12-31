package com.cypay.common.quartz.job;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.cypay.common.entity.Bank;
import com.cypay.common.repository.impl.BankRepository;
import com.cypay.common.service.impl.SettleMentService;
import com.cypay.common.service.impl.SystemSetService;

@Component
public class T1AutoSettlementTask implements Job {
	
	public static T1AutoSettlementTask t1AutoSettlementTask;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SystemSetService systemSetService;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	protected SettleMentService settleMentService;
	
	@PostConstruct
    public void init() {    
		t1AutoSettlementTask = this;
		t1AutoSettlementTask.systemSetService = this.systemSetService;
		t1AutoSettlementTask.bankRepository = this.bankRepository;
		t1AutoSettlementTask.settleMentService = this.settleMentService;
    }

	@Transactional
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		List<Bank> banks = t1AutoSettlementTask.bankRepository.findT1SettlementInfo();
		if (!banks.isEmpty()) {
			// T1最小结算金额
			BigDecimal t1MinAmount = t1AutoSettlementTask.systemSetService.findT1MinAmount();
			
			Iterator<Bank> iterator = banks.iterator();
			while (iterator.hasNext()) {
				Bank bank = iterator.next();
				BigDecimal overMoney = bank.getOverMoney();
				bank.setFee(BigDecimal.ZERO); // 不扣手续费
				if (overMoney.compareTo(BigDecimal.ZERO) < 1 || overMoney.compareTo(t1MinAmount) == -1) {
					iterator.remove();
				}
			}
			if (!banks.isEmpty()) {
				// 插入付款记录
				t1AutoSettlementTask.settleMentService.batchInsertSettlement(banks, 2, 3, "【T1定时结算】", "T");
				// 更新账户余额
				t1AutoSettlementTask.settleMentService.batchUpdateBankOverMoney(banks);
				
				logger.info("【T1定时结算】：最小结算金额{}，Data：{}", t1MinAmount, JSON.toJSONString(banks));
			}
		}
	}
}
