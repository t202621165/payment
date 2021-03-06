package com.cypay.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cy_daifu")
public class DaiFu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/* 支付网关 */
	@NotBlank(message = "请求网关不能为空")
	private String reqUrl;
	/* APPID */
	@NotBlank(message = "合作者ID不能为空")
	private String partner;
	/* 付款账号名称 */
	private String accountName;
	/* 付款账号 */
	@NotBlank(message = "付款账号不能为空")
	private String email;
	/* 密钥 */
	@NotBlank(message = "密钥不能为空")
	@Column(columnDefinition = "text")
	private String securityKey;
	
	/*公钥 支付宝需填*/
	@Column(columnDefinition = "text")
	private String publicKey;
	
	/* 代付标识 alipay:支付宝 wechat：微信 */
	@NotBlank(message = "代付标识不能为空")
	private String mark;

	/* 标识名称 */
	@NotBlank(message = "标识名称不能为空")
	private String markName;

	/* 付款备注 */
	@NotBlank(message = "付款备注不能为空")
	private String remark;
	
	/** 微信网页授权密钥*/
	private String appSecret;
	
	/** 微信-公众号绑定重定向域名（网页授权域名）*/
	private String redirectUrl;

	public DaiFu() {
	};

	public DaiFu(String markName) {
		super();
		this.markName = markName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReqUrl() {
		return reqUrl;
	}

	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecurityKey() {
		return securityKey;
	}

	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}
