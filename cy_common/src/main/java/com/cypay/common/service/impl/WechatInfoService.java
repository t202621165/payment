package com.cypay.common.service.impl;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cypay.common.config.WxMpConfig;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Message;
import com.cypay.common.entity.MessageRecord;
import com.cypay.common.entity.Order;
import com.cypay.common.entity.WechatInfo;
import com.cypay.common.pattern.template.payee.wechat.WechatAuthorize;
import com.cypay.common.repository.impl.MerchantRepository;
import com.cypay.common.repository.impl.MessageRepository;
import com.cypay.common.repository.impl.WechatInfoRepository;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.DUtil;
import com.cypay.common.util.QRCodeUtil;
import com.cypay.common.vo.Result;
import com.google.common.collect.Maps;

import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

@Service
public class WechatInfoService extends BaseServiceImpl<WechatInfoRepository, WechatInfo, WechatInfo> {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MerchantRepository merchantRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private WxMpConfig wxMpConfig;
	
	/**
	 * 微信开放平台-appid
	 */
	@Value("${wx.open.appid}")
	private String appid;
	
	/**
	 * 微信开放平台-appsecret
	 */
	@Value("${wx.open.secret}")
	private String secret;
	
	// 事件处理器
	private static Map<String, Function<Map<String, String>, String>> eventProcessor = Maps.newHashMap();
	
	@PostConstruct
	public void init() {
		// 公众号订阅(关注)事件
		eventProcessor.put("subscribe", (data) -> {
			String eventKey = data.get("EventKey");
			if (!StringUtils.isEmpty(eventKey)) {
				eventKey = eventKey.replace("qrscene_", "");
				data.put("EventKey", eventKey);
				return eventProcessor.get("SCAN").apply(data);
			}
			return null;
		});
		
		// 扫描带参数二维码事件(已关注公众号)
		eventProcessor.put("SCAN", (data) -> {
			String eventKey = data.get("EventKey");
			String openid = data.get("FromUserName");
			try {
				if (wxMpConfig.isSubMpUsable()) {
					Optional<Message> optional = messageRepository.findById(Long.valueOf(eventKey));
					if (optional.isPresent()) {
						Message message = optional.get();
						if (!message.getIsSubscribe()) {
							Consumer<WxMpTemplateMessage> consumer = sendMessageToWx(message, openid);
							boolean result = wxMpConfig.sendMessageToSubWx("/wechat/leaving", message.getId().toString(), consumer);
							if (result) {
								// 将留言设置为已订阅状态
								messageRepository.updateSubscribeAndOpenid(message.getId(), openid);
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return null;
		});
	}
	
	@Override
	public boolean isExist(WechatInfo t) {
		Optional<WechatInfo> optional = baseRepository.findByOpenid(t.getOpenid());
		return optional.isPresent();
	}
	
	/**
	 * 微信登陆
	 * @param code
	 * @param state
	 */
	public Result wechatLogin(String code) {
		JSONObject json = getAuthorizeInfo(code, appid, secret);
		String unionid = json.getString("unionid");
		Optional<WechatInfo> optional = baseRepository.findByUnionid(unionid);
		if (!optional.isPresent()) {
			return Result.error("微信登录失败，未绑定平台账号，请登录到平台手动绑定！");
		}
		
		Optional<Merchant> merchant = merchantRepository.findById(optional.get().getId());
		if (!merchant.isPresent()) {
			return Result.error("账户不存在或已被删除！");
		}
		
		ShiroManager.login(merchant.get().setEncrypt(false));
		return Result.success();
	}
	
	/**
	 * 生成微信网页授权二维码
	 * @param request
	 * @param response
	 */
	public void createWechatQRCode(HttpServletRequest request, HttpServletResponse response) {
		if (wxMpConfig.isMpUsable()) {
			String qrcodeUrl = wxMpConfig.oauth2buildAuthorizationUrl("/wechat/bind", ShiroManager.getMerchant().getAccount());
			QRCodeUtil.createQRCode(qrcodeUrl, response);
		}
	}
	
	/**
	 * 微信网页授权成功绑定账号
	 * @param code
	 * @param uuid
	 * @param model
	 */
	public void wechatBind(String code, String account, Model model) {
		boolean state = false;
		String content = "账号【"+account+"】绑定成功！";
		WechatInfo wi = baseRepository.findByMerchantAccount(account);
		// 判断是否已绑定微信账号
		if (wi != null && wi.getId() == null) {
			try {
				// 用code换取oauth2的access token
				WxMpOAuth2AccessToken oAuth2AccessToken = wxMpConfig.getWxMpService().oauth2getAccessToken(code);
				// 用oauth2获取用户信息
				WxMpUser wxMpUser = wxMpConfig.getWxMpService().oauth2getUserInfo(oAuth2AccessToken, "zh_CN");
				WechatInfo wechatInfo = new WechatInfo();
				wechatInfo.setMerchantId(wi.getMerchantId());
				wechatInfo.setAccessToken(oAuth2AccessToken.getAccessToken());
				wechatInfo.setExpiresIn(oAuth2AccessToken.getExpiresIn());
				wechatInfo.setRefreshToken(oAuth2AccessToken.getRefreshToken());
				
				wechatInfo.setNickname(wxMpUser.getNickname());
				wechatInfo.setSex(wxMpUser.getSex() == 1);
				wechatInfo.setCountry(wxMpUser.getCountry());
				wechatInfo.setProvince(wxMpUser.getProvince());
				wechatInfo.setCity(wxMpUser.getCity());
				wechatInfo.setHeadimgurl(wxMpUser.getHeadImgUrl());
				wechatInfo.setOpenid(wxMpUser.getOpenId());
				wechatInfo.setUnionid(Optional.ofNullable(wxMpUser.getUnionId()).orElse(""));
				Result result = save(wechatInfo);
				if (!result.getState()) {
					content = "绑定失败，当前微信已绑定其它账号";
				}
				state = result.getState();
			} catch (Exception e) {
				e.printStackTrace();
				content = e.getMessage();
			}
		} else {
			content = "请勿重复绑定！";
		}
		model.addAttribute("content", content);
		model.addAttribute("state", state);
	}

	public WechatInfo findByMerchantId(Long merchantId) {
		return baseRepository.findByMerchantId(merchantId);
	}

	/**
	 * 微信公众号事件处理
	 * @param data
	 */
	public String eventProcess(Map<String, String> data) {
		if (eventProcessor.containsKey(data.get("Event"))) {
			// 获取事件处理器处理相关事件
			return eventProcessor.get(data.get("Event")).apply(data);
		}
		return null;
	}
	
	/**
	 * 留言推送到商户微信
	 * @param message
	 */
	@EventListener
	public void sendMessageToWx(Message message) {
		if (wxMpConfig.isMpUsable()) {			
			String openid = resolveOpenid(message.getMerchant().getId(), true);
			if (!StringUtils.isEmpty(openid)) {
				Consumer<WxMpTemplateMessage> consumer = sendMessageToWx(message, openid);
				wxMpConfig.sendMessageToWx("/wechat/replying", message.getId().toString(), consumer);
			}
		}
	}
	
	/**
	 * 留言回复推送到微信
	 * @param message
	 */
	@EventListener
	public void sendReplyMsgToWx(MessageRecord record) {
		Long msgId = record.getMessage().getId();
		Optional<Message> optional = messageRepository.findById(msgId);
		if (optional.isPresent()) {
			Message message = optional.get();
			if (record.getType() == 1) {
				Consumer<WxMpTemplateMessage> consumer = sendReplyMsgToWx(record, message.getOpenid(), "游戏管理");
				wxMpConfig.sendReplyMsgToSubWx("/wechat/leaving", message.getId().toString(), consumer);
			} else {
				String openid = resolveOpenid(message.getMerchant().getId(), true);
				if (!StringUtils.isEmpty(openid)) {					
					Consumer<WxMpTemplateMessage> consumer = sendReplyMsgToWx(record, openid, message.getAccount());
					wxMpConfig.sendReplyMsgToWx("/wechat/replying", message.getId().toString(), consumer);
				}
			}
		}
	}
	
	/**
	 * 订单推送到微信
	 * @param order
	 */
	@EventListener
	public void sendOrderToWx(Order order) {
		if (wxMpConfig.isMpUsable()) {
			String openid = resolveOpenid(order.getMerchant().getId(), false);
			if (!StringUtils.isEmpty(openid)) {
				logger.info("【订单推送】：order_number = {}", order.getOrderNumber());
				wxMpConfig.sendOrderToWx("/wechat/order", order.getOrderNumber(), (wmtm) -> {
					boolean isSuccess = order.getState() == 1;
					wmtm.setToUser(openid);
					wmtm.addData(new WxMpTemplateData("keyword1", DUtil.format(order.getOrderDate(), "yyyy-MM-dd HH:mm:ss"), "#173177"))
						.addData(new WxMpTemplateData("keyword2", String.format("%.2f", order.getAmount()), "#173177"))
						.addData(new WxMpTemplateData("keyword3", order.getPlayerAccount(), "#173177"))
						.addData(new WxMpTemplateData("keyword4", isSuccess ? "成　功" : "等待发送", isSuccess ? "#008000" : "#0000ff"));
				});
			}
		}
	}
	
	private String resolveOpenid(Long merchantId, boolean isMsg) {
		Optional<Merchant> optional = merchantRepository.findById(merchantId);
		if (optional.isPresent() && (isMsg ? optional.get().getMessageToWx() : optional.get().getOrderToWx())) {
			WechatInfo info = baseRepository.findByMerchantId(merchantId);
			return info == null ? null : info.getOpenid();
		}
		
		return null;
	}
	
	private Consumer<WxMpTemplateMessage> sendMessageToWx(Message message, String openid) {
		logger.info("【留言推送】：msg_id = {}", message.getId());
		String qq = message.getQq();
		if (StringUtils.isEmpty(qq)) {
			qq = StringUtils.isEmpty(message.getPhone()) ? "--" : message.getPhone();
			message.setQq(qq);
		} else {
			message.setQq("QQ：" + qq);
		}
		return (wmtm) -> {
			wmtm.setToUser(openid);
			wmtm.addData(new WxMpTemplateData("keyword1", message.getContent(), "#888888"))
				.addData(new WxMpTemplateData("keyword2", message.getAccount(), "#FF9800"))
				.addData(new WxMpTemplateData("keyword3", message.getQq(), "#FF9800"))
				.addData(new WxMpTemplateData("keyword4", DUtil.format(message.getLeaveDate(), "yyyy-MM-dd HH:mm:ss"), "#FF9800"));
		};
	}
	
	/**
	 * 获取微信授权信息
	 * 		access_token和openid
	 * @param code
	 * @return
	 */
	private JSONObject getAuthorizeInfo(String code, String appid, String secret) {
		// 获取授权access_token和openid
		String url = String.format(WechatAuthorize.ACCESS_TOKEN_URL, appid, secret, code);
		logger.info("ACCESS_TOKEN_URL: " + url);
		JSONObject result = JSON.parseObject(restTemplate.getForObject(url, String.class));
		logger.info("ACCESS_TOKEN: " + result);
		return result;
	}
	
	
	private Consumer<WxMpTemplateMessage> sendReplyMsgToWx(MessageRecord record, String openid, String byUser) {
		return (wmtm) -> {
			wmtm.setToUser(openid);
			wmtm.addData(new WxMpTemplateData("first", "收到一条新的留言回复", "#888888"))
				.addData(new WxMpTemplateData("keyword1", byUser, "#173177"))
				.addData(new WxMpTemplateData("keyword2", DUtil.format(record.getRecordDate(), "yyyy-MM-dd HH:mm:ss"), "#173177"))
				.addData(new WxMpTemplateData("keyword3", "点击查看详情", "#FF0000"));
		};
	}
	
}
