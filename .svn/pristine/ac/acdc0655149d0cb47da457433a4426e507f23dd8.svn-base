package com.cypay.common.vo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cypay.common.annotation.jpa.JavaType;
import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.annotation.jpa.OrderType;
import com.cypay.common.annotation.jpa.Conditional;

public class SettleMentReplyVo {
	
	@JpaQuery
	@JpaOrderBy
	private Long id;
	
	private Long settlementId;
	
	@JpaQuery
	private Date replyDate;
	
	@JpaQuery
	private String serialNumber;
	
	@JpaQuery(cond = Conditional.EQ)
	@JpaOrderBy(type = OrderType.ASC)
	private Boolean state;
	
	@JpaQuery(value = "user", chain = "username", subField = "username", cond = Conditional.EQ)
	private String userName;
	
	private Long totalCount;
	
	private BigDecimal totalAmount;
	
	@JpaQuery(select = false, value = "replyDate", cond = Conditional.BETWEEN_$GTE, jType = JavaType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	
	@JpaQuery(select = false, value = "replyDate", cond = Conditional.BETWEEN_$LTE, jType = JavaType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate;

	public SettleMentReplyVo(){};
	
	public SettleMentReplyVo(Long id, Date replyDate, String serialNumber, Boolean state,
			String userName, Long totalCount, BigDecimal totalAmount) {
		super();
		this.id = id;
		this.replyDate = replyDate;
		this.serialNumber = serialNumber;
		this.state = state;
		this.userName = userName;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
	}
	
	public SettleMentReplyVo(BigDecimal totalAmount){
		this.totalAmount = totalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Long getSettlementId() {
		return settlementId;
	}

	public void setSettlementId(Long settlementId) {
		this.settlementId = settlementId;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
