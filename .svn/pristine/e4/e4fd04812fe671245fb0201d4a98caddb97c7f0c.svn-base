package com.cypay.common.pattern.template.payee.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.NotParam;

public class AlipayRequest {
	/* 请求地址 */
	@NotParam
	private String reqUrl;
	@NotParam
	private String privateKey;
	
	/* 接口名称 */
	private String method = "alipay.fund.trans.toaccount.transfer";
	/* 合作者身份ID */
	private String app_id;
	/* 编码 */
	private String charset = "UTF-8";
	/* 签名类型 */
	@NoSignature
	private String sign_type = "RSA2";

	private String biz_content;
	/* 付款批次号 */
	private String out_biz_no;
	/* 收款方账户类型 */
	private String payee_type = "ALIPAY_LOGONID";
	/* 收款方账户 */
	private String payee_account;
	/* 转账金额 */
	private String amount;
	
	private String remark;

	public AlipayRequest(String reqUrl,String out_biz_no,String app_id, String payee_account,String amount, String remark) {
		this.reqUrl = reqUrl;
		this.out_biz_no = out_biz_no;
		this.app_id = app_id;
		this.payee_account = payee_account;
		this.amount = amount;
		this.remark = remark;
	}
	
	public String biz_content(){
		JSONObject content = new JSONObject();
		content.put("out_biz_no", this.out_biz_no);
		content.put("payee_type", this.payee_type);
		content.put("payee_account", this.payee_account);
		content.put("amount", this.amount);
		content.put("remark", this.remark);
		return content.toJSONString();
	}

	public AlipayClient alipayClient(String privateKey,String publicKey) {
		return new DefaultAlipayClient(this.reqUrl, this.app_id, privateKey,"json", this.charset,publicKey,this.sign_type);
	}

	public String getReqUrl() {
		return reqUrl;
	}

	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getBiz_content() {
		return biz_content;
	}

	public void setBiz_content(String biz_content) {
		this.biz_content = biz_content;
	}

	public String getOut_biz_no() {
		return out_biz_no;
	}

	public void setOut_biz_no(String out_biz_no) {
		this.out_biz_no = out_biz_no;
	}

	public String getPayee_type() {
		return payee_type;
	}

	public void setPayee_type(String payee_type) {
		this.payee_type = payee_type;
	}

	public String getPayee_account() {
		return payee_account;
	}

	public void setPayee_account(String payee_account) {
		this.payee_account = payee_account;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
