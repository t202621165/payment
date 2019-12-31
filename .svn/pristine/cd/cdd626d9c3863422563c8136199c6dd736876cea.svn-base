package com.cypay.pay.notice.open;

import java.math.BigDecimal;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-官方财付通
 * @author International
 * @2019年1月14日 上午9:58:38
 */
@Notice(prefix = "&key=")
public class NoticeToTenpay extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.TENPAY.type();
	}
	
	@Override
	protected void initPreprocess() {
		setCharset(PaymentType.TENPAY.getCharset());
		setResultCode("<xml><return_code>SUCCESS</return_code></xml>");
	}
	
	@Override
	protected void init() {
		setIsSuccess("0".equals(getData("trade_state")));
		
		setOrderNumber(getData("out_trade_no"));
		
		setSupNumber(getData("transaction_id"));
		
		setPayAmount(new BigDecimal(
				String.format("%.2f", Double.valueOf(getData("total_fee")) * 0.01)));
		
		setSign(getData("sign"));
	}

}
