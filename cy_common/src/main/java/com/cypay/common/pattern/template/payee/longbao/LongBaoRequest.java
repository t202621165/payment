package com.cypay.common.pattern.template.payee.longbao;

import java.io.UnsupportedEncodingException;

import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.MD5Util;

import cn.hutool.core.lang.UUID;

public class LongBaoRequest {
	
	private String parter;
	
	private String orderid;
	
	private String amount;
	
	private String accout_type = "0";
	
	private String account_no;
	
	private String account_name;
	
	private String bank_code;
	
	private String nonce_str;
	
	private String clientip;
	
	private String sign;
	
	
	public LongBaoRequest(String parter, String orderid, String amount, String account_no,
			String account_name,String key,String bank_code) throws UnsupportedEncodingException {
		super();
		this.parter = parter;
		this.orderid = orderid;
		this.amount = amount;
		this.account_no = account_no;
		this.account_name = account_name;
		this.bank_code = bank_code;
		this.nonce_str = UUID.fastUUID().toString().replace("-", "");
		this.clientip = "47.75.81.50";
		this.sign = getRequestSign(key);
	}
	
	private String getRequestSign(String key){
		StringBuffer buffer = new StringBuffer();
		buffer.append("parter="+getParter()).append("&orderid="+getOrderid())
		.append("&amount="+getAmount()).append("&accout_type="+getAccout_type())
		.append("&account_no="+getAccount_no()).append("&account_name="+getAccount_name())
		.append("&nonce_str="+getNonce_str());
		System.out.println(String.format("请求签名串：%s",buffer.toString())+key);
		return MD5Util.signToLowerCase(buffer.toString(), key, "GB2312");
	}
	
	public String requestParam(){
		return CommonUtil.getQueryString(this);
	}

	public String getParter() {
		return parter;
	}

	public void setParter(String parter) {
		this.parter = parter;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAccout_type() {
		return accout_type;
	}

	public void setAccout_type(String accout_type) {
		this.accout_type = accout_type;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getClientip() {
		return clientip;
	}

	public void setClientip(String clientip) {
		this.clientip = clientip;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
