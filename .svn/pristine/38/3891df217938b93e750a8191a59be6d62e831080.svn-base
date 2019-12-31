package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

@Notice(prefix = "&key=")
public class NoticeToQuanHai extends BaseNotice{

	@Override
	public String notifyType() {
		// TODO Auto-generated method stub
		return PaymentType.QUANHAI.type();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
		setIsSuccess("status".equals(getData("00")));
		
		setOrderNumber(getData("orderid"));
		
		setSupNumber(getData("ptorderid"));
		
		setPayAmount(new BigDecimal(String.format("%.2f", Double.valueOf(getData("money")) * 0.01)));
		
		setSign(getData("sign"));
	}

	@Override
	protected void initPreprocess() {
		// TODO Auto-generated method stub
		setResultCode("ok");
	}

}
