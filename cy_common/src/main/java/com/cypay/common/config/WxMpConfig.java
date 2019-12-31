package com.cypay.common.config;

import java.util.Map;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.impl.WxMpQrcodeServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpTemplateMsgServiceImpl;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;

@Component
@ConfigurationProperties(prefix = "wx.mp")
public class WxMpConfig {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/************** 主公众号：订单通知>>商户、留言成功通知>>商户 *******************/
	private String token;
	
	private String authUrl;
	
	private String appid;
	
	private String secret;
	
	private String msgTid;
	
	private String msgRemark;
	
	private String orderTid;
	
	private String orderRemark;
	
	private String replyTid;
	
	private String replyRemark;
	
	private Boolean isShare = false;
	
	private boolean mpUsable;
	
	private WxMpServiceImpl wxMpService;
	
	private WxMpQrcodeServiceImpl wxMpQrcodeService;
	
	private WxMpTemplateMsgServiceImpl wxMpTemplateMsgService;
	
	/** 子公众号：留言成功通知、留言回复通知>>玩家 */
	private SubWxMp subWxMp;
	
	private static AES aes;
	
	@PostConstruct
	public void init() {
		this.doInit();
		
		if (this.subWxMp == null) {
			subWxMp = new SubWxMp();
		}
		
		this.subWxMp.overridePropertyValue(this);
		if (!(this.mpUsable | this.subWxMp.isMpUsable())) {
			logger.warn("请完善公众号配置！！！");
		}
		
		if (this.mpUsable) {
			aes = SecureUtil.aes(this.secret.getBytes());
		} else {
			aes = SecureUtil.aes((this.isSubMpUsable() ? this.subWxMp.getSecret() : "AES").getBytes());
		}
	}
	
	/**
	 * 加密
	 * @param content
	 * @return
	 */
	public String encrypt(String content) {
		return Base64.encodeUrlSafe(aes.encrypt(content));
	}
	
	/**
	 * 解密
	 * @param content
	 * @return
	 */
	public String decrypt(String content) {
		return aes.decryptStr(Base64.decode(content));
	}
	
	/**
	 * 子公众号是否可用
	 * @return
	 */
	public boolean isSubMpUsable() {
		return this.subWxMp.isMpUsable();
	}
	
	public WxMpQrcodeServiceImpl getSubWxMpQrcodeService() {
		return this.subWxMp.getWxMpQrcodeService();
	}
	
	/**
	 * 发送订单模板消息
	 * @param consumer
	 * @return
	 */
	public boolean sendOrderToWx(String URI, String content, Consumer<WxMpTemplateMessage> consumer) {
		return sendTemplateMsgToWx(URI, content, this.orderTid, this.orderRemark, consumer);
	}
	
	/**
	 * 发送留言模板消息
	 * @param consumer
	 * @return
	 */
	public boolean sendMessageToWx(String URI, String content, Consumer<WxMpTemplateMessage> consumer) {
		return sendTemplateMsgToWx(URI, content, this.msgTid, this.msgRemark, consumer);
	}
	
	/**
	 * 子公众号->发送留言模板消息
	 * @param consumer
	 * @return
	 */
	public boolean sendMessageToSubWx(String URI, String content, Consumer<WxMpTemplateMessage> consumer) {
		return this.subWxMp.sendMessageToWx(URI, content, consumer);
	}
	
	/**
	 * 发送留言回复模板消息
	 * @param consumer
	 * @return
	 */
	public boolean sendReplyMsgToWx(String URI, String content, Consumer<WxMpTemplateMessage> consumer) {
		return sendTemplateMsgToWx(URI, content, this.replyTid, this.replyRemark, consumer);
	}
	
	/**
	 * 子公众号->发送留言回复模板消息
	 * @param consumer
	 * @return
	 */
	public boolean sendReplyMsgToSubWx(String URI, String content, Consumer<WxMpTemplateMessage> consumer) {
		return this.subWxMp.sendReplyMsgToWx(URI, content, consumer);
	}
	
	/**
	 * 构造oauth2授权的url连接.

	 * @param URI
	 * @param state
	 * @return
	 */
	public String oauth2buildAuthorizationUrl(String URI, String state) {
		if (this.mpUsable) {
			return this.wxMpService.oauth2buildAuthorizationUrl(this.authUrl + URI, "snsapi_userinfo", state);
		}
		
		return null;
	}
	
	public String xmlOutText(String content, Map<String, String> data) {
		WxMpXmlOutTextMessage outTextMsg = new WxMpXmlOutTextMessage();
		outTextMsg.setFromUserName(data.get("ToUserName"));
		outTextMsg.setToUserName(data.get("FromUserName"));
		outTextMsg.setCreateTime(System.currentTimeMillis());
		outTextMsg.setContent(content);
		return outTextMsg.toXml();
	}
	
	private boolean sendTemplateMsgToWx(String URI, String content, String templateId, String remark, Consumer<WxMpTemplateMessage> consumer) {
		if (this.mpUsable) {			
			WxMpTemplateMessage wmtm = new WxMpTemplateMessage();
			wmtm.setTemplateId(templateId);
			if (StrUtil.isNotBlank(URI)) {
				wmtm.setUrl(this.authUrl + URI + "/" + encrypt(content));
			}
			consumer.accept(wmtm);
			wmtm.addData(new WxMpTemplateData("remark", remark, "#00B066"));
			try {
				wxMpTemplateMsgService.sendTemplateMsg(wmtm);
				return true;
			} catch (WxErrorException e) {
				logger.info(e.getMessage());
			}
		} else {
			logger.info("【微信推送-失败】：请完善公众号配置！");
		}
		return false;
	}
	
	protected void doInit() {
		// 公众号配置是否可用
		mpUsable = StrUtil.isNotBlank(appid) && StrUtil.isNotBlank(secret);
		
		if (mpUsable) {
			this.wxMpService = new WxMpServiceImpl();
			WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
			
			configStorage.setAppId(appid);
			configStorage.setSecret(secret);
			this.wxMpService.setWxMpConfigStorage(configStorage);
			
			this.wxMpQrcodeService = new WxMpQrcodeServiceImpl(wxMpService);
			
			this.wxMpTemplateMsgService = new WxMpTemplateMsgServiceImpl(wxMpService);
		}
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getMsgTid() {
		return msgTid;
	}

	public void setMsgTid(String msgTid) {
		this.msgTid = msgTid;
	}

	public String getMsgRemark() {
		return msgRemark;
	}

	public void setMsgRemark(String msgRemark) {
		this.msgRemark = msgRemark;
	}

	public String getOrderTid() {
		return orderTid;
	}

	public void setOrderTid(String orderTid) {
		this.orderTid = orderTid;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public String getReplyTid() {
		return replyTid;
	}

	public void setReplyTid(String replyTid) {
		this.replyTid = replyTid;
	}

	public String getReplyRemark() {
		return replyRemark;
	}

	public void setReplyRemark(String replyRemark) {
		this.replyRemark = replyRemark;
	}

	public Boolean getIsShare() {
		return isShare;
	}

	public void setIsShare(Boolean isShare) {
		this.isShare = isShare;
	}

	public boolean isMpUsable() {
		return mpUsable;
	}

	public void setMpUsable(boolean mpUsable) {
		this.mpUsable = mpUsable;
	}

	public WxMpServiceImpl getWxMpService() {
		return wxMpService;
	}

	public void setWxMpService(WxMpServiceImpl wxMpService) {
		this.wxMpService = wxMpService;
	}

	public WxMpQrcodeServiceImpl getWxMpQrcodeService() {
		return wxMpQrcodeService;
	}

	public void setWxMpQrcodeService(WxMpQrcodeServiceImpl wxMpQrcodeService) {
		this.wxMpQrcodeService = wxMpQrcodeService;
	}

	public WxMpTemplateMsgServiceImpl getWxMpTemplateMsgService() {
		return wxMpTemplateMsgService;
	}

	public void setWxMpTemplateMsgService(WxMpTemplateMsgServiceImpl wxMpTemplateMsgService) {
		this.wxMpTemplateMsgService = wxMpTemplateMsgService;
	}

	public SubWxMp getSubWxMp() {
		return subWxMp;
	}

	public void setSubWxMp(SubWxMp subWxMp) {
		this.subWxMp = subWxMp;
	}

	public static class SubWxMp extends WxMpConfig {
		
		public void overridePropertyValue (WxMpConfig superConfig) {
			this.setAuthUrl(superConfig.authUrl);
			
			if (superConfig.isShare) {
				if (StrUtil.isBlank(this.getAppid())) {
					this.setAppid(superConfig.appid);
				}
				
				if (StrUtil.isBlank(this.getSecret())) {
					this.setSecret(superConfig.secret);
				}
				
				if (StrUtil.isBlank(this.getMsgTid())) {
					this.setMsgTid(superConfig.msgTid);
				}
				
				if (StrUtil.isBlank(this.getMsgRemark())) {
					this.setMsgRemark(superConfig.msgRemark);
				}
				
				if (StrUtil.isBlank(this.getOrderTid())) {
					this.setOrderTid(superConfig.orderTid);
				}
				
				if (StrUtil.isBlank(this.getOrderRemark())) {
					this.setOrderRemark(superConfig.orderRemark);
				}
				
				if (StrUtil.isBlank(this.getReplyTid())) {
					this.setReplyTid(superConfig.replyTid);
				}
				
				if (StrUtil.isBlank(this.getReplyRemark())) {
					this.setReplyRemark(superConfig.replyRemark);
				}
				
				this.setMpUsable(superConfig.mpUsable);
				this.setWxMpQrcodeService(superConfig.wxMpQrcodeService);
				this.setWxMpTemplateMsgService(superConfig.wxMpTemplateMsgService);
			} else {				
				this.doInit();
			}
		}
		
	}
}
