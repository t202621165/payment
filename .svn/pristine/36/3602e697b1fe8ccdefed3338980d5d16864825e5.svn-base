package com.cypay.common.annotation.jpa;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * JPA标准化注解
 * <P>自定义查询字段和查询条件</p>
 * @author International
 * @2019年4月8日 下午6:02:34
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface JpaQuery {
	
	/**
	 * 是否查询该Field
	 * <p>默认：true</p>
	 * @return
	 */
	boolean select() default true;
	
	/**
	 * Field别名
	 * @return
	 */
	String value() default "";
	
	/**
	 * <p>当 select = true时有效</p>
	 * 查询的Field如果为对象，
	 * 可指定该对象的一个或多个Field作为查询字段
	 * @return
	 */
	String[] chain() default {};
	
	/**
	 * <p>当 cond != SELECT时生效</p>
	 * @return
	 */
	String[] subField() default {};

	/**
	 * <p>SELECT：只作查询</p>
	 * <p>EQ：等于 =</p>
	 * <p>EQ_OR：and (... or ...) </p>
	 * <p>BETWEEN_$GT：大于 ></p>
	 * <p>BETWEEN_$LT：小于 <</p>
	 * <p>BETWEEN_$GTE：大于等于 >=</p>
	 * <p>BETWEEN_$LTE：小于等于 <=</p>
	 * <p>IS_NOT_NOLL：字段不为null</p>
	 * @return
	 */
	Conditional cond() default Conditional.SELECT;
	
	/**
	 * 数据校验方式
	 * @return
	 */
	VerifyMode verify() default VerifyMode.isNotBlank;
	
	/**
	 * 数据类型转换
	 * @return
	 */
	JavaType jType() default JavaType.OBJ;
}
