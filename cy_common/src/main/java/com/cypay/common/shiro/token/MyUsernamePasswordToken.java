package com.cypay.common.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自定义用户名密码Token验证
 * @author International
 * 2018年8月1日 下午3:31:52
 */
public class MyUsernamePasswordToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;
	
	/**登录类型-商户登录 、管理员登录*/
	private String loginType;
	
	private Boolean encrypt = Boolean.TRUE;
	
	public MyUsernamePasswordToken(String username, String password, String loginType) {
		
		super(username, password, Boolean.TRUE);
		
		this.loginType = loginType;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public Boolean getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(Boolean encrypt) {
		this.encrypt = encrypt;
	}

}
