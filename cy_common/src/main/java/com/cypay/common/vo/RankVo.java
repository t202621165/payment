package com.cypay.common.vo;

import java.util.Date;

import com.cypay.common.entity.Rank;

public class RankVo extends Rank {
	
	private static final long serialVersionUID = 1L;

	private Long merchantCount;
	
	private Long merchantId;
	
	private String merchantAccount;
	
	public RankVo(){};
	
	public RankVo(Long id, String name, Long merchantId) {
		setId(id);
		setName(name);
		this.merchantId = merchantId;
	}
	
	public RankVo(Long id, Date createDate, String name, Boolean isDefault, Long merchantCount) {
		setId(id);
		setName(name);
		setIsDefault(isDefault);
		setCreateDate(createDate);
		this.merchantCount = merchantCount;
	}
	
	public RankVo(Long id, Date createDate, String name, Boolean isDefault, Boolean isAgency, Long merchantId, String merchantAccount, Long merchantCount) {
		this(id, createDate, name, isDefault, merchantCount);
		setIsAgency(isAgency);
		this.merchantId = merchantId;
		this.merchantAccount = merchantAccount;
	}

	public Long getMerchantCount() {
		return merchantCount;
	}

	public void setMerchantCount(Long merchantCount) {
		this.merchantCount = merchantCount;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantAccount() {
		return merchantAccount;
	}

	public void setMerchantAccount(String merchantAccount) {
		this.merchantAccount = merchantAccount;
	}

}
