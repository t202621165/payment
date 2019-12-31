package com.cypay.pay.payment.open;

import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;

/**
 * -支付接口-15173
 * @author International
 *
 */
@Payment(prefix = "&key=", upperCase = true)
public class PayBy15173 extends CustomSignSortPayment {
	
	/**15173平台商户ID*/
	@SignatureSort(1)
	@PublicData(value = "account")
	protected String bargainor_id;
	
	/**订单号*/
	@SignatureSort(2)
	@PublicData(value = "orderNumber")
	protected String sp_billno;
	
	/**支付类型*/
	@SignatureSort(3)
	protected final String pay_type = "a";
	
	/**支付成功跳转URL*/
	@SignatureSort(4)
	@PublicData(value = "returnUrl")
	protected String return_url;
	
	/**自定义参数*/
	@SignatureSort(5)
	@PublicData(value = "productMark")
	protected String attach;
	
	/**自定义参数*/
	@PublicData(value = "productMark")
	protected String zidy_code;
	
	/**支付结果通知URL*/
	@PublicData(value = "notifyUrl")
	protected String select_url;
	
	/**终端IP*/
	@PublicData(value = "clientIp")
	protected String czip;
	
	/**交易金额【元】*/
	@PublicData(value = "amount", type = AmountType.YUAN)
	protected String total_fee;
	
	/**数据签名字符串*/
	protected String sign;
	
	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.PAY_15173;
	}
	
	public String getBargainor_id() {
		return bargainor_id;
	}

	public void setBargainor_id(String bargainor_id) {
		this.bargainor_id = bargainor_id;
	}

	public String getSp_billno() {
		return sp_billno;
	}

	public void setSp_billno(String sp_billno) {
		this.sp_billno = sp_billno;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getZidy_code() {
		return zidy_code;
	}

	public void setZidy_code(String zidy_code) {
		this.zidy_code = zidy_code;
	}

	public String getSelect_url() {
		return select_url;
	}

	public void setSelect_url(String select_url) {
		this.select_url = select_url;
	}

	public String getCzip() {
		return czip;
	}

	public void setCzip(String czip) {
		this.czip = czip;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
