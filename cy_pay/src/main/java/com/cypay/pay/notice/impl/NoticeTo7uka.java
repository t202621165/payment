package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-优卡联盟
 * @author International
 * @2019年1月14日 上午10:48:55
 */
@Notice
public class NoticeTo7uka extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.PAY_7UKA.type();
	}
	
	@Override
	protected void initPreprocess() {
		signKeys.add("orderid");
		signKeys.add("opstate");
		signKeys.add("ovalue");
		
		setResultCode("opstate=0");
		setCharset(PaymentType.PAY_7UKA.getCharset());
	}

	@Override
	protected void init() {
		setIsSuccess("0".equals(getData("opstate")));
		
		setOrderNumber(getData("orderid"));
		
		setSupNumber(getData("sysorderid"));
		
		setPayAmount(new BigDecimal(getData("ovalue")));
		
		setSign(getData("sign"));
	}

}
