package com.cypay.common.bo;

import java.math.BigDecimal;
import java.util.Date;

public class MainBo {
	
	private BigDecimal payAmountTotal; //交易总额
	
	private BigDecimal currentProfit; //当天利润
	
	private Long sendCount; //待发送订单笔数
	
	private Long merchantCount; //注册商户个数
	
	private Long orderCount; //今日订单数
	
	private BigDecimal payAmount; //今日成交额
	
	private Long zrOrderCount; //昨日订单数
	
	private BigDecimal zrPayAmount; //昨日成交额
	
	private Date lastLoginDateTime; //最后登陆时间
	

	public BigDecimal getPayAmountTotal() {
		return payAmountTotal == null ? new BigDecimal("0.00") : payAmountTotal;
	}

	public void setPayAmountTotal(BigDecimal payAmountTotal) {
		this.payAmountTotal = payAmountTotal;
	}

	public BigDecimal getCurrentProfit() {
		return currentProfit == null ? new BigDecimal("0.00") : currentProfit;
	}

	public void setCurrentProfit(BigDecimal currentProfit) {
		this.currentProfit = currentProfit;
	}

	public Long getSendCount() {
		return sendCount == null ? 0 : sendCount;
	}

	public void setSendCount(Long sendCount) {
		this.sendCount = sendCount;
	}

	public Long getMerchantCount() {
		return merchantCount == null ? 0 : merchantCount;
	}

	public void setMerchantCount(Long merchantCount) {
		this.merchantCount = merchantCount;
	}

	public Long getOrderCount() {
		return orderCount == null ? 0 : orderCount;
	}

	public void setOrderCount(Long orderCount) {
		this.orderCount = orderCount;
	}

	public BigDecimal getPayAmount() {
		return payAmount == null ? new BigDecimal("0.00") : payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public Long getZrOrderCount() {
		return zrOrderCount == null ? 0 : zrOrderCount;
	}

	public void setZrOrderCount(Long zrOrderCount) {
		this.zrOrderCount = zrOrderCount;
	}

	public BigDecimal getZrPayAmount() {
		return zrPayAmount == null ? new BigDecimal("0.00") : zrPayAmount;
	}

	public void setZrPayAmount(BigDecimal zrPayAmount) {
		this.zrPayAmount = zrPayAmount;
	}

	public Date getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public void setLastLoginDateTime(Date lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}
}
