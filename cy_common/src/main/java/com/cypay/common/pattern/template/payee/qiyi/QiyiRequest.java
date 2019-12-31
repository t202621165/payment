package com.cypay.common.pattern.template.payee.qiyi;

import com.cypay.common.annotation.NoSignature;
import com.cypay.common.entity.DaiFu;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.MD5Util;
import com.cypay.common.vo.SettleMentVo;

public class QiyiRequest {
	
	private String merchant_id; //商户账号
	
	private String merchant_order; //业务订单号唯一
	
	private String total_amount; //代付金额
	
	private String bank_code; //银行卡标识
	
	private String bank_name; //开户行名称
	
	private String real_name; //开户真实姓名
	
	private String bank_number; //开户行卡号
	
	@NoSignature
	private String sign; //签名结果
	
	public QiyiRequest(){}
	
	public QiyiRequest(DaiFu daifu,SettleMentVo settlement){
		this.merchant_id = daifu.getPartner();
		this.merchant_order = settlement.getSerialNumber();
		this.total_amount = String.format("%.2f", settlement.getAmount().doubleValue());
		this.bank_code = settlement.getMark();
		this.bank_name = settlement.getBankName();
		this.real_name = settlement.getRealName();
		this.bank_number = settlement.getBankNumber();
		this.sign = sign(daifu.getSecurityKey());
	}
	
	private String sign(String key){
		return MD5Util.signToLowerCase(CommonUtil.getSignStr(this), key, "utf-8");
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

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getBank_number() {
		return bank_number;
	}

	public void setBank_number(String bank_number) {
		this.bank_number = bank_number;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
