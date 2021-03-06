package com.cypay.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.springframework.util.StringUtils;

import com.cypay.common.util.CommonUtil;
import com.cypay.common.vo.Result;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 商户银行卡账户
 * 
 * @author iwano
 *
 */
@Entity
@Table(name = "cy_bank")
public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Version
	private Long version;

	@Column(nullable = false)
	private String realName; // 持卡人姓名

	@Column(nullable = false)
	private String bankName; // 开户行

	@Column(nullable = false)
	private String bankMark; // 银行标识

	private String bankBranch; // 开户支行

	@Column(nullable = false)
	private String bankNumber; // 银行卡账号、支付宝账号

	@Column(nullable = false)
	private BigDecimal overMoney = new BigDecimal("0.00"); // 账户余额

	@Column(nullable = false)
	private BigDecimal allDeposit = new BigDecimal("0.00"); // 总存入金额

	@Column(nullable = false)
	private BigDecimal allPay = new BigDecimal("0.00"); // 总支出金额

	@Column(nullable = false, updatable = false)
	private Boolean bankType = Boolean.TRUE;
	
	@Column(nullable = false)
	private Boolean activated = Boolean.FALSE; // 是否已激活
	
	private Boolean state = Boolean.TRUE; // true 开启 false 冻结

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, nullable = false, updatable = false)
	private Merchant merchant;
	
	@Transient
	private Long merchantId;
	
	@Transient
	private BigDecimal frozen = new BigDecimal("0.00"); // 冻结金额
	
	@Transient
	private BigDecimal settlementable = new BigDecimal("0.00"); // 可结算金额

	@JsonIgnore
	@OneToMany(mappedBy = "bank", orphanRemoval = true, cascade = { CascadeType.REMOVE })
	private Set<SettleMent> settleMents = new HashSet<>();
	
	@Transient
	private BigDecimal fee = new BigDecimal("0.00");
	
	public Bank() {
		
	}
	
	public Bank(BigDecimal allPay, BigDecimal overMoney, Boolean state, Boolean activated) {
		this.allPay = allPay == null ? this.allPay : allPay;
		this.overMoney = overMoney == null ? this.overMoney : overMoney;
		this.state = state == null ? this.state : state;
		this.activated = activated == null ? this.activated : activated;
	}
	
	public Bank(Long id, String realName, String bankName, String bankMark, String bankBranch, 
			String bankNumber, BigDecimal overMoney, Boolean state, Boolean activated, Long version, BigDecimal fee) {
		this.id = id;
		this.realName = realName;
		this.bankName = bankName;
		this.bankMark = bankMark;
		this.bankBranch = bankBranch;
		this.bankNumber = bankNumber;
		this.overMoney = overMoney;
		this.state = state;
		this.activated = activated;
		this.fee = fee;
		this.version = version;
	}
	
	public Bank(Long id, BigDecimal overMoney, Long merchantId, BigDecimal fee) {
		this.id = id;
		this.overMoney = overMoney;
		this.merchantId = merchantId;
		this.fee = fee;
	}
	
	public Bank replace() {
		this.realName = CommonUtil.truncateHalf(realName, "*");
		
		if (!StringUtils.isEmpty(bankNumber)) {
			this.bankNumber = CommonUtil.getBufferString(
					bankNumber.substring(0, 4), " **** **** **** ", bankNumber.substring(
							bankNumber.length()-3, bankNumber.length()));
		}
		return this;
	}
	
	public Result validate() {
		if (StringUtils.isEmpty(this.bankMark)) {
			return Result.error("开户银行不能为空", "bankMark");
		}
		if (StringUtils.isEmpty(this.realName)) {
			return Result.error("账户名不能为空", "realName");
		}
		if (StringUtils.isEmpty(this.bankNumber)) {
			return Result.error("账户卡号不能为空", "bankNumber");
		}
		if (StringUtils.isEmpty(this.bankBranch)) {
			return Result.error("请输入银行开户地区", "bankBranch");
		}
		return Result.success();
	}
	
	public static Bank unactivate() {
		Bank bank = new Bank();
		bank.realName = "";
		bank.bankName = "";
		bank.bankMark = "";
		bank.bankBranch = "";
		bank.bankNumber = "";
		return bank;
	}
	
	public void merge(Bank b) {
		this.bankMark = b.bankMark;
		this.bankName = b.bankName;
		this.bankNumber = b.bankNumber;
		this.realName = b.realName;
		this.bankBranch = b.bankBranch;
	}

	
	public Bank(BigDecimal overMoney){
		this.overMoney = overMoney;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankMark() {
		return bankMark;
	}

	public void setBankMark(String bankMark) {
		this.bankMark = bankMark;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public BigDecimal getOverMoney() {
		return overMoney;
	}

	public void setOverMoney(BigDecimal overMoney) {
		this.overMoney = overMoney;
	}

	public BigDecimal getAllDeposit() {
		return allDeposit;
	}

	public void setAllDeposit(BigDecimal allDeposit) {
		this.allDeposit = allDeposit;
	}

	public BigDecimal getAllPay() {
		return allPay;
	}

	public void setAllPay(BigDecimal allPay) {
		this.allPay = allPay;
	}

	public Boolean getBankType() {
		return bankType;
	}

	public void setBankType(Boolean bankType) {
		this.bankType = bankType;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Set<SettleMent> getSettleMents() {
		return settleMents;
	}

	public void setSettleMents(Set<SettleMent> settleMents) {
		this.settleMents = settleMents;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}


	public Long getMerchantId() {
		return this.getMerchant() == null ? merchantId : this.getMerchant().getId();
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}


	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public BigDecimal getFrozen() {
		return frozen;
	}

	public void setFrozen(BigDecimal frozen) {
		this.frozen = frozen;
	}

	public BigDecimal getSettlementable() {
		return settlementable;
	}

	public void setSettlementable(BigDecimal settlementable) {
		this.settlementable = settlementable;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", version=" + version + ", realName=" + realName + ", bankName=" + bankName
				+ ", bankMark=" + bankMark + ", bankBranch=" + bankBranch + ", bankNumber=" + bankNumber
				+ ", overMoney=" + overMoney + ", allDeposit=" + allDeposit + ", allPay=" + allPay + ", activated="
				+ activated + ", state=" + state + ", fee=" + fee + "]";
	}
	
}
