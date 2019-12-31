package com.cypay.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SettlementExcel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String serialNumber;
	
	private Date applyDate;
	
	private String nickname;
	
	private BigDecimal amount;
	
	private BigDecimal cost;
	
	private String realName;
	
	private String bankName;
	
	private String bankNumber;
	
	private String bankBranch;
	
	private String discription;
	
	private Date complateDate;
	
	public SettlementExcel(String serialNumber, Date applyDate, String nickname, BigDecimal amount, 
			BigDecimal cost,String realName, String bankName, String bankNumber, String bankBranch, String discription, 
			Date complateDate) {
		this.serialNumber = serialNumber;
		this.applyDate = applyDate;
		this.nickname = nickname;
		this.amount = amount;
		this.cost = cost;
		this.realName = realName;
		this.bankName = bankName;
		this.bankNumber = bankNumber;
		this.bankBranch = bankBranch;
		this.discription = discription;
		this.complateDate = complateDate;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Date getComplateDate() {
		return complateDate;
	}

	public void setComplateDate(Date complateDate) {
		this.complateDate = complateDate;
	}

}
