package com.cypay.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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

import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.annotation.jpa.Conditional;
import com.cypay.common.annotation.jpa.VerifyMode;

/**
 * 补发记录
 * @author International
 *
 */
@Entity
@Table(name = "cy_reissue_record")
public class ReissueRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JpaQuery
	@JpaOrderBy
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**补发时间*/
	@JpaQuery
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date reissueDate = new Date();
	
	/**流水号：订单号、手动充值流水*/
	@JpaQuery
	private String serialNumber;
	
	/**补发金额*/
	@JpaQuery
	@Column(nullable = false)
	private BigDecimal amount;
	
	/**玩家充值账号*/
	@JpaQuery(cond = Conditional.EQ)
	@Column(length = 30, nullable = false)
	private String playerAccount;
	
	@JpaQuery
	private String pName;
	
	/**补发类型: true：手动充值 false：整区补发*/
	@JpaQuery(cond = Conditional.EQ)
	@Column(nullable = false)
	private Boolean type = Boolean.TRUE;

	@JpaQuery(chain = {"id", "name"})
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;

	@JpaQuery(chain = {"id", "name", "useName", "changeDate", "isChangeInTime"}, cond = Conditional.EQ, verify = VerifyMode.isBeanId)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false,foreignKey=@ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
	private Partition partition;

	@JpaQuery(select = false, cond = Conditional.EQ, verify = VerifyMode.isBeanId)
	@ManyToOne(fetch = FetchType.LAZY)
	private Merchant merchant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getReissueDate() {
		return reissueDate;
	}

	public void setReissueDate(Date reissueDate) {
		this.reissueDate = reissueDate;
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

	public String getPlayerAccount() {
		return playerAccount;
	}

	public void setPlayerAccount(String playerAccount) {
		this.playerAccount = playerAccount;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
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

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Override
	public String toString() {
		return "ReissueRecord [id=" + id + ", reissueDate=" + reissueDate + ", amount=" + amount + ", playerAccount="
				+ playerAccount + ", type=" + type + "]";
	}
	
}
