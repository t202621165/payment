package com.cypay.common.to;

import java.io.Serializable;

/**
 * 装备赠送信息
 * @author International
 * 2018年7月29日 下午5:39:41
 */
public class Equip implements Serializable {

	private static final long serialVersionUID = 1L;

	/**装备名称*/
	private String name;
	
	/**目标金额*/
	private int amount;
	
	/**脚本命令*/
	private String command;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return "Equip [name=" + name + ", amount=" + amount + ", command=" + command + "]";
	}

}
