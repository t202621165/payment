package com.cypay.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.cypay.common.annotation.jpa.Conditional;
import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.annotation.jpa.OrderType;
import com.cypay.common.enums.ProductTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

/***
 * 支付产品实体
 * @author International
 * 2018年8月1日 上午10:13:00
 */
@Entity
@Table(name = "cy_product")
@NamedEntityGraphs({
	@NamedEntityGraph(
		name = "productWithGallery", 
		attributeNodes = {@NamedAttributeNode(value = "gallery")}
	)
})
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final List<Product> DEFAULT_PRODUCT = new ArrayList<Product>();
	
	static {
		DEFAULT_PRODUCT.add(new Product("支付宝①", "alipay1", 0, 1, ProductTypeEnum.alipay));
		DEFAULT_PRODUCT.add(new Product("支付宝②", "alipay2", 0, 2, ProductTypeEnum.alipay));
		DEFAULT_PRODUCT.add(new Product("微信①", "wechat1", 0, 3, ProductTypeEnum.wechat));
		DEFAULT_PRODUCT.add(new Product("微信②", "wechat2", 0, 4, ProductTypeEnum.wechat));
		DEFAULT_PRODUCT.add(new Product("蚂蚁花呗①", "hbpay1", 0, 5, ProductTypeEnum.hbpay));
		DEFAULT_PRODUCT.add(new Product("蚂蚁花呗②", "hbpay2", 0, 6, ProductTypeEnum.hbpay));
		DEFAULT_PRODUCT.add(new Product("QQ钱包", "qpay", 0, 7, ProductTypeEnum.qpay));
		DEFAULT_PRODUCT.add(new Product("财付通", "tenpay", 0, 8, ProductTypeEnum.tenpay));
		DEFAULT_PRODUCT.add(new Product("银联扫码", "union", 0, 9, ProductTypeEnum.union));
		DEFAULT_PRODUCT.add(new Product("农业银行", "ABC", 1, 10, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("北京银行", "BOB", 1, 11, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("中国银行", "BOC", 1, 12, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("上海银行", "BOSC", 1, 13, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("建设银行", "CCB", 1, 14, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("光大银行", "CEB", 1, 15, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("广发银行", "CGB", 1, 16, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("兴业银行", "CIB", 1, 17, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("中信银行", "CITIC", 1, 18, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("招商银行", "CMB", 1, 19, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("民生银行", "CMBC", 1, 20, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("交通银行", "COMM", 1, 21, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("广州银行", "GZCB", 1, 22, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("华夏银行", "HXB", 1, 23, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("工商银行", "ICBC", 1, 24, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("平安银行", "PINGAN", 1, 25, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("邮政储蓄", "PSBC", 1, 26, ProductTypeEnum.ebank));
		DEFAULT_PRODUCT.add(new Product("浦发银行", "SPDB", 1, 27, ProductTypeEnum.ebank));
	}

	/**产品-ID*/
	@JpaQuery
	@JpaOrderBy(type = OrderType.ASC)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**产品-名称*/
	@JpaQuery
	@NotBlank(message = "产品名称不能为空")
	@Column(length = 10, nullable = false)
	private String name;
	
	/**产品-标识(唯一)*/
	@JpaQuery
	@NotBlank(message = "产品标识不能为空")
	@Column(length = 10, nullable = false, unique = true)
	private String mark;
	
	/**产品-启用状态*/
	@JpaQuery(cond = Conditional.EQ)
	@Column(nullable = false)
	private Boolean state;
	
	/**产品-类型: 0：其他 1：网银 2：点卡*/
	@JpaQuery(cond = Conditional.EQ)
	@Column(nullable = false)
	private Integer type;
	
	/**产品-类型标识*/
	@JpaQuery
	@Column(length = 10, nullable = false)
	private String typeMark;
	
	/**产品-类型标识名称*/
	@Column(length = 10, nullable = false)
	private String markName;
	
	/**产品支付默认通道*/
	@JpaQuery(chain = {"id", "name"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Gallery gallery;
	
	@JpaQuery
	@JpaOrderBy(type = OrderType.ASC)
	private Integer sort = 0; //排序号
	
	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST})
	private Set<RankRate> rankRates = new HashSet<RankRate>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = {CascadeType.REMOVE})
	private List<GalleryRate> galleryRates = new ArrayList<GalleryRate>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = {CascadeType.REMOVE})
	private Set<MerchantProduct> merchantProducts = new HashSet<MerchantProduct>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = {CascadeType.REMOVE})
	private List<Order> orders = new ArrayList<Order>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = {CascadeType.REMOVE})
	private List<TemplateProduct> templateProducts = new ArrayList<TemplateProduct>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = {CascadeType.REMOVE})
	private List<ReissueRecord> reissueRecords = new ArrayList<ReissueRecord>();
		

	public Product() {}
	
	public Product(Long id) {
		this.id = id;
	}
	
	public Product(Long id, Integer type, String name) {
		this.id = id;
		this.type = type;
		this.name = name;
	}
	
	public Product(String name, String mark, Integer type, Integer sort, ProductTypeEnum productType) {
		this.name = name;
		this.mark = mark;
		this.type = type;
		this.sort = sort;
		this.state = Boolean.TRUE;
		this.typeMark = productType.getTypeMark();
		this.markName = productType.getTypeMarkName();
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

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
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

	public String getTypeMark() {
		return typeMark;
	}

	public void setTypeMark(String typeMark) {
		this.typeMark = typeMark;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public Set<MerchantProduct> getMerchantProducts() {
		return merchantProducts;
	}

	public void setMerchantProducts(Set<MerchantProduct> merchantProducts) {
		this.merchantProducts = merchantProducts;
	}
	
	public Set<RankRate> getRankRates() {
		return rankRates;
	}

	public void setRankRates(Set<RankRate> rankRates) {
		this.rankRates = rankRates;
	}

	public List<GalleryRate> getGalleryRates() {
		return galleryRates;
	}

	public void setGalleryRates(List<GalleryRate> galleryRates) {
		this.galleryRates = galleryRates;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	

	public List<TemplateProduct> getTemplateProducts() {
		return templateProducts;
	}

	public void setTemplateProducts(List<TemplateProduct> templateProducts) {
		this.templateProducts = templateProducts;
	}

	public List<ReissueRecord> getReissueRecords() {
		return reissueRecords;
	}

	public void setReissueRecords(List<ReissueRecord> reissueRecords) {
		this.reissueRecords = reissueRecords;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", mark=" + mark + ", state=" + state + ", type=" + type
				+ ", typeMark=" + typeMark + ", markName=" + markName + ", gallery=" + gallery + "]";
	}
	
}
