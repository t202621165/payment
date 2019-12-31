package com.cypay.common.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AmountType {
	
	/**非金额类型-原样返回*/
	NOT_AMOUNT("%s"),
	
	/**金额【单位：元】-保留两位小数*/
	YUAN("%.2f"), 
	
	/**金额【单位：分】*/
	CENT("%.0f");

	private String format;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private AmountType(String format) {
		this.format = format;
	}
	
	public String format(Object obj) {
		try {
			if (this == CENT) {
				Double d = Double.valueOf(String.valueOf(obj));
				return String.format(format, d * 100);
			}
			
			return String.format(format, obj);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return String.valueOf(obj);
	}

	public String getFormat() {
		return format;
	}
}
