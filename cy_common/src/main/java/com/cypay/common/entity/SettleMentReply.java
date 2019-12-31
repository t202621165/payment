package com.cypay.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cy_settle_ment_reply")
public class SettleMentReply implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //主键id
	
	@Column(length=22)
	private String serialNumber;

	@Column(nullable=false)
	private Boolean state; //0 批复中 1 出款成功
	
	@OneToMany(mappedBy="settleMentReply",cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	private Set<SettleMent> settleMents = new HashSet<SettleMent>();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date replyDate; //批复时间
	
	private String discription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user; //批复人
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Set<SettleMent> getSettleMents() {
		return settleMents;
	}

	public void setSettleMents(Set<SettleMent> settleMents) {
		this.settleMents = settleMents;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}
}
