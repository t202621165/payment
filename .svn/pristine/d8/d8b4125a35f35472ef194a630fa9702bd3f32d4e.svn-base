package com.cypay.common.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "cy_partition_group")
public class PartitionGroup implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Group group;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Partition partition;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Group getGroup() {
		return group;
	}

	@JsonProperty
	public void setGroup(Group group) {
		this.group = group;
	}

	public Partition getPartition() {
		return partition;
	}

	@JsonProperty
	public void setPartition(Partition partition) {
		this.partition = partition;
	}
	
}
