package com.cypay.common.vo;

import static com.cypay.common.annotation.jpa.JavaType.DATE;
import static com.cypay.common.annotation.jpa.JavaType.DECIMAL;
import static com.cypay.common.annotation.jpa.Conditional.BETWEEN_$GTE;
import static com.cypay.common.annotation.jpa.Conditional.BETWEEN_$LTE;
import static com.cypay.common.annotation.jpa.Conditional.EQ;
import static com.cypay.common.annotation.jpa.VerifyMode.isDecimal;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.annotation.jpa.OrderType;


public class SettleMentVo{
	
	@JpaQuery(value = "id")
	private Long settlementId;
	
	@JpaQuery(value = "merchant", chain = "id", subField = "id", cond = EQ)
	private Long merchantId;
	
	@JpaQuery(value = "bank", chain = "id")
	private Long bankId;
	
	@JpaQuery(value = "merchant", chain = "account", subField = "account", cond = EQ)
	private String account;
	
	@JpaQuery(value = "merchant", chain = "nickname")
	private String nickname;
	
	@JpaQuery(value = "bank", chain = "realName")
	private String realName;
	
	@JpaQuery(value = "bank", chain = "bankName")
	private String bankName;
	
	@JpaQuery(value = "bank", chain = "bankNumber")
	private String bankNumber;
	
	@JpaQuery(select = false, value = "amount", cond = BETWEEN_$GTE, verify = isDecimal, jType = DECIMAL)
	private BigDecimal useAmount;
	
	@JpaQuery(value = "cost", verify = isDecimal)
	private BigDecimal fee;
	
	@JpaQuery(value = "amount", cond = BETWEEN_$LTE, verify = isDecimal, jType = DECIMAL)
	//@JpaOrderBy
	private BigDecimal amount;
	
	@JpaQuery(select = false, value = "applyDate", cond = BETWEEN_$GTE, jType = DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	
	@JpaQuery(select = false, value = "applyDate", cond = BETWEEN_$LTE, jType = DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate;
	
	@JpaQuery
	@JpaOrderBy(type = OrderType.DESC)
	private Date applyDate;
	
	@JpaQuery
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date complateDate;
	
	@JpaQuery
	private String discription;
	
	@JpaQuery(cond = EQ)
	private String serialNumber;
	
	@JpaQuery(cond = EQ)
	private Integer state;
	
	private String mark;
	
	private String openid;
	
	@JpaQuery(select = false, value = "merchant", subField = "settlementType", cond = EQ)
	private Integer type;
	
	@JpaQuery(select = false, value = "settleMentReply", subField = "serialNumber", cond = EQ)
	private String replySerialNumber;
	
	public SettleMentVo(){};
	
	public SettleMentVo(Long settlementId, Long merchantId, Long bankId, String account, String nickname, String realName, String bankName,
			String bankNumber, BigDecimal fee, BigDecimal amount, Date applyDate,Date complateDate, String discription,
			String serialNumber, Integer state) {
		super();
		this.settlementId = settlementId;
		this.merchantId = merchantId;
		this.bankId = bankId;
		this.account = account;
		this.nickname = nickname;
		this.realName = realName;
		this.bankName = bankName;
		this.bankNumber = bankNumber;
		this.fee = fee;
		this.amount = amount;
		this.applyDate = applyDate;
		this.discription = discription;
		this.serialNumber = serialNumber;
		this.state = state;
		this.complateDate = complateDate;
	}

	public SettleMentVo(BigDecimal amount, BigDecimal fee) {
		super();
		this.amount = amount;
		this.fee = fee;
	}

	public SettleMentVo(BigDecimal amount, String mark) {
		super();
		this.amount = amount;
		this.mark = mark;
	}

	public SettleMentVo(Long id, BigDecimal amount,String discription,String serialNumber, 
			String bankMark,String realName,String bankNumber,String openid) {
		this.settlementId = id;
		this.amount = amount;
		this.discription = discription;
		this.serialNumber = serialNumber;
		this.mark = bankMark;
		this.bankNumber = bankNumber;
		this.realName = realName;
		this.openid = openid;
	}

	public Long getSettlementId() {
		return settlementId;
	}

	public void setSettlementId(Long settlementId) {
		this.settlementId = settlementId;
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

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getComplateDate() {
		return complateDate;
	}

	public void setComplateDate(Date complateDate) {
		this.complateDate = complateDate;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getReplySerialNumber() {
		return replySerialNumber;
	}

	public void setReplySerialNumber(String replySerialNumber) {
		this.replySerialNumber = replySerialNumber;
	}
	
}
