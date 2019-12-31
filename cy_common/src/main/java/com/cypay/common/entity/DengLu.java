package com.cypay.common.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 登陆器打开实体
 * 
 * @author iwano
 * uniqueConstraints = { @UniqueConstraint(columnNames = { "merchantId", "dlDate" }) } 
 */
@Entity
@Table(name = "cy_denglu",indexes = {@Index(columnList = "merchantId"),@Index(columnList = "dlDate")})
public class DengLu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** 商户ID */
	private Long merchantId;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	/** 登陆日期 */
	private Date dlDate = new Date();
	/** 登陆时间 */
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date dlTime = new Date();
	/**访问时间*/
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date vTime = new Date();
	/** 登陆IP */
	private String ips = "0.0.0.0";
	/** 登陆次数 */
	private Long count = 0L;
	/** 自行输入访问次数 */
	private Long selfCount = 0L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Date getDlDate() {
		return dlDate;
	}

	public void setDlDate(Date dlDate) {
		this.dlDate = dlDate;
	}

	public Date getDlTime() {
		return dlTime;
	}

	public void setDlTime(Date dlTime) {
		this.dlTime = dlTime;
	}

	public Date getvTime() {
		return vTime;
	}

	public void setvTime(Date vTime) {
		this.vTime = vTime;
	}

	public String getIps() {
		return ips;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getSelfCount() {
		return selfCount;
	}

	public void setSelfCount(Long selfCount) {
		this.selfCount = selfCount;
	}
	
}
