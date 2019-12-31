package com.cypay.merchant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cypay.common.entity.SystemSet;
import com.cypay.common.service.impl.SystemSetService;
import com.cypay.common.util.CommonUtil;

import cn.hutool.core.util.IdUtil;

@Controller
@RequestMapping(value = "mer")
public class HomeController {

	@Autowired
	private SystemSetService systemSetService;
	
	@Value("${wx.open.appid}")
	private String appid;
	
	@Value("${wx.open.redirect_uri}")
	private String redirect_uri;
	
	@ModelAttribute
	public void findWebInfo(Model model) {
		SystemSet webInfo = systemSetService.findWebInfo();
		model.addAttribute("webInfo", webInfo);
		model.addAttribute("qqNumbers", CommonUtil.getQQNumbers(webInfo.getServiceQQ()));
		model.addAttribute("fees", webInfo.getFees());
	}
	
	/**
	 * 登陆成功首页
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = {"index.spa"})
	public String spa(Model model, HttpServletRequest request) {
		model.addAttribute("domain", CommonUtil.getRequestDomain(request));
		return "spa/index";
	}
	
	/**
	 * 登陆页面
	 * 
	 * @return
	 */
	@GetMapping(value = {"/", "/login"})
	public String login(Model model, HttpServletRequest request) {
		String token = IdUtil.fastSimpleUUID();
		request.getSession().setAttribute("token", token);
		model.addAttribute("appid", appid);
		model.addAttribute("state", token);
		model.addAttribute("redirect_uri", redirect_uri);
		return "merchant/home/login";
	}

	/**
	 * 首页注册页面
	 * 
	 * @return
	 */
	@GetMapping(value = "/register")
	public String register(Model model, String uuid) {
		model.addAttribute("uuid", uuid);
		return "merchant/home/register";
	}

	/**
	 * 首页资费页面
	 * 
	 * @return
	 */
	@GetMapping(value = "/fee")
	public String fee() {
		return "merchant/home/fee";
	}

	/**
	 * 首页关于我们
	 * 
	 * @return
	 */
	@GetMapping(value = "/us")
	public String us() {
		return "merchant/home/us";
	}

}
