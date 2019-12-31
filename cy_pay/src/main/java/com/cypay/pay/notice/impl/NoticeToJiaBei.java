package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

@Notice(prefix = "&key=")
public class NoticeToJiaBei extends BaseNotice{

	@Override
	public String notifyType() {
		return PaymentType.JIABEI.type();
	}
	
	@Override
	protected void initPreprocess() {
		noSignKeys.add("Sign");
		
		setResultCode("SUCCESS");
		setCharset(PaymentType.JIABEI.getCharset());
	}

	@Override
	protected void init() {
		setIsSuccess("01".equals(getData("Status")));

		setOrderNumber(getData("TradeNum"));

		setSupNumber(getData("OrderNum"));

		setPayAmount(new BigDecimal(getData("Amount")));

		setSign(getData("Sign"));
	}
}
