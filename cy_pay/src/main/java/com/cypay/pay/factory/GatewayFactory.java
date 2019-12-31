package com.cypay.pay.factory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.payment.BasePayment;

@Component
public class GatewayFactory {
	
	public static Map<String, BasePayment> payments = new ConcurrentHashMap<>();
	
	private Map<String, BaseNotice> notifys = new ConcurrentHashMap<>();
	
	public GatewayFactory(List<BasePayment> payments, List<BaseNotice> notifys) {
		GatewayFactory.payments.putAll(payments.parallelStream().collect(Collectors.toMap(BasePayment::mark, Function.identity())));;
		this.notifys.putAll(notifys.parallelStream().collect(Collectors.toMap(BaseNotice::notifyType, Function.identity())));
	}
	
	/**
	 * 创建支付接口实例
	 * @param galleryMark
	 * @return
	 * @throws Exception
	 */
	public BasePayment createPaymentInstance(String galleryMark) throws Exception {
		return payments.get(galleryMark).clone();
	}
	
	/**
	 * 创建异步通知实例
	 * @param galleryMark
	 * @return
	 * @throws Exception
	 */
	public BaseNotice createNotifyInstance(String galleryMark) throws Exception {
		return notifys.get(galleryMark).clone();
	}
}
