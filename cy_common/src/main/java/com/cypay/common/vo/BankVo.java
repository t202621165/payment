package com.cypay.common.vo;

import static com.cypay.common.annotation.jpa.Conditional.BETWEEN_$GT;
import static com.cypay.common.annotation.jpa.Conditional.BETWEEN_$LTE;
import static com.cypay.common.annotation.jpa.Conditional.EQ;
import static com.cypay.common.annotation.jpa.VerifyMode.isDecimal;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cypay.common.annotation.jpa.JavaType;
import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;


public class BankVo{
	
	@JpaQuery(value = "merchant", chain = "id", subField = "id", cond = EQ)
	private Long merchantId;
	
	@JpaQuery(value = "merchant", chain = "account", subField = "account", cond = EQ)
	private String account;
	
	@JpaQuery(value = "merchant", chain = "nickname")
	private String nickname;
	
	@JpaQuery(value = "id")
	private Long bankId;
	
	@JpaQuery
	private String realName;
	
	@JpaQuery
	private String bankName;
	
	@JpaQuery
	private String bankBranch;
	
	@JpaQuery
	private String bankNumber;
	
	@JpaQuery(value = "state", cond = EQ)
	private Boolean bankState;
	
	@JpaQuery(cond = EQ)
	private Boolean activated;
	
	@JpaQuery(select = false, value = "overMoney", 
			cond = BETWEEN_$GT, verify = isDecimal, jType = JavaType.DECIMAL)
	private BigDecimal useAmount;
	
	@JpaQuery(cond = BETWEEN_$LTE, verify = isDecimal, jType = JavaType.DECIMAL)
	@JpaOrderBy
	private BigDecimal overMoney;
	
	@JpaQuery
	private BigDecimal allDeposit = new BigDecimal("0.00"); // 总存入金额

	@JpaQuery
	private BigDecimal allPay = new BigDecimal("0.00"); // 总支出金额
	
	private BigDecimal frozenAmount;
	
	@JpaQuery(value = "merchant", chain = "fee", verify = isDecimal)
	private BigDecimal fee;
	
	@JpaQuery(select = false, value = "merchant", subField = "settlementType", cond = EQ)
	private Integer type;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate;
	
	public BankVo() {}
	
	public BankVo(Long merchantId, String account, String nickname, Long bankId, String realName, String bankName, String bankBranch, String bankNumber,
			Boolean bankState, Boolean activated, BigDecimal overMoney, BigDecimal allDeposit, BigDecimal allPay, BigDecimal fee) {
		super();
		this.merchantId = merchantId;
		this.account = account;
		this.nickname = nickname;
		this.bankId = bankId;
		this.realName = realName;
		this.bankName = bankName;
		this.bankBranch = bankBranch;
		this.bankNumber = bankNumber;
		this.bankState = bankState;
		this.activated = activated;
		this.overMoney = overMoney;
		this.allDeposit = allDeposit;
		this.allPay = allPay;
		this.frozenAmount = new BigDecimal("0.00");
		this.fee = fee;
	}

	public BankVo(Long merchantId, String account, String nickname, Long bankId, String realName, String bankName, String bankBranch, String bankNumber,
			Boolean bankState, Boolean activated, BigDecimal overMoney, BigDecimal allDeposit, BigDecimal allPay, BigDecimal fee, BigDecimal frozenAmount) {
		this(merchantId, account, nickname, bankId, realName, bankName, bankBranch, bankNumber, bankState, activated, overMoney, allDeposit, allPay, fee);
		this.frozenAmount = frozenAmount;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public BigDecimal getFrozenAmount() {
		return frozenAmount;
	}

	public void setFrozenAmount(BigDecimal frozenAmount) {
		this.frozenAmount = frozenAmount;
	}

	public BigDecimal getUseAmount() {
		return useAmount == null ? new BigDecimal("0.00") : useAmount;
	}

	public void setUseAmount(BigDecimal useAmount) {
		this.useAmount = useAmount;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Boolean getBankState() {
		return bankState;
	}

	public void setBankState(Boolean bankState) {
		this.bankState = bankState;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	
}
