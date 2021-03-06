package com.cypay.common.annotation.jpa;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * 数据校验方式
 * <p>根据数据校验结果，构建动态查询条件</p>
 * @author International
 * @2019年4月8日 下午6:16:03
 */
public enum VerifyMode {

	/**
	 * 不为空校验
	 */
	isNotBlank {

		@Override
		public boolean verify(Object value) {
			return value != null && !"".equals(value);
		}
	}, 
	/**
	 * 校验对象ID
	 */
	isBeanId {

		@Override
		public boolean verify(Object value) {
			Field field;
			try {
				field = value.getClass().getDeclaredField("id");
				field.setAccessible(true);
				return field != null && field.get(value) != null;
			} catch (Exception e) {
				return false;
			}
		}
		
	}, 
	/**
	 * 校验布尔类型
	 */
	isBoolean {

		@Override
		public boolean verify(Object value) {
			return Boolean.valueOf(String.valueOf(value));
		}
		
	}, 
	/**
	 * BigDecimal校验
	 * <p>不为空，且大于0</p>
	 */
	isDecimal {

		@Override
		public boolean verify(Object value) {
			try {
				BigDecimal decimal = new BigDecimal(String.valueOf(value));
				
				return decimal.compareTo(BigDecimal.ZERO) >= 0;
			} catch (Exception e) {
				return false;
			}
		}
		
	}
	;
	
	public abstract boolean verify(Object value);
}
