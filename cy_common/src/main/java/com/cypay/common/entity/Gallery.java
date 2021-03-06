package com.cypay.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.cypay.common.to.Support;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 支付通道实体
 * 
 * @author International 2018年8月1日 上午10:13:14
 */
@Entity
@DynamicUpdate
@Table(name = "cy_gallery")
public class Gallery implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 通道-ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** 通道-名称 */
	@NotBlank(message = "通道名称不能为空")
	@Column(length = 10, nullable = false)
	private String name;

	/** 通道-标识(唯一) */
	@Column(length = 15, nullable = false, updatable = false)
	private String mark;

	/** 通道-帐号 */
	@NotNull(message = "通道帐号不能为空")
	@Column(nullable = false)
	private String account;

	/** appId(官方微信参数) */
	private String appId;

	/** 风控状态 */
	@Column(nullable = false)
	private Boolean riskState = Boolean.FALSE;

	/** 风控域名 */
	private String riskDomain;

	/** 通道允许最小付款金额 */
	@Column(nullable = false)
	private BigDecimal minAmount = new BigDecimal("0.00");

	/** 通道允许最大付款金额-0.00：无上限 */
	@Column(nullable = false)
	private BigDecimal maxAmount = new BigDecimal("0.00");

	/** 通道权重 */
	@Column(nullable = false)
	private Integer weight = 0;

	/** 通道启用状态 */
	@Column(nullable = false)
	private Boolean state = Boolean.TRUE;
	
	/** 通道数据MD5签名密钥 */
	@Column(columnDefinition = "text")
	private String md5Key;

	/** 通道RSA公钥 */
	@Column(columnDefinition = "text")
	private String publicKey;

	/** 通道RSA私钥 */
	@Column(columnDefinition = "text")
	private String privateKey;

	/** 通道付款备注 */
	@Column(nullable = false)
	private String des;
	
	/** 是否重定向1：重定向跳转0：二维码链接 */
	@Column(nullable = false)
	private Boolean isRedirect = Boolean.TRUE;
	
	/** 是否开启风控金额 */
	@Column(nullable = false)
	private Boolean isRiskAmount = Boolean.FALSE;
	
	/** 风控金额：0 < riskAmount < 1 */
	private BigDecimal riskAmount = new BigDecimal("0.0");
	
	/** 风控金额利润分成比率 */
	private Integer riskAmountRatio = 0;
	
	@JsonIgnore
	@OneToMany(mappedBy = "gallery", cascade = { CascadeType.REMOVE })
	private List<GalleryRate> galleryRate = new ArrayList<GalleryRate>();

	@JsonIgnore
	@OneToMany(mappedBy = "gallery", cascade = { CascadeType.REMOVE })
	private List<Order> orders = new ArrayList<Order>();

	@Transient
	private String realName;
	
	@Transient
	private Support support = Support.DEFAULT;
	
	/** 签名方式-0: MD5、SHA等哈希摘要算法 1：RSA等非对称加密算法 */
	@Transient
	private Integer signType = 0;
	
	/** 是否为统一支付 */
	@Transient
	private Boolean isUnified = Boolean.TRUE;
	
	@Transient
	private Boolean isSupportRiskAmount = Boolean.FALSE;

	public Gallery() {
	}

	public Gallery(Long id) {
		this.id = id;
	}
	
	public Gallery(Long id, String name, String mark) {
		this.id = id;
		this.name = name;
		this.mark = mark;
	}
	
	public Gallery(String name, String mark, Boolean isUnified) {
		this.name = name;
		this.mark = mark;
		this.account = "";
		this.des = "";
		this.isUnified = isUnified;
		this.state = Boolean.FALSE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Boolean getRiskState() {
		return riskState;
	}

	public void setRiskState(Boolean riskState) {
		this.riskState = riskState;
	}

	public String getRiskDomain() {
		return riskDomain;
	}

	public void setRiskDomain(String riskDomain) {
		this.riskDomain = riskDomain;
	}

	public BigDecimal getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}

	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getMd5Key() {
		return md5Key;
	}

	public void setMd5Key(String md5Key) {
		this.md5Key = md5Key;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Boolean getIsUnified() {
		return isUnified;
	}

	public void setIsUnified(Boolean isUnified) {
		this.isUnified = isUnified;
	}

	public Support getSupport() {
		return support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

	public Boolean getIsRiskAmount() {
		return isRiskAmount;
	}

	public void setIsRiskAmount(Boolean isRiskAmount) {
		this.isRiskAmount = isRiskAmount;
	}

	public BigDecimal getRiskAmount() {
		return riskAmount;
	}

	public void setRiskAmount(BigDecimal riskAmount) {
		this.riskAmount = riskAmount;
	}

	public Integer getRiskAmountRatio() {
		return riskAmountRatio;
	}

	public void setRiskAmountRatio(Integer riskAmountRatio) {
		this.riskAmountRatio = riskAmountRatio;
	}

	public List<GalleryRate> getGalleryRate() {
		return galleryRate;
	}

	public void setGalleryRate(List<GalleryRate> galleryRate) {
		this.galleryRate = galleryRate;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Boolean getIsRedirect() {
		return isRedirect;
	}

	public void setIsRedirect(Boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public Integer getSignType() {
		return signType;
	}

	public void setSignType(Integer signType) {
		this.signType = signType;
	}

	public Boolean getIsSupportRiskAmount() {
		return isSupportRiskAmount;
	}

	public void setIsSupportRiskAmount(Boolean isSupportRiskAmount) {
		this.isSupportRiskAmount = isSupportRiskAmount;
	}

	@Override
	public String toString() {
		return "Gallery [id=" + id + ", name=" + name + ", mark=" + mark + ", account=" + account + ", appId=" + appId
				+ ", riskState=" + riskState + ", riskDomain=" + riskDomain + ", minAmount=" + minAmount
				+ ", maxAmount=" + maxAmount + ", weight=" + weight + ", state=" + state + ", md5Key=" + md5Key
				+ ", publicKey=" + publicKey + ", privateKey=" + privateKey + ", des=" + des + ", isUnified="
				+ isUnified + ", isRedirect=" + isRedirect + "]";
	}

}
