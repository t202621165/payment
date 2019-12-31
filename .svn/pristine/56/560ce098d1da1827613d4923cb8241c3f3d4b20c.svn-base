package com.cypay.pay.notice.open;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.XMLUtil;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

/**
 * -异步通知-官方微信
 * @author International
 * @2019年1月12日 下午4:14:26
 */
@Notice(prefix = "&key=")
public class NoticeToWechat extends BaseNotice {
	
	@Override
	public String notifyType() {
		return PaymentType.WECHAT.type();
	}
	
	@Override
	protected void initPreprocess() {
		setCharset(PaymentType.WECHAT.getCharset());
		setResultCode("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
	}

	@Override
	protected void init() {
		setIsSuccess("SUCCESS".equals(getData("result_code")));
		
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
