package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

@Notice
public class NoticeToLingPao extends BaseNotice{

	@Override
	public String notifyType() {
		return PaymentType.LINGPAO.type();
	}

	@Override
	protected void init() {
		setIsSuccess("1".equals(getData("orderstatus")));

		setOrderNumber(getData("ordernumber"));

		setSupNumber(getData("sysnumber"));

		setPayAmount(new BigDecimal(getData("paymoney")));

		setSign(getData("sign"));
	}
	
	@Override
	protected void initPreprocess() {
		signKeys.add("partner");
		signKeys.add("ordernumber");
		signKeys.add("orderstatus");
		signKeys.add("paymoney");
		
		setResultCode("ok");
		setCharset(PaymentType.LINGPAO.getCharset());
	}

}
