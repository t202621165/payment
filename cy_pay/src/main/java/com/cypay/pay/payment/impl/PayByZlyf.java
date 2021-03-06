package com.cypay.pay.payment.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.DUtil;
import com.cypay.pay.payment.GenericSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.Resultful;

/**
 * 智联易付
 * @author iwano
 *
 */
@Payment(field = "pay_md5sign", prefix = "&key=")
public class PayByZlyf extends GenericSignSortPayment {
	
	private final String pay_productname = "game";
	
	@PublicData(value = "account")
	private String pay_memberid;
	
	@PublicData(value = "orderNumber")
	private String pay_orderid;
	
	private String pay_applydate = DUtil.now();
	
	@PublicData(value = "productMark", alias = true)
	private String pay_bankcode;
	
	@PublicData(value = "notifyUrl")
	private String pay_notifyurl;
	
	@PublicData(value = "returnUrl")
	private String pay_callbackurl;
	
	@PublicData(value = "amount",type = AmountType.YUAN)
	private String pay_amount;
	
	@NoSignature
	private String pay_md5sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "903");
		alias.put("wechat", "902");
		alias.put("qpay", "908");
		alias.put("jingdong", "910");
	}
	
	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.ZLYF;
	}

	@Override
	protected Resultful getQRCodeURL() {
		ResponseEntity<String> result = restTemplate.postForEntity(domainName, getEntitys(null), String.class);
		
		if (!StringUtils.isEmpty(result.getBody())){
			JSONObject ob = JSONObject.parseObject(result.getBody());
			if ("1".equals(ob.getString("code")))
				return Resultful.qrCodeURL(ob.getString("url"), pay_orderid,String.format("%.2f", Double.valueOf(pay_amount)));		
		}
		logger.info("【智联易付-同步获取二维码URL】：" + result.getBody());
		return Resultful.error("下单失败");
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

	public String getPay_productname() {
		return pay_productname;
	}

	public String getPay_md5sign() {
		return pay_md5sign;
	}

	public void setPay_md5sign(String pay_md5sign) {
		this.pay_md5sign = pay_md5sign;
	}

}
