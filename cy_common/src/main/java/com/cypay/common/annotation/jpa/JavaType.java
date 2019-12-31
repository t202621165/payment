package com.cypay.common.annotation.jpa;

import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("unchecked")
public enum JavaType {
	
	/**
	 * 返回原数据类型
	 */
	OBJ {

		@Override
		public Object transform(Object value) {
			return value;
		}
	}, 

	/**
	 * 日期类型
	 */
	DATE {
		@Override
		public Date transform(Object value) {
			return (Date) value;
		}
	}, 
	
	/**
	 * BigDecimal类型
	 */
	DECIMAL {

		@Override
		public BigDecimal transform(Object value) {
			return (BigDecimal) value;
		}
		
	};
	
	public abstract <T> T transform(Object value);
}
