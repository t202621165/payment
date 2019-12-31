package com.cypay.pay.payment.open;

import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.GenericSignSortPayment;
import com.cypay.pay.payment.Payment;

/**
 * -支付接口-官方支付宝
 * @author International
 * 2018年7月30日 下午12:22:57
 */
@Payment
public class PayByAlipay extends GenericSignSortPayment {
	
	public final String service = "create_direct_pay_by_user";
	
	/**数据签名字符集*/
	public final String _input_charset = "UTF-8";
	
	/**付款方式*/
	public final Integer payment_type = 1;
	
	/**数据签名方式*/
	@NoSignature
	public final String sign_type = "MD5";
	
	/**订单号*/
	@PublicData(value = "orderNumber")
	public String out_trade_no;
	
	/**支付宝接口商户号/对接帐号*/
	@PublicData(value = "account")
	public String partner;
	
	@PublicData(value = "account")
	public String seller_id;
	
	/**支付结果通知URL*/
	@PublicData(value = "notifyUrl")
	public String notify_url;
	
	/**支付成功跳转URL*/
	@PublicData(value = "returnUrl")
	public String return_url;
	
	/**订单备注*/
	@PublicData(value = "des")
	public String subject;
	
	/**订单金额【元】*/
	@PublicData(value = "amount", type = AmountType.YUAN)
	public String total_fee;
	
	/**支付宝直联网银参数-默认：(DEFAULT)支付宝扫码支付*/
	@PublicData(value = "productMark", alias = true)
	public String defaultbank = "DEFAULT";
	
	/**数据签名字符串*/
	@NoSignature
	public String sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "DEFAULT");
		alias.put("CCB", "CCB");
		alias.put("ICBC", "ICBC");
		alias.put("ABC", "ABC");
		alias.put("CMB", "CMB");
		alias.put("COMM", "COMM");
		alias.put("CMBC", "CMBC");
		alias.put("PSBC", "PSBC");
		alias.put("BOC", "BOC");
		alias.put("CITIC", "CITIC");
		alias.put("SPDB", "SPDB");
		alias.put("CEB", "CEB");
		alias.put("CIB", "CIB");
		alias.put("PINGAN", "SPABANK");
		alias.put("CGB", "GDB");
	}
	
	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.ALIPAY;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getDefaultbank() {
		return defaultbank;
	}

	public void setDefaultbank(String defaultbank) {
		this.defaultbank = defaultbank;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
