package com.cypay.pay.payment.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.NotParam;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.GenericSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;

@Payment(upperCase = true)
public class PayByQianTaiWx extends GenericSignSortPayment{

	private String app_code;
	
	private String redirect_uri;
	
	private String mchid;
	
	@NoSignature
	private String sign;
	
	@NotParam
	private String amount;
	
	@NotParam
	private String orderNumber;


	@Override
	public void setPaymentType() {
		// TODO Auto-generated method stub
		this.paymentType = PaymentType.QIANTAI;
	}
	
	@Override
	public String mark() {
		return super.mark() + "_wechat";
	}

	@Override
	protected void initPostProcess(RechargeVo recharge) {
		// TODO Auto-generated method stub		
		this.mchid = recharge.getAccount().split("\\|")[0];
		this.app_code = recharge.getAccount().split("\\|")[1];
		this.redirect_uri = recharge.getCurrentReqUrl().concat("/pay/callback/"+this.paymentType.type()+"/"+recharge.getOrderNumber());
		this.amount = String.format("%.2f", recharge.getAmount().doubleValue());
		this.orderNumber = recharge.getOrderNumber();
	}
	
	@Override
	protected Resultful getQRCodeURL() {
		//第一步：获取微信oauth的code
		String url;
		try {
			url = domainName.concat("/tool/v1/get_weixin_oauth_code").concat("?app_code="+this.getApp_code())
					.concat("&redirect_uri="+this.getRedirect_uri()).concat("&mchid="+this.getMchid())
					.concat("&sign="+this.getSign());
			logger.info("下单地址:{}",url);
			return Resultful.qrCodeURL(URLEncoder.encode(url, "utf-8"), this.orderNumber,this.amount);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Resultful.error("下单失败");
	}
	
	public String getApp_code() {
		return app_code;
	}

	public void setApp_code(String app_code) {
		this.app_code = app_code;
	}

	public String getRedirect_uri() {
		return redirect_uri;
	}

	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
