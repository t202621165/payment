package com.cypay.common.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 角色实体
 * @author International
 * 2018年8月2日 下午3:13:09
 */
@Entity
@Table(name = "cy_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**角色-ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**角色-唯一标识*/
	@Column(length = 20, nullable = false, unique = true)
	private String mark;
	
	/**角色-信息描述*/
	private String des;
	
	/**角色-启用状态*/
	@Column(nullable = false)
	private Boolean state;
	
	/**赋予角色的用户*/
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="cy_role_user", 
		joinColumns=@JoinColumn(name="role_id"), 
			inverseJoinColumns=@JoinColumn(name="user_id"))
	private Set<User> users = new HashSet<User>();
	
	/**角色拥有的权限*/
	@ManyToMany
	@JoinTable(name="cy_role_permission", 
		joinColumns=@JoinColumn(name="role_id"), 
			inverseJoinColumns=@JoinColumn(name="permission_id"))
	private Set<Permission> permissions = new HashSet<Permission>();
	
	/**移除user*/
	public void removeUser(User user){
		this.getUsers().remove(user);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", mark=" + mark + ", des=" + des + ", state=" + state + "]";
	}

}
