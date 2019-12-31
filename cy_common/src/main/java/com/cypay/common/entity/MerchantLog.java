package com.cypay.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.annotation.jpa.Conditional;
import com.cypay.common.annotation.jpa.VerifyMode;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 商户日志
 * @author iwano
 *
 */
@Entity
@Table(name = "cy_merchant_log")
public class MerchantLog implements Serializable{
	private static final long serialVersionUID = 1L;

	@JpaOrderBy
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime; //操作时间
	
	private String ip; //操作ip
	
	private String discription; //操作描述
	
	private String message; // 执行结果
	
	@JpaQuery(select = false, cond = Conditional.EQ, verify = VerifyMode.isBeanId)
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Merchant merchant;
	
	public MerchantLog(){}
	
	public MerchantLog(Date date, String ip, String discription, String message, Merchant merchant) {
		this.dateTime = date;
		this.ip = ip;
		this.discription = discription;
		this.message = message;
		this.merchant = merchant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "MerchantLog [id=" + id + ", dateTime=" + dateTime + ", ip=" + ip + ", discription=" + discription
				+ ", message=" + message + "]";
	}

}
