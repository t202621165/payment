package com.cypay.merchant.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cypay.common.entity.Bank;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.MerchantLog;
import com.cypay.common.service.impl.BankService;
import com.cypay.common.service.impl.MerchantLogService;
import com.cypay.common.service.impl.MerchantProductService;
import com.cypay.common.service.impl.MerchantService;
import com.cypay.common.service.impl.SettleMentService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.MerchantProductVo;
import com.cypay.common.vo.MerchantVo;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.SettleMentVo;
import com.cypay.merchant.aop.MerchantLogs;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;

@Controller
@RequestMapping(value = "mer")
public class AccountController {
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private MerchantService merchantService;
	
//	@Autowired
//	private OrderService orderService;
	
	@Autowired
	private SettleMentService settleMentService;
	
	@Autowired
	private MerchantLogService merchantLogService;
	
	@Autowired
	private MerchantProductService merchantProductService;
	
	/**
	 * 商户资料页面
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/profile.html")
	public String profile(Model model) {
		model.addAllAttributes(merchantService.getLoginInfo());
		return "merchant/account/profile";
	}
	
	/**
	 * 获取当前商户信息
	 * @return
	 */
	@PostMapping(value = "/profile")
	public @ResponseBody Merchant profile() {
		Merchant merchant = ShiroManager.getMerchant();
		Merchant m = new Merchant();
		m.setNickname(merchant.getNickname());
		m.setAccount(merchant.getAccount());
		m.setQqNumber(merchant.getQqNumber());
		m.setPhoneNumber(merchant.getPhoneNumber());
		m.setServiceQQ(merchant.getServiceQQ());
		m.setServicePhone(merchant.getServicePhone());
		return m;
	}
	
	/**
	 * 获取当前商户信息
	 * @return
	 */
	@PostMapping(value = "/profiles")
	public @ResponseBody Map<String, Object> loginInfo() {
		return merchantService.getLoginInfo();
	}
	
	/**
	 * 提现页面
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/takemoney.html")
	public String takeMoney(Model model) {
		Merchant merchant = ShiroManager.getMerchant();
		Bank bank = bankService.findByMerchant(merchant);
		if (bank == null) {
			bank = new Bank();
		}
		// T1商户获取当天利润
//		if (merchant.getSettlementType() == 1) {
//			// 当天利润 = 冻结金额
//			BigDecimal frozen = orderService.getTodayOrderMerchantProfit(merchant);
//			if (frozen != null && frozen.compareTo(BigDecimal.ZERO) > 0) {
//				bank.setFrozen(frozen);
//			}
//		}
		model.addAttribute("bank", bank.replace());
		return "merchant/account/takemoney";
	}
	
	/**
	 * 提现纪录
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/takerecord.html")
	public String takeRecord(Model model) {
		return "merchant/account/takerecord";
	}
	
	/**
	 * 申请提现
	 * @param amount
	 * @return
	 */
	@MerchantLogs(value = "【提现申请】")
	@PostMapping(value = "/takemoney")
	public @ResponseBody Result takeMoney(@RequestParam(value = "amount", required = true) BigDecimal amount) {
		return bankService.updateOverMoney(amount);
	}
	
	/**
	 * 提现记录
	 * @param pageData
	 * @param v
	 * @return
	 */
	@PostMapping(value = "/take/list")
	public @ResponseBody Page<?> takeRecord(PageData pageData, SettleMentVo v) {
		v.setMerchantId(ShiroManager.getMerchant().getId());
		return settleMentService.findVoPageList(v, pageData);
	}
	
	/**
	 * 结算比例
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/rate.html")
	public String rate(Model model) {
		List<MerchantProductVo> products = merchantProductService.findAllByMerchant(ShiroManager.getMerchant());
		Map<Integer, List<MerchantProductVo>> map = products.stream().collect(Collectors.groupingBy(MerchantProductVo::getpType));
		if (MapUtil.isNotEmpty(map)) {
			List<MerchantProductVo> type0 = map.get(0);
			List<MerchantProductVo> type1 = map.get(1);
			if (CollUtil.isNotEmpty(type1)) {
				MerchantProductVo mp = type1.get(0);
				mp.setProductName("网银支付");
				if (CollUtil.isNotEmpty(type0)) {
					type0.add(mp);
					model.addAttribute("products", type0);
				} else {
					model.addAttribute("products", Arrays.asList(mp));
				}
			}
		}
		return "merchant/account/rate";
	}
	
	/**
	 * 商户开关
	 * @param type
	 * @return
	 */
	@PostMapping(value = "/switch")
	public @ResponseBody Result serviceState(@RequestParam(value = "type") Integer type) {
		return merchantService.updateState(type);
	}
	
	/**
	 * 商户资料编辑
	 * @param m
	 * @return
	 */
	@MerchantLogs(value = "商户资料编辑")
	@PostMapping(value = "/profile/edit")
	public @ResponseBody Result edit(@Valid Merchant m) {
		return merchantService.save(m);
	}
	
	/**
	 * 编辑客服信息
	 * @param m
	 * @return
	 */
	@PostMapping(value = "/profile/service-info")
	public @ResponseBody Result service(String[] serviceQQ, 
			@RequestParam(value="servicePhone") String servicePhone) {
		String qqNumbers = "";
		if (serviceQQ != null) {
			qqNumbers = Arrays.asList(serviceQQ).toString();
		}
		return merchantService.updateServiceInfo(qqNumbers, servicePhone);
	}
	
	/**
	 * 商户修改密码
	 * @param m
	 * @return
	 */
	@MerchantLogs(value = "修改密码")
	@PostMapping(value = "/profile/password")
	public @ResponseBody Result passowrd(MerchantVo v) {
		return merchantService.updatePassword(v);
	}
	
	/**
	 * 商户绑定结算银行
	 * @param bank
	 * @return
	 */
	@PostMapping(value = "/bind_bank")
	public @ResponseBody Object bank(Bank bank) {
		return bankService.saveBank(bank);
	}
	
	/**
	 * 商户更换授权IP
	 * @param bank
	 * @return
	 */
	@MerchantLogs(value = "修改授权IP")
	@PostMapping(value = "/authorize_ip")
	public @ResponseBody Result addAuthorizeIp(@RequestParam(value = "ips", defaultValue = "") String ips) {
		return merchantService.updateAuthorizeIp(ips);
	}
	
	/**
	 * 商户更换通讯密钥
	 * @param bank
	 * @return
	 */
	@MerchantLogs(value = "更换通讯密钥")
	@PostMapping(value = "/change_key")
	public @ResponseBody Result changeKey() {
		return merchantService.updateSecretKey();
	}

	/**
	 * 用户日志
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/log.html")
	public String log(Model model) {
		return "merchant/account/log";
	}
	
	/**
	 * 日志列表
	 * @param pageData
	 * @param v
	 * @return
	 */
	@PostMapping(value = "/log/list")
	public @ResponseBody Page<?> logList(PageData pageData, MerchantLog v) {
		v.setMerchant(ShiroManager.getMerchant());
		return merchantLogService.findVoPageList(v, pageData);
	}
	
	/**
	 * 日志清除
	 * @param pageData
	 * @param v
	 * @return
	 */
	@MerchantLogs(value = "日志清除")
	@PostMapping(value = "/log/clean")
	public @ResponseBody Result clean() {
		return merchantLogService.deleteLog();
	}
}
