package com.cypay.pay.payment.open;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.CommonUtil;
import com.cypay.pay.payment.GenericSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;

import cn.hutool.core.codec.Base64;

/**
 * -支付接口-爱玩在线
 * @author International
 *
 */
@Payment
public class PayByIwanol extends GenericSignSortPayment {
	
	/** 接口类型 */
	@PublicData(value = "typeMark", alias = true)
	private String service;

	/** 版本号 */
	private String version = "1.0";

	/** 编码方式 */
	private final String charset = "UTF-8";

	/** 签名方式 */
	private String sign_type = "MD5";

	/** 下单账号 */
	@PublicData(value = "account")
	private String merchant_id;

	/** 下单订单号 */
	@PublicData(value = "orderNumber")
	private String merchant_order;

	/** 下单金额【分】 */
	@PublicData(value = "amount", type = AmountType.CENT)
	private String total_fee;

	/** 异步通知地址 */
	@PublicData(value = "notifyUrl")
	private String notify_url;

	/** 前端跳转地址 */
	@PublicData(value = "returnUrl")
	private String return_url;

	/** 页面类型 */
	private String page_type = "0";

	private String bank_code;

	@NoSignature
	private String sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "iwanol.alipay.native");
		alias.put("wechat", "iwanol.wechat.native");
		alias.put("tenpay", "iwanol.cft.native");
		alias.put("qpay", "iwanol.qpay.native");
		alias.put("hbpay", "iwanol.hbpay.native");
		alias.put("ebank", "iwanol.bank.native");
		alias.put("union", "iwanol.ecode.native");
	}

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.IWANOL;
	}

	@Override
	protected void initPostProcess(RechargeVo recharge) {
		this.page_type = recharge.getIsRedirect() ? "0" : "1";
		if ("iwanol.bank.native".equals(this.service)) {
			this.bank_code = recharge.getProductMark();
		}
	}
	
	@Override
	protected Resultful getRedirectURL() {
		return Resultful.redirectURL(CommonUtil.getBufferString(domainName, "?", "data="+Base64.encode(getJSONStr(true), charset)));
	}
	
	@Override
	public Resultful getQRCodeURL(){
		ResponseEntity<String> result = restTemplate.getForEntity(CommonUtil.getBufferString(domainName, "?", "data="+Base64.encode(getJSONStr(true), charset)), String.class);
		if (!StringUtils.isEmpty(result.getBody())){
			logger.info("爱玩下单响应:{}",result.getBody());
			JSONObject ob = JSONObject.parseObject(result.getBody());
			if (ob.getString("status").equals("0")){
				boolean createQrCode = ob.containsKey("qrcodeImage") ? false : true;
				String amount = String.format("%.2f", new BigDecimal(total_fee).divide(BigDecimal.valueOf(100)).doubleValue());
				try {
					String codeUrl = URLDecoder.decode(ob.getString("code_url"), "utf-8");
					return Resultful.qrCodeURL(codeUrl, merchant_order,amount,createQrCode).setIframe(ob.containsKey("iframe"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					logger.error("爱玩下单异常:{}",e.getMessage());
					return Resultful.error(e.getMessage());
				}
				
			}
		}
		return Resultful.error("下单失败");
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getMerchant_order() {
		return merchant_order;
	}

	public void setMerchant_order(String merchant_order) {
		this.merchant_order = merchant_order;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}
	
	public String getPage_type() {
		return page_type;
	}

	public void setPage_type(String page_type) {
		this.page_type = page_type;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getCharset() {
		return charset;
	}
}
