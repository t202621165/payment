package com.cypay.common.pattern.template.settlement.impl;

import org.springframework.stereotype.Component;

import com.cypay.common.enums.SettlementBusiness;

/**
 * 拒绝审核
 * @author International
 * @2019年3月18日 下午5:55:12
 */
@Component
public class RefuseToAudit extends RefusePayment {

	@Override
	protected SettlementBusiness getSettlementBus() {
		return SettlementBusiness.REFUSE_TO_AUDIT;
	}
	
}
