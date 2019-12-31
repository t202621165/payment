package com.cypay.common.to;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 多方式赠送
 * @author International
 * 2018年7月29日 下午6:27:23
 */
public abstract class MultiWayGive implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 赠送方式：
	 * 		1：按充值金额赠送
	 * 		2：按充值金额赠送 + 渠道赠送
	 * 		3：按充值金额赠送 + 激励赠送
	 * 		4：按充值金额赠送 + 渠道赠送 + 激励赠送
	 */
	private int type;
	
	/**
	 * 计算最终赠送金额
	 * @param amount
	 * 			充值金额
	 * @param pAmount
	 * 			渠道赠送金额
	 * @param iAmount
	 * 			激励赠送金额
	 * @return
	 */
	public BigDecimal calcFinalAmount(BigDecimal amount, BigDecimal cAmount, BigDecimal iAmount) {
		
		switch (type) {
		case 1:
			
			return amount;
		case 2:
			
			return amount.add(cAmount);
		case 3:
			
			return amount.add(iAmount);
		case 4:
			
			return amount.add(cAmount).add(iAmount);
		default:
			
			return new BigDecimal(0);
		}
	}
	
	public static BigDecimal calcFinalAmount(int type, BigDecimal amount, BigDecimal cAmount, BigDecimal iAmount) {
		
		switch (type) {
		case 1:
			
			return amount;
		case 2:
			
			return amount.add(cAmount);
		case 3:
			
			return amount.add(iAmount);
		case 4:
			
			return amount.add(cAmount).add(iAmount);
		default:
			
			return new BigDecimal(0);
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
