package com.cypay.pay.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.util.StringUtils;

import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.vo.Result;

@SuppressWarnings("serial")
public class RechargeVo implements Serializable {
	
	private Integer type;
	
	private String typeMark;
	
	private String productMark;
	
	private String productName;
	
	private Long galleryId;
	
	private String galleryMark;
	
	private String realGalleryMark;
	
	private String account;
	
	private String appId;
	
	private String secretKey;
	
	private String des;
	
	private BigDecimal minAmount;
	
	private BigDecimal maxAmount;
	
	private Boolean state = Boolean.TRUE;
	
	private Boolean isRedirect = Boolean.TRUE;
	
	private String reqUrl;
	
	private BigDecimal amount;
	
	private String orderNumber;
	
	private String notifyUrl;
	
	private String returnUrl;
	
	private String clientIp;
	
	private String currentReqUrl;
	
	public RechargeVo() {
		
	}
	
	public RechargeVo(Integer type, String productMark, String typeMark, String productName, Long galleryId, 
			String galleryMark, String account, String appId, String secretKey, String des, BigDecimal minAmount, 
			BigDecimal maxAmount, Boolean state, Boolean isRedirect, String reqUrl) {
		this.type = type;
		this.productMark = productMark;
		this.typeMark = typeMark;
		this.productName = productName;
		this.galleryId = galleryId;
		this.galleryMark = galleryMark;
		this.realGalleryMark = galleryMark;
		this.account = account;
		this.appId = appId;
		this.secretKey = secretKey;
		this.des = des;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.state = state;
		this.isRedirect = isRedirect;
		this.reqUrl = reqUrl;
	}
	
	public Result validate(BigDecimal amount) {
		if (this.galleryId == null || !this.state)
			return Result.error("PRODUCT_UNUSABLE！");
		
		if (StringUtils.isEmpty(this.account) || 
				StringUtils.isEmpty(this.secretKey) || StringUtils.isEmpty(this.reqUrl)) {
			return Result.error("PRODUCT_UNUSABLE！");
		}
		
		if (this.minAmount != null && amount.compareTo(this.minAmount) == -1) {
			return Result.error(CommonUtil.getBufferString(
					"【", this.productName, "】充值金额不能小于", this.minAmount.doubleValue()));
		}
		
		if (this.maxAmount != null && this.maxAmount.compareTo(
				BigDecimal.ZERO) == 1 && amount.compareTo(this.maxAmount) == 1) {
			return Result.error(CommonUtil.getBufferString(
					"【", this.productName, "】充值金额不能超过", this.maxAmount.doubleValue()));
		}
		
		if (!PaymentType.getIsUnified(galleryMark)) {
			this.galleryMark = String.format("%s_%s", this.galleryMark, this.typeMark);
		}
		
		if (this.type == 0) {
			this.productMark = this.typeMark;
		}
		
		if (StringUtils.isEmpty(this.des)) {
			this.des = this.typeMark;
		}
		
		return Result.success();
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTypeMark() {
		return typeMark;
	}

	public void setTypeMark(String typeMark) {
		this.typeMark = typeMark;
	}

	public String getProductMark() {
		return productMark;
	}

	public void setProductMark(String productMark) {
		this.productMark = productMark;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(Long galleryId) {
		this.galleryId = galleryId;
	}

	public String getGalleryMark() {
		return galleryMark;
	}

	public void setGalleryMark(String galleryMark) {
		this.galleryMark = galleryMark;
	}

	public String getRealGalleryMark() {
		return realGalleryMark;
	}

	public void setRealGalleryMark(String realGalleryMark) {
		this.realGalleryMark = realGalleryMark;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getReqUrl() {
		return reqUrl;
	}

	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	public BigDecimal getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}

	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public Boolean getIsRedirect() {
		return isRedirect;
	}

	public void setIsRedirect(Boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getCurrentReqUrl() {
		return currentReqUrl;
	}

	public void setCurrentReqUrl(String currentReqUrl) {
		this.currentReqUrl = currentReqUrl;
	}

	@Override
	public String toString() {
		return "RechargeVo [type=" + type + ", typeMark=" + typeMark + ", productMark=" + productMark + ", productName="
				+ productName + ", galleryId=" + galleryId + ", galleryMark=" + galleryMark + ", realGalleryMark="
				+ realGalleryMark + ", account=" + account + ", appId=" + appId + ", secretKey=" + secretKey + ", des="
				+ des + ", minAmount=" + minAmount + ", maxAmount=" + maxAmount + ", state=" + state + ", isRedirect="
				+ isRedirect + ", reqUrl=" + reqUrl + ", amount=" + amount + ", orderNumber=" + orderNumber
				+ ", notifyUrl=" + notifyUrl + ", returnUrl=" + returnUrl + ", clientIp=" + clientIp + "]";
	}

}
