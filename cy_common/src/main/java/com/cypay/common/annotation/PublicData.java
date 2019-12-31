package com.cypay.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.cypay.common.enums.AmountType;

/**
 * 接口公共数据
 * @author International
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PublicData {
	
	/**字段名*/
	String value();
	
	/**别名*/
	boolean alias() default false;
	
	/**字段值类型*/
	AmountType type() default AmountType.NOT_AMOUNT;
}
