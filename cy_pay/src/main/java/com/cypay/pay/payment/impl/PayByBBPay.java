package com.cypay.pay.payment.impl;

import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;

/**
 * 
 * @author International
 * 2018年7月30日 下午12:22:57
 */
@Payment(prefix = "&")
public class PayByBBPay extends CustomSignSortPayment {
	
	@SignatureSort(1)
	public final String version = "1.0";

	@SignatureSort(2)
	@PublicData(value = "account")
	public String customerid;

	@SignatureSort(3)
	@PublicData(value = "amount", type = AmountType.YUAN)
	public String total_fee;
	
	/**订单号*/
	@SignatureSort(4)
	@PublicData(value = "orderNumber")
	public String sdorderno;
	
	/**支付结果通知URL*/
	@SignatureSort(5)
	@PublicData(value = "notifyUrl")
	public String notifyurl;
	
	/**支付成功跳转URL*/
	@SignatureSort(6)
	@PublicData(value = "returnUrl")
	public String returnurl;
	
	@PublicData(value = "typeMark", alias = true)
	public String paytype;
	
	@PublicData(value = "productMark", alias = true)
	public String bankcode;
	
	/**数据签名字符串*/
	public String sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "alipay");
		alias.put("wechat", "weixin");
		alias.put("qpay", "qq");
		alias.put("tenpay", "tenpay");
		alias.put("ebank", "bank");
		alias.put("CCB", "CCB");
		alias.put("ICBC", "ICBC");
		alias.put("ABC", "ABC");
		alias.put("BOC", "BOCSH");
		alias.put("HXB", "HXB");
		alias.put("CMB", "CMB");
		alias.put("SPDB", "SPDB");
		alias.put("CGB", "GDB");
		alias.put("COMM", "BOCOM");
		alias.put("PSBC", "PSBC");
		alias.put("CITIC", "CNCB");
		alias.put("CMBC", "CMBC");
		alias.put("CEB", "CEB");
		alias.put("CIB", "CIB");
		alias.put("BOSC", "BOS");
		alias.put("PINGAN", "PAB");
		alias.put("BOB", "BCCB");
	}
	
	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.BBPAY;
	}

}
