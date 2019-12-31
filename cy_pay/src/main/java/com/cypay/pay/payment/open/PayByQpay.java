package com.cypay.pay.payment.open;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.XMLUtil;
import com.cypay.pay.payment.GenericSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.Resultful;

import cn.hutool.core.util.IdUtil;

/**
 * -支付接口-腾讯QQ钱包
 * @author International
 * 2018年7月30日 下午3:43:55
 */
@Payment(upperCase = true, prefix = "&key=")
public class PayByQpay extends GenericSignSortPayment {

	/**交易类型*/
	protected final String trade_type = "NATIVE";
	
	/**货币类型*/
	protected final String fee_type = "CNY";
	
	/**QQ钱包分配分配的商户号*/
	@PublicData(value = "account")
	protected String mch_id;
	
	/**异步接收QQ钱包分配结果通知的回调地址*/
	@PublicData(value = "notifyUrl")
	protected String notify_url;
	
	/**随机字符串*/
	protected String nonce_str = IdUtil.fastSimpleUUID();
	
	/**订单号*/
	@PublicData(value = "orderNumber")
	protected String out_trade_no;
	
	/**商品简单描述*/
	@PublicData(value = "des")
	protected String body;
	
	/**交易金额【分】*/
	@PublicData(value = "amount", type = AmountType.CENT)
	protected String total_fee;
	
	/**终端IP*/
	@PublicData(value = "clientIp")
	protected String spbill_create_ip;
	
	/**数据签名字符串*/
	@NoSignature
	protected String sign;
	
	@Override
	protected Resultful getQRCodeURL() {
		ResponseEntity<String> result = restTemplate.postForEntity(domainName, XMLUtil.toXML(this), String.class);
		JSONObject json = XMLUtil.parseXmlToJson(result.getBody(), "UTF-8");
		if (json == null)
			return Resultful.error("XML_PARSE_ERROR！");
		
		if (json.getString("code_url") != null){
			String amount = String.format("%.2f", new BigDecimal(total_fee).divide(BigDecimal.valueOf(100)).doubleValue());
			return Resultful.qrCodeURL(json.getString("code_url"), out_trade_no,amount);
		}
		
		return Resultful.error(json.getString("return_msg"));
	}

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.QPAY;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public String getFee_type() {
		return fee_type;
	}

}
