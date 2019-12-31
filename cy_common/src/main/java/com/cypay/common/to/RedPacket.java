package com.cypay.common.to;

import java.io.Serializable;

/**
 * 红包赠送信息
 * @author International
 * 2018年7月29日 下午5:45:47
 */
public class RedPacket implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**目标金额*/
	private int amount;
	
	/**赠送金额段-Start*/
	private int startAmount;
	
	/**赠送金额段-End*/
	private int endAmount;
	
	/**是否加入附加赠送金额计算*/
	private boolean aState;
	
	/**是否加入积分赠送金额计算*/
	private boolean iState;
	
	/**是否加入装备赠送金额计算*/
	private boolean eState;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStartAmount() {
		return startAmount;
	}

	public void setStartAmount(int startAmount) {
		this.startAmount = startAmount;
	}

	public int getEndAmount() {
		return endAmount;
	}

	public void setEndAmount(int endAmount) {
		this.endAmount = endAmount;
	}

	public boolean isaState() {
		return aState;
	}

	public void setaState(boolean aState) {
		this.aState = aState;
	}

	public boolean isiState() {
		return iState;
	}

	public void setiState(boolean iState) {
		this.iState = iState;
	}

	public boolean iseState() {
		return eState;
	}

	public void seteState(boolean eState) {
		this.eState = eState;
	}

	@Override
	public String toString() {
		return "RedPacket [amount=" + amount + ", startAmount=" + startAmount + ", endAmount=" + endAmount + ", aState="
				+ aState + ", iState=" + iState + ", eState=" + eState + "]";
	}
	
}
