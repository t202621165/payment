package com.cypay.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author iwano 通道成本费率
 *
 */
@Entity
@Table(name = "cy_gallery_rate")
public class GalleryRate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	private Product product;

	@JsonIgnore
	@ManyToOne
	private Gallery gallery;

	private BigDecimal rate = new BigDecimal("0.00");

	private String reqUrl; // 通道产品下单提交地址

	private Boolean route = Boolean.FALSE; // 是否开启路由 true 开启路由 false 关闭路由
	
	@Transient
	private Long productId;
	
	@Transient
	private String productName;
	
	@Transient
	private String productTypeMark;
	
	public GalleryRate(){};
	
	public GalleryRate(Long galleryId,Long productId,Long rateId,BigDecimal rate,String reqUrl){
		this.gallery = new Gallery(galleryId);
		this.product = new Product(productId);
		this.id = rateId;
		this.rate = rate;
		this.reqUrl = reqUrl;
	}
	
	public GalleryRate(Gallery gallery,Product product){
		this.gallery = gallery;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getReqUrl() {
		return reqUrl;
	}

	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	public Boolean getRoute() {
		return route;
	}

	public void setRoute(Boolean route) {
		this.route = route;
	}

	public String getProductName() {
		if (this.product != null) {
			return product.getName();
		}
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductId() {
		if (this.product != null) {
			return product.getId();
		}
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductTypeMark() {
		if (this.product != null) {
			return product.getTypeMark();
		}
		return productTypeMark;
	}

	public void setProductTypeMark(String productTypeMark) {
		this.productTypeMark = productTypeMark;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
		
		try {
			result = result * prime + this.gallery.getId().hashCode();
			
			result = result * prime + this.product.getId().hashCode();
		} catch (Exception e) {
			result = result * prime;
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof GalleryRate) {
			GalleryRate gr = (GalleryRate) obj;
			if (this.gallery == null || this.gallery.getId() == null || gr.gallery == null || gr.gallery.getId() == null) {
				return false;
			}
			
			if (this.product == null || this.product.getId() == null || gr.product == null || gr.product.getId() == null) {
				return false;
			}
			
			return this.gallery.getId().equals(gr.gallery.getId()) && this.product.getId().equals(gr.product.getId());
		}
		return false;
	}
}
