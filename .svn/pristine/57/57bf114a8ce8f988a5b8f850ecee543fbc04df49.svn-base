package com.cypay.pay.notice.open;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-官方支付宝
 * @author International
 * @2019年1月10日 上午11:06:09
 */
@Notice
public class NoticeToAlipay extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.ALIPAY.type();
	}
	
	@Override
	protected void initPreprocess() {
		noSignKeys.add("sign_type");
		
		setResultCode("success");
		setCharset(PaymentType.ALIPAY.getCharset());
	}
	
	@Override
	protected void init() {
		setIsSuccess("TRADE_SUCCESS".equals(getData("trade_status")));
		
		setOrderNumber(getData("out_trade_no"));
		
		setSupNumber(getData("trade_no"));
		
		setPayAmount(new BigDecimal(getData("total_fee")));
		
		setSign(getData("sign"));
	}
	
}
