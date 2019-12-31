package com.cypay.common.bo;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import com.cypay.common.vo.OrderVo;

public class OrderBo {
	
	public Page<OrderVo> page;
	
	public BigDecimal payAmount;
	
	public BigDecimal merchantProfit;
	
	public BigDecimal platformProfit;
	
	public BigDecimal tailAmount;
	
	public BigDecimal zrpayAmount;
	
	public BigDecimal zrmerchantProfit;
	
	public BigDecimal zrplatformProfit;
	
	public BigDecimal zrtailAmount;

	public Page<OrderVo> getPage() {
		return page;
	}

	public void setPage(Page<OrderVo> page) {
		this.page = page;
	}

	public BigDecimal getPayAmount() {
		return payAmount == null ? new BigDecimal("0.00") : payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public BigDecimal getMerchantProfit() {
		return merchantProfit == null ? new BigDecimal("0.00") : merchantProfit;
	}

	public void setMerchantProfit(BigDecimal merchantProfit) {
		this.merchantProfit = merchantProfit;
	}

	public BigDecimal getPlatformProfit() {
		return platformProfit == null ? new BigDecimal("0.00") : platformProfit;
	}

	public void setPlatformProfit(BigDecimal platformProfit) {
		this.platformProfit = platformProfit;
	}

	public BigDecimal getZrpayAmount() {
		return zrpayAmount == null ? new BigDecimal("0.00") : zrpayAmount;
	}

	public void setZrpayAmount(BigDecimal zrpayAmount) {
		this.zrpayAmount = zrpayAmount;
	}

	public BigDecimal getZrmerchantProfit() {
		return zrmerchantProfit == null ? new BigDecimal("0.00") : zrmerchantProfit;
	}

	public void setZrmerchantProfit(BigDecimal zrmerchantProfit) {
		this.zrmerchantProfit = zrmerchantProfit;
	}

	public BigDecimal getZrplatformProfit() {
		return zrplatformProfit == null ? new BigDecimal("0.00") : zrplatformProfit;
	}

	public void setZrplatformProfit(BigDecimal zrplatformProfit) {
		this.zrplatformProfit = zrplatformProfit;
	}

	public BigDecimal getTailAmount() {
		return tailAmount == null ? new BigDecimal("0.00") : tailAmount;
	}

	public void setTailAmount(BigDecimal tailAmount) {
		this.tailAmount = tailAmount;
	}

	public BigDecimal getZrtailAmount() {
		return zrtailAmount == null ? new BigDecimal("0.00") : zrtailAmount;
	}

	public void setZrtailAmount(BigDecimal zrtailAmount) {
		this.zrtailAmount = zrtailAmount;
	}
	
}
