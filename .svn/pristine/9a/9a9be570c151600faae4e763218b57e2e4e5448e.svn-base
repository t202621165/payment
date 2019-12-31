package com.cypay.common.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 商户产品信息实体
 * @author International
 * 2018年8月11日 下午2:59:59
 */
@Entity
@Table(name = "cy_merchant_product")
public class MerchantProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**商户自定义产品启用状态*/
	private Boolean state;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Merchant merchant;
	
	public MerchantProduct() {
		
	}
	
	public MerchantProduct(Long productId, Merchant merchant) {
		this.product = new Product(productId);
		this.merchant = merchant;
		this.state = Boolean.TRUE;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "MerchantProduct [id=" + id + ", state=" + state + "]";
	}
	
}
