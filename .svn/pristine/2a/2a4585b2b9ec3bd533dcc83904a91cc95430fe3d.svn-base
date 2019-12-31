package com.cypay.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 结算
 * @author iwano
 *
 */
@Entity
@Table(name = "cy_settle_ment")
@NamedEntityGraph(
		name = "settleMentWithBank", 
		attributeNodes = {@NamedAttributeNode(value = "bank")}
)
public class SettleMent implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //主键id
	
	@Version
	private Long version;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date applyDate = new Date(); //业务申请时间
	
	@Column(length=25)
	private String serialNumber; //业务流水号  提现审核：(check)C_+年+月+日+时+分+秒+毫秒+4位随机数+服务器标识; 等待付款：(pay)P_+年+月+日+时+分+秒+毫秒+4位随机数+服务器标识
	
	@Column(nullable=false)
	private BigDecimal amount; // 结算金额
	
	@Column(nullable=false)
	private BigDecimal cost; // 手续费
	
	private Integer state; //-2拒绝出款 -1审核失败 0 等待审核 1 出款成功 2等待出款 3批复中
	
	private Integer type = 0; //业务类型 falset/0 普通业务结算   true/1资金自提
	
	private String discription; //业务描述
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date complateDate; //业务完成时间
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Merchant merchant; //出款商户
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Bank bank; //收款银行账户
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private SettleMentReply settleMentReply;//出款批复
	
	public SettleMent(String serialNumber, BigDecimal amount, BigDecimal cost, 
			Merchant merchant, Bank bank, Integer state, String discription) {
		this.serialNumber = serialNumber;
		this.amount = amount;
		this.cost = cost;
		this.merchant = merchant;
		this.bank = bank;
		this.state = state;
		this.discription = discription;
	}
	
	public SettleMent() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public SettleMentReply getSettleMentReply() {
		return settleMentReply;
	}

	public void setSettleMentReply(SettleMentReply settleMentReply) {
		this.settleMentReply = settleMentReply;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	

}
