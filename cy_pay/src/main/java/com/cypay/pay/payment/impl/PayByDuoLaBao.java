package com.cypay.pay.payment.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.annotation.NotParam;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.BasePayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.payment.SignHandler;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;
/**
 * 哆啦宝
 * @author iwano
 *
 */
@Payment(upperCase = true, handler = SignHandler.SHA1)
public class PayByDuoLaBao extends BasePayment{
	
	private String customerNum;
	
	private String shopNum;
	
	private String machineNum;
	
	@PublicData(value = "orderNumber")
	private String requestNum;
	
	@PublicData(value = "amount",type = AmountType.YUAN)
	private String amount;
	
	private String source = "API";
	
	@PublicData(value = "notifyUrl")
	private String callbackUrl;
	
	@NotParam
	private String publicKey;
	
	@NotParam
	private String privateKey;
	
	@NotParam
	private String timestamp;
	
	@NotParam
	private String sign;

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.DLB;
	}
	
	@Override
	protected String getSignStr() {
		StringBuilder sb = new StringBuilder();
		Map<String,String> param = new LinkedHashMap<String, String>();
		param.put("customerNum", this.getCustomerNum());
		param.put("shopNum", this.getShopNum());
		param.put("machineNum", this.getMachineNum());
		param.put("requestNum", this.getRequestNum());
		param.put("amount", this.getAmount());
		param.put("source", this.getSource());
		param.put("callbackUrl", this.getCallbackUrl());
		sb.append("secretKey=" + this.getPrivateKey());
		sb.append("&timestamp=" + this.getTimestamp());
		sb.append("&path=/v1/customer/order/payurl/create&body=");
		sb.append(JSONObject.toJSONString(param));
		return sb.toString();
	}

	@Override
	protected void initPostProcess(RechargeVo recharge) {
		this.customerNum = recharge.getAccount().split("\\|")[0];
		this.shopNum = recharge.getAccount().split("\\|")[1];
		this.machineNum = recharge.getAccount().split("\\|")[2];
		this.publicKey = recharge.getSecretKey().split("\\|")[0];
		this.privateKey = recharge.getSecretKey().split("\\|")[1];
		this.timestamp = String.valueOf(new Date().getTime());
	}
	
	@Override
	protected Resultful getQRCodeURL() {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("accessKey",this.getPublicKey());
		headers.add("timestamp", this.getTimestamp());
		headers.add("token", this.getSign());
		ResponseEntity<String> result = restTemplate.postForEntity(domainName, getEntitys(headers), String.class);
		if (!StringUtils.isEmpty(result.getBody())){
			JSONObject ob = JSONObject.parseObject(result.getBody());
			if ("success".equals(ob.getString("result"))){
				String url = JSONObject.parseObject(ob.getString("data")).getString("url");			
				return Resultful.qrCodeURL(url, this.getRequestNum(),String.format("%.2f", Double.valueOf(amount)));
			}
						
		}
		logger.info("【哆啦宝-同步获取二维码URL】：" + result.getBody());
		return Resultful.error("下单失败");
	}

	public String getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}

	public String getShopNum() {
		return shopNum;
	}

	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}

	public String getMachineNum() {
		return machineNum;
	}

	public void setMachineNum(String machineNum) {
		this.machineNum = machineNum;
	}

	public String getRequestNum() {
		return requestNum;
	}

	public void setRequestNum(String requestNum) {
		this.requestNum = requestNum;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
