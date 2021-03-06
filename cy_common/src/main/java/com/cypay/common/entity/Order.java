package com.cypay.common.entity;

import static com.cypay.common.annotation.jpa.Conditional.BETWEEN_$GTE;
import static com.cypay.common.annotation.jpa.Conditional.BETWEEN_$LTE;
import static com.cypay.common.annotation.jpa.Conditional.EQ;
import static com.cypay.common.annotation.jpa.Conditional.EQ_OR;
import static com.cypay.common.annotation.jpa.VerifyMode.isBeanId;
import static com.cypay.common.annotation.jpa.VerifyMode.isDecimal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.cypay.common.annotation.jpa.JavaType;
import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;

/**
 * 系统订单实体
 * @author International
 * 2018年8月1日 上午10:12:39
 */
@Entity
@Table(name = "cy_order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**订单-ID*/
	@JpaQuery
	@JpaOrderBy
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**订单创建时间*/
	@JpaQuery(cond = BETWEEN_$GTE, jType = JavaType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	/**系统订单号*/
	@JpaQuery(subField = {"orderNumber", "supNumber"}, cond = EQ_OR)
	@Column(length = 30, nullable = false, unique = true)
	private String orderNumber;

	/**上级订单号*/
	@Column(length = 40)
	private String supNumber;
	
	/**下单金额*/
	@JpaQuery(cond = BETWEEN_$GTE, jType = JavaType.DECIMAL)
	@Column(nullable = false)
	private BigDecimal amount;
	
	/*订单尾额*/
	private BigDecimal tailAmount = new BigDecimal("0.00");
	
	/**付款金额*/
	@JpaQuery(select = false, value = "amount", cond = BETWEEN_$LTE, jType = JavaType.DECIMAL, verify = isDecimal)
	@Column(nullable = false)
	private BigDecimal payAmount = BigDecimal.ZERO;
	
	/**赠送金额*/
	@JpaQuery
	private BigDecimal giveAmount = BigDecimal.ZERO;
	
	/**红包赠送金额*/
	private BigDecimal redPacketAmount = BigDecimal.ZERO;
	
	/**付款时间*/
	@JpaQuery(select = false, value = "orderDate", cond = BETWEEN_$LTE, jType = JavaType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date payDate;
	
	/**商户利润*/
	@JpaQuery
	@Column(nullable = false)
	private BigDecimal merchantProfit = BigDecimal.ZERO;
	
	/**平台利润*/
	@Column(nullable = false)
	private BigDecimal platformProfit = BigDecimal.ZERO;
	
	/**尾额利润*/
	@Column(nullable = false)
	private BigDecimal tailAmountProfit = BigDecimal.ZERO;
	
	/**代理利润*/
	@JpaQuery
	@Column(nullable = false)
	private BigDecimal agentProfit = BigDecimal.ZERO;
	
	/**
	 * 尾额分成比率
	 */
	@Column(nullable = false)
	private BigDecimal tailRate = BigDecimal.ZERO;
	
	/**订单状态: 0：待付款 1：成功 2：待发送 3退款成功*/
	@JpaQuery(cond = EQ)
	@Column(nullable = false)
	private Integer state;
	
	@Column(nullable = false)
	private Integer version = 0;

	/**玩家充值账号*/
	@JpaQuery(cond = EQ)
	@Column(length = 30, nullable = false)
	private String playerAccount;

	/**玩家联系QQ*/
	@Column(name = "player_qq", length = 11)
	private String playerQQ;

	/**玩家联系电话*/
	@Column(length = 20)
	private String playerPhone;

	/**玩家IP*/
	private String playerIp;
	
	/**点卡卡号*/
	@Column(length = 30)
	private String cardNumber;
	
	/**订单备注(下发道具)*/
	@Column(columnDefinition = "text")
	private String remarks;
	
	@JpaQuery
	private String discription;
	
	/**订单付款通道*/
	@JpaQuery(select = false, cond = EQ, verify = isBeanId)
	@ManyToOne(fetch = FetchType.LAZY)
	private Gallery gallery;
	
	/**订单支付产品*/
	@JpaQuery(chain = "name", cond = EQ, verify = isBeanId)
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
	/**订单-所属分区*/
	@JpaQuery(chain = {"name", "useName", "changeDate", "isChangeInTime"}, cond = EQ, verify = isBeanId)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false,foreignKey=@ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
	private Partition partition;
	
	/**订单-所属分组*/
	@JpaQuery(select = false, cond = EQ)
	private Long groupId;
	
	/**订单-所属商户*/
	@JpaQuery(chain = {"id", "account", "nickname"}, cond = EQ, verify = isBeanId)
	@ManyToOne(fetch = FetchType.LAZY,cascade={CascadeType.MERGE})
	private Merchant merchant;
	
	/**订单-所属代理商户*/
	@JpaQuery(select = true, chain = {"account"}, cond = EQ, verify = isBeanId)
	@ManyToOne(fetch = FetchType.LAZY)
	private Merchant agent;
	
	public Order() {
		
	}

	public Order(BigDecimal amount, String playerAccount, String playerQQ, String playerPhone, Long productId) {
		this.amount = amount;
		this.playerAccount = playerAccount;
		this.playerQQ = playerQQ;
		this.playerPhone = playerPhone;
		this.product = new Product(productId);
		this.state = 0;
		this.orderDate = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date oDate) {
		this.orderDate = oDate;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getTailAmount() {
		return tailAmount;
	}

	public void setTailAmount(BigDecimal tailAmount) {
		this.tailAmount = tailAmount;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public BigDecimal getGiveAmount() {
		return giveAmount;
	}

	public void setGiveAmount(BigDecimal giveAmount) {
		this.giveAmount = giveAmount;
	}

	public BigDecimal getRedPacketAmount() {
		return redPacketAmount;
	}

	public void setRedPacketAmount(BigDecimal redPacketAmount) {
		this.redPacketAmount = redPacketAmount;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public BigDecimal getMerchantProfit() {
		return merchantProfit;
	}

	public void setMerchantProfit(BigDecimal merchantProfit) {
		this.merchantProfit = merchantProfit;
	}

	public BigDecimal getPlatformProfit() {
		return platformProfit;
	}

	public void setPlatformProfit(BigDecimal platformProfit) {
		this.platformProfit = platformProfit;
	}

	public BigDecimal getTailAmountProfit() {
		return tailAmountProfit;
	}

	public void setTailAmountProfit(BigDecimal tailAmountProfit) {
		this.tailAmountProfit = tailAmountProfit;
	}

	public BigDecimal getAgentProfit() {
		return agentProfit;
	}

	public void setAgentProfit(BigDecimal agentProfit) {
		this.agentProfit = agentProfit;
	}

	public BigDecimal getTailRate() {
		return tailRate;
	}

	public void setTailRate(BigDecimal tailRate) {
		this.tailRate = tailRate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getPlayerAccount() {
		return playerAccount;
	}

	public void setPlayerAccount(String playerAccount) {
		this.playerAccount = playerAccount;
	}

	public String getPlayerQQ() {
		return playerQQ;
	}

	public void setPlayerQQ(String playerQQ) {
		this.playerQQ = playerQQ;
	}

	public String getPlayerPhone() {
		return playerPhone;
	}

	public void setPlayerPhone(String playerPhone) {
		this.playerPhone = playerPhone;
	}

	public String getPlayerIp() {
		return playerIp;
	}

	public void setPlayerIp(String playerIp) {
		this.playerIp = playerIp;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Partition getPartition() {
		return partition;
	}

	public void setPartition(Partition partition) {
		this.partition = partition;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Merchant getAgent() {
		return agent;
	}

	public void setAgent(Merchant agent) {
		this.agent = agent;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", orderNumber=" + orderNumber + ", supNumber="
				+ supNumber + ", amount=" + amount + ", payAmount=" + payAmount + ", giveAmount=" + giveAmount
				+ ", redPacketAmount=" + redPacketAmount + ", payDate=" + payDate + ", merchantProfit=" + merchantProfit
				+ ", platformProfit=" + platformProfit + ", agentProfit=" + agentProfit + ", state=" + state
				+ ", version=" + version + ", playerAccount=" + playerAccount + ", playerQQ=" + playerQQ
				+ ", playerPhone=" + playerPhone + ", playerIp=" + playerIp + ", cardNumber=" + cardNumber
				+ ", remarks=" + remarks + "]";
	}

}
