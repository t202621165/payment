package com.cypay.pay.notice.open;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.XMLUtil;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-QQ钱包
 * @author International
 * @2019年1月14日 上午9:53:17
 */
@Notice(prefix = "&key=")
public class NoticeToQpay extends BaseNotice {

	@Override
	public String notifyType() {
		return PaymentType.QPAY.type();
	}
	
	@Override
	protected void initPreprocess() {
		setCharset(PaymentType.QPAY.getCharset());
		setResultCode("<xml><return_code>SUCCESS</return_code></xml>");
	}
	
	@Override
	protected void init() {
		setIsSuccess("SUCCESS".equals(getData("trade_state")));
		
		setOrderNumber(getData("out_trade_no"));
		
		setSupNumber(getData("transaction_id"));
		
		setPayAmount(new BigDecimal(
				String.format("%.2f", Double.valueOf(getData("total_fee")) * 0.01)));
		
		setSign(getData("sign"));
	}
	
	@Override
	protected void parseData(HttpServletRequest request) {
		setData(XMLUtil.parseXml(request));
	}

}
