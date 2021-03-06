package com.cypay.pay.notice;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.cypay.pay.service.OrderService;
import com.cypay.pay.vo.NoticeVo;
import com.cypay.pay.vo.NotifyVo;
import com.cypay.pay.vo.ReturnVo;

import cn.hutool.core.collection.CollUtil;

/**
 * -接口异步通知结果处理-
 * @author International
 * @2019年1月10日 上午11:06:31
 */
public abstract class BaseNotice implements Cloneable {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderService orderService;
	
	protected Notice notify = this.getClass().getAnnotation(Notice.class);
	
	/**不参与签名字段*/
	protected Set<String> noSignKeys = new HashSet<>(Arrays.asList("sign"));;
	
	/**待签名字段*/
	protected List<String> signKeys = new ArrayList<>();
	
	/**接口异步通知参数*/
	private Map<String, String> data;
	
	private String charset = "UTF-8";
	
	/**是否只对值签名*/
	private Boolean isOnlyValue = Boolean.FALSE;
	
	/**支付结果*/
	private Boolean isSuccess;
	
	/**订单号*/
	private String orderNumber;
	
	/**上游接口返回的订单号*/
	private String supNumber;
	
	/**上游接口返回的实际支付金额*/
	private BigDecimal payAmount;
	
	/**签名*/
	private String sign;
	
	/**处理成功，返回至上游接口的标识*/
	private String resultCode;
	
	/**
	 * 解析接口返回的数据
	 * @param request
	 */
	protected void parseData(HttpServletRequest request) {
		this.data = request.getParameterMap().keySet().parallelStream().filter(
				key -> !"_gateway_type_".equals(key)).collect(Collectors.toMap(Function.identity(), key -> request.getParameter(key)));
	}
	
	/**
	 * 异步通知类型
	 * @return
	 */
	public abstract String notifyType();

	/**
	 * 参数初始化
	 */
	protected abstract void init();
	
	/**
	 * 初始化前置处理
	 */
	@PostConstruct
	protected abstract void initPreprocess();
	
	/**
	 * 签名验证
	 */
	protected boolean verify(String secretKey) {
		return this.notify.handler().verify(this.getSignatureStr(secretKey), this.sign, secretKey, this.charset);
	}
	
	/**
	 * 接收接口通知结果
	 * @param request
	 * @param response
	 * @param type
	 * 			0：异步通知 1：同步跳转
	 * @return
	 * @throws IOException
	 */
	public final NoticeVo notice(HttpServletRequest request, HttpServletResponse response, Integer type) throws IOException {
		response.resetBuffer();
		
		// 解析上有接口返回的数据
		this.parseData(request);
		
		// 初始化异步通知参数
		this.init();
		logger.info("【接口通知_{}】-param：{}", type, this.data);
		NoticeVo notice = null;
		// 是否支付成功
		if (isSuccess) {
			if (type == 1 || this.isRedirect()) {
				notice =  this.returnn(response);
			}else {
				notice =  this.notify(response);
			}
		}else {
			response.getWriter().print("PAYMENT_FAILED"); // 支付失败
		}
		return notice;
	}
	
	/**
	 * 异步通知
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private final NoticeVo notify(HttpServletResponse response) throws IOException {
		// 根据订单号查询异步通知数据
		NotifyVo notify = this.orderService.findNotifyData(this.orderNumber);
		// 当前订单状态 0：等待付款
		if (notify.getOrderState() == 0) {
			// 签名验证	
			String key = this.notify.prefix() + notify.getSecretKey();
			if (this.verify(key)) {
				notify.setPayAmount(notify.getPayAmount());
				notify.setSupNumber(this.supNumber);
				notify.setOrderNumber(this.orderNumber);
				notify.setResultCode(this.resultCode);
				notify.setIsRedirect(false);
				return notify;
			}else {
				logger.info("【接口通知】-validate：签名验证未通过！！！");
				response.getWriter().print("SIGNATURE_FAILED"); // 签名验证未通过
			}
		}else {
			logger.info("【接口通知】-result：订单已处理！！！");
			response.getWriter().print(this.resultCode); // 订单已处理
		}
		return null;
	}
	
	/**
	 * 同步跳转
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private final NoticeVo returnn(HttpServletResponse response) throws IOException {
		ReturnVo returnVo = this.orderService.findReturnData(this.orderNumber);
		returnVo.setOrderNumber(this.orderNumber);
		returnVo.setPayAmount(this.getPayAmount());
		returnVo.setIsRedirect(true);
		return returnVo;
	}
	
	protected boolean isRedirect() {
		return false;
	}
	
	/**
	 * 获取签名字符串
	 * @param kyes
	 * 			不参与签名字段
	 * @return
	 */
	protected String getSignatureStr(String secretKey) {
		if (CollUtil.isEmpty(this.signKeys)) {
			this.signKeys = this.data.keySet().stream().sorted().collect(Collectors.toList());
		}
		
		StringBuilder builder = new StringBuilder();
		int i = 0;
		for (String key : this.signKeys) {
			if (!noSignKeys.contains(key)) {
				String value = this.data.get(key);
				if (!StringUtils.isEmpty(value)){
					if (this.isOnlyValue) {
						builder.append(value);
					} else {
						if (i++ > 0) {
							builder.append("&");
						}
						builder.append(key).append("=").append(value);
					}
				}
			}
		}
		logger.info("【接口通知】-签名字符串：" + builder.toString());
		return builder.toString();
	}
	
	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public void setIsOnlyValue(Boolean isOnlyValue) {
		this.isOnlyValue = isOnlyValue;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setSupNumber(String supNumber) {
		this.supNumber = supNumber;
	}

	public BigDecimal getPayAmount() {
		return payAmount.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 设置接收成功的标识
	 * @param resultCode
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	protected String getData(String key) {
		return data.get(key);
	}
	
	@Override
	public BaseNotice clone() throws CloneNotSupportedException {
		BaseNotice notice = null;
		try {
			notice = (BaseNotice) super.clone();
		} catch (Exception e) {}
		
		return notice;
	}

	@Override
	public String toString() {
		return "BaseNotice [noSignKeys=" + noSignKeys + ", signKeys=" + signKeys
				+ ", charset=" + charset + ", isOnlyValue=" + isOnlyValue + ", isSuccess=" + isSuccess
				+ ", orderNumber=" + orderNumber + ", supNumber=" + supNumber + ", payAmount=" + payAmount + ", sign="
				+ sign + ", resultCode=" + resultCode + "]";
	}

}
