package com.cypay.common.to;

import java.io.Serializable;

/**
 * 积分赠送信息
 * @author International
 * 2018年7月29日 下午5:20:46
 */
public class Integral extends MultiWayGive implements Serializable {

	private static final long serialVersionUID = 1L;

	/**赠送物品*/
	private String name;
	
	/**积分文件名*/
	private String file;
	
	/**赠送比例*/
	private int ratio = 1;
	
	/**是否显示*/
	private boolean show;

	public Integral() {
		
	}
	
	public Integral(String name, String file) {
		this.name = name;
		this.file = file;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
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
		return "Integral [name=" + name + ", file=" + file + ", ratio=" + ratio + ", show=" + show + ", type=" + getType() + "]";
	}

}
