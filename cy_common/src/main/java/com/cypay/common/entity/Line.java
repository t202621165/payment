package com.cypay.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.DynamicUpdate;

import com.cypay.common.util.RegExpUtil;

/**
 * 充值线路实体
 * @author International
 * 2018年8月3日 下午3:07:23
 */
@Entity
@DynamicUpdate
@Table(name = "cy_line")
public class Line implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**线路-ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**线路-名称*/
	@NotBlank(message = "线路名称不能为空")
	@Column(nullable = false)
	private String name;
	
	/**充值域名*/
	@NotBlank(message = "域名不能为空")
	@Pattern(regexp = RegExpUtil.DOMAIN_NAME, message = RegExpUtil.DOMAIN_NAME_ERROR_MESSAGE)
	@Column(nullable = false)
	private String domainName;
	
	/**充值域名访问端口*/
	@Column(nullable = false)
	private Integer port = 80;
	
	/**是否为默认线路*/
	@Column(nullable = false, updatable = false)
	private Boolean isDefault = Boolean.FALSE;
	
	/**启用状态*/
	@Column(nullable = false)
	private Boolean state = Boolean.TRUE;
	
	/**线路类型 0：充值  1：商户  2：总后台*/
	@Column(nullable = false)
	private Integer type = 0;
	
	public String typeKey() {
		switch (type) {
		case 0:
			
			return "rechargeLine";
		case 1:
			
			return "merchantLine";
		case 2:
			
			return "manageLine";
			
		case 3:
			return "statisticsLine";
		}
		return "";
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

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Line [id=" + id + ", name=" + name + ", domainName=" + domainName + ", port=" + port + ", isDefault="
				+ isDefault + ", state=" + state + "]";
	}

}
