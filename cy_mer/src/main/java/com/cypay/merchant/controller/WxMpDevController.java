package com.cypay.merchant.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.thymeleaf.util.ListUtils;

import com.cypay.common.config.WxMpConfig;
import com.cypay.common.entity.Message;
import com.cypay.common.entity.MessageRecord;
import com.cypay.common.entity.Order;
import com.cypay.common.service.impl.MessageService;
import com.cypay.common.service.impl.OrderService;
import com.cypay.common.service.impl.WechatInfoService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.DUtil;
import com.cypay.common.util.XMLUtil;
import com.cypay.common.vo.Result;
import com.cypay.merchant.aop.MerchantLogs;
import com.google.common.collect.Lists;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * 微信公众号开发控制器
 * @author International
 *
 */
@Controller
public class WxMpDevController {

	@Autowired
	private WxMpConfig wxMpConfig;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private WechatInfoService wechatInfoService;
	
	/***/
	@RequestMapping("/wechat/authorize_token")
	public @ResponseBody String authorizeToken(HttpServletRequest request) {
		Map<String, String> data = XMLUtil.parseXml(request);
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		
		List<String> list = ListUtils.sort(Lists.newArrayList(wxMpConfig.getToken(), nonce, timestamp));
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		String signStr = list.stream().collect(Collectors.joining());
		if (SecureUtil.sha1(signStr).equals(signature)) {
			String result = wechatInfoService.eventProcess(data);
			return Optional.ofNullable(result).orElse(echostr);
		}
		return "FAILE";
	}
	

	/**
	 * 绑定微信账号
	 * @param code
	 * @param uuid
	 * @return
	 */
	@MerchantLogs(value = "绑定微信账号")
	@RequestMapping(value = "/wechat/bind")
	public String wechatBind(@RequestParam(value = "code") String code, @RequestParam(value = "state") String state, Model model) {
		wechatInfoService.wechatBind(code, state, model);
		return "merchant/account/wechat";
	}
	
	/**
	 * 微信端-查看订单详情
	 * @param orderNumber
	 * @param model
	 * @return
	 */
	@GetMapping("/wechat/order/{no}")
	public String orderDetail(@PathVariable(value = "no") String orderNumber, Model model) {
		try {			
			Order order = orderService.findDetail(wxMpConfig.decrypt(orderNumber));
			if (order == null) {
				model.addAttribute("isPresent", false);
				model.addAttribute("msg", "Invalid Order Number");
			} else {
				model.addAttribute("isPresent", true);
				model.addAttribute("order", order);
			}
		} catch (Exception e) {
			model.addAttribute("isPresent", false);
			model.addAttribute("msg", e.getMessage());
		}
		return "merchant/account/wxorder";
	}

	/**
	 * SSE服务推送-即时通信
	 * @param msgId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/wechat/conn")
	public @ResponseBody SseEmitter connect(@RequestParam(value = "msgId") String msgId, HttpServletRequest request) {
		return messageService.connect(msgId);
	}
	
	/**
	 * 微信端-留言回复窗口
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@GetMapping(value = {"/wechat/replying/{msgId}", "/wechat/leaving/{msgId}"})
	public String replying(@PathVariable(value = "msgId") String msgId, Model model, HttpServletRequest request) {
		boolean isReply = request.getRequestURI().indexOf("replying") != -1;
		try {			
			boolean isMicroMessenger = false;
			String userAgent = request.getHeader("user-agent");
			if (!StringUtils.isEmpty(userAgent)) {
				isMicroMessenger = userAgent.toLowerCase().indexOf("micromessenger") != -1;
			}
			
			Assert.isTrue(isMicroMessenger, "请在微信客户端打开链接");
			
			Long messageId = Long.valueOf(wxMpConfig.decrypt(msgId));
			Optional<Message> optional = messageService.findMessageRecodeById(messageId);
			
			return replying(isMicroMessenger, isReply, msgId, model, optional);
		} catch (Exception e) {
			model.addAttribute("msgId", msgId);
			model.addAttribute("errMsg", e.getMessage());
			model.addAttribute("isMicroMessenger", false);
			model.addAttribute("isReply", isReply);
			return "merchant/account/chat";
		}
		
	}
	
	/**
	 * 平台-留言回复窗口
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/mer/replying")
	public String replying(@RequestParam("id") Long id, Model model) {
		Optional<Message> optional = messageService.findByIdAndMerchant(id, ShiroManager.getMerchant());
		return replying(true, true, wxMpConfig.encrypt(id.toString()), model, optional);
	}
	
	/**
	 * 留言回复
	 * @param record
	 * @param msgId
	 * @return
	 */
	@PostMapping("/wechat/reply")
	public @ResponseBody Result reply(MessageRecord record, String msgId) {
		return messageService.saveMessageRecord(record, msgId);
	}
	
	private String replying(boolean isMicroMessenger, boolean isReply, String id, Model model, Optional<Message> optional) {
		messageService.clearMsgCache((isReply ? 1 : 0) + id);
		if (optional.isPresent()) {
			Message message = optional.get();
			if (isReply && !message.getState()) {
				messageService.updateMessageState(message.getId());
			}
			int lastMsgType = 0;
			List<MessageRecord> list = message.getReplies();
			if (CollUtil.isNotEmpty(list)) {						
				for (int i = 0; i < list.size(); i++) {
					MessageRecord record = list.get(i);
					Date date = i == 0 ? message.getLeaveDate() : list.get(i - 1).getRecordDate();
					if (DUtil.format(date, "yy-MM-dd HH:mm")
							.equals(DUtil.format(record.getRecordDate(),"yy-MM-dd HH:mm"))) {
						record.setIsSameTime(true);
					}
					lastMsgType = record.getType();
				}
			}
			model.addAttribute("isMsg", isReply ? lastMsgType == 0 : lastMsgType == 1);
			model.addAttribute("message", message);
		} else {
			isMicroMessenger = false;
			model.addAttribute("errMsg", "留言不存在或已被删除");
		}
		model.addAttribute("msgId", id);
		model.addAttribute("isMicroMessenger", isMicroMessenger);
		model.addAttribute("isReply", isReply);
		return "merchant/account/chat";
	}
}
