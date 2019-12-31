package com.cypay.pay.payment;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.NotParam;
import com.cypay.common.util.CommonUtil;

/**
 * 通用签名顺序
 * <p/>
 * 字段按ASCII码从小到大排序生成签名字符串
 * @author International
 * @2019年5月9日 上午11:09:10
 */
public abstract class GenericSignSortPayment extends BasePayment {
	
	/**
	 * 获取签名字符串
	 * @return
	 */
	@Override
	protected String getSignStr() {
		return Arrays.stream(fields)
				.filter(field -> !field.isAnnotationPresent(NotParam.class) 
						&& !field.isAnnotationPresent(NoSignature.class))
					.map(field -> {
						// 设置字段可访问
						field.setAccessible(true);
						try {
							// 按key=value拼接签名字符串
							if (!StringUtils.isEmpty(field.get(this))){
								return CommonUtil.getBufferString(field.getName(), "=", field.get(this));
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						return "";
					}).filter(s -> s.length() > 0).sorted().collect(Collectors.joining("&"));
	}
}
