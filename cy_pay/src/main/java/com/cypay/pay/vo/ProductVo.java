package com.cypay.pay.vo;

import java.util.ArrayList;
import java.util.List;

import com.cypay.common.entity.Product;
import com.cypay.common.to.AmountRate;
import com.cypay.common.util.CommonUtil;

/**
 * 充值页面产品信息
 * @author International
 * 2018年8月11日 下午4:38:25
 */
public class ProductVo extends Product {

	private static final long serialVersionUID = 1L;
	
	private Integer rate;
	
	private List<AmountRate> amountRates = new ArrayList<AmountRate>();
	
	public ProductVo(Long id,String mark,String name,Integer type,String typeMark,Integer rate,String amountRate) {
		setId(id);
		setMark(mark);
		setName(name);
		setType(type);
		setTypeMark(typeMark);
		this.rate = rate==null?0:rate;
		this.amountRates = CommonUtil.parseArray(amountRate, AmountRate.class);
	}
	
	public ProductVo(Long id,String typeMark,String markName) {
		setId(id);
		setTypeMark(typeMark);
		setMarkName(markName);
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public List<AmountRate> getAmountRates() {
		return amountRates;
	}

	public void setAmountRates(List<AmountRate> amountRates) {
		this.amountRates = amountRates;
	}

	@Override
	public String toString() {
		return "ProductVo [rate=" + rate + ", amountRates=" + amountRates + "]";
	}

}
