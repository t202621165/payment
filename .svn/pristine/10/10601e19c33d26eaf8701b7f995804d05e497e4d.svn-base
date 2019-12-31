package com.cypay.pay.notice.open;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-爱玩在线
 * @author International
 * @2019年1月14日 上午10:04:50
 */
@Notice
public class NoticeToIwanol extends BaseNotice {
	

	@Override
	public String notifyType() {
		return PaymentType.IWANOL.type();
	}
	
	@Override
	protected void initPreprocess() {
		setResultCode("success");
		setCharset(PaymentType.IWANOL.getCharset());
	}

	@Override
	protected void init() {
		setIsSuccess("0".equals(getData("status")));
		
		setOrderNumber(getData("merchant_order"));
		
		setSupNumber(getData("trade_order"));
		
		setPayAmount(new BigDecimal(
				String.format("%.2f", Double.valueOf(getData("total_fee")) * 0.01)));
		
		setSign(getData("sign"));
	}

}
