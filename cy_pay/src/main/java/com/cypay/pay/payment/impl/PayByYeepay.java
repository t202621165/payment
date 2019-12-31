package com.cypay.pay.payment.impl;

import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.payment.SignHandler;
import com.cypay.pay.vo.RechargeVo;

/**
 * 易宝支付【网银接口】
 * @author iwano
 *
 */
@Payment(field = "hmac", handler = SignHandler.HMAC)
public class PayByYeepay extends CustomSignSortPayment {
	
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
	@PublicData(value = "returnUrl")
	private String p8_Url;
	
	@SignatureSort(7)
	@PublicData(value = "productMark")
	private String pa_MP;
	
	@SignatureSort(9)
	@PublicData(value = "productMark", alias = true)
	private String pd_FrpId;
	
	@SignatureSort(10)
	private final String pr_NeedResponse = "1";
	
	@SignatureSort(8)
	@PublicData(value = "notifyUrl")
	private String pb_ServerNotifyUrl;
	
	private String hmac;
	
	@Override
	protected void initPreProcess() {
		alias.put("CCB", "CCB-NET-B2C");
		alias.put("ICBC", "ICBC-NET-B2C");
		alias.put("ABC", "ABC-NET-B2C");
		alias.put("CMB", "CMBCHINA-NET-B2C");
		alias.put("COMM", "BOCO-NET-B2C");
		alias.put("CMBC", "CMBC-NET-B2C");
		alias.put("BOC", "POST-NET-B2C");
		alias.put("SPDB", "SPDB-NET-B2C");
		alias.put("CEB", "CEB-NET-B2C");
		alias.put("CIB", "CIB-NET-B2C");
		alias.put("HXB", "HXB-NET-B2C");
		alias.put("PINGAN", "PINGANBANK-NET-B2C");
		
	}

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.YEEPAY;
	}

	@Override
	protected void initPostProcess(RechargeVo recharge) {
		this.pd_FrpId = alias.get(recharge.getProductMark());
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

	public String getPb_ServerNotifyUrl() {
		return pb_ServerNotifyUrl;
	}

	public void setPb_ServerNotifyUrl(String pb_ServerNotifyUrl) {
		this.pb_ServerNotifyUrl = pb_ServerNotifyUrl;
	}

	public String getHmac() {
		return hmac;
	}

	public void setHmac(String hmac) {
		this.hmac = hmac;
	}
	
}
