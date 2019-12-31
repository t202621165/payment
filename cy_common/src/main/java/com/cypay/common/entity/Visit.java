package com.cypay.common.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * IPS访问实体
 * 
 * @author iwano
 *
 */
@Entity
@Table(name = "cy_visit", indexes = { @Index(columnList = "merchantId"), @Index(columnList = "visitDate"),
		@Index(columnList = "domain"), @Index(columnList = "ips") })
public class Visit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** 访问域名 */
	private String domain = "0";
	/** 访问日期 */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date visitDate = new Date();
	/** 访问时间 */
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date visitTime = new Date();
	/** 登陆时间 */
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date dlTime = new Date();
	/** 所属商户 */
	private Long merchantId;
	/** 访问IP */
	private String ips = "0.0.0.0";
	/** 登陆次数 */
	private Long count = 0L;
	/** 订单次数 */
	private Long orderCount = 0L;
	/** 订单支付金额 */
	private BigDecimal orderMoney = new BigDecimal("0.00");
	/** 订单利润 */
	private BigDecimal profit = new BigDecimal("0.00");

	/******************************* @Transient *******************************/
	/** 截止日期 */
	@Transient
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate;

	/** 显示前多少条记录 */
	@Transient
	private int pageSize;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
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

	public Long getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Long orderCount) {
		this.orderCount = orderCount;
	}

	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDlTime() {
		return dlTime;
	}

	public void setDlTime(Date dlTime) {
		this.dlTime = dlTime;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize < 5 ? 5 : pageSize > 100 ? 100 : pageSize;
	}

}
