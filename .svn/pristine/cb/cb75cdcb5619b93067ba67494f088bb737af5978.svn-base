package com.cypay.pay.notice.open;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-15173支付
 * @author International
 * @2019年1月12日 下午6:05:23
 */
@Notice
public class NoticeTo15173 extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.PAY_15173.type();
	}
	
	@Override
	protected void initPreprocess() {
		signKeys.add("pay_result");
		signKeys.add("bargainor_id");
		signKeys.add("sp_billno");
		signKeys.add("total_fee");
		signKeys.add("attach");
		
		setResultCode("OK");
		setCharset(PaymentType.PAY_15173.getCharset());
	}

	@Override
	protected void init() {
		setIsSuccess("0".equals(getData("pay_result")));
		
		setOrderNumber(getData("sp_billno"));
		
		setSupNumber(getData("transaction_id"));
		
		setPayAmount(new BigDecimal(getData("total_fee")));
		
		setSign(getData("sign"));
	}

}
