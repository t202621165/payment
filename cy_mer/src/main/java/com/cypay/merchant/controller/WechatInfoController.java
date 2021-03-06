package com.cypay.merchant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.WechatInfo;
import com.cypay.common.service.impl.WechatInfoService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.vo.Result;

@Controller
@RequestMapping(value = "mer")
public class WechatInfoController {
	
	@Autowired
	private WechatInfoService wechatInfoService;
	
	/**
	 * 微信登录
	 * @return
	 */
	@RequestMapping("/wechat-login")
	public String wechatLogin(Model model, @RequestParam(value = "code") String code, @RequestParam(value = "state") String state, HttpServletRequest request) {
		Object token = request.getSession().getAttribute("token");
		if (state.equals(token)) {
			Result result = wechatInfoService.wechatLogin(code);
			model.addAttribute("msg", result.getMsg());
			if (result.getState()) {
				return "forward:/mer/index";
			}
		} else {
			model.addAttribute("msg", "无效的Token");
		}
		return "manage/line";
	}
	
	/**
	 * 生成微信账号绑定二维码
	 * @param qrcodeUrl
	 * @param response
	 */
	@GetMapping(value = "/qrcode-wechat")
	public void qrcode(HttpServletRequest request, HttpServletResponse response) {
		wechatInfoService.createWechatQRCode(request, response);
	}
	
	@PostMapping(value = "/wechatInfo")
	public @ResponseBody Boolean wechatInfo() {
		Merchant merchant = ShiroManager.getMerchant();
		WechatInfo wechatInfo = wechatInfoService.findByMerchantId(merchant.getId());
		if (wechatInfo != null) {
			merchant.setWechatInfo(wechatInfo);
			merchant.setIsWxBind(true);
			return true;
		}
		return false;
	}
}
