package com.cypay.pay.payment.impl;

import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;
@Payment
public class PayBy520 extends CustomSignSortPayment{
	
	@SignatureSort(1)
	@PublicData(value = "account")
	public String parter;
	
	@SignatureSort(2)
	@PublicData(value = "productMark", alias = true)
	public String type;
	
	@SignatureSort(3)
	@PublicData(value = "amount", type = AmountType.YUAN)
	public String value;
	
	@SignatureSort(4)
	@PublicData(value = "orderNumber")
	public String orderid;
	
	@SignatureSort(5)
	@PublicData(value = "notifyUrl")
	public String callbackurl;
	
	@PublicData(value = "returnUrl")
	public String hrefbackurl;
	
	@PublicData(value = "clientIp")
	public String payerIp;
	
	@PublicData(value = "productMark")
	public String attach;
	
	public String sign;

	@Override
	protected void initPreProcess() {
		alias.put("alipay", "1009");
		alias.put("wechat", "1004");
		alias.put("hbpay", "1208");
		alias.put("CCB", "998");
		alias.put("ICBC", "998");
		alias.put("ABC", "998");
		alias.put("CMB", "998");
		alias.put("COMM", "998");
		alias.put("CMBC", "998");
		alias.put("BOC", "998");
		alias.put("SPDB", "998");
		alias.put("CEB", "998");
		alias.put("CIB", "998");
		alias.put("HXB", "998");
		alias.put("PINGAN", "998");
	}
	
	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.KUNDIU;
	}

	public String getParter() {
		return parter;
	}

	public void setParter(String parter) {
		this.parter = parter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getCallbackurl() {
		return callbackurl;
	}

	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}

	public String getHrefbackurl() {
		return hrefbackurl;
	}

	public void setHrefbackurl(String hrefbackurl) {
		this.hrefbackurl = hrefbackurl;
	}

	public String getPayerIp() {
		return payerIp;
	}

	public void setPayerIp(String payerIp) {
		this.payerIp = payerIp;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
