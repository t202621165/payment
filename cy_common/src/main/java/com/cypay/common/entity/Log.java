package com.cypay.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 系统日志
 * @author iwano
 *
 */
@Entity
@Table(name = "cy_log")
public class Log implements Serializable{
	private static final long serialVersionUID = 1L;

	@JpaOrderBy
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime; //操作时间
	
	private String ip; //操作ip
	
	private String location; //地址
	
	private String discription; //操作描述
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	@Transient
	private String userName;

	public Log(){};
	
	public Log(Date dateTime) {
		super();
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUserName() {
		return this.user.getUsername();
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
