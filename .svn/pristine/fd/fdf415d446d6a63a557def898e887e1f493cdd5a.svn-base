package com.cypay.common.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏引擎
 * @author International
 *
 */
public class GameEngine implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static List<GameEngine> engines = new ArrayList<GameEngine>();

	/**游戏引擎*/
	private String engine;
	
	/**浏览器指令*/
	private String command;
	
	/**引擎类别 1传奇  2传世*/
	private Integer type;
	
	static {
		engines.add(new GameEngine("LEG", "WebBrowser",1));
		engines.add(new GameEngine("GEE", "OpenWebSite",1));
		engines.add(new GameEngine("3KM2", "WebBrowser",1));
		engines.add(new GameEngine("MaxM2", "WebBrowser",1));
		engines.add(new GameEngine("Bluem2", "WebBrowser",1));
		engines.add(new GameEngine("Herom2", "OpenWebSite",1));
		engines.add(new GameEngine("BLUE2017", "WebBrowser",1));
		engines.add(new GameEngine("Gameofmir", "OpenWebSite",1));
		engines.add(new GameEngine("传世", "@@url",2));
	}
	
	public GameEngine() {
		
	}
	
	public GameEngine(String engine, String command,Integer type) {
		this.engine = engine;
		this.command = command;
		this.type = type;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "GameEngine [engine=" + engine + ", command=" + command + "]";
	}
	
}
