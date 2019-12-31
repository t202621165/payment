package com.cypay.pay.payment;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.cypay.common.annotation.SignatureSort;
import com.cypay.common.util.CommonUtil;

/**
 * 自定义字段签名顺序
 * 
 * </p>
 * 字段按照@SignatureSort自定义的顺序生成签名字符串
 * @author International
 * @2019年5月9日 上午11:08:51
 */
public abstract class CustomSignSortPayment extends BasePayment {
	
	/**
	 * 获取签名字符串
	 * @return
	 */
	@Override
	protected String getSignStr() {
		// 是否只对字段值签名
		boolean isOnlyValue = this.payment.onlyValue();
		
		return Arrays.stream(fields)
				.filter(field -> field.isAnnotationPresent(SignatureSort.class)) // 筛选待签名字段
					.sorted((f1, f2) -> { // 签名字段按指定顺序排序
						if (f1.getAnnotation(SignatureSort.class).value() > f2.getAnnotation(SignatureSort.class).value())
							return 1;
						else if (f1.getAnnotation(SignatureSort.class).value() < f2.getAnnotation(SignatureSort.class).value())
							return -1;
						return 0;
					}).map(field -> {
						// 设置字段可访问
						field.setAccessible(true);
						try {
							if (isOnlyValue) // 只对字段值签名
								return String.valueOf(field.get(this));
							
							// 按key=value拼接签名字符串
							return CommonUtil.getBufferString(field.getName(), "=", field.get(this));
						} catch (Exception e) {
							e.printStackTrace();
						}
						return "";
					}).filter(s -> s.length() > 0).collect(Collectors.joining(isOnlyValue ? "" : "&"));
	}
}
