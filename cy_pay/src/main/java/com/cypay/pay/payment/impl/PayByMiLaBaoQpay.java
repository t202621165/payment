package com.cypay.pay.payment.impl;

import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;

@Payment(upperCase = true)
public class PayByMiLaBaoQpay extends CustomSignSortPayment{

	@SignatureSort(1)
	@PublicData(value = "account")
	public String customerid;
	
	@SignatureSort(2)
	@PublicData(value = "orderNumber")
	public String sdcustomno;
	
	@SignatureSort(3)
	@PublicData(value = "amount", type = AmountType.CENT)
	public String orderAmount;
	
	@SignatureSort(4)
	public String cardno = "32";
	
	@SignatureSort(5)
	@PublicData(value = "notifyUrl")
	public String noticeurl;
	
	@SignatureSort(6)
	@PublicData(value = "returnUrl")
	public String backurl;
	
	@PublicData(value = "productMark")
	public String mark;
	
	public String sign;

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.MILABAO;
	}
	
	@Override
	public String mark() {
		return super.mark() + "_qpay";
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getSdcustomno() {
		return sdcustomno;
	}

	public void setSdcustomno(String sdcustomno) {
		this.sdcustomno = sdcustomno;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getNoticeurl() {
		return noticeurl;
	}

	public void setNoticeurl(String noticeurl) {
		this.noticeurl = noticeurl;
	}

	public String getBackurl() {
		return backurl;
	}

	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
