package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-支付云
 * @author International
 * @2019年1月14日 上午11:16:57
 */
@Notice(prefix = "|")
public class NoticeToZfy extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.ZFY.type();
	}
	
	@Override
	protected void initPreprocess() {
		signKeys.add("Version");
		signKeys.add("MerId");
		signKeys.add("TransNo");
		signKeys.add("OrderNo");
		signKeys.add("OrderAmount");
		signKeys.add("TransAmount");
		signKeys.add("Status");
		signKeys.add("TransTime");
		signKeys.add("Remark");
		
		setResultCode("OK");
		setIsOnlyValue(Boolean.TRUE);
		setCharset(PaymentType.ZFY.getCharset());
	}

	@Override
	protected void init() {
		setIsSuccess("1".equals(getData("Status")));
		
		setOrderNumber(getData("OrderNo"));
		
		setSupNumber(getData("TransNo"));
		
		setPayAmount(new BigDecimal(getData("TransAmount")));
		
		setSign(getData("Sign"));
	}
}
