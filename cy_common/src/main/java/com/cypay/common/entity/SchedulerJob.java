package com.cypay.common.entity;

import static com.cypay.common.annotation.jpa.Conditional.EQ;
import static com.cypay.common.annotation.jpa.VerifyMode.isBeanId;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.hutool.core.date.DateUtil;

@Entity
@Table(name = "cy_scheduler_job")
public class SchedulerJob implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JpaOrderBy
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = true)
	private Date createDate = new Date();
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String className;
	
	@Column(nullable = false)
	private String groupName;
	
	@Column(nullable = false)
	private String cronExpression;
	
	/**-1：执行失败 0：未执行 1：执行成功 2：任务过期*/
	private Integer state;
	
	private String discription;
	
	@Column(columnDefinition = "text")
	private String jsonData;
	
	@JpaQuery(chain = {"id"}, cond = EQ, verify = isBeanId)
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Merchant merchant;
	
	public SchedulerJob() {
		
	}
	
	public SchedulerJob(String name, String groupName, String className, String cronExpression, Merchant merchant) {
		this.name = name;
		this.groupName = groupName;
		this.className = className;
		this.cronExpression = cronExpression;
		this.merchant = merchant;
		this.state = 0;
	}
	
	/**
	 * 定时任务是否过期
	 * @return
	 */
	public boolean isExpired() {
		try {
			Date date = DateUtil.parse(cronExpression, "s m H d M ? yyyy");
			return date.compareTo(new Date()) < 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	
}
