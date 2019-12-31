package com.cypay.common.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * NPC信息
 * @author International
 * 2018年7月29日 下午5:29:36
 */
public class NpcInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static List<NpcInfo> npcInfos = new ArrayList<NpcInfo>();
	
	static {
		npcInfos.add(new NpcInfo("元宝充值使者", "3", 343, 338, 12, true));
		npcInfos.add(new NpcInfo("元宝充值使者", "0", 332, 264, 12, true));
	}

	/**NPC名称*/
	private String name;
	
	/**NPC所在地图*/
	private String map;
	
	/**NPC所在地图X轴*/
	private int x_axis;
	
	/**NPC所在地图Y轴*/
	private int y_axis;
	
	/**NPC外貌*/
	private int looks;
	
	/**NPC类型(true：充值NPC false：红包NPC)*/
	private boolean type;
	
	public NpcInfo(){};

	public NpcInfo(String name, String map, int x_axis, int y_axis, int looks, boolean type) {
		super();
		this.name = name;
		this.map = map;
		this.x_axis = x_axis;
		this.y_axis = y_axis;
		this.looks = looks;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public int getX_axis() {
		return x_axis;
	}

	public void setX_axis(int x_axis) {
		this.x_axis = x_axis;
	}

	public int getY_axis() {
		return y_axis;
	}

	public void setY_axis(int y_axis) {
		this.y_axis = y_axis;
	}

	public int getLooks() {
		return looks;
	}

	public void setLooks(int looks) {
		this.looks = looks;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "NpcInfo [name=" + name + ", map=" + map + ", x_axis=" + x_axis + ", y_axis=" + y_axis + ", looks="
				+ looks + ", type=" + type + "]";
	}
	
}
