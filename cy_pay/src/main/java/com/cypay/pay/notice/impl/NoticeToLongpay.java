package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-龙宝支付
 * @author International
 * @2019年1月14日 上午10:21:12
 */
@Notice
public class NoticeToLongpay extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.LONGPAY.type();
	}
	
	@Override
	protected void initPreprocess() {
		signKeys.add("orderid");
		signKeys.add("opstate");
		signKeys.add("ovalue");
		
		setResultCode("opstate=0");
		setCharset(PaymentType.LONGPAY.getCharset());
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
