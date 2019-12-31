package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

@Notice(prefix = "&")
public class NoticeToBBPay extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.BBPAY.type();
	}

	@Override
	protected void init() {
		setIsSuccess("1".equals(getData("status")));
		
		setOrderNumber(getData("sdorderno"));
		
		setSupNumber(getData("sdpayno"));
		
		setPayAmount(new BigDecimal(getData("total_fee")));
		
		setSign(getData("sign"));
	}

	@Override
	protected void initPreprocess() {
		signKeys.add("customerid");
		signKeys.add("status");
		signKeys.add("sdpayno");
		signKeys.add("sdorderno");
		signKeys.add("total_fee");
		signKeys.add("paytype");
		setResultCode("success");
	}

}
