package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

@Notice(prefix = "&key=")
public class NoticeToWanXiang extends BaseNotice{

	@Override
	public String notifyType() {
		// TODO Auto-generated method stub
		return PaymentType.WANXIANG.type();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		setIsSuccess("success".equals(getData("status")));
		
		setOrderNumber(getData("orderno"));
		
		setSupNumber(getData("orderid"));
		
		setPayAmount(new BigDecimal(getData("amount")));
		
		setSign(getData("sign"));
	}

	@Override
	protected void initPreprocess() {
		// TODO Auto-generated method stub
		signKeys.add("version");
		signKeys.add("status");
		signKeys.add("parter");
		signKeys.add("orderno");
		signKeys.add("amount");
		setResultCode("ok");
	}

}
