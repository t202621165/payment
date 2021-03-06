package com.cypay.common.pattern.template.settlement.impl;

import java.util.Date;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cypay.common.entity.SettleMent;
import com.cypay.common.entity.SettleMentReply;
import com.cypay.common.enums.SettlementBusiness;
import com.cypay.common.pattern.template.settlement.SettlementTemplate;
import com.cypay.common.repository.impl.SettleMentReplyRepository;
import com.cypay.common.shiro.ShiroManager;

/**
 * 同意付款
 * @author International
 * @2019年3月19日 下午3:36:12
 */
@Component
public class AgreePayment extends SettlementTemplate {
	
	@Autowired
	private SettleMentReplyRepository settleMentReplyRepository;

	@Override
	protected SettlementBusiness getSettlementBus() {
		return SettlementBusiness.AGREE_PAYMENT;
	}
	
	@Override
	protected Consumer<? super SettleMent> getAction(String discription) {
		SettleMentReply settleMentReply = new SettleMentReply();
		settleMentReply.setReplyDate(new Date());
		settleMentReply.setSerialNumber("P" + snowflakeIdWorker.nextId());
		settleMentReply.setState(false);
		settleMentReply.setUser(ShiroManager.getUser());
		Consumer<? super SettleMent> action = s -> {
			s.setSettleMentReply(settleMentReply);
			s.setComplateDate(new Date());
			s.setState(getSettlementBus().nextState());
			settleMentReply.getSettleMents().add(s);
		};
		settleMentReplyRepository.save(settleMentReply);
		return action;
	}
}
