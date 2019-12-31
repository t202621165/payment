package com.cypay.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cypay.common.config.WxMpConfig;
import com.cypay.common.entity.Message;
import com.cypay.common.service.impl.MessageService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.Result;

@Controller
@RequestMapping("/mer")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private WxMpConfig wxMpConfig;
	
	/**
	 * 留言箱
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/message.html")
	public String message(Model model) {
		model.addAttribute("mpUsable", wxMpConfig.isMpUsable());
		model.addAttribute("authUrl", wxMpConfig.getAuthUrl());
		return "merchant/index/message";
	}
	
	/**
	 * 获取所有留言
	 * @param m
	 * @param pageData
	 * @return
	 */
	@PostMapping(value = "/message/list")
	public @ResponseBody Page<?> list(Message m, PageData pageData) {
		m.setMerchant(ShiroManager.getMerchant());
		Page<Message> page = messageService.findAll(m, pageData);
		page.getContent().parallelStream().forEach(message -> {
			message.setMsgId(wxMpConfig.encrypt(message.getId().toString()));
		});
		return page;
	}
	
	/**
	 * 删除玩家留言
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/message/delete")
	public @ResponseBody Result delete(@RequestParam(value = "id", required = true) Long id) {
		return messageService.deleteByIdAndMerchant(id, ShiroManager.getMerchant());
	}
	
	/**
	 * 批量删除留言
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/message/batch_delete")
	public @ResponseBody Result batchDelete(Long[] ids) {
		return messageService.batchDelete(ids, ShiroManager.getMerchant());
	}
	
	/**
	 * 更新留言状态
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/message/state")
	public @ResponseBody Result state(@RequestParam(value = "id", required = true) Long id) {
		return messageService.updateMessageState(id, ShiroManager.getMerchant());
	}
	
}
