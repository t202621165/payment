package com.cypay.common.to;

import java.io.Serializable;

/**
 * 附加赠送信息
 * @author International
 * 2018年7月29日 下午5:16:52
 */
public class Additional extends MultiWayGive implements Serializable {

	private static final long serialVersionUID = 1L;

	/**赠送物品*/
	private String name;
	
	/**脚本命令*/
	private String command;
	
	/**赠送比例*/
	private int ratio = 1;

	/**是否显示*/
	private boolean show;
	
	public Additional() {
		
	}
	
	public Additional(String name, String command) {
		this.name = name;
		this.command = command;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	@Override
	public String toString() {
		return "Additional [name=" + name + ", command=" + command + 
				", ratio=" + ratio + ", show=" + show + ", type=" + getType() + "]";
	}

}
