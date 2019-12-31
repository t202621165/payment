package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-智联易付
 * @author International
 * @2019年1月14日 上午11:24:20
 */
@Notice(prefix = "&key=")
public class NoticeToZlyf extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.ZLYF.type();
	}
	
	@Override
	protected void initPreprocess() {
		noSignKeys.add("attach");
		
		setResultCode("OK");
		setCharset(PaymentType.ZLYF.getCharset());
	}
	
	@Override
	protected void init() {
		setIsSuccess("00".equals(getData("returncode")));
		
		setOrderNumber(getData("orderid"));
		
		setSupNumber(getData("transaction_id"));
		
		setPayAmount(new BigDecimal(getData("amount")));
		
		setSign(getData("sign"));
	}

}
