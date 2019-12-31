package com.cypay.pay.payment.open;

import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.GenericSignSortPayment;
import com.cypay.pay.payment.Payment;

/**
 * -支付接口-官方财付通
 * @author International
 *
 */
@Payment(prefix = "&key=")
public class PayByTenpay extends GenericSignSortPayment {

	/**币种*/
	private final String fee_type = "1";
	
	/**接收财付通通知的URL*/
	@PublicData(value = "notifyUrl")
	private String notify_url;
	
	/**交易完成后跳转的URL*/
	@PublicData(value = "returnUrl")
	private String return_url;
	
	/**银行类型*/
	@PublicData(value = "productMark", alias = true)
	private String bank_type = "DEFAULT";
	
	/**商品名称*/
	@PublicData(value = "des")
	private String subject;
	
	/**商品描述*/
	@PublicData(value = "des")
	private String body;
	
	/**财付通统一分配的商户号*/
	@PublicData(value = "account")
	private String partner;
	
	/**订单号*/
	@PublicData(value = "orderNumber")
	private String out_trade_no;
	
	/**订单总金额【分】*/
	@PublicData(value = "amount", type = AmountType.CENT)
	private String total_fee;
	
	/**终端IP*/
	@PublicData(value = "clientIp")
	private String spbill_create_ip;
	
	/**数据签名字符串*/
	@NoSignature
	private String sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("tenpay", "DEFAULT");
		alias.put("CCB", "CCB_D");
		alias.put("ICBC", "ICBC_D");
		alias.put("ABC", "ABC");
		alias.put("CMB", "CMB_D");
		alias.put("COMM", "COMM_D");
		alias.put("CMBC", "CMBC_D");
		alias.put("PSBC", "POSTGC");
		alias.put("BOC", "BOC_D");
		alias.put("CITIC", "CITIC");
		alias.put("SPDB", "SPDB");
		alias.put("CEB", "CEB_D");
		alias.put("CIB", "CIB_D");
		alias.put("PINGAN", "PAB");
		alias.put("CGB", "GDB_D");
	}
	
	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.TENPAY;
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

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
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

	public String getFee_type() {
		return fee_type;
	}

}
