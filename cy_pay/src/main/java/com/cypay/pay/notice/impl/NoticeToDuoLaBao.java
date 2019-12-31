package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import com.cypay.common.enums.PaymentType;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;
import com.cypay.pay.payment.SignHandler;

/**
 * 哆啦宝异步通知
 * @author iwano
 *
 */
@Notice(handler = SignHandler.SHA1)
public class NoticeToDuoLaBao extends BaseNotice{
	
	private String token;
	
	private String timestamp;

	@Override
	public String notifyType() {
		return PaymentType.DLB.type();
	}
	
	@Override
	protected void parseData(HttpServletRequest request) {
		super.parseData(request);
		this.token = request.getHeader("token");
		this.timestamp = request.getHeader("timestamp");
	}
	
	@Override
	protected void initPreprocess() {
		setResultCode("SUCCESS");
	}

	@Override
	protected void init() {
		setIsSuccess("SUCCESS".equals(getData("status")));
		
		setOrderNumber(String.valueOf(getData("requestNum")));
		
		setSupNumber(String.valueOf(getData("orderNum")));
		
		setPayAmount(new BigDecimal(getData("orderAmount")));
		
		setSign(token);
	}
	
	@Override
	protected String getSignatureStr(String secretKey) {
		String privateKey = secretKey.split("\\|")[1];
		return "secretKey="+privateKey+"&timestamp="+timestamp;
	}
}
