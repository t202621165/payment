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

@Payment(prefix = "&key=")
public class PayByWanXiang extends CustomSignSortPayment{
	
	@SignatureSort(1)
	private String version = "2.1";
	
	@SignatureSort(2)
	@PublicData(value = "account")
	private String parter;
	
	@SignatureSort(3)
	@PublicData(value = "productMark", alias = true)
	private String type;
	
	@SignatureSort(4)
	@PublicData(value = "amount", type = AmountType.YUAN)
	private String amount;
	
	@SignatureSort(5)
	@PublicData(value = "orderNumber")
	private String orderno;
	
	@SignatureSort(6)
	@PublicData(value = "returnUrl")
	private String recefiveurl;
	
	@SignatureSort(7)
	@PublicData(value = "notifyUrl")
	private String notifyurl;
	
	@SignatureSort(8)
	@PublicData(value = "des")
	private String remark;
	
	@SignatureSort(9)
	private String orderencodetype = "MD5";
	
	private String qrcode = "0";
	
	private String sign;
 
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "ALIPAY");
		alias.put("hbpay", "ALIPAY");
		alias.put("wechat", "WEIXIN");
		alias.put("tenpay", "TENPAY");
		alias.put("CCB", "CCB");
		alias.put("ICBC", "ICBC");
		alias.put("ABC", "ABC");
		alias.put("CMB", "CMB");
		alias.put("COMM", "BOCO");
		alias.put("CMBC", "CMBC");
		alias.put("PSBC", "POST");
		alias.put("BOC", "BOC");
		alias.put("SPDB", "SPDB");
		alias.put("CEB", "CEB");
		alias.put("CIB", "CIB");
		alias.put("HXB", "HXB");
		alias.put("PINGAN", "PINGANBANK");
	}
	
	@Override
	protected void initPostProcess(RechargeVo recharge) {
		// TODO Auto-generated method stub
		super.initPostProcess(recharge);
		if (!recharge.getIsRedirect()){
			this.qrcode = "1";
		}
	}

	@Override
	public void setPaymentType() {
		// TODO Auto-generated method stub
		this.paymentType = PaymentType.WANXIANG;
	}

	@Override
	protected Resultful getQRCodeURL() {
		// TODO Auto-generated method stub
		ResponseEntity<String> result = restTemplate.postForEntity(domainName, getEntitys(null), String.class);
		if (!StringUtils.isEmpty(result.getBody())){
			logger.info("【万像-下单返回参数】：" + result.getBody());
			JSONObject ob = JSONObject.parseObject(result.getBody());
			if (ob.getString("State").equals("Success")){
				String qrcode = ob.getString("Data");
				return Resultful.qrCodeURL(qrcode,orderno,String.format("%.2f", Double.valueOf(amount)),false);
			}else{
				return Resultful.error(ob.getString("Msg"));
			}	
		}
		return null;
	}

	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getParter() {
		return parter;
	}


	public void setParter(String parter) {
		this.parter = parter;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getOrderno() {
		return orderno;
	}


	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}


	public String getRecefiveurl() {
		return recefiveurl;
	}


	public void setRecefiveurl(String recefiveurl) {
		this.recefiveurl = recefiveurl;
	}


	public String getNotifyurl() {
		return notifyurl;
	}


	public void setNotifyurl(String notifyurl) {
		this.notifyurl = notifyurl;
	}


	public String getSign() {
		return sign;
	}


	public void setSign(String sign) {
		this.sign = sign;
	}
	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	
}
