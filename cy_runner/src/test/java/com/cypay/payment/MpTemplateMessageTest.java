package com.cypay.payment;

import com.cypay.common.config.WxMpConfig;
import com.cypay.common.util.DUtil;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.google.common.collect.Maps;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpQrcodeServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpTemplateMsgServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;

import java.util.Map;

public class MpTemplateMessageTest {

	private static String opentId = "onOaB1NgxU59S-L_6DrToqwYjtJU";
	
	private static String appId = "wx2c0b4b5f8eae318e";
	
	private static String secret = "3bc58c839670fcb6ae34685e55dc5bf6";
	
	private static String templateId1 = "ElHxnxqo7xQ_GQoMqSSTc8zq70jv0dMKwN1lfqEa-gY";
	
	private static String templateId2 = "0-5LC3F-FCtpKc-I56CceBhdzG8K37zDSLI_O3WOZDE";
	
	private static String templateId3 = "ZC0WTXq2-1_Vz_IaW-mWre5w_FjS3O-GrMPflrn7h10";
	
	private static WxMpTemplateMsgServiceImpl templateMsgService;
	
	private static WxMpQrcodeServiceImpl qrcodeService;
	
	public static AES aes = SecureUtil.aes(secret.getBytes());
	
	static {
		WxMpService wxMpService = new WxMpServiceImpl();
		WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
		
		configStorage.setAppId(appId);
		configStorage.setSecret(secret);
		wxMpService.setWxMpConfigStorage(configStorage);
		templateMsgService = new WxMpTemplateMsgServiceImpl(wxMpService);
		
		qrcodeService = new WxMpQrcodeServiceImpl(wxMpService);
	}
	
	public static void main(String[] args) {
//		String key = "123";
//		String signStr = "orderid=C19125656689687908352&opstate=0&ovalue=100.98";
//		System.out.println("http://192.168.0.100/pay/notify/longpay?" + signStr + "&sysorderid=L19125656689687908352&sign=" + SecureUtil.md5(signStr + key));
//		sendMsg();
//		AES aes = SecureUtil.aes(secret.getBytes());
//		for (int i = 0; i < 10; i++) {
//			System.out.println(Base64.encodeUrlSafe(aes.encrypt(String.valueOf(i))));
//			System.out.println(aes.encryptBase64(String.valueOf(i)));
//			System.out.println(aes.encryptHex(String.valueOf(i)));
//			System.out.println();
//		}
//		System.out.println(aes.decryptStr(Base64.decode("FKzni5I6zZXgUwsnyTZCnQ")));
//		qrCodeCreate();
		WxMpConfig wxMpConfig = new WxMpConfig();

		wxMpConfig.setAppid(appId);
		wxMpConfig.setSecret(secret);
		wxMpConfig.setAuthUrl("http://192.168.0.100");

		Map<String, String> data = Maps.newHashMap();
		data.put("FromUserName", "onOaB1NgxU59S-L_6DrToqwYjtJU");
		data.put("ToUserName", "gh_a022f90acb1e");
		String content = wxMpConfig.oauth2buildAuthorizationUrl("/mer/wechat-bind", "540557ffdd2d4d039d5575dbf3577a5e");
		wxMpConfig.xmlOutText(content, data);
	}
	
	/**
	 * 发送模版消息
	 */
	public static void sendMsg() {
		WxMpConfig wxMpConfig = new WxMpConfig();
		
		wxMpConfig.setAppid(appId);
		wxMpConfig.setSecret(secret);
		wxMpConfig.setOrderTid(templateId1);
		wxMpConfig.setOrderRemark("请及时处理您的订单,如果没同步请尽快登录平台进行处理！！");
		wxMpConfig.setMsgTid(templateId2);
		wxMpConfig.setMsgRemark("收到一条新的留言反馈，请及时回复（点击下方）！！");
		wxMpConfig.setReplyTid(templateId3);
		wxMpConfig.setReplyRemark("点击下方查看回复详情！！");
		wxMpConfig.setAuthUrl("http://192.168.0.100");
		wxMpConfig.init();
		
		// 订单推送
		wxMpConfig.sendOrderToWx("/wechat/order/", "C19125656689687908352", (wmtm) -> {
			wmtm.setToUser(opentId);
			wmtm.addData(new WxMpTemplateData("keyword1", DUtil.format("yyyy-MM-dd HH:mm:ss"), "#173177"))
				.addData(new WxMpTemplateData("keyword2", "100.00", "#173177"))
				.addData(new WxMpTemplateData("keyword3", "iwanol", "#173177"))
				.addData(new WxMpTemplateData("keyword4", "成　功", "#008000"));
		});
		// 留言推送
		wxMpConfig.sendMessageToWx("/wechat/replying/", "1", (wmtm) -> {
			wmtm.setToUser(opentId);
			wmtm.addData(new WxMpTemplateData("keyword1", "充值未到账", "#888888"))
				.addData(new WxMpTemplateData("keyword2", "iwanol", "#FF9800"))
				.addData(new WxMpTemplateData("keyword3", "4654685", "#FF9800"))
				.addData(new WxMpTemplateData("keyword4", DUtil.format("yyyy-MM-dd HH:mm:ss"), "#FF9800"));
		});
		// 留言反馈
		wxMpConfig.sendReplyMsgToWx("/wechat/replying/", "1", (wmtm) -> {
			wmtm.setToUser(opentId);
			wmtm.addData(new WxMpTemplateData("first", "你收到一条新的留言回复", "#888888"))
			.addData(new WxMpTemplateData("keyword1", "iwanol", "#173177"))
			.addData(new WxMpTemplateData("keyword2", DUtil.format("yyyy-MM-dd HH:mm:ss"), "#173177"))
			.addData(new WxMpTemplateData("keyword3", "您的反馈已受理！", "#FF0000"));
		});
	}
	
	public static void qrCodeCreate() {
		try {
			System.out.println(templateMsgService.getAllPrivateTemplate());
			WxMpQrCodeTicket ticket = qrcodeService.qrCodeCreateTmpTicket(1, 36000);
			System.out.println(ticket.getTicket());
			System.out.println(ticket.getUrl());
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}
	
}
