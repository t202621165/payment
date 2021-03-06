package com.cypay.pay.payment;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.annotation.NotParam;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.CommonUtil;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;

import cn.hutool.core.util.ReflectUtil;

public abstract class BasePayment implements Cloneable {
	
	@NotParam
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@NotParam
	@Autowired
	protected RestTemplate restTemplate;
	
	@NotParam
	protected Map<String, String> alias = new HashMap<>();
	
	/**所有字段-包括父类*/
	@NotParam
	protected Field[] fields = ReflectUtil.getFields(this.getClass());
	
	/**签名字段*/
	@NotParam
	protected Field signField;
	
	@NotParam
	protected Payment payment = this.getClass().getAnnotation(Payment.class);
	
	/**接口下单请求域名*/
	@NotParam
	protected String domainName;
	
	@NotParam
	protected PaymentType paymentType;
	
	public BasePayment() {
		this.setPaymentType();
	}
	
	/**
	 * 接口类型
	 * @return
	 */
	public abstract void setPaymentType();
	
	/**
	 * 接口唯一标识
	 * @return
	 */
	public String mark() {
		return paymentType.type();
	}
	
	/**
	 * 获取签名字符串
	 * @return
	 */
	protected abstract String getSignStr();

	/**
	 * 下单
	 * @param order
	 * @param gallery
	 * @return
	 */
	public final Resultful placeOnOrder(RechargeVo recharge) {
		// 初始化参数
		init(recharge);
		// 数据签名
		sign(recharge);
		// 发送请求
		return recharge.getIsRedirect() ? getRedirectURL() : getQRCodeURL();
	}
	
	/**
	 * 初始化接口参数
	 * @param order
	 * @param gallery
	 */
	private void init(RechargeVo recharge) {
		// 获取签名字段
		if (payment != null && payment.field().length() > 0) {
			try {
				this.signField = this.getClass().getDeclaredField(payment.field());
			} catch (Exception e) {}
		}
		
		this.domainName = recharge.getReqUrl();
		
		for (Field field : fields) {
			PublicData pub = field.getAnnotation(PublicData.class);
			if (pub != null) {
				field.setAccessible(true);
				
				try {
					Field f = recharge.getClass().getDeclaredField(pub.value());
					f.setAccessible(true);
					Object value = pub.type().format(f.get(recharge));
					
					if (pub.alias()) {
						value = alias.get(value);
					}
					
					field.set(this, value);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		}
		
		// 初始化后置处理
		initPostProcess(recharge);
	}
	
	/**
	 * 初始化前置处理
	 */
	@PostConstruct
	protected void initPreProcess() {}
	
	/**
	 * 初始化后置处理
	 */
	protected void initPostProcess(RechargeVo recharge) {}
	
	/**
	 * 生成签名
	 * @param recharge
	 * @return
	 */
	protected String getSign(RechargeVo recharge) {
		logger.info("签名排序串【{}】",getSignStr()+this.payment.prefix()+recharge.getSecretKey());
		String sign = this.payment.handler().sign(getSignStr(), 
				this.payment.prefix() + recharge.getSecretKey(), paymentType.getCharset());
		
		if (this.payment.upperCase()) {
			// 签名结果转为大写
			sign = sign.toUpperCase();
		}
		return sign;
	}
	
	/**
	 * 签名字段赋值
	 * @param gallery
	 */
	protected void sign(RechargeVo recharge) {
		if (signField != null) {
			try {
				// 设置签名字段可访问
				signField.setAccessible(true);
				// 反射设置签名字段的值
				signField.set(this, getSign(recharge));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取请求链接
	 * @return
	 */
	protected Resultful getRedirectURL() {
		return Resultful.redirectURL(CommonUtil.getBufferString(domainName, "?", getParamStr()));
	}
	
	/**
	 * 获取二维码URL
	 * @return
	 */
	protected Resultful getQRCodeURL() {
		return Resultful.error("NOT_SUPPORT_QRCODE");
	}
	
	/**
	 * 属性拼接
	 * @return
	 */
	protected String getParamStr() {
		int i = 0;
		StringBuilder builder = new StringBuilder();
		
		for (Field field : fields) {
			if (!field.isAnnotationPresent(NotParam.class)) {
				// 设置字段可访问
				field.setAccessible(true);
				try {
					// 按key=value拼接签名字符串
					if (!StringUtils.isEmpty(field.get(this))){
						if (i++ > 0) {
							builder.append("&");
						}
						
						builder.append(field.getName()).append("=").append(field.get(this));
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		}
		return builder.toString();
	}
	
	protected String getJSONStr(boolean isAll) {
		Map<String,Object> map = new HashMap<String, Object>();
		for (Field field : fields){
			if (isAll && !field.isAnnotationPresent(NotParam.class)){
				// 设置字段可访问
				field.setAccessible(true);
				try {
					if (!StringUtils.isEmpty(field.get(this))){
						map.put(field.getName(), field.get(this));
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		}
		return JSONObject.toJSONString(map);
	}
	
	protected  HttpEntity<?> getEntitys(MultiValueMap<String, String> headers){
		MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
		for (Field field : this.fields) {
			if (!field.isAnnotationPresent((NotParam.class))) {
				field.setAccessible(true);
				try {
					requestBody.add(field.getName(), field.get(this));
				} catch (Exception e) {}
			}
		}
		return new HttpEntity<>(requestBody, headers);
	}

	@Override
	public BasePayment clone() throws CloneNotSupportedException {
		try {
			return (BasePayment) super.clone();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
}
