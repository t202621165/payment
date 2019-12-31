package com.cypay.common.enums;

/**
 * 系统版本
 * @author International
 * @2019年4月19日 上午10:24:57
 */
public enum Edition {
	
	/**
	 * 商业版
	 */
	BUSINESS(Boolean.TRUE, Boolean.TRUE),
	
	/**
	 * 个人版
	 */
	PERSONAL,
	
	/**
	 * 默认
	 */
	DEFAULT;
	
	/**
	 * 当前系统版本
	 */
	public static Edition current_edition = Edition.DEFAULT;
	
	/**
	 * 个人版-商户最大允许注册数
	 */
	private int max_allowed_regist_number = 10;
	
	/**
	 * 支付宝代付
	 */
	private boolean isPayeeAlipay = false;
	
	/**
	 * 微信代付
	 */
	private boolean isPayeeWechat = false;
	
	private int galleryCount = 1;
	
	/**
	 * 授权通道
	 */
	private Object oauth_gallerys = "0";
	
	private boolean isCq = true;
	
	private boolean isCs = true;
	
	private boolean isCq3 = true;
	
	private boolean isSql = true;
	
	private boolean isWeb = true;
	
	/**
	 * 到期时间
	 */
	private long expiration_date = 946656000000L; // 2000-01-01
	
	Edition(){}
	
	Edition(Boolean isPayeeAlipay, Boolean isPayeeWechat) {
		this.isPayeeAlipay = isPayeeAlipay;
		this.isPayeeWechat = isPayeeWechat;
	}
	
	/**
	 * 是否拥有当前分区类型的网关授权
	 * @param partitionType
	 * @return
	 */
	public static boolean hasWGPermission(Integer partitionType) {
		switch (partitionType) {
		case 0:
			return current_edition.isSql();
		case 1:
			return current_edition.isCq();
		case 2:
			return current_edition.isCs();
		case 3:
			return current_edition.isCq3();
		case 4:
			return current_edition.isWeb();
		default:
			return false;
		}
	}

	public int getMax_allowed_regist_number() {
		return max_allowed_regist_number;
	}

	public void setMax_allowed_regist_number(int max_allowed_regist_number) {
		this.max_allowed_regist_number = max_allowed_regist_number;
	}

	public boolean isPayeeAlipay() {
		return isPayeeAlipay;
	}

	public void setPayeeAlipay(boolean isPayeeAlipay) {
		this.isPayeeAlipay = isPayeeAlipay;
	}

	public boolean isPayeeWechat() {
		return isPayeeWechat;
	}

	public void setPayeeWechat(boolean isPayeeWechat) {
		this.isPayeeWechat = isPayeeWechat;
	}

	public Object getOauth_gallerys() {
		return oauth_gallerys;
	}

	public void setOauth_gallerys(Object oauth_gallerys) {
		this.oauth_gallerys = oauth_gallerys;
	}

	public long getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(long expiration_date) {
		this.expiration_date = expiration_date;
	}

	public boolean isCq() {
		return isCq;
	}

	public void setCq(boolean isCq) {
		this.isCq = isCq;
	}

	public boolean isCs() {
		return isCs;
	}

	public void setCs(boolean isCs) {
		this.isCs = isCs;
	}

	public boolean isCq3() {
		return isCq3;
	}

	public void setCq3(boolean isCq3) {
		this.isCq3 = isCq3;
	}

	public boolean isSql() {
		return isSql;
	}

	public void setSql(boolean isSql) {
		this.isSql = isSql;
	}

	public boolean isWeb() {
		return isWeb;
	}

	public void setWeb(boolean isWeb) {
		this.isWeb = isWeb;
	}

	public int getGalleryCount() {
		return galleryCount;
	}

	public void setGalleryCount(int galleryCount) {
		this.galleryCount = galleryCount;
	}
	
	public Edition reset() {
		this.isSql = true;
		this.isCq = true;
		this.isCs = true;
		this.isCq3 = true;
		this.isWeb = true;
		this.isPayeeAlipay = false;
		this.isPayeeWechat = false;
		this.max_allowed_regist_number = 10;
		this.galleryCount = 1;
		this.oauth_gallerys = "0";
		this.expiration_date = 946656000000L;
		return this;
	}

	@Override
	public String toString() {
		return super.toString() + " [m_n=" + max_allowed_regist_number + ", p_a=" + isPayeeAlipay
				+ ", p_w=" + isPayeeWechat + ", o_g=" + oauth_gallerys + ", g_c=" + galleryCount 
				+ ", w_g=" + (isSql?0:"") + (isCq?1:"") + (isCs?2:"") + (isCq3?3:"") + (isWeb?4:"") + "]";
	}
	
}
