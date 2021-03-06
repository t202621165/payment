package com.cypay.merchant.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cypay.common.entity.Merchant;
import com.cypay.common.service.impl.MerchantService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.MD5Util;
import com.cypay.common.util.RegExpUtil;
import com.cypay.common.vo.Result;
import com.cypay.merchant.aop.MerchantLogs;

import cn.hutool.core.util.StrUtil;

@Controller
@RequestMapping(value = "mer")
public class LoginRegistController {

	@Autowired
	private MerchantService merchantService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/code")
	public void getCode(HttpServletRequest request, HttpServletResponse response) {
		try {
			int width = 200;
			int height = 69;
			BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			// 生成对应宽高的初始图片
			String randomCode = CommonUtil.drawRandomCode(width, height, verifyImg);
			ShiroManager.setValue2Session("randomCode", randomCode);
			response.setContentType("image/png");// 必须设置响应内容类型为图片，否则前台不识别
			OutputStream os = response.getOutputStream(); // 获取文件输出流
			ImageIO.write(verifyImg, "png", os);// 输出图片流
			os.flush();
			os.close();// 关闭流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 商户注册
	 * 
	 * @param merchant
	 * @return
	 */
	@PostMapping("/register")
	public @ResponseBody Result reg(@Valid Merchant merchant) {
		if (!Pattern.matches(RegExpUtil.PWD, merchant.getPassword())) {
			return Result.error(RegExpUtil.PWD_ERROR_MESSAGE, "password");
		}
		return merchantService.register(merchant);
	}

	/**
	 * 商户登陆验证
	 * 
	 * @param merchant
	 * @return
	 */
	@MerchantLogs(value = "商户登录！", isLogin = true)
	@PostMapping(value = "/login")
	public @ResponseBody Result login(String account, String password, String code, HttpServletRequest request) {
		try {
			return login(new Merchant(account, password), code, request);
		} catch (Exception e) {
			return Result.error(e.getMessage());
		}
	}
	
	@GetMapping("/sign_in")
	public String signIn(Model model) {
		return "merchant/home/signin";
	}
	
	@GetMapping(value = "/signin")
	public String loginAjax(Merchant merchant, String code, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		try {
			Result result = login(merchant, code, request);
			Assert.isTrue(result.getState(), result.getMsg());
			return "redirect:/mer/index";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("account", merchant.getAccount());
			redirectAttributes.addFlashAttribute("password", merchant.getPassword());
			redirectAttributes.addFlashAttribute("msg", e.getMessage());
			return "redirect:/mer/sign_in";
		}
	}

	/**
	 * 登陆成功首页
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "index", "/index.html" })
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("domain", CommonUtil.getRequestDomain(request));
		model.addAllAttributes(merchantService.findHomePageData());
		return "merchant/index/index";
	}
	
	@PostMapping(value = "/homedata")
	public @ResponseBody Map<String, Object> getHomeData() {
		return merchantService.findHomePageData();
	}

	/**
	 * 总管理后台登录商户
	 * 
	 * @param id
	 * @param sign
	 * @param response
	 * @throws IOException
	 */
	@MerchantLogs(value = "管理员登录")
	@GetMapping("/tomerchant")
	public @ResponseBody Result go(@RequestParam(value = "id") Long id, @RequestParam(value = "sign") String sign,
			HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("GBK");
		Merchant merchant = merchantService.findById(id);
		if (merchant == null) {
			return Result.error("商户不存在或者已删除");
		}
		if (MD5Util.verify(
				String.format("%s@%s", id,
						merchant.getFinalDate() == null ? "1546272000000" : merchant.getFinalDate().getTime()),
				sign, "", "UTF-8")) {
			ShiroManager.login(merchant.setEncrypt(false));
			response.sendRedirect("/mer/index.html");
			return Result.success("登录成功！");
		} else {
			return Result.error("拒绝登陆");
		}
	}

	/**
	 * 退出登陆
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/logout")
	public String logout(Model model) {
		ShiroManager.logout();
		return "redirect:/mer/login";
	}

	private Result login(Merchant merchant, String code, HttpServletRequest request) {
		String randomCode = String.valueOf(ShiroManager.getValueBySession("randomCode"));
		
		Assert.isTrue(randomCode.equalsIgnoreCase(code), "验证码校验失败");
		
		Assert.hasLength(merchant.getAccount(), "用户名不能为空");
		
		Assert.hasLength(merchant.getPassword(), "请输入登陆密码");
		
		merchant = ShiroManager.login(merchant);
		String clientIp = CommonUtil.getIpAddr(request);
		if (StrUtil.isNotBlank(merchant.getAuthorizeIp())) {
			String[] ips = merchant.getAuthorizeIp().split(",");
			int index = Arrays.asList(ips).indexOf(clientIp);
			if (index == -1) {
				ShiroManager.logout();
				return Result.error("登录失败，当前IP已被限制登录！");
			}
		}
		
		logger.info("【登录】：{account: {}, IP: {}, Host: {}}", merchant.getAccount(), clientIp, request.getServerName());
		return Result.success("登陆成功！");
	}
}
