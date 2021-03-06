package com.cypay.common.entity;

import static com.cypay.common.annotation.jpa.Conditional.EQ;
import static com.cypay.common.annotation.jpa.VerifyMode.isBeanId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import com.alibaba.fastjson.annotation.JSONField;
import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.to.Login;
import com.cypay.common.util.RegExpUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 商户实体
 * @author International
 * 2018年8月1日 上午10:55:10
 */
@Entity
@DynamicUpdate
@Table(name = "cy_merchant")
@NamedEntityGraphs({
	@NamedEntityGraph(
			name = "merchantWithRank",
			attributeNodes = {
					@NamedAttributeNode(value = "rank"),
					@NamedAttributeNode(value = "partitions")
			}
	)
})
public class Merchant extends Login implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**商户-ID*/
	@JpaQuery(cond = EQ)
	@JpaOrderBy
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**商户-昵称*/
	@JpaQuery(cond = EQ)
	@NotBlank(message = "昵称不能为空")
	@Length(max = 8, message = "昵称长度不能超过8个字符")
	@Column(length = 8, nullable = false)
	private String nickname;
	
	/**商户-登录账号*/
	@JpaQuery(cond = EQ)
	@NotBlank(message="商户账号不能为空")
	@Pattern(regexp = RegExpUtil.USER_NAME, message = "账号由"+RegExpUtil.USER_NAME_ERROR_MESSAGE)
	@Column(length = 10, nullable = false, unique = true)
	private String account;
	
	/**商户-登录密码*/
	@Column(length = 32, nullable = false)
	private String password;
	
	/**商户-注册时间*/ 
	@JpaQuery
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = true)
	private Date joinDate = new Date();
	
	/**最后登陆时间*/
	@JpaQuery
	@Temporal(TemporalType.TIMESTAMP)
	private Date finalDate;
	
	/**商户-类型: true：代理 false：普通商户*/
	@JpaQuery
	@Column(nullable = false)
	private Boolean type = Boolean.FALSE;
	
	/**商户-客服QQ*/
	@Column(name = "service_qq")
	private String serviceQQ;
	
	/**商户-客服电话*/
	@Column(length = 20)
	private String servicePhone;
	
	/**客服启用状态*/
	@Column(nullable = false)
	private Boolean serviceState = Boolean.FALSE;
	
	/**留言功能开启状态*/
	@Column(nullable = false)
	private Boolean leaveState = Boolean.FALSE;
	
	/**商户-联系QQ*/
	@JpaQuery(cond = EQ)
	@NotBlank(message = "QQ号码不能为空")
	@Pattern(regexp = RegExpUtil.QQ, message = RegExpUtil.QQ_ERROR_MESSAGE)
	@Column(length = 11)
	private String qqNumber;
	
	@NotBlank(message = "联系电话不能为空")
	@Length(max = 20, message = "联系电话不能超过20位")
	@Column(length = 20)
	private String phoneNumber;
	
	/**商户-结算类型*/
	@JpaQuery(cond = EQ)
	@Column(nullable = false)
	private Integer settlementType;
	
	/**商户-网关通讯密钥*/
	@Column(length = 32, nullable = false, unique = true)
	private String secretKey;
	
	/**商户-提现手续费*/
	@Column(nullable = false)
	private BigDecimal fee = new BigDecimal("0.00");
	
	/**商户-启用状态: -1：0：禁用 1：启用 2：审核中*/
	@JpaQuery(cond = EQ)
	@Column(nullable = false)
	private Integer state;
	
	/**发布站来源统计*/
	@Column(nullable = false)
	private Boolean isIps = Boolean.FALSE;
	
	/**登录器访问统计*/
	@Column(nullable = false)
	private Boolean isLogger = Boolean.FALSE;
	
	@Column(nullable = false, columnDefinition = "varchar(255) DEFAULT '' COMMENT '安全IP'")
	private String authorizeIp;
	
	/**商户-唯一标识*/
	@Column(length = 32, nullable = false, unique = true, updatable = false)
	private String uuid;
	
	@Column(nullable = false)
	private Boolean phoneState = Boolean.FALSE;
	
	@Column(nullable = false)
	private Boolean orderToWx = Boolean.FALSE;
	
	@Column(nullable = false)
	private Boolean messageToWx = Boolean.FALSE;
	
	/**产品费率组*/
	@JpaQuery(chain = {"id", "name"}, cond = EQ, verify = isBeanId)
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Rank rank;
	
	/**父级代理*/
	@JpaQuery(select = true,chain = {"account"}, cond = EQ, verify = isBeanId)
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Merchant parent;
	
	/**代理子商户*/
	@JsonIgnore
	@OneToMany(mappedBy = "parent")
	private Set<Merchant> children = new HashSet<Merchant>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "merchant",cascade={CascadeType.REMOVE})
	private Set<Group> groups = new HashSet<Group>();
	
	/**拥有分区*/
	@JsonIgnore
	@OneToMany(mappedBy = "merchant",cascade={CascadeType.REMOVE})
	private Set<Partition> partitions = new HashSet<Partition>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "merchant",cascade = {CascadeType.REMOVE})
	private Set<Template> templates = new HashSet<Template>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "merchant", cascade={CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Bank> banks = new HashSet<Bank>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "merchant",orphanRemoval = true, cascade = {CascadeType.REMOVE})
	private Set<SettleMent> settleMents = new HashSet<SettleMent>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "merchant",cascade={CascadeType.REMOVE})
	private Set<Order> orders = new HashSet<Order>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "merchant",cascade = {CascadeType.REMOVE})
	private Set<ReissueRecord> reissueRecords = new HashSet<ReissueRecord>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "merchant",cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private Set<MerchantProduct> merchantProducts = new HashSet<MerchantProduct>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "merchant",cascade = {CascadeType.REMOVE})
	private Set<MerchantLog> merchantLogs = new HashSet<MerchantLog>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "merchant",cascade = {CascadeType.REMOVE})
	private Set<Message> messages = new HashSet<Message>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "merchant",cascade = {CascadeType.REMOVE})
	private Set<Rank> agencRanks = new HashSet<Rank>();
	
	@Transient
	private Long parentId;
	
	@Transient
	private Long rankId;
	
	@Transient
	private String rankName;
	
	@Transient
	private List<Rank> ranks;
	
	@Transient
	private WechatInfo wechatInfo;
	
	@Transient
	private Boolean isWxBind;

	public Merchant(){
		
	}
	
	public Merchant(Long id){
		this.id = id;
	}
	
	public Merchant(Long id, Long rankId){
		this.id = id;
		this.rankId = rankId;
		if (rankId != null) {
			this.rank = new Rank(rankId);
		}
	}

	public Merchant(String account, String password) {
		this.account = account;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public String getServiceQQ() {
		return serviceQQ;
	}

	public void setServiceQQ(String serviceQQ) {
		this.serviceQQ = serviceQQ;
	}

	public String getServicePhone() {
		return servicePhone;
	}

	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	public Boolean getServiceState() {
		return serviceState;
	}

	public void setServiceState(Boolean serviceState) {
		this.serviceState = serviceState;
	}

	public Boolean getLeaveState() {
		return leaveState;
	}

	public void setLeaveState(Boolean leaveState) {
		this.leaveState = leaveState;
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(Integer settlementType) {
		this.settlementType = settlementType;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Boolean getIsIps() {
		return isIps;
	}

	public void setIsIps(Boolean isIps) {
		this.isIps = isIps;
	}

	public Boolean getIsLogger() {
		return isLogger;
	}

	public void setIsLogger(Boolean isLogger) {
		this.isLogger = isLogger;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Boolean getPhoneState() {
		return phoneState;
	}

	public void setPhoneState(Boolean phoneState) {
		this.phoneState = phoneState;
	}

	public Boolean getOrderToWx() {
		return orderToWx;
	}

	public void setOrderToWx(Boolean orderToWx) {
		this.orderToWx = orderToWx;
	}

	public Boolean getMessageToWx() {
		return messageToWx;
	}

	public void setMessageToWx(Boolean messageToWx) {
		this.messageToWx = messageToWx;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Merchant getParent() {
		return parent;
	}

	public void setParent(Merchant parent) {
		this.parent = parent;
	}

	public Set<Merchant> getChildren() {
		return children;
	}

	public void setChildren(Set<Merchant> children) {
		this.children = children;
	}

	public Set<Partition> getPartitions() {
		return partitions;
	}

	public void setPartitions(Set<Partition> partitions) {
		this.partitions = partitions;
	}

	public Set<Bank> getBanks() {
		return banks;
	}

	public void setBanks(Set<Bank> banks) {
		this.banks = banks;
	}

	public Set<SettleMent> getSettleMents() {
		return settleMents;
	}

	public void setSettleMents(Set<SettleMent> settleMents) {
		this.settleMents = settleMents;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<ReissueRecord> getReissueRecords() {
		return reissueRecords;
	}

	public void setReissueRecords(Set<ReissueRecord> reissueRecords) {
		this.reissueRecords = reissueRecords;
	}

	public Set<MerchantProduct> getMerchantProducts() {
		return merchantProducts;
	}

	public void setMerchantProducts(Set<MerchantProduct> merchantProducts) {
		this.merchantProducts = merchantProducts;
	}

	public Set<MerchantLog> getMerchantLogs() {
		return merchantLogs;
	}

	public void setMerchantLogs(Set<MerchantLog> merchantLogs) {
		this.merchantLogs = merchantLogs;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getRankId() {
		return rankId;
	}

	public void setRankId(Long rankId) {
		this.rankId = rankId;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public List<Rank> getRanks() {
		return ranks;
	}

	public void setRanks(List<Rank> ranks) {
		this.ranks = ranks;
	}

	public WechatInfo getWechatInfo() {
		return wechatInfo;
	}

	public void setWechatInfo(WechatInfo wechatInfo) {
		this.wechatInfo = wechatInfo;
	}
	
	public Set<Template> getTemplates() {
		return templates;
	}

	public void setTemplates(Set<Template> templates) {
		this.templates = templates;
	}

	@JSONField(serialize = false)
	@Override
	public String getSalt() {
		return this.getUuid();
	}
	
	@JSONField(serialize = false)
	@Override
	public boolean isUnusable() {
		return this.state == 0;
	}
	
	@JSONField(serialize = false)
	@Override
	public boolean isInAudit() {
		return this.state == 2;
	}
	
	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Set<Rank> getAgencRanks() {
		return agencRanks;
	}

	public void setAgencRanks(Set<Rank> agencRanks) {
		this.agencRanks = agencRanks;
	}

	public Boolean getIsWxBind() {
		return isWxBind;
	}

	public void setIsWxBind(Boolean isWxBind) {
		this.isWxBind = isWxBind;
	}

	public String getAuthorizeIp() {
		return authorizeIp;
	}

	public void setAuthorizeIp(String authorizeIp) {
		this.authorizeIp = authorizeIp;
	}

	@Override
	public String toString() {
		return "Merchant [id=" + id + ", nickname=" + nickname + ", account=" + account + ", password=" + password
				+ ", joinDate=" + joinDate + ", finalDate=" + finalDate + ", type=" + type + ", serviceQQ=" + serviceQQ
				+ ", servicePhone=" + servicePhone + ", serviceState=" + serviceState + ", leaveState=" + leaveState
				+ ", qqNumber=" + qqNumber + ", phoneNumber=" + phoneNumber + ", settlementType=" + settlementType
				+ ", secretKey=" + secretKey + ", fee=" + fee + ", state=" + state + ", isIps=" + isIps + ", isLogger="
				+ isLogger + ", uuid=" + uuid + ", parentId=" + parentId + ", rankId=" + rankId + ", rankName="
				+ rankName + "]";
	}
	
}
