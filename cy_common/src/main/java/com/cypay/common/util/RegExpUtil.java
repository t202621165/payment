package com.cypay.common.util;

/**
 * 数据校验正则表达式
 * @author International
 * @2019年3月14日 下午2:16:36
 */
public interface RegExpUtil {
	
	/**
	 * 正则表达式-QQ
	 */
	static final String QQ = "^[1-9][\\d]{4,10}$";
	
	static final String QQ_ERROR_MESSAGE = "QQ为5-11位非0开头纯数字组成";
	/**
	 * 正则表达式-用户名
	 */
	static final String USER_NAME = "^[a-z0-9A-Z]{3,10}$";
	
	static final String USER_NAME_ERROR_MESSAGE = "3~10个英文字母或数字组成";
	/**
	 * 正则表达式-密码
	 */
	static final String PWD = "^\\w{6,20}$";
	
	static final String PWD_ERROR_MESSAGE = "密码由6~20个英文字母、数字和下划线组成";
	/**
	 * 正则表达式-Email地址
	 */
	static final String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	
	static final String EMAIL_ERROR_MESSAGE = "请输入有效的Email地址";
	
	static final String IP = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
	
	static final String IP_ERROR_MESSAGE = "请输入有效的IP地址";
	
	/**
	 * 正则表达式-顶级域名或IP
	 * 
	 */
	static final String DOMAIN_NAME = "(?=^.{3,255}$)(http(s)?:\\/\\/)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(\\/\\w+\\.\\w+)*";
	
	static final String DOMAIN_NAME_ERROR_MESSAGE = "请输入有效的域名或ip";

}
