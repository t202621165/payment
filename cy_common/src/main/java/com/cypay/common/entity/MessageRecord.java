package com.cypay.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cy_message_record")
public class MessageRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JpaOrderBy
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date recordDate = new Date();
	
	@Column(nullable = false, length = 100)
	private String content;
	
	@Column(nullable = false, columnDefinition = "int DEFAULT '0' COMMENT '类型-0：玩家回复, 1：GM回复'")
	private Integer type;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, updatable = false)
	private Message message;
	
	@Transient
	private Boolean isSameTime = Boolean.FALSE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Boolean getIsSameTime() {
		return isSameTime;
	}

	public void setIsSameTime(Boolean isSameTime) {
		this.isSameTime = isSameTime;
	}

	@Override
	public String toString() {
		return "MessageRecord [id=" + id + ", recordDate=" + recordDate + ", content=" + content + ", type=" + type
				+ ", message=" + message + ", isSameTime=" + isSameTime + "]";
	}
	
}
