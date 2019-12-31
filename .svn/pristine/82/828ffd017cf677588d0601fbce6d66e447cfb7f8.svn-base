package com.cypay.pay.payment.impl;

import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.GenericSignSortPayment;
import com.cypay.pay.payment.Payment;

@Payment(prefix = "&key=")
public class PayByTongFu extends GenericSignSortPayment{

	@PublicData(value = "account")
	private String merchant_id;
	
	@PublicData(value = "orderNumber")
	private String order_no;
	
	@PublicData(value = "productMark", alias = true)
	private String type;
	
	@PublicData(value = "amount", type = AmountType.YUAN)
	private String amount;
	
	@PublicData(value = "clientIp")
	private String user_identifier;
	
	@PublicData(value = "notifyUrl")
	private String callback_url;
	
	@NoSignature
	@PublicData(value = "returnUrl")
	private String return_url;
	
	private String sign;
	
	@Override
	public void setPaymentType() {
		// TODO Auto-generated method stub
		this.paymentType = PaymentType.TONGFU;
	}
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "ALIPAYQR");
		alias.put("wechat", "WECHAT");
		alias.put("union", "YSF");
		alias.put("CCB", "INTERNETBANK");
		alias.put("ICBC", "INTERNETBANK");
		alias.put("ABC", "INTERNETBANK");
		alias.put("CMB", "INTERNETBANK");
		alias.put("COMM", "INTERNETBANK");
		alias.put("CMBC", "INTERNETBANK");
		alias.put("BOC", "INTERNETBANK");
		alias.put("SPDB", "INTERNETBANK");
		alias.put("CEB", "INTERNETBANK");
		alias.put("CIB", "INTERNETBANK");
		alias.put("HXB", "INTERNETBANK");
		alias.put("PINGAN", "INTERNETBANK");
	}

	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getUser_identifier() {
		return user_identifier;
	}

	public void setUser_identifier(String user_identifier) {
		this.user_identifier = user_identifier;
	}

	public String getCallback_url() {
		return callback_url;
	}

	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
