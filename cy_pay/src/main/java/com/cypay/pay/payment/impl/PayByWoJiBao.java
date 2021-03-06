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
import com.cypay.pay.vo.Resultful;

/**
 * 沃基宝
 * @author iwano
 */
@Payment
public class PayByWoJiBao extends CustomSignSortPayment{
	
	@SignatureSort(1)
	@PublicData(value = "clientIp")
	private String postip;
	
	@SignatureSort(2)
	@PublicData(value = "account")
	private String partner;
	
	@SignatureSort(3)
	@PublicData(value = "productMark", alias = true)
	private String banktype;
	
	@SignatureSort(4)
	@PublicData(value = "amount", type = AmountType.YUAN)
	private String paymoney;
	
	@SignatureSort(6)
	@PublicData(value = "notifyUrl")
	private String callbackurl;
	
	private String goodsname = "game";
	
	@SignatureSort(5)
	@PublicData(value = "orderNumber")
	private String ordernumber;
	
	private String isshow = "0";
	
	private String sign;

	@Override
	public void setPaymentType() {
		// TODO Auto-generated method stub
		this.paymentType = PaymentType.WOJIBAO;
	}
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "ALIPAY");
		alias.put("wechat", "WEIXIN");
	}
	
	@Override
	protected Resultful getRedirectURL() {
		return this.getPaymentUrl("pageurl");
	}
	
	@Override
	protected Resultful getQRCodeURL() {
		return this.getPaymentUrl("qrurl");
	}
	
	/**
	 * 获取支付连接
	 * @param urlMark
	 * <pre>
	 * pageurl：同步跳转地址
	 * qrurl：二维码地址
	 * </pre>
	 * @return
	 */
	private Resultful getPaymentUrl(String urlMark) {
		ResponseEntity<String> result = restTemplate.postForEntity(domainName, getEntitys(null), String.class);
		if (!StringUtils.isEmpty(result.getBody())){
			try{
				JSONObject ob = JSONObject.parseObject(result.getBody());
				if ("1".equals(ob.getString("status"))){
					if ("pageurl".equals(urlMark)) {
						return Resultful.redirectURL(ob.getString(urlMark));
					} else {
						return Resultful.qrCodeURL(ob.getString(urlMark),ob.getString("riskmoney"), ordernumber,String.format("%.2f", Double.valueOf(paymoney)));
					}
				}
				return Resultful.error(ob.getString("message"));
			}catch (Exception e) {
				return Resultful.error("请求异常"+e.getMessage());
			}
		}
		logger.info("【沃基宝-同步获取二维码URL】：" + result.getBody());
		return Resultful.error("下单失败");
	}

	public String getPostip() {
		return postip;
	}

	public void setPostip(String postip) {
		this.postip = postip;
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

	public String getCallbackurl() {
		return callbackurl;
	}

	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
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
