package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;
import com.cypay.pay.payment.SignHandler;

/**
 * -异步通知-易宝支付
 * @author International
 * @2019年1月14日 上午11:02:39
 */
@Notice(handler = SignHandler.HMAC)
public class NoticeToYeepay extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.YEEPAY.type();
	}
	
	@Override
	protected void initPreprocess() {
		signKeys.add("p1_MerId");
		signKeys.add("r0_Cmd");
		signKeys.add("r1_Code");
		signKeys.add("r2_TrxId");
		signKeys.add("r3_Amt");
		signKeys.add("r4_Cur");
		signKeys.add("r5_Pid");
		signKeys.add("r6_Order");
		signKeys.add("r7_Uid");
		signKeys.add("r8_MP");
		signKeys.add("r9_BType");
		
		setResultCode("success");
		setIsOnlyValue(Boolean.TRUE);
		setCharset(PaymentType.YEEPAY.getCharset());
	}

	@Override
	protected void init() {
		setIsSuccess("1".equals(getData("r1_Code")));
		
		setOrderNumber(getData("r6_Order"));
		
		setSupNumber(getData("r2_TrxId"));
		
		setPayAmount(new BigDecimal(getData("r3_Amt")));
		
		setSign(getData("hmac"));
	}

}
