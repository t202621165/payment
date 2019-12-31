package com.cypay.pay.payment.impl;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.cypay.common.annotation.NotParam;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.DUtil;
import com.cypay.common.util.huilian.Config;
import com.cypay.common.util.huilian.HuiLianTool;
import com.cypay.common.util.huilian.XmlSignUtil;
import com.cypay.pay.payment.BasePayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;

import cn.hutool.core.util.IdUtil;


@Payment
public class PayByHuiLian extends BasePayment {

	private static final StringBuilder REQUEST_BUILDER = new StringBuilder();

	private static String Function = "ant.mybank.bkmerchanttrade.intendpay";
	
	static {
		REQUEST_BUILDER.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\r\n").append(
				"<document><request id=\"request\"><head><Version>1.0.0</Version><Appid>11001</Appid><Function>").append(Function)
				.append("</Function><ReqTime>@TIME@</ReqTime>").append("<ReqMsgId>@UUID@</ReqMsgId>")
				.append("<ReqTimeZone>UTC+8</ReqTimeZone><RsaType>01</RsaType><ProviderType>08</ProviderType><InputCharset>UTF-8</InputCharset></head>")
				.append("<body><Currency>CNY</Currency><IsvOrgId>12031</IsvOrgId><SettleType>T0</SettleType>@BODY@</body></request></document>");
	}

	@PublicData(value = "orderNumber")
	private String OutTradeNo;

	@PublicData(value = "des")
	private String Body;

	@PublicData(value = "amount", type = AmountType.CENT)
	private String TotalAmount;

	@PublicData(value = "account")
	private String HlMerchantId;

	@PublicData(value = "productMark", alias = true)
	private String ChannelType;

	@PublicData(value = "notifyUrl")
	private String NotifyUrl;

	@NotParam
	private String key;

	@Override
	protected void initPreProcess() {
		alias.put("alipay", "ALI");
		alias.put("wechat", "WX");
		alias.put("hbpay", "ALI");
	}

	@Override
	protected void initPostProcess(RechargeVo recharge) {
		this.key = recharge.getSecretKey();
	}
	
	@Override
	protected String getSignStr() {
		StringBuilder body = new StringBuilder();
		for (Field field : fields) {
			if (field.isAnnotationPresent(PublicData.class)) {
				field.setAccessible(true);
				try {
					body.append("<").append(field.getName()).append(">");
					body.append(field.get(this));
					body.append("</").append(field.getName()).append(">");
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return REQUEST_BUILDER.toString().replace("@TIME@", DUtil.format("yyyyMMddHHmmss"))
				.replace("@UUID@", IdUtil.fastUUID()).replace("@BODY@", body.toString());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Resultful getQRCodeURL() {
		// 封装报文
		Map<String, Object> RespInfo = new HashMap<String, Object>();
		try {
			String param = XmlSignUtil.sign(getSignStr(), this.key);
			ResponseEntity<String> result = restTemplate.postForEntity(domainName, param, String.class);
			if (!XmlSignUtil.verify(result.getBody(), Config.huiLianRsaPublicKey)) {
				return Resultful.error("签名校验失败");
			}
			Map<String, Object> res = HuiLianTool.INSTANCE.parse(result.getBody(), Function);

			RespInfo = (Map<String, Object>) res.get("RespInfo");
			if (RespInfo.get("ResultStatus").toString().equals("S")) {
				String codeUrl = res.get("QrCodeUrl").toString();
				String amount = String.format("%.2f",
						new BigDecimal(TotalAmount).divide(BigDecimal.valueOf(100)).doubleValue());
				return Resultful.qrCodeURL(codeUrl, OutTradeNo, amount);
			}
			
			logger.error(RespInfo.toString());
			return Resultful.error(RespInfo.get("ResultMsg").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Resultful.error("下单失败！");
	}

	@Override
	public void setPaymentType() {
		this.paymentType = PaymentType.HUILIAN;
	}

	public String getFunction() {
		return Function;
	}

	public void setFunction(String function) {
		Function = function;
	}

	public String getOutTradeNo() {
		return OutTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		OutTradeNo = outTradeNo;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	public String getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		TotalAmount = totalAmount;
	}

	public String getHlMerchantId() {
		return HlMerchantId;
	}

	public void setHlMerchantId(String hlMerchantId) {
		HlMerchantId = hlMerchantId;
	}

	public String getChannelType() {
		return ChannelType;
	}

	public void setChannelType(String channelType) {
		ChannelType = channelType;
	}

	public String getNotifyUrl() {
		return NotifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		NotifyUrl = notifyUrl;
	}

}
