package com.cypay.pay.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.cypay.common.vo.ReissueRecordVo;

public class NotifyVo extends NoticeVo {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal hundredth = new BigDecimal("0.01");
	
	private BigDecimal thousandth = new BigDecimal("0.0001");
	
	private Date orderDate;
	
	private Long merchantId;
	
	private Long agentId;
	
	private Long productId;
	
	private Long partitionId;
	
	private String playerIp;
	
	private BigDecimal galleryRate;
	
	private BigDecimal productRate;
	
	private BigDecimal agentRate;
	
	private String uuid;
	
	private String resultCode;
	
	public NotifyVo() {
		
	}
	
	public NotifyVo(Long orderId, Date orderDate, Long merchantId, Long agentId, Long productId, Long partitionId, 
			String playerIp, String playerAccount, BigDecimal galleryRate, BigDecimal productRate, 
			BigDecimal agentRate, Integer state, String secretKey, String uuid,BigDecimal amount,BigDecimal tailAmount) {
		setOrderId(orderId);
		this.orderDate = orderDate;
		this.merchantId = merchantId;
		this.agentId = agentId;
		this.productId = productId;
		this.partitionId = partitionId;
		this.playerIp = playerIp;
		this.uuid = uuid;
		setPlayerAccount(playerAccount);
		this.galleryRate = galleryRate;
		this.productRate = productRate;
		this.agentRate = agentRate;
		setOrderState(state);
		setSecretKey(secretKey);
		setPayAmount(amount);
		setTailAmount(tailAmount);
	}
	
	public ReissueRecordVo reissueVo() {
		ReissueRecordVo vo = new ReissueRecordVo(getOrderNumber(), getPayAmount(), 
				getPlayerAccount(), productId, partitionId);
		vo.setMerchantId(merchantId);
		return vo;
	}
	
	public BigDecimal merchantProfit(BigDecimal tailRate) {
		try {
			BigDecimal tailAmount = getTailAmount().multiply(galleryRate).multiply(tailRate).multiply(thousandth);
			return getPayAmount().multiply(productRate).multiply(hundredth).add(tailAmount);
//			return this.productRate.multiply(getPayAmount()).add(augend).multiply(new BigDecimal(0.01));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return BigDecimal.ZERO;
	}
	
	public BigDecimal platformProfit(BigDecimal tailRate) {
		try {
			//tailRate = new BigDecimal("100").subtract(tailRate);
			//BigDecimal tailAmount = getTailAmount().multiply(galleryRate).multiply(tailRate).multiply(thousandth);
			return getPayAmount().multiply(this.galleryRate.subtract(
					this.agentId == null ? this.productRate : this.agentRate)).multiply(hundredth);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return BigDecimal.ZERO;
	}
	
	public BigDecimal tailAmountProfit(BigDecimal tailRate){
		tailRate = new BigDecimal("100").subtract(tailRate);
		return getTailAmount().multiply(galleryRate).multiply(tailRate).multiply(thousandth);
	}
	
	public BigDecimal agentProfit() {
		if (this.agentId != null) {
			try {
				return getPayAmount().multiply(this.agentRate.subtract(this.productRate)).multiply(hundredth);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return BigDecimal.ZERO;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPartitionId() {
		return partitionId;
	}

	public void setPartitionId(Long partitionId) {
		this.partitionId = partitionId;
	}

	public String getPlayerIp() {
		return playerIp;
	}

	public void setPlayerIp(String playerIp) {
		this.playerIp = playerIp;
	}

	public BigDecimal getGalleryRate() {
		return galleryRate;
	}

	public void setGalleryRate(BigDecimal galleryRate) {
		this.galleryRate = galleryRate;
	}

	public BigDecimal getProductRate() {
		return productRate;
	}

	public void setProductRate(BigDecimal productRate) {
		this.productRate = productRate;
	}

	public BigDecimal getAgentRate() {
		return agentRate;
	}

	public void setAgentRate(BigDecimal agentRate) {
		this.agentRate = agentRate;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "NotifyVo [merchantId=" + merchantId + ", agentId=" + agentId + ", productId=" + productId
				+ ", partitionId=" + partitionId + ", playerIp=" + playerIp + ", galleryRate=" + galleryRate
				+ ", productRate=" + productRate + ", agentRate=" + agentRate + ", uuid=" + uuid + ", resultCode="
				+ resultCode + "]";
	}

}
