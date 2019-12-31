package com.cypay.pay.payment.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;
/**
 * 领跑支付接口
 * @author iwano
 *
 */
@Payment
public class PayByLingPao extends CustomSignSortPayment {
	
	@SignatureSort(1)
	@PublicData(value = "account")
	private String partner;
	
	@SignatureSort(2)
	@PublicData(value = "typeMark", alias = true)
	private String banktype;
	
	@SignatureSort(3)
	@PublicData(value = "amount",type = AmountType.YUAN)
	private String paymoney;
	
	@SignatureSort(4)
	@PublicData(value = "orderNumber")
	private String ordernumber;
	
	@SignatureSort(5)
	@PublicData(value = "notifyUrl")
	private String callbackurl;
	
	private String isshow = "0";
	
	private String sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "ALIPAY");
		alias.put("wechat", "WEIXIN");
		alias.put("tenpay", "TENPAY");
	}
	
	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.LINGPAO;
	}
	
	@Override
	protected void initPostProcess(RechargeVo recharge) {
		this.isshow = recharge.getIsRedirect() ? "1" : "0";
	}

	@Override
	protected Resultful getQRCodeURL() {
		ResponseEntity<String> result = restTemplate.postForEntity(domainName, getEntitys(null), String.class);
		if (!StringUtils.isEmpty(result.getBody())){
			return Resultful.qrCodeURL(result.getBody(),ordernumber,String.format("%.2f", Double.valueOf(paymoney)));
		}
		logger.info("【领跑-同步获取二维码URL】：" + result.getBody());
		return Resultful.error("下单失败");
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getBanktype() {
		return banktype;
	}

	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}

	public String getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(String paymoney) {
		this.paymoney = paymoney;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getCallbackurl() {
		return callbackurl;
	}

	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}

	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
