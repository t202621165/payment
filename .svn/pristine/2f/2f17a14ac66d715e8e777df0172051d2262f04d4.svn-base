package com.cypay.pay.payment.open;

import com.cypay.common.annotation.NotParam;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.pay.payment.CustomSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.RechargeVo;

/**
 * -支付接口-口碑聚合支付
 * @author International
 * @2019年1月7日 下午4:39:40
 */
@Payment(upperCase = true)
public class PayByKbpay extends CustomSignSortPayment {
	
	/**接口版本号*/
	@SignatureSort(8)
	private final String ver = "2.0";

	/**支付网关ID*/
	@SignatureSort(2)
	@PublicData(value = "productMark", alias = true)
	private String gateid;
	
	/**口碑统一发放的商户ID*/
	@SignatureSort(1)
	@PublicData(value = "account")
	private String userid;
	
	/**订单金额【元】*/
	@SignatureSort(3)
	@PublicData(value = "amount", type = AmountType.YUAN)
	private String ordermoney;
	
	/**订单号*/
	@SignatureSort(4)
	@PublicData(value = "orderNumber")
	private String billno;
	
	/**支付成功跳转URL*/
	@SignatureSort(6)
	@PublicData(value = "returnUrl")
	private String returnurl;
	
	/**支付结果通知URL*/
	@SignatureSort(7)
	@PublicData(value = "notifyUrl")
	private String notifyurl;
	
	/**终端IP*/
	@PublicData(value = "clientIp")
	private String userip;
	
	@NotParam
	@SignatureSort(5)
	@PublicData(value = "secretKey")
	private String keyvalue;
	
	private String sign;
	
	@Override
	protected void initPreProcess() {
		alias.put("alipay", "43");
		alias.put("wechat", "42");
		alias.put("qpay", "50");
		alias.put("CCB", "6");
		alias.put("ICBC", "5");
		alias.put("ABC", "7");
		alias.put("CMB", "11");
		alias.put("COMM", "10");
		alias.put("CMBC", "18");
		alias.put("PSBC", "8");
		alias.put("BOC", "9");
		alias.put("CITIC", "16");
		alias.put("SPDB", "13");
		alias.put("CEB", "12");
		alias.put("CIB", "17");
		alias.put("HXB", "14");
		alias.put("PINGAN", "22");
		alias.put("CGB", "15");
	}
	
	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.KBPAY;
	}

	@Override
	protected void initPostProcess(RechargeVo recharge) {
		recharge.setSecretKey("");
	}
	
	public String getGateid() {
		return gateid;
	}

	public void setGateid(String gateid) {
		this.gateid = gateid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getOrdermoney() {
		return ordermoney;
	}

	public void setOrdermoney(String ordermoney) {
		this.ordermoney = ordermoney;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getReturnurl() {
		return returnurl;
	}

	public void setReturnurl(String returnurl) {
		this.returnurl = returnurl;
	}

	public String getNotifyurl() {
		return notifyurl;
	}

	public void setNotifyurl(String notifyurl) {
		this.notifyurl = notifyurl;
	}

	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	public String getVer() {
		return ver;
	}

	public String getKeyvalue() {
		return keyvalue;
	}

	public void setKeyvalue(String keyvalue) {
		this.keyvalue = keyvalue;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
