package com.cypay.common.enums;

public enum ProductTypeEnum {
	alipay("alipay", "支付宝"),wechat("wechat","微信"),hbpay("hbpay","蚂蚁花呗"),
	tenpay("tenpay","财付通"),qpay("qpay","QQ钱包"),ebank("ebank","网银支付"),union("union","银联扫码");
	private String typeMark;
	private String typeMarkName;

	private ProductTypeEnum(String typeMark, String typeMarkName) {
		this.typeMark = typeMark;
		this.typeMarkName = typeMarkName;
	}

	
	public static String productTypeMarkName(String typeMark){
		for (ProductTypeEnum productTypeEnum : values()){
			if (typeMark.equals(productTypeEnum.getTypeMark())){
				return productTypeEnum.getTypeMarkName();
			}
		}
		return null;
	}

	public String getTypeMark() {
		return typeMark;
	}

	public void setTypeMark(String typeMark) {
		this.typeMark = typeMark;
	}

	public String getTypeMarkName() {
		return typeMarkName;
	}

	public void setTypeMarkName(String typeMarkName) {
		this.typeMarkName = typeMarkName;
	}

}
