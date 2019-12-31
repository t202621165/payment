package com.cypay.pay.notice.open;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-口碑支付
 * @author International
 * @2019年1月12日 下午4:54:51
 */
@Notice
public class NoticeToKbpay extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.KBPAY.type();
	}
	
	@Override
	protected void initPreprocess() {
		signKeys.add("result");
		signKeys.add("userid");
		signKeys.add("gateid");
		signKeys.add("ordermoney");
		signKeys.add("billno");
		signKeys.add("keyvalue");
		signKeys.add("extdata");
		signKeys.add("ordersid");
		
		setResultCode("ok");
		setCharset(PaymentType.KBPAY.getCharset());
	}

	@Override
	protected void init() {
		setIsSuccess("1".equals(getData("result")));
		
		setOrderNumber(getData("billno"));
		
		setSupNumber(getData("ordersid"));
		
		setPayAmount(new BigDecimal(getData("ordermoney")));
		
		setSign(getData("sign"));
	}

	@Override
	protected boolean verify(String secretKey) {
		getData().put("keyvalue", secretKey);
		return super.verify("");
	}
}
