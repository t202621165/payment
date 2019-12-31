package com.cypay.common.to;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 激励赠送信息
 * @author International
 * 2018年7月29日 下午5:11:58
 */
public class Incentive implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**目标金额*/
	private int amount;
	
	/**赠送金额*/
	private int giveAmount;
	
	/**
	 * 获取激励赠送金额
	 * @return
	 */
	public static BigDecimal getIncentiveAmount(BigDecimal payAmount, String incentiveInfo) {
		BigDecimal giveAmount = new BigDecimal(0.00);
		
		return giveAmount;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public int getGiveAmount() {
		return giveAmount;
	}

	public void setGiveAmount(int giveAmount) {
		this.giveAmount = giveAmount;
	}

	@Override
	public String toString() {
		return "Incentive [amount=" + amount + ", giveAmount=" + giveAmount + "]";
	}
	
}
