package com.cypay.common.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.cypay.common.to.Login;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 系统用户实体
 * @author International
 * 2018年8月2日 下午2:40:30
 */
@Entity
@Table(name = "cy_user")
public class User extends Login implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**用户-ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**用户-昵称*/
	@NotBlank(message = "用户昵称不能为空")
	@Column(length = 10, nullable = false)
	private String nickname;
	
	/**用户名*/
	@Column(length = 10, nullable = false, unique = true)
	@NotBlank(message = "用户名不能为空")
	private String username;
	
	/**用户登录密码*/
	@Column(length = 32, nullable = false)
	private String password;
	
	/**用户密码加密盐*/
	@Column(length = 32, nullable = false)
	private String salt;
	
	/**用户-登录密码*/
	@Column(nullable = false)
	private Boolean state;
	
	/**用户已拥有的角色*/
	@ManyToMany(mappedBy="users")
	private Set<Role> roles = new HashSet<Role>();
	
	@JsonIgnore
	@OneToMany(mappedBy="user",orphanRemoval  = true,cascade={CascadeType.REMOVE})
	private Set<SettleMentReply> settleMentReplys = new HashSet<SettleMentReply>();
	
	@JsonIgnore
	@OneToMany(mappedBy="user",orphanRemoval = true, cascade = {CascadeType.REMOVE})
	private Set<Log> logs = new HashSet<Log>();

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<SettleMentReply> getSettleMentReplys() {
		return settleMentReplys;
	}

	public void setSettleMentReplys(Set<SettleMentReply> settleMentReplys) {
		this.settleMentReplys = settleMentReplys;
	}

	public Set<Log> getLogs() {
		return logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}
	
	@Override
	public String getAccount() {
		return this.username;
	}
	
	@Override
	public boolean isUnusable() {
		return !this.state;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", username=" + username + ", password=" + password
				+ ", salt=" + salt + ", state=" + state + "]";
	}
	
}
