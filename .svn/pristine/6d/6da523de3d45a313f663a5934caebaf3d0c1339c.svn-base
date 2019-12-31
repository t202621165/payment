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
@Payment
public class PayBy369Pay extends CustomSignSortPayment {
	
	@SignatureSort(1)
	@PublicData(value = "account")
	public String partner;

	@SignatureSort(2)
	@PublicData(value = "productMark", alias = true)
	public String banktype;
	
	@SignatureSort(3)
	@PublicData(value = "amount", type = AmountType.YUAN)
	public String paymoney;
	
	/**订单号*/
	@SignatureSort(4)
	@PublicData(value = "orderNumber")
	public String ordernumber;
	
	/**支付结果通知URL*/
	@SignatureSort(5)
	@PublicData(value = "notifyUrl")
	public String callbackurl;
	
	/**支付成功跳转URL*/
	@PublicData(value = "returnUrl")
	public String hrefbackurl;
	
	/**数据签名字符串*/
	public String sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "ALIPAY");
		alias.put("wechat", "WEIXIN");
		alias.put("qpay", "QQ");
		alias.put("tenpay", "TENPAY");
		alias.put("ICBC", "ICBC");
		alias.put("ABC", "ABC");
		alias.put("CCB", "CCB");
		alias.put("BOC", "BOC");
		alias.put("CMB", "CMB");
		alias.put("BOB", "BCCB");
		alias.put("COMM", "BOCO");
		alias.put("CIB", "CIB");
		alias.put("CMBC", "CMBC");
		alias.put("CEB", "CEB");
		alias.put("PINGAN", "PINGANBANK");
		alias.put("CITIC", "CTTIC");
		alias.put("CGB", "GDB");
		alias.put("BOSC", "SHB");
		alias.put("SPDB", "SPDB");
		alias.put("PSBC", "PSBC");
		alias.put("HXB", "HXB");
	}
	
	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.PAY_369;
	}

}
