package com.cypay.common.to;

import java.io.Serializable;

/**
 * 模版金额段赠送比率信息
 * @author International
 * 2018年8月11日 下午4:09:34
 */
public class AmountRate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int amount;
	
	private int rate;
	
	public AmountRate() {
		
	}
	
	public AmountRate(int amount, int rate) {
		this.amount = amount;
		this.rate = rate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "AmountRate [amount=" + amount + ", rate=" + rate + "]";
	}

}
