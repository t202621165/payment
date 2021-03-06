package com.cypay.common.exception;

import java.net.BindException;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cypay.common.vo.Result;
/**
 * 全局异常处理
 * @author iwano
 *
 */
//@ControllerAdvice
public class MyExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 
	 * @param e 未知异常
	 * @return 异常结果
	 */
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Result handlerException(Exception e){
		logger.error(e.getMessage());
		return Result.error(e.getMessage());
	}
	
	/**
	 * 未授权
	 * @param e
	 * @return
	 */
	@ExceptionHandler(AuthorizationException.class)
	public String handlerAuthorizationException(AuthorizationException e){
		return "forward:/403";
	}
	
	
	/**
	 * 
	 * @param e 绑定异常
	 * @return 异常结果
	 */
	@ResponseBody
	@ExceptionHandler(BindException.class)
	public Result handlerBindException(BindException e){
		logger.error(e.getMessage());
		return Result.error(e.getMessage());
	}
	
	/**
	 * 
	 * @param e 校验绑定异常
	 * @return 异常结果
	 */
	@ResponseBody
	@ExceptionHandler(org.springframework.validation.BindException.class)
	public Result handlerVlidateBindException(org.springframework.validation.BindException e){
		return Result.error(e.getBindingResult().getFieldError()
				.getDefaultMessage(), e.getBindingResult().getFieldError().getField());
	}
	
	/**
	 * 
	 * @param e 参数校验异常
	 * @return 异常结果
	 */
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
		return Result.error(e.getBindingResult().getFieldError().getDefaultMessage());
	}
	
	
	/**
	 * 
	 * @param e 违反约束异常
	 * @return 异常结果
	 */
	@ResponseBody
	@ExceptionHandler(ConstraintViolationException.class)
	public Result handlerConstraintViolationException(ConstraintViolationException e){
		Set<ConstraintViolation<?>> es = e.getConstraintViolations();
		String result = es.stream().map(error -> error.getMessage()).collect(Collectors.joining(","));
		return Result.error(result);
	}
	
	@ResponseBody
	@ExceptionHandler(DataAccessException.class)
	public Result handlerDataAccessException(DataAccessException e){
		logger.error(e.getMessage());
		return Result.error("操作失败");
	}
	
	/**
	 * 
	 * @param e 空指针异常
	 * @return 异常结果
	 */
	@ResponseBody
	@ExceptionHandler(NullPointerException.class)
	public Result handlerNullPointerException(NullPointerException e){
		logger.error(e.getMessage());
		return Result.error("空指针异常!");
	}
	
	/**
	 * 
	 * @param e 消息不可正确读异常
	 * @return 异常结果
	 */
	@ResponseBody
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Result handlerHttpMessageNotReadableException(HttpMessageNotReadableException e){
		logger.error(e.getMessage());
		return Result.error("数据解析错误,请检查请求数据格式是否正确!");
	}
	
	/**
	 * 
	 * @param e 系统事务异常
	 * @return 异常结果
	 */
	@ResponseBody
	@ExceptionHandler(TransactionSystemException.class)
	public Result handlerTransactionSystemException(TransactionSystemException e){
		logger.error(e.getMessage());
		return Result.error("事务提交异常");
	}

}
