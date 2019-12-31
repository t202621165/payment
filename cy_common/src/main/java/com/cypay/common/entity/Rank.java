package com.cypay.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cy_rank")

public class Rank implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate = new Date();
	
	@Column(nullable = false)
	private String name;
	
	/**是否为默认*/
	@Column(nullable = false, updatable = false)
	private Boolean isDefault = Boolean.FALSE;
	
	/**是否为代理*/
	@Column(updatable = false)
	private Boolean isAgency = Boolean.FALSE;

	/**所属商户*/
	@JsonIgnore
	@JoinColumn(updatable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Merchant merchant;
	
	@OneToMany(mappedBy = "rank")
	@JsonIgnore
	private Set<Merchant> merchants = new HashSet<Merchant>();
	
	@OneToMany(mappedBy="rank",cascade= {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	private Set<RankRate> rankRates = new HashSet<RankRate>();
	
	@Transient
	private List<RankRate> rates = new ArrayList<RankRate>();
	
	public Rank() {}
	
	public Rank(Long id) {
		this.id = id;
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

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Boolean getIsAgency() {
		return isAgency;
	}

	public void setIsAgency(Boolean isAgency) {
		this.isAgency = isAgency;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Set<Merchant> getMerchants() {
		return merchants;
	}

	public void setMerchants(Set<Merchant> merchants) {
		this.merchants = merchants;
	}

	public Set<RankRate> getRankRates() {
		return rankRates;
	}

	public void setRankRates(Set<RankRate> rankRates) {
		this.rankRates = rankRates;
	}

	public List<RankRate> getRates() {
		return rates;
	}

	public void setRates(List<RankRate> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "Rank [id=" + id + ", createDate=" + createDate + ", name=" + name + ", isDefault=" + isDefault
				+ ", isAgency=" + isAgency + "]";
	}

}
