package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;
/**
 * 异步通知沃基宝
 * @author iwano
 */
@Notice
public class NoticeToWoJiBao extends BaseNotice{

	@Override
	public String notifyType() {
		return PaymentType.WOJIBAO.type();
	}

	@Override
	protected void init() {
		String paymoney = String.format("%.2f", Double.valueOf(getData("paymoney")) * 0.01);
		getData().put("paymoney", paymoney);
		
		setIsSuccess("1".equals(getData("orderstatus")));
		
		setOrderNumber(getData("ordernumber"));
		
		setSupNumber(getData("sysnumber"));
		
		setPayAmount(new BigDecimal(paymoney));
		
		setSign(getData("sign"));
	}

	@Override
	protected void initPreprocess() {
		signKeys.add("partner");
		signKeys.add("ordernumber");
		signKeys.add("orderstatus");
		signKeys.add("paymoney");
		
		setResultCode("ok");
		setCharset(PaymentType.WOJIBAO.getCharset());
	}

}
