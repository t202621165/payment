package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-易爱支付
 * @author International
 * @2019年1月14日 上午10:57:54
 */
@Notice
public class NoticeToYiAipay extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.YIAIPAY.type();
	}
	
	@Override
	protected void initPreprocess() {
		signKeys.add("orderid");
		signKeys.add("opstate");
		signKeys.add("ovalue");
		
		setResultCode("opstate=0");
		setCharset(PaymentType.YIAIPAY.getCharset());
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
