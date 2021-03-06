package com.cypay.pay.payment.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.CommonUtil;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.Resultful;

/**
 * 支付云接口
 * 
 * @author iwano
 *
 */
@Payment(prefix = "|", upperCase = true, onlyValue = true)
public class PayByZfy extends CustomSignSortPayment {

	private final String Charset = "UTF-8";

	@SignatureSort(1)
	private final String Version = "1.0";

	@SignatureSort(2)
	@PublicData(value = "account")
	private String MerId;

	@SignatureSort(3)
	@PublicData(value = "orderNumber")
	private String TransNo;

	@SignatureSort(4)
	@PublicData(value = "amount", type = AmountType.YUAN)
	private String OrderAmount;

	@SignatureSort(6)
	@PublicData(value = "productMark", alias = true)
	private String PayChannel;

	@SignatureSort(5)
	private final String ProductName = "game";

	@SignatureSort(7)
	@PublicData(value = "notifyUrl")
	private String NotiyUrl;

	@SignatureSort(8)
	@PublicData(value = "returnUrl")
	private String PostBackUrl;

	@SignatureSort(9)
	@PublicData(value = "productMark")
	private String Remark;
    
	private String sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "ALIPAY");
		alias.put("wechat", "WEIXIN");
		alias.put("qpay", "QQ");
		alias.put("hbpay", "HUABAI");
		alias.put("union", "UNIONPAY");
		alias.put("CCB", "CCB");
		alias.put("ICBC", "ICBC");
		alias.put("ABC", "ABC");
		alias.put("CMB", "CMB");
		alias.put("COMM", "COMM");
		alias.put("CMBC", "CMBC");
		alias.put("BOC", "BOC");
		alias.put("SPDB", "SPDB");
		alias.put("CEB", "CEB");
		alias.put("CIB", "CIB");
		alias.put("HXB", "HXB");
		alias.put("PINGAN", "PINGAN");
	}
	
	@Override
	protected Resultful getQRCodeURL() {
		ResponseEntity<String> result = restTemplate.postForEntity(domainName, getEntitys(null), String.class);
		logger.info("支付云下单响应:{}",result.getBody());
		if (!StringUtils.isEmpty(result.getBody())){
			String url = CommonUtil.getHtmlUrl(result.toString(), "code_url");
			if (!StringUtils.isEmpty(url)){
				return Resultful.qrCodeURL(url,TransNo,String.format("%.2f", Double.valueOf(OrderAmount)));
			}else{
				logger.info("支付云下单失败,无法获取url扫码链接");
				return Resultful.error("下单失败");
			}	
		}
		return null;
	}

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.ZFY;
	}

	public String getVersion() {
		return Version;
	}

	public String getMerId() {
		return MerId;
	}

	public void setMerId(String merId) {
		MerId = merId;
	}

	public String getTransNo() {
		return TransNo;
	}

	public void setTransNo(String transNo) {
		TransNo = transNo;
	}

	public String getOrderAmount() {
		return OrderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		OrderAmount = orderAmount;
	}

	public String getPayChannel() {
		return PayChannel;
	}

	public void setPayChannel(String payChannel) {
		PayChannel = payChannel;
	}

	public String getProductName() {
		return ProductName;
	}

	public String getNotiyUrl() {
		return NotiyUrl;
	}

	public void setNotiyUrl(String notiyUrl) {
		NotiyUrl = notiyUrl;
	}

	public String getPostBackUrl() {
		return PostBackUrl;
	}

	public void setPostBackUrl(String postBackUrl) {
		PostBackUrl = postBackUrl;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getCharset() {
		return Charset;
	}

}
