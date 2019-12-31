package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;
/**
 * 异步通知520接口
 * @author leo
 */
@Notice
public class NoticeTo520 extends BaseNotice{

	@Override
	public String notifyType() {
		return PaymentType.KUNDIU.type();
	}

	@Override
	protected void init() {
		setIsSuccess("0".equals(getData("opstate")));
		
		setOrderNumber(getData("orderid"));
		
		setSupNumber(getData("sysorderid"));
		
		setPayAmount(new BigDecimal(getData("ovalue")));
		
		setSign(getData("sign"));
	}

	@Override
	protected void initPreprocess() {
		signKeys.add("orderid");
		signKeys.add("opstate");
		signKeys.add("ovalue");
		
		setResultCode("opstate=0");
		setCharset(PaymentType.KUNDIU.getCharset());
	}

}
