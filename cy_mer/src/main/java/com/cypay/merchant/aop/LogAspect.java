package com.cypay.merchant.aop;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.MerchantLog;
import com.cypay.common.repository.impl.MerchantLogRepository;
import com.cypay.common.repository.impl.MerchantRepository;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.vo.Result;

@Aspect
@Component
public class LogAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MerchantRepository merchantRepository;
	
	@Autowired
	private MerchantLogRepository merchantLogRepository;
	
	/**
	 * 切点
	 */
	@Pointcut("@annotation(com.cypay.merchant.aop.MerchantLogs)")
	public void logPointCut() {
		
	}
	
	/**
	 * 切面 保存操作日志
	 * @param joinPoint
	 * @param json
	 */
	@AfterReturning(pointcut = "logPointCut()", returning = "result")
	public void saveLog(JoinPoint joinPoint, Result result) {
		try {
			boolean isLogin = ShiroManager.isLogin(Merchant.class);
			// 已登陆、方法执行成功
			if (isLogin && result.getState()) {
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				String ip = CommonUtil.getIpAddr(request);
				//从切面织入点处通过反射机制获取织入点处的方法
				MethodSignature signature = (MethodSignature) joinPoint.getSignature();
				//获取切入点所在的方法
				Method method = signature.getMethod();
				//获取操作
				MerchantLogs myLog = method.getAnnotation(MerchantLogs.class);
				Merchant merchant = ShiroManager.getMerchant();
				Date date = new Date();
				String value = "";
				if (myLog != null) {
					value = myLog.value();
					if (myLog.isLogin()) {
						merchant.setFinalDate(date);
						merchantRepository.updateFinalDate(merchant.getId(), date);
					}
				}
				
				MerchantLog log = new MerchantLog(date, ip, value, result.getMsg(), merchant);
				merchantLogRepository.save(log);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
