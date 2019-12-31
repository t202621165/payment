package com.cypay.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import org.hibernate.annotations.DynamicInsert;

import com.cypay.common.annotation.jpa.Conditional;
import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.annotation.jpa.OrderType;
import com.cypay.common.annotation.jpa.VerifyMode;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 玩家留言实体
 * @author International
 *
 */
@NamedEntityGraphs({
	@NamedEntityGraph(
			name = "messageWithReplies",
			attributeNodes = {
				@NamedAttributeNode(value = "replies")
			}
		)
})
@Entity
@Table(name = "cy_message")
@DynamicInsert
public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JpaOrderBy
	/**留言-ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**留言时间*/
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date leaveDate = new Date();

	/**玩家游戏账号*/
	@Column(nullable = false)
	private String account;
	
	/**玩家联系QQ*/
	private String qq;
	
	/**玩家联系电话*/
	private String phone;

	/**留言内容*/
	@Column(nullable = false)
	private String content;
	
	/**是否已读*/
	@JpaQuery(select = false, cond = Conditional.EQ)
	@JpaOrderBy(type = OrderType.ASC)
	@Column(nullable = false)
	private Boolean state = Boolean.FALSE;
	
	/**玩家是否订阅当前留言*/
	@Column(nullable = false)
	private Boolean isSubscribe = Boolean.FALSE;
	
	/**分区名称*/
	@Column(nullable = false)
	private String partitionName;
	
	/**玩家是否被禁言*/
	@Column(nullable = false, columnDefinition = "bit DEFAULT 0 COMMENT '是否被禁言'")
	private Boolean isBanned = Boolean.FALSE;
	
	@Column(nullable = false, columnDefinition = "varchar(50) DEFAULT '' COMMENT '订阅此留言的微信openid'")
	private String openid;
	
	/**留言回复记录*/
	@OneToMany(mappedBy = "message")
	private List<MessageRecord> replies = new ArrayList<>();
	
	/**所属商户*/
	@JpaQuery(select = false, cond = Conditional.EQ, verify = VerifyMode.isBeanId)
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Merchant merchant;
	
	@Transient
	private Long partitionId;
	
	@Transient
	private String msgId;
	
	public Message() {
		
	}
	
	public Message(Merchant merchant) {
		this.merchant = merchant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Boolean getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(Boolean isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getPartitionName() {
		return partitionName;
	}

	public void setPartitionName(String partitionName) {
		this.partitionName = partitionName;
	}

	public Boolean getIsBanned() {
		return isBanned;
	}

	public void setIsBanned(Boolean isBanned) {
		this.isBanned = isBanned;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public List<MessageRecord> getReplies() {
		return replies;
	}

	public void setReplies(List<MessageRecord> replies) {
		this.replies = replies;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Long getPartitionId() {
		return partitionId;
	}

	public void setPartitionId(Long partitionId) {
		this.partitionId = partitionId;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", leaveDate=" + leaveDate + ", account=" + account + ", qq=" + qq + ", phone="
				+ phone + ", content=" + content + ", state=" + state + ", isSubscribe=" + isSubscribe
				+ ", partitionName=" + partitionName + ", isBanned=" + isBanned + ", openid=" + openid + ", replies="
				+ replies + ", merchant=" + merchant + ", partitionId=" + partitionId + ", msgId=" + msgId + "]";
	}
	
}
