package com.cypay.common.vo;

import java.math.BigDecimal;

import com.cypay.common.entity.MerchantProduct;

public class MerchantProductVo extends MerchantProduct {

	private static final long serialVersionUID = 1L;
	
	private Long productId;
	
	private String productName;
	
	private Integer pSort;
	
	private Integer pType;
	
	private BigDecimal rate = new BigDecimal(0);
	
	public MerchantProductVo() {
		
	}
	
	public MerchantProductVo(Long id,Long productId,String productName, BigDecimal rate,Integer type, Boolean state) {
		this.setId(id);
		this.setState(state);
		this.productId = productId;
		this.productName = productName;
		this.pType = type;
		this.rate = rate;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getpSort() {
		return pSort;
	}

	public void setpSort(Integer pSort) {
		this.pSort = pSort;
	}

	public Integer getpType() {
		return pType;
	}

	public void setpType(Integer pType) {
		this.pType = pType;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "MerchantProductVo [productId=" + productId + ", productName=" + productName + ", rate=" + rate + "]";
	}

}
