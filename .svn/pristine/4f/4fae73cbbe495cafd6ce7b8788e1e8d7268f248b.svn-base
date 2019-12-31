package com.cypay.pay.notice;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

import com.cypay.pay.payment.SignHandler;

@Component
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface Notice {
	
	/**
	 * 密钥前缀-例如：&key=
	 * 
	 * @return
	 */
	String prefix() default "";
	
	/**
	 * 签名验证处理器
	 * 
	 * @return
	 */
	SignHandler handler() default SignHandler.MD5;
}
