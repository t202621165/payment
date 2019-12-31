package com.cypay.common.enums;

/**
 * 授权许可
 * 
 * @author International
 * @date 2019年8月7日 下午4:26:41
 */
public enum AuthorizePermissions {

	/**
	 * 支付宝代付
	 */
	PAYEE_ALIPAY,
	/**
	 * 微信代付
	 */
	PAYEE_WECHAT,
	
	/**
	 * 传奇网关
	 */
	GATEWAY_CQ,
	/**
	 * 传世网关
	 */
	GATEWAY_CS,
	/**
	 * 传奇三网关
	 */
	GATEWAY_CQ3,
	/**
	 * 通用网关
	 */
	GATEWAY_SQL,
	/**
	 * WEB通讯
	 */
	GATEWAY_WEB;
	
	public String of() {
		return this.toString().toLowerCase();
	}
}
