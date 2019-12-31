package com.cypay.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cy_rank_rate")
public class RankRate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**产品费率*/
	@Column(nullable = false)
	private BigDecimal rate = new BigDecimal(0.00);
	
	/**产品*/
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
	/**比率组*/
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Rank rank;
	
	@Transient
	private Long productId;
	
	@Transient
	private String productName;
	
	@Transient
	private BigDecimal rate2 = new BigDecimal(0.00);
	
	public RankRate() {
		
	}
	
	public RankRate(Long id, BigDecimal rate, Long productId, String productName) {
		this.id = id;
		this.rate = rate;
		this.productId = productId;
		this.productName = productName;
	}
	
	public RankRate(Long id, BigDecimal rate, Long productId, String productName, BigDecimal rate2) {
		this(id, rate, productId, productName);
		this.rate2 = rate2;
	}
	
	public RankRate(Long productId,Rank rank,BigDecimal rate){
		this.product = new Product(productId);
		this.rank = rank;
		this.rate = rate;
	}
	
	public RankRate(Product product,Rank rank,BigDecimal rate){
		this.product = product;
		this.rank = rank;
		this.rate = rate;
	}
	
	public RankRate(Long productId,Long rateId,Rank rank,BigDecimal rate){
		this.product = new Product(productId);
		this.id = rateId;
		this.rank = rank;
		this.rate = rate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Long getProductId() {
		if (StringUtils.isEmpty(productId))
			return this.getProduct() == null ? productId : this.getProduct().getId();
		else
		    return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		if (StringUtils.isEmpty(productName))
			return this.getProduct() == null ? productName : this.getProduct().getName();
		else
			return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getRate2() {
		return rate2;
	}

	public void setRate2(BigDecimal rate2) {
		this.rate2 = rate2;
	}

	@Override
	public String toString() {
		return "RankRate [id=" + id + ", rate=" + rate + "]";
	}

}
