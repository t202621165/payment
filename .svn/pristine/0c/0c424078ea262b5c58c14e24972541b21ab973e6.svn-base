package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;
/**
 * 异步通知山海支付宝
 * @author leo
 */
@Notice(prefix = "&key=")
public class NoticeToShanHaiZfb extends BaseNotice{

	@Override
	public String notifyType() {
		return PaymentType.SHANHAI.type() + "_alipay";
	}

	@Override
	protected void init() {
		setIsSuccess("1".equals(getData("state")));
		
		setOrderNumber(getData("sdcustomno"));
		
		setSupNumber(getData("sd51no"));
		
		setPayAmount(new BigDecimal(getData("ordermoney")));
		
		setSign(getData("sign"));
	}

	@Override
	protected void initPreprocess() {
		signKeys.add("customerid");
		signKeys.add("sd51no");
		signKeys.add("sdcustomno");
		
		setResultCode("<result>1</result>");
	}

}
