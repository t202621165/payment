package com.cypay.pay.payment.impl;

import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.DUtil;
import com.cypay.pay.payment.GenericSignSortPayment;
import com.cypay.pay.payment.Payment;

/**
 * 新瑞支付
 * @author International
 *
 */
@Payment(field = "pay_md5sign", prefix = "&key=", upperCase = true)
public class PayByXinRui extends GenericSignSortPayment {

	@PublicData(value = "account")
	private String pay_memberid;
	
	@PublicData(value = "orderNumber")
	private String pay_orderid;
	
	private String pay_applydate = DUtil.date().toString();
	
	@PublicData(value = "productMark", alias = true)
	private String pay_bankcode;
	
	@PublicData(value = "notifyUrl")
	private String pay_notifyurl;
	
	@PublicData(value = "returnUrl")
	private String pay_callbackurl;
	
	@PublicData(value = "amount", type = AmountType.YUAN)
	private String pay_amount;
	
	@NoSignature
	private String pay_md5sign;
	
	@NoSignature
	@PublicData(value = "des")
	private String pay_productname;
	
	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.XINRUI;
	}
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "903");
		alias.put("wechat", "902");
	}

	public String getPay_memberid() {
		return pay_memberid;
	}

	public void setPay_memberid(String pay_memberid) {
		this.pay_memberid = pay_memberid;
	}

	public String getPay_orderid() {
		return pay_orderid;
	}

	public void setPay_orderid(String pay_orderid) {
		this.pay_orderid = pay_orderid;
	}

	public String getPay_applydate() {
		return pay_applydate;
	}

	public void setPay_applydate(String pay_applydate) {
		this.pay_applydate = pay_applydate;
	}

	public String getPay_bankcode() {
		return pay_bankcode;
	}

	public void setPay_bankcode(String pay_bankcode) {
		this.pay_bankcode = pay_bankcode;
	}

	public String getPay_notifyurl() {
		return pay_notifyurl;
	}

	public void setPay_notifyurl(String pay_notifyurl) {
		this.pay_notifyurl = pay_notifyurl;
	}

	public String getPay_callbackurl() {
		return pay_callbackurl;
	}

	public void setPay_callbackurl(String pay_callbackurl) {
		this.pay_callbackurl = pay_callbackurl;
	}

	public String getPay_amount() {
		return pay_amount;
	}

	public void setPay_amount(String pay_amount) {
		this.pay_amount = pay_amount;
	}

	public String getPay_md5sign() {
		return pay_md5sign;
	}

	public void setPay_md5sign(String pay_md5sign) {
		this.pay_md5sign = pay_md5sign;
	}

	public String getPay_productname() {
		return pay_productname;
	}

	public void setPay_productname(String pay_productname) {
		this.pay_productname = pay_productname;
	}

}
