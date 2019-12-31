package com.cypay.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cy_permission")
public class Permission implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**权限-ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**权限-名称*/
	@Column(length = 10, nullable = false)
	private String name;
	
	/**权限-类型：false：菜单 true：按钮*/
	@Column(nullable = false)
	private Boolean type;
	
	/**权限-资源访问路径*/
	@Column(length = 50, nullable = false)
	private String url;
	
	private String path;
	
	/**权限-唯一标识*/
	@Column(length = 20, nullable = false, unique = true)
	private String mark;
	
	/**父级权限*/
	@ManyToOne(fetch = FetchType.LAZY)
	private Permission parent;
	
	/**子权限*/
	@OneToMany(mappedBy = "parent")
	private List<Permission> children = new ArrayList<Permission>();

	@ManyToMany(mappedBy = "permissions")
	private Set<Role> roles = new HashSet<Role>();

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

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Permission getParent() {
		return parent;
	}

	public void setParent(Permission parent) {
		this.parent = parent;
	}

	public List<Permission> getChildren() {
		return children;
	}

	public void setChildren(List<Permission> children) {
		this.children = children;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", type=" + type + ", url=" + url + ", mark=" + mark + "]";
	}

}
