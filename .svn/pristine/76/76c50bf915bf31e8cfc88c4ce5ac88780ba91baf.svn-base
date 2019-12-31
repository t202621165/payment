package com.cypay.pay.payment.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;

/**
 * 易爱接口
 * @author iwano
 *
 */
@Payment
public class PayByYiAipay extends CustomSignSortPayment {
	
	@SignatureSort(2)
	@PublicData(value = "productMark", alias = true)
	private String type;
	
	@SignatureSort(1)
	@PublicData(value = "account")
	private String parter;
	
	@SignatureSort(3)
	@PublicData(value = "amount",type = AmountType.YUAN)
	private String value;
	
	@SignatureSort(4)
	@PublicData(value = "orderNumber")
	private String orderid;
	
	@SignatureSort(5)
	@PublicData(value = "notifyUrl")
	private String callbackurl;
	
	@PublicData(value = "returnUrl")
	private String hrefbackurl;
	
	@PublicData(value = "clientIp")
	private String payerIp;
	
	@PublicData(value = "productMark")
	private String attach;
	
	private String sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "992");
		alias.put("hbpay", "992");
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
	protected void initPostProcess(RechargeVo recharge) {
		if (!recharge.getIsRedirect()){
			if (recharge.getProductMark().equals("alipay"))
				this.type = "1011";	
			if (recharge.getProductMark().equals("wechat"))
				this.type = "1007";		
		}
	}
	
	@Override
	protected Resultful getQRCodeURL() {
		ResponseEntity<String> result = restTemplate.postForEntity(domainName, getEntitys(null), String.class);
		if (!StringUtils.isEmpty(result.getBody())){
			JSONObject ob = JSONObject.parseObject(result.getBody());
			if (ob.getString("id").equals("0")){
				JSONObject data = ob.getJSONObject("data");
				return Resultful.qrCodeURL(data.getString("qrcode"),orderid,String.format("%.2f", Double.valueOf(value)));
			}else{
				return Resultful.error(ob.getString("message"));
			}	
		}
		logger.info("【易爱-下单返回参数】：" + result.getBody());
		return null;
	}
	

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.YIAIPAY;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParter() {
		return parter;
	}

	public void setParter(String parter) {
		this.parter = parter;
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
