package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

@Notice
public class NoticeToTongFu extends BaseNotice{

	@Override
	public String notifyType() {
		// TODO Auto-generated method stub
		return PaymentType.TONGFU.type();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		setIsSuccess("1".equals(getData("status")));
		
		setOrderNumber(getData("order_no"));
		
		setSupNumber(getData("trade_no"));
		
		setPayAmount(new BigDecimal(getData("amount")));
		
		setSign(getData("sign"));
	}

	@Override
	protected void initPreprocess() {
		// TODO Auto-generated method stub
		setResultCode("success");
	}

}
