package com.cypay.pay.payment.impl;

import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.payment.SignHandler;

/**
 * 优易数卡支付接口
 * @author iwano
 *
 */
@Payment(field = "hmac", onlyValue = true, handler = SignHandler.HMAC)
public class PayBy186ue extends CustomSignSortPayment {
	
	@SignatureSort(1)
	private final String p0_Cmd = "Buy";
	
	@SignatureSort(2)
	@PublicData(value = "account")
	private String p1_MerId;
	
	@SignatureSort(3)
	@PublicData(value = "orderNumber")
	private String p2_Order;
	
	@SignatureSort(4)
	@PublicData(value = "amount",type = AmountType.YUAN)
	private String p3_Amt;
	
	@SignatureSort(5)
	private final String p4_Cur = "CNY";
	
	@SignatureSort(6)
	@PublicData(value = "notifyUrl")
	private String p8_Url;
	
	@SignatureSort(7)
	@PublicData(value = "productMark")
	private String pa_MP;
	
	@SignatureSort(8)
	@PublicData(value = "productMark", alias = true)
	private String pd_FrpId;
	
	@SignatureSort(9)
	private final String pr_NeedResponse = "1";
	
	private String hmac;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "alipay");
		alias.put("wechat", "wxcode");
		alias.put("qpay", "qqpay");
		alias.put("hbpay", "hbpay");
		alias.put("tenpay", "tenpay");
		alias.put("CCB", "CCB");
		alias.put("ICBC", "ICBC");
		alias.put("ABC", "ABC");
		alias.put("CMB", "CMBCHINA");
		alias.put("COMM", "BOCO");
		alias.put("CMBC", "CMBC");
		alias.put("BOC", "BOC");
		alias.put("SPDB", "SPDB");
		alias.put("CEB", "CEB");
		alias.put("CIB", "CIB");
		alias.put("HXB", "HXB");
		alias.put("PINGAN", "PINGANBANK");
	}

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.PAY_186UE;
	}
	
	public String getP0_Cmd() {
		return p0_Cmd;
	}

	public String getP1_MerId() {
		return p1_MerId;
	}

	public void setP1_MerId(String p1_MerId) {
		this.p1_MerId = p1_MerId;
	}

	public String getP2_Order() {
		return p2_Order;
	}

	public void setP2_Order(String p2_Order) {
		this.p2_Order = p2_Order;
	}

	public String getP3_Amt() {
		return p3_Amt;
	}

	public void setP3_Amt(String p3_Amt) {
		this.p3_Amt = p3_Amt;
	}

	public String getP4_Cur() {
		return p4_Cur;
	}

	public String getP8_Url() {
		return p8_Url;
	}

	public void setP8_Url(String p8_Url) {
		this.p8_Url = p8_Url;
	}

	public String getPa_MP() {
		return pa_MP;
	}

	public void setPa_MP(String pa_MP) {
		this.pa_MP = pa_MP;
	}

	public String getPd_FrpId() {
		return pd_FrpId;
	}

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}

	public String getPr_NeedResponse() {
		return pr_NeedResponse;
	}

	public String getHmac() {
		return hmac;
	}

	public void setHmac(String hmac) {
		this.hmac = hmac;
	}

}
