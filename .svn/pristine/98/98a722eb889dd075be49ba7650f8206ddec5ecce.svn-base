package com.cypay.common.annotation.jpa;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface JpaOrderBy {
	/**
	 * 定义多个排序字段时，可控制排序字段的先后顺序
	 * @return
	 */
	int sort() default 0;
	
	/**
	 * 链式调用
	 * 如果被标记排序的Field为对象，可指定该对象的具体Field排序
	 * @return
	 */
	String chain() default "";
	
	/**
	 * 排序类型ASC DESC
	 * @return
	 */
	OrderType type() default OrderType.DESC;
}
