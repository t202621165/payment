package com.cypay.common.to;

/**
 * 数据库信息
 * @author International
 * 2018年7月30日 上午10:49:39
 */
public class DbInfo {
	
	/**数据库类型：MySql、SqlServer...*/
	private int type;
	
	/**数据库服务器IP*/
	private String ip;
	
	/**数据库连接端口*/
	private Integer port;
	
	/**数据库登录用户名*/
	private String user;
	
	/**数据库登录密码*/
	private String pwd;
	
	/**自定义sql语句*/
	private String sql;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public String toString() {
		return "DbInfo [type=" + type + ", ip=" + ip + ", port=" + port + ", user=" + user + ", pwd=" + pwd
				+ ", sql=" + sql + "]";
	}
	
}
