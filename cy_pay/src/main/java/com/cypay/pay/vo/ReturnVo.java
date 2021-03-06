package com.cypay.pay.vo;

import java.math.BigDecimal;

public class ReturnVo extends NoticeVo {

	private static final long serialVersionUID = 1L;

	private String serviceQQ;
	
	private String servicePhone;
	
	private String productName;
	
	private String partitionName;
	
	private String remarks;
	
	public ReturnVo() {
		
	}
	
	public ReturnVo(String orderNumber, BigDecimal payAmount, BigDecimal tailAmount, 
			String productName, String partitionName, String playerAccount, Integer state, 
			String secretKey, String serviceQQ, String servicePhone, String remarks) {
		setOrderNumber(orderNumber);
		setPayAmount(payAmount);
		this.productName = productName;
		this.partitionName = partitionName;
		setPlayerAccount(playerAccount);
		setOrderState(state);
		setSecretKey(secretKey);
		setTailAmount(tailAmount);
		this.serviceQQ = serviceQQ;
		this.servicePhone = servicePhone;
		this.remarks = remarks;
	}

	public String getServiceQQ() {
		return serviceQQ;
	}

	public void setServiceQQ(String serviceQQ) {
		this.serviceQQ = serviceQQ;
	}

	public String getServicePhone() {
		return servicePhone;
	}

	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPartitionName() {
		return partitionName;
	}

	public void setPartitionName(String partitionName) {
		this.partitionName = partitionName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ReturnVo [serviceQQ=" + serviceQQ + ", servicePhone=" + servicePhone + ", productName=" + productName
				+ ", partitionName=" + partitionName + ", remarks=" + remarks + "]";
	}
	
}
