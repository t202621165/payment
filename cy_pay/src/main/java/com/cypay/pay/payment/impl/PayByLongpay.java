package com.cypay.pay.payment.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.Resultful;

/**
 * 龙宝支付
 * @author iwano
 *
 */
@Payment
public class PayByLongpay extends CustomSignSortPayment {
	
	@SignatureSort(1)
	@PublicData(value = "account")
	private String parter;
	
	@SignatureSort(4)
	@PublicData(value = "orderNumber")
	private String orderid;
	
	@SignatureSort(5)
	@PublicData(value = "notifyUrl")
	private String callbackurl;
	
	@PublicData(value = "returnUrl")
	private String hrefbackurl;
	
	@PublicData(value = "productMark")
	private String attach;
	
	@SignatureSort(2)
	@PublicData(value = "productMark", alias = true)
	private String type;
	
	@SignatureSort(3)
	@PublicData(value = "amount",type = AmountType.YUAN)
	private String value;
	
	@NoSignature
	private String sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "1003");
		alias.put("wechat", "1004");
		alias.put("tenpay", "993");	
		alias.put("CCB", "965");
		alias.put("ICBC", "967");
		alias.put("ABC", "964");
		alias.put("CMB", "970");
		alias.put("COMM", "981");
		alias.put("CMBC", "980");
		alias.put("BOC", "963");
		alias.put("SPDB", "977");
		alias.put("CEB", "986");
		alias.put("CIB", "972");
		alias.put("HXB", "982");
		alias.put("PINGAN", "978");
	}

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.LONGPAY;
	}

	@Override
	protected Resultful getQRCodeURL() {
		ResponseEntity<String> result = restTemplate.postForEntity(domainName, getEntitys(null), String.class);
		if (!StringUtils.isEmpty(result.getBody())){
			JSONObject ob = JSONObject.parseObject(result.getBody());
			if ("0".equals(ob.getString("code"))){
				return Resultful.qrCodeURL(ob.getString("url"), orderid,String.format("%.2f", Double.valueOf(value)));
			}
		}
		logger.info("【龙宝-同步获取二维码URL】：" + result.getBody());
		return Resultful.error("下单失败");
	}

	public String getParter() {
		return parter;
	}

	public void setParter(String parter) {
		this.parter = parter;
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

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
