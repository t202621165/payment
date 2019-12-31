package com.cypay.pay.payment.impl;

import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;
@Payment(upperCase = true,prefix="&key=")
public class PayByShanHaiHb extends CustomSignSortPayment{

	@SignatureSort(1)
	@PublicData(value = "account")
	public String customerid;
	
	@SignatureSort(2)
	@PublicData(value = "orderNumber")
	public String sdcustomno;
	
	@SignatureSort(3)
	@PublicData(value = "amount", type = AmountType.YUAN)
	public String ordermoney;
	
	@SignatureSort(4)
	public String cardno = "34";
	
	@SignatureSort(5)
	public String faceno = "zfb";
	
	@SignatureSort(6)
	@PublicData(value = "notifyUrl")
	public String noticeurl;
	
	@PublicData(value = "returnUrl")
	public String backurl;
	
	public String endcustomer = "";
	
	@PublicData(value = "clientIp")
	public String endip;
	
	public String remarks = "GAME";
	
	@PublicData(value = "productMark")
	public String mark;
	
	public String stype = "1";
	
	public String ZFtype = "1";
	
	public String sign;

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.SHANHAI;
	}
	
	@Override
	public String mark() {
		return super.mark() + "_hbpay";
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

	public String getOrdermoney() {
		return ordermoney;
	}

	public void setOrdermoney(String ordermoney) {
		this.ordermoney = ordermoney;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getFaceno() {
		return faceno;
	}

	public void setFaceno(String faceno) {
		this.faceno = faceno;
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

	public String getEndcustomer() {
		return endcustomer;
	}

	public void setEndcustomer(String endcustomer) {
		this.endcustomer = endcustomer;
	}

	public String getEndip() {
		return endip;
	}

	public void setEndip(String endip) {
		this.endip = endip;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getZFtype() {
		return ZFtype;
	}

	public void setZFtype(String zFtype) {
		ZFtype = zFtype;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}


}
