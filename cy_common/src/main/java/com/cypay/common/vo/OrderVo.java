package com.cypay.common.vo;

import static com.cypay.common.annotation.jpa.Conditional.EQ;
import static com.cypay.common.annotation.jpa.Conditional.IS_NOT_NULL;
import static com.cypay.common.annotation.jpa.VerifyMode.isBoolean;

import java.math.BigDecimal;
import java.util.Date;

import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Order;

public class OrderVo extends Order {

	private static final long serialVersionUID = 1L;

	@JpaQuery(select = false, value = "agent", cond = IS_NOT_NULL, verify = isBoolean)
	private Boolean isAgency = Boolean.FALSE;

	private Boolean isAdmin = Boolean.TRUE; // 是否为系统管理员查询

	private String productName;

	private String galleryName;

	private String partitionName;

	private BigDecimal rankRate;
	
	private BigDecimal galleryRate;

	@JpaQuery(select = false, value = "merchant", subField = "account", cond = EQ)
	private String account;
	
	@JpaQuery(select = false, value = "agent",subField = "account",cond = EQ)
	private String agencyAccount;

	private Integer ratio;

	private BigDecimal payAmountTotal; // 交易总额

	private BigDecimal currentProfit; // 当天利润

	private Long orderCount; // 订单总数
	
	private Long successCount; // 成功订单数
	
	private Long waitingCount; // 等待发送订单数

	@JpaQuery(select = false, value = "merchant", subField = "secretKey", cond = EQ)
	private String secretKey;

	private String statistics = "merchant"; // 统计类型

	private Date startDate;

	private Date endDate;

	private BigDecimal successRate = new BigDecimal("0.00");
	
	private Integer groupModle = 0;
	
	public OrderVo() {
	}

	/**
	 * 订单查询(商户)
	 */
	public OrderVo(Long id, Date orderDate, String orderNumber, BigDecimal amount, BigDecimal giveAmount, BigDecimal merchantProfit,
			BigDecimal agentProfit, Integer state, String playerAccount, String discription, String productName, String partitionName, 
			String partitionUseName, Date changeDate, Boolean isChangeInTime, Long merchantId, 
			String account, String nickname,String agencyAccount) {
		setId(id);
		setOrderNumber(orderNumber);
		setOrderDate(orderDate);
		setAmount(amount);
		setMerchantProfit(merchantProfit);
		setAgentProfit(agentProfit);
		setPlayerAccount(playerAccount);
		setDiscription(discription);
		setState(state);
		Merchant merchant = new Merchant(merchantId);
		merchant.setNickname(nickname);
		merchant.setAccount(account);
		setMerchant(merchant);
		this.partitionName = partitionName;
		if (changeDate != null && new Date().compareTo(changeDate) > 0) {
			this.partitionName = isChangeInTime ? partitionUseName : partitionName;
		}
		this.productName = productName;
		this.setGiveAmount(giveAmount);
		this.agencyAccount = agencyAccount;
	}
	
	/**
	 * 订单查询(系统管理员)
	 */
	public OrderVo(Long id, Date orderDate, String orderNumber, BigDecimal amount, BigDecimal giveAmount, BigDecimal merchantProfit,
			BigDecimal agentProfit, Integer state, String playerAccount, String discription, String productName, String partitionName, 
			String partitionUseName, Date changeDate, Boolean isChangeInTime, Long merchantId, String account, String nickname,String agencyAccount, BigDecimal platformProfit, String galleryName, BigDecimal tailAmount,BigDecimal tailAmountProfit) {
		this(id, orderDate, orderNumber, amount, giveAmount, merchantProfit, agentProfit, 
				state, playerAccount, discription, productName, partitionName, partitionUseName, changeDate, isChangeInTime, merchantId, account, nickname,agencyAccount);
		setPlatformProfit(platformProfit);
		this.galleryName = galleryName;
		setTailAmount(tailAmount);
		setTailAmountProfit(tailAmountProfit);
	}

	public OrderVo(String orderNumber, String supNumber, String playerQQ, String account, String partitionName, String playerAccount,
			String productName, Date orderDate, Date payDate, BigDecimal amount, BigDecimal payAmount, BigDecimal giveAmount, 
			BigDecimal redPacketAmount, BigDecimal rankRate,BigDecimal galleryRate, BigDecimal merchantProfit, BigDecimal platformProfit, 
			String galleryName, Integer state, String playerIp, String remarks, Integer ratio, BigDecimal tailRate, String discription) {
		this.setOrderNumber(orderNumber);
		this.setSupNumber(supNumber);
		this.setPlayerQQ(playerQQ);
		this.account = account;
		this.partitionName = partitionName;
		this.setPlayerAccount(playerAccount);
		this.productName = productName;
		this.setOrderDate(orderDate);
		this.setPayDate(payDate);
		this.setAmount(amount);
		this.setPayAmount(payAmount);
		this.setGiveAmount(giveAmount);
		this.setRedPacketAmount(redPacketAmount);
		this.rankRate = rankRate;
		this.galleryRate = galleryRate;
		this.setMerchantProfit(merchantProfit);
		this.setPlatformProfit(platformProfit);
		this.galleryName = galleryName;
		this.setState(state);
		this.setPlayerIp(playerIp);
		this.setRemarks(remarks);
		this.ratio = ratio;
		this.setTailRate(tailRate);
		this.setDiscription(discription);
	}

	public OrderVo(Date payDate, BigDecimal payAmount, BigDecimal giveAmount, BigDecimal redPacketAmount,
			String playerQQ, String playerPhone, String playerIp, String remarks) {
		this.setPayDate(payDate);
		this.setPayAmount(payAmount);
		this.setGiveAmount(giveAmount);
		this.setRedPacketAmount(redPacketAmount);
		this.setPlayerQQ(playerQQ);
		this.setPlayerPhone(playerPhone);
		this.setPlayerIp(playerIp);
		this.setRemarks(remarks);
	}

	public OrderVo(Long orderCount) {
		super();
		this.orderCount = orderCount;
	}

	public OrderVo(ReissueRecordVo v) {
		setOrderDate(v.getStartDate());
		setPayDate(v.getEndDate());
		setMerchant(v.getMerchant());
	}

	public OrderVo(BigDecimal payAmountTotal, BigDecimal currentProfit, BigDecimal payAmount) {
		super();
		this.payAmountTotal = payAmountTotal;
		this.currentProfit = currentProfit;
		setPayAmount(payAmount);
	}
	
	public OrderVo(BigDecimal payAmountTotal, BigDecimal currentProfit, BigDecimal payAmount,BigDecimal tailAmount) {
		super();
		this.payAmountTotal = payAmountTotal;
		this.currentProfit = currentProfit;
		setPayAmount(payAmount);
		setTailAmount(tailAmount);
	}

	public OrderVo(Date date, String account, BigDecimal currentProfit, Long orderCount, BigDecimal payAmount) {
		super();
		this.setOrderDate(date);
		this.account = account;
		this.currentProfit = currentProfit;
		this.orderCount = orderCount;
		setPayAmount(payAmount);
	}

	public OrderVo(Long orderCount, BigDecimal payAmount, String partitionName) {
		super();
		this.orderCount = orderCount;
		setPayAmount(payAmount);
		this.partitionName = partitionName;
	}

	public OrderVo(Long orderCount, Integer state, BigDecimal amount, BigDecimal payAmount, BigDecimal merchantProfit,
			BigDecimal agentProfit) {
		this.orderCount = orderCount;
		setState(state);
		setAmount(amount);
		setPayAmount(payAmount);
		setMerchantProfit(merchantProfit);
		setAgentProfit(agentProfit);
	}
	
	public OrderVo(Long orderCount, Integer state, BigDecimal amount, BigDecimal payAmount, BigDecimal merchantProfit,
			BigDecimal agentProfit, BigDecimal platformProfit, BigDecimal tailAmount,BigDecimal tailAmountProfit) {
		this(orderCount, state, amount, payAmount, merchantProfit, agentProfit);
		setPlatformProfit(platformProfit);
		setTailAmount(tailAmount);
		setTailAmountProfit(tailAmountProfit);
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getGalleryName() {
		return galleryName;
	}

	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}

	public String getPartitionName() {
		return partitionName;
	}

	public void setPartitionName(String partitionName) {
		this.partitionName = partitionName;
	}

	public Boolean getIsAgency() {
		return isAgency;
	}

	public void setIsAgency(Boolean isAgency) {
		this.isAgency = isAgency;
	}

	public BigDecimal getRankRate() {
		return rankRate;
	}

	public void setRankRate(BigDecimal rankRate) {
		this.rankRate = rankRate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAgencyAccount() {
		return agencyAccount;
	}

	public void setAgencyAccount(String agencyAccount) {
		this.agencyAccount = agencyAccount;
	}

	public Integer getRatio() {
		return ratio;
	}

	public void setRatio(Integer ratio) {
		this.ratio = ratio;
	}

	public BigDecimal getPayAmountTotal() {
		return payAmountTotal;
	}

	public void setPayAmountTotal(BigDecimal payAmountTotal) {
		this.payAmountTotal = payAmountTotal;
	}

	public BigDecimal getCurrentProfit() {
		return currentProfit;
	}

	public void setCurrentProfit(BigDecimal currentProfit) {
		this.currentProfit = currentProfit;
	}

	public Long getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Long orderCount) {
		this.orderCount = orderCount;
	}

	public Long getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Long successCount) {
		this.successCount = successCount;
	}

	public Long getWaitingCount() {
		return waitingCount;
	}

	public void setWaitingCount(Long waitingCount) {
		this.waitingCount = waitingCount;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getStatistics() {
		return statistics;
	}

	public void setStatistics(String statistics) {
		this.statistics = statistics;
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

	public BigDecimal getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(BigDecimal successRate) {
		this.successRate = successRate;
	}

	public BigDecimal getGalleryRate() {
		return galleryRate;
	}

	public void setGalleryRate(BigDecimal galleryRate) {
		this.galleryRate = galleryRate;
	}

	public Integer getGroupModle() {
		return groupModle;
	}

	public void setGroupModle(Integer groupModle) {
		this.groupModle = groupModle;
	}

	@Override
	public String toString() {
		return "OrderVo [isAdmin=" + isAdmin + ", productName=" + productName + ", galleryName=" + galleryName
				+ ", partitionName=" + partitionName + "]";
	}
}
