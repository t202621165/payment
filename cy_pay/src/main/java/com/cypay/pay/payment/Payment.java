package com.cypay.pay.payment;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Component
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface Payment {

	/**
	 * 签名字段
	 * 
	 * @return
	 */
	String field() default "sign";
	
	/**
	 * 密钥前缀-例如：&key=
	 * 
	 * @return
	 */
	String prefix() default "";
	
	/**
	 * 是否只对值进行签名
	 * 
	 * @return
	 */
	boolean onlyValue() default false;
	
	/**
	 * 签名结果是否转为大写
	 * 
	 * @return
	 */
	boolean upperCase() default false;
	
	/**
	 * 签名处理器
	 * 
	 * @return
	 */
	SignHandler handler() default SignHandler.MD5;
}
