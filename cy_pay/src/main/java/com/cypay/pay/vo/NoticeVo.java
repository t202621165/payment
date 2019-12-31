package com.cypay.pay.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected  Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Long orderId;
	
	private String orderNumber;
	
	private String supNumber;
	
	private BigDecimal payAmount;
	
	private BigDecimal tailAmount;
	
	private String playerAccount;
	
	private Integer orderState;
	
	private String secretKey;
	
	private Boolean isRedirect;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getSupNumber() {
		return supNumber;
	}

	public void setSupNumber(String supNumber) {
		this.supNumber = supNumber;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	

	public BigDecimal getTailAmount() {
		return tailAmount;
	}

	public void setTailAmount(BigDecimal tailAmount) {
		this.tailAmount = tailAmount;
	}

	public String getPlayerAccount() {
		return playerAccount;
	}

	public void setPlayerAccount(String playerAccount) {
		this.playerAccount = playerAccount;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Boolean getIsRedirect() {
		return isRedirect;
	}

	public void setIsRedirect(Boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	@Override
	public String toString() {
		return "NoticeVo [orderId=" + orderId + ", orderNumber=" + orderNumber + ", supNumber=" + supNumber
				+ ", payAmount=" + payAmount + ", playerAccount=" + playerAccount + ", orderState=" + orderState
				+ ", secretKey=" + secretKey + "]";
	}
	
}
