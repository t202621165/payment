package com.cypay.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cypay.common.to.AmountRate;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.vo.ReissueRecordVo;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 模版产品赠送比率实体
 * @author International
 * 2018年8月11日 下午2:59:59
 */
@Entity
@Table(name = "cy_template_product")
public class TemplateProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**固定赠送比率*/
	@Column(nullable = false)
	private Integer rate;
	
	/**金额段赠送比率(JSONArray格式)*/
	@Column(columnDefinition = "text")
	private String amountRate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Template template;
	
	@Transient
	private List<AmountRate> amountRates = new ArrayList<AmountRate>();

	public TemplateProduct() {
		
	}
	
	public TemplateProduct(Long id, Integer rate, String amountRate, 
			Long productId, Integer type, String productName) {
		this.id = id;
		this.rate = rate == null?0:rate;
		this.product = new Product(productId, type, productName);
		setAmountRates(CommonUtil.parseArray(amountRate, AmountRate.class));
	}
	
	public String parse() {
		return this.amountRate = JSON.toJSONString(amountRates);
	}
	
	/**
	 * 获取渠道赠送金额
	 */
	public JSONObject channelAmount(ReissueRecordVo v, String uuid) {
		this.rate = rate == null ? 0 : rate;
		int amount = v.getAmount().intValue();
		// 按充值金额赠送
		if (template.getGiveWay()) {
			rate = this.amountRates.isEmpty()? 0 : this.amountRates.stream().filter(a -> a.getAmount() <= amount)
					.map(a -> a.getRate()).reduce(this.amountRates.get(0).getRate(), Integer::max);
		}
		int iAmount = 0;
		// 渠道赠送包含激励赠送
		if (template.getIsContains()) {
			iAmount = template.incentiveAmount(amount).intValue();
		}
		
		BigDecimal cAmount = new BigDecimal(rate * (amount + iAmount) * 0.01);
		return template.dataToGetway(v, cAmount, uuid);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getAmountRate() {
		return amountRate;
	}

	public void setAmountRate(String amountRate) {
		this.amountRate = amountRate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public List<AmountRate> getAmountRates() {
		return amountRates;
	}

	public void setAmountRates(List<AmountRate> amountRates) {
		if (amountRates == null || amountRates.isEmpty()) {
			amountRates = new ArrayList<AmountRate>();
			amountRates.add(new AmountRate(0, 0));
			amountRates.add(new AmountRate(0, 0));
			amountRates.add(new AmountRate(0, 0));
			amountRates.add(new AmountRate(0, 0));
			amountRates.add(new AmountRate(0, 0));
			amountRates.add(new AmountRate(0, 0));
		}
		
		this.amountRates = amountRates;
	}

	@Override
	public String toString() {
		return "TemplateProduct [id=" + id + ", rate=" + rate + "]";
	}
	
}
