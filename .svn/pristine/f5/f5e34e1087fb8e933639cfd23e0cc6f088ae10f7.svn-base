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
 * 码聚合
 * @author iwano
 *
 */
@Payment
public class PayByMaJuHe extends CustomSignSortPayment {
	
	@SignatureSort(1)
	private String version = "3.0";
	
	@SignatureSort(2)
	private String method = "Mjh.online.interface";
	
	@SignatureSort(3)
	@PublicData(value = "account")
	private String partner;
	
	@SignatureSort(4)
	@PublicData(value = "typeMark", alias = true)
	private String banktype;
	
	@SignatureSort(5)
	@PublicData(value = "amount",type = AmountType.YUAN)
	private String paymoney;
	
	@SignatureSort(6)
	@PublicData(value = "orderNumber")
	private String ordernumber;
	
	@SignatureSort(7)
	@PublicData(value = "notifyUrl")
	private String callbackurl;
	
	@NoSignature
	private String isshow = "0";
	
	@PublicData(value = "clientIp")
	private String attach;
	
	@NoSignature
	private String sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "ALIPAY");
		alias.put("wechat", "WEIXIN");
		alias.put("qpay", "QQ");
		alias.put("jingdong", "JD");
		alias.put("union", "UNIONPAY");
	}
	
	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.MJH;
	}
	
	@Override
	protected Resultful getQRCodeURL() {
		ResponseEntity<String> result = restTemplate.postForEntity(domainName, getEntitys(null), String.class);
		if (!StringUtils.isEmpty(result.getBody())){
			JSONObject ob = JSONObject.parseObject(result.getBody());
			if ("1".equals(ob.getString("status"))){
				return Resultful.qrCodeURL(ob.getString("qrurl"), ordernumber,String.format("%.2f", Double.valueOf(paymoney)));
			}
		}
		logger.info("【码聚合-同步获取二维码URL】：" + result.getBody());
		return Resultful.error("下单失败");
	}

}
