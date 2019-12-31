package com.cypay.pay.payment.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.GenericSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;

@Payment(upperCase = true, prefix = "&key=")
public class PayByQuanHai extends GenericSignSortPayment {

	@PublicData(value = "account")
	private String merid;

	@PublicData(value = "orderNumber")
	private String orderid;

	@PublicData(value = "amount", type = AmountType.CENT)
	private String money;

	private String type;

	@PublicData(value = "des")
	private String body;
	
	@PublicData(value = "notifyUrl")
	private String notify_url;

	@PublicData(value = "productMark", alias = true)
	private String bankcode;

	@NoSignature
	private String sign;

	@Override
	public void setPaymentType() {
		// TODO Auto-generated method stub
		this.paymentType = PaymentType.QUANHAI;
	}
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "13");
		alias.put("wechat", "23");
		alias.put("CCB", "CCB");
		alias.put("ICBC", "ICBC");
		alias.put("ABC", "ABC");
		alias.put("CMB", "CMB");
		alias.put("COMM", "BCOM");
		alias.put("CMBC", "CMBC");
		alias.put("BOC", "BOC");
		alias.put("SPDB", "SPDB");
		alias.put("CEB", "CEB");
		alias.put("CIB", "CIB");
		alias.put("HXB", "HXB");
		alias.put("PINGAN", "PABC");
		alias.put("PSBC", "PSBC");
		alias.put("CITIC", "CITIC");
	}
	
	@Override
	protected void initPostProcess(RechargeVo recharge) {
		String mark = recharge.getTypeMark();
		switch (mark) {
		case "alipay":
			this.type = "13";
			break;

		case "wechat":
			this.type = "23";
			break;
		
		case "ebank":
			this.type = "43";
			break;		
		}
		
		if (StringUtils.isEmpty(body)){
			this.body = "game";
		}
		
	}
	
	@Override
	protected Resultful getRedirectURL() {
		ResponseEntity<String> result = restTemplate.postForEntity(domainName, getEntitys(null), String.class);
		if (!StringUtils.isEmpty(result.getBody())){
			JSONObject ob = JSONObject.parseObject(result.getBody());
			if ("200".equals(ob.getString("code"))){
				return Resultful.redirectURL(ob.getString("payurl"));
			}else{
				return Resultful.error(ob.getString("errmsg"));
			}
		}
		logger.info("【全海-同步获取参数】：" + result.getBody());
		return Resultful.error("下单失败");
	}

	public String getMerid() {
		return merid;
	}

	public void setMerid(String merid) {
		this.merid = merid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
