package com.cypay.pay.payment.impl;

import java.util.Date;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.DUtil;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;

import cn.hutool.http.HttpRequest;

@Payment(field = "Sign", prefix = "&key=")
public class PayByJiaBei extends CustomSignSortPayment {
	
	private String ApiMethod = "OnLinePay";
	
	private String Version = "V2.0";
	
	@PublicData(value = "account")
	private String MerID;
	
	@PublicData(value = "orderNumber")
	private String TradeNum;
	
	@PublicData(value = "amount",type = AmountType.YUAN)
	private String Amount;
	
	@PublicData(value = "notifyUrl")
	private String NotifyUrl;
	
	@PublicData(value = "returnUrl")
	private String ReturnUrl;
	
	private String TransTime;
	
	@PublicData(value = "productMark")
	private String Ext1;
	
	private String PayType;
	
	private String BankCode;
	
	private String SignType = "MD5";
	
	private String IsImgCode = "1";
	
	@PublicData(value = "clientIp")
	private String UserIP;
	
	@NoSignature
	private String Sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "alipay");
		alias.put("wechat", "wxcode");
		alias.put("qpay", "qqpay");	
		alias.put("union", "unionpay");	
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
		alias.put("PSBC", "POST");
		alias.put("PINGAN", "PINGANBANK");
	}

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.JIABEI;
	}

	@Override
	protected void initPostProcess(RechargeVo recharge){
		this.TransTime = DUtil.format(new Date(), "yyyyMMddHHmmss");
		if (recharge.getTypeMark().equals("ebank")){
			this.PayType = "onlinebank";
			this.BankCode = alias.get(recharge.getProductMark());
		}else{
			this.PayType = alias.get(recharge.getProductMark());
		}
	}
	
	@Override
	protected Resultful getQRCodeURL(){
		String result = HttpRequest.get(domainName).charset("utf-8").body(getParamStr()).execute().body();
		if (!StringUtils.isEmpty(result)){
			JSONObject ob = JSONObject.parseObject(result);
			if ("1111".equals(ob.getString("RespCode"))){
				return Resultful.qrCodeURL(ob.getString("PayUrl"), TradeNum,String.format("%.2f", Double.valueOf(Amount)));			
			}
		}
		logger.info("【佳贝-同步获取二维码URL】：" + result);
		return Resultful.error("下单失败");
	}

	public String getApiMethod() {
		return ApiMethod;
	}

	public void setApiMethod(String apiMethod) {
		ApiMethod = apiMethod;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getMerID() {
		return MerID;
	}

	public void setMerID(String merID) {
		MerID = merID;
	}

	public String getTradeNum() {
		return TradeNum;
	}

	public void setTradeNum(String tradeNum) {
		TradeNum = tradeNum;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getNotifyUrl() {
		return NotifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		NotifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return ReturnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		ReturnUrl = returnUrl;
	}

	public String getTransTime() {
		return TransTime;
	}

	public void setTransTime(String transTime) {
		TransTime = transTime;
	}

	public String getExt1() {
		return Ext1;
	}

	public void setExt1(String ext1) {
		Ext1 = ext1;
	}

	public String getPayType() {
		return PayType;
	}

	public void setPayType(String payType) {
		PayType = payType;
	}

	public String getBankCode() {
		return BankCode;
	}

	public void setBankCode(String bankCode) {
		BankCode = bankCode;
	}

	public String getSignType() {
		return SignType;
	}

	public void setSignType(String signType) {
		SignType = signType;
	}

	public String getSign() {
		return Sign;
	}

	public void setSign(String sign) {
		Sign = sign;
	}

	public String getIsImgCode() {
		return IsImgCode;
	}

	public void setIsImgCode(String isImgCode) {
		IsImgCode = isImgCode;
	}

	public String getUserIP() {
		return UserIP;
	}

	public void setUserIP(String userIP) {
		UserIP = userIP;
	}
	
}
