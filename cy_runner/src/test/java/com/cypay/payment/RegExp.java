package com.cypay.payment;

import java.util.regex.Pattern;

public enum RegExp {

	/** 正则：QQ */
	QQ("^[1-9][\\d]{4,10}$", "QQ为5-11位非0开头纯数字组成"),
	/**
	 * 正则：手机号（简单：1xxx...）
	 */
	MOBILE_SIMPLE("^[1]\\d{10}$", "手机号码格式为：1xxx...共11位的纯数字"),
	/**
	 * 正则：手机号（精确）
	 * <p>
	 * 移动：134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188
	 * </p>
	 * <p>
	 * 联通：130、131、132、145、155、156、175、176、185、186
	 * </p>
	 * <p>
	 * 电信：133、153、173、177、180、181、189
	 * </p>
	 * <p>
	 * 全球星：1349
	 * </p>
	 * <p>
	 * 虚拟运营商：170、171、174
	 * </p>
	 */
	MOBILE_EXACT("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,1,3-8])|(18[0-9])|(147))\\d{8}$", "手机号码输入有误"),
	/**
	 * 正则：电话号码
	 */
	TEL("^0\\d{2,3}[- ]?\\d{7,8}", "电话号码输入有误"),
	/**
	 * 正则：身份证号码15位
	 */
	ID_CARD15("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$", "请输入有效的身份证号码(15位或18位)"),
	/**
	 * 正则：身份证号码18位
	 */
	ID_CARD18("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9Xx])$", "请输入有效的身份证号码(15位或18位)"),
	/**
	 * 正则：邮箱
	 */
	EMAIL("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", "请输入有效的Email地址"),
	/**
	 * 正则：URL
	 */
	URL("[a-zA-z]+://[^\\s]*", "请输入有效的URL地址"),
	/**
	 * 正则：汉字
	 */
	ZH("^[\\u4e00-\\u9fa5]+$", "请输入汉字"),
	/**
	 * 正则：用户名、账号<p>取值范围为a-z, A-Z, 0-9, _ ,必须是3-20位</p>
	 */
	USERNAME("^[\\w]{3,20}$", "由3-20位英文字母、数字或下划线组成"),
	/**
	 * 正则：昵称<p>1-20位中文、英文字母、数字或下划线组成</p>
	 */
	NICKNAME("^[\\w\\u4e00-\\u9fa5]{1,20}$", "由1-20位中文、英文字母、数字或下划线组成"),
	/**
	 * 正则：密码
	 */
	PWD("^\\w{6,20}$", "密码由6~20个英文字母、数字和下划线组成"),
	/**
	 * 正则：IP地址
	 */
	IP("((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)", "请输入有效的IP地址");

	/**
	 * 正则表达式
	 */
	private String regex;

	/**
	 * 匹配失败提示信息
	 */
	private String msg;

	RegExp(String regex, String msg) {
		this.regex = regex;
		this.msg = msg;
	}
	
	public String regex() {
		return regex;
	}

	public String msg() {
		return msg;
	}
	
	/**
	 * 判断是否匹配正则
	 * @param input
	 * @return
	 */
	public boolean isMacth(CharSequence input) {
		return Pattern.matches(this.regex, input);
	}
	
	@Override
	public String toString() {
		return this.regex;
	}
}