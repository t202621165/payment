package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * 异步通知-新瑞支付
 * @author International
 *
 */
@Notice(prefix = "&key=")
public class NoticeToXinRui extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.XINRUI.type();
	}

	@Override
	protected void init() {
		setIsSuccess("00".equals(getData("returncode")));
		
		setOrderNumber(getData("orderid"));
		
		setSupNumber(getData("transaction_id"));
		
		setPayAmount(new BigDecimal(getData("amount")));
		
		setSign(getData("sign"));
	}

	@Override
	protected void initPreprocess() {
		signKeys.add("amount");
		signKeys.add("attach");
		signKeys.add("datetime");
		signKeys.add("memberid");
		signKeys.add("orderid");
		signKeys.add("returncode");
		signKeys.add("transaction_id");
		
		setResultCode("OK");
	}
}
