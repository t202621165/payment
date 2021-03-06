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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cypay.common.annotation.jpa.Conditional;
import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.annotation.jpa.VerifyMode;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 游戏分组实体
 * @author International
 * 2018年8月1日 下午12:21:22
 */
@Entity
@Table(name = "cy_group")
@NamedEntityGraphs({
	@NamedEntityGraph(
			name = "groupWithPartition",
			attributeNodes = {
				@NamedAttributeNode(value = "merchant"),
				@NamedAttributeNode(value = "partitionGroups", subgraph = "partitions")
			},
			subgraphs = @NamedSubgraph(name = "partitions", attributeNodes = @NamedAttributeNode("partition"))
		)
})
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	/**分组-ID*/
	@JpaOrderBy
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, updatable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate = new Date();
	
	/**分组-名称*/
	@Column(length = 20, nullable = false)
	private String name;
	
	/**分组-唯一标识*/
	@Column(length = 32, nullable = false, unique = true, updatable = false)
	private String uuid;
	
	/**分组-所属商户*/
	@JpaQuery(select = false, cond = Conditional.EQ, verify = VerifyMode.isBeanId)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false)
	private Merchant merchant;
	
	@OneToMany(mappedBy = "group")
	private List<PartitionGroup> partitionGroups = new ArrayList<PartitionGroup>();
	
	@JpaQuery(select = false, value = "merchant", cond = Conditional.EQ, subField = "account")
	@Transient
	private String account;
	
	@Transient
	private Boolean isChecked = Boolean.FALSE;
	
	public Group() {
		
	}
	
	public Group(Long id) {
		this.id = id;
	}
	
	public Group(Merchant merchant) {
		this.merchant = merchant;
	}
	
	public Group(Long id, String name, Long partitionId) {
		this.id = id;
		this.name = name;
		this.isChecked = partitionId != null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public List<PartitionGroup> getPartitionGroups() {
		return partitionGroups;
	}

	public void setPartitionGroups(List<PartitionGroup> partitionGroups) {
		this.partitionGroups = partitionGroups;
	}

	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", createDate=" + createDate + ", name=" + name + ", uuid=" + uuid + "]";
	}

}
