package com.cypay.common.to;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;
import com.cypay.common.enums.ProductTypeEnum;

public class Support implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	public static final Support DEFAULT = new Support();
	
	private boolean alipay;
	
	private boolean wechat;
	
	private boolean tenpay;
	
	private boolean qpay;
	
	private boolean hbpay;
	
	private boolean ebank;
	
	private boolean union;
	
	private boolean jingdong;
	
	@JSONField(serialize = false)
	private Set<String> types = new HashSet<>();
	
	public Support alipay() {
		this.alipay = true;
		types.add(ProductTypeEnum.alipay.getTypeMark());
		return this;
	}
	
	public Support wechat() {
		this.wechat = true;
		types.add(ProductTypeEnum.wechat.getTypeMark());
		return this;
	}
	
	public Support tenpay() {
		this.tenpay = true;
		types.add(ProductTypeEnum.tenpay.getTypeMark());
		return this;
	}
	
	public Support qpay() {
		this.qpay = true;
		types.add(ProductTypeEnum.qpay.getTypeMark());
		return this;
	}
	
	public Support hbpay() {
		this.hbpay = true;
		types.add(ProductTypeEnum.hbpay.getTypeMark());
		return this;
	}
	
	public Support ebank() {
		this.ebank = true;
		types.add(ProductTypeEnum.ebank.getTypeMark());
		return this;
	}
	
	public Support union() {
		this.union = true;
		types.add(ProductTypeEnum.union.getTypeMark());
		return this;
	}
	
	public Support jingdong() {
		this.jingdong = true;
		return this;
	}
	
	public boolean support(String type) {
		return types.contains(type);
	}

	public boolean isAlipay() {
		return alipay;
	}

	public void setAlipay(boolean alipay) {
		this.alipay = alipay;
	}

	public boolean isWechat() {
		return wechat;
	}

	public void setWechat(boolean wechat) {
		this.wechat = wechat;
	}

	public boolean isTenpay() {
		return tenpay;
	}

	public void setTenpay(boolean tenpay) {
		this.tenpay = tenpay;
	}

	public boolean isQpay() {
		return qpay;
	}

	public void setQpay(boolean qpay) {
		this.qpay = qpay;
	}

	public boolean isHbpay() {
		return hbpay;
	}

	public void setHbpay(boolean hbpay) {
		this.hbpay = hbpay;
	}

	public boolean isEbank() {
		return ebank;
	}

	public void setEbank(boolean ebank) {
		this.ebank = ebank;
	}

	public boolean isUnion() {
		return union;
	}

	public void setUnion(boolean union) {
		this.union = union;
	}

	public boolean isJingdong() {
		return jingdong;
	}

	public void setJingdong(boolean jingdong) {
		this.jingdong = jingdong;
	}

	public void setTypes(Set<String> types) {
		this.types = types;
	}

	public Set<String> getTypes() {
		return types;
	}

	@Override
	public String toString() {
		return "Support [alipay=" + alipay + ", wechat=" + wechat + ", tenpay=" + tenpay + ", qpay=" + qpay + ", hbpay="
				+ hbpay + ", ebank=" + ebank + ", union=" + union + ", jingdong=" + jingdong + "]";
	}
	
}
