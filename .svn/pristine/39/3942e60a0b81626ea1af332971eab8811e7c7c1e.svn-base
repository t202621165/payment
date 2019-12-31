package com.cypay.common.pattern.template.settlement.impl;

import java.util.Date;
import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.cypay.common.entity.SettleMent;
import com.cypay.common.enums.SettlementBusiness;
import com.cypay.common.pattern.template.settlement.SettlementTemplate;

/**
 *审核通过
 * @author International
 * @2019年3月18日 下午5:55:12
 */
@Component
public class AgreeToAudit extends SettlementTemplate {

	@Override
	protected SettlementBusiness getSettlementBus() {
		return SettlementBusiness.AGREE_TO_AUDIT;
	}
	
	@Override
	protected Consumer<? super SettleMent> getAction(String discription) {
		return s -> {
			s.setState(getSettlementBus().nextState());
			s.setComplateDate(new Date());
		};
	}
}
