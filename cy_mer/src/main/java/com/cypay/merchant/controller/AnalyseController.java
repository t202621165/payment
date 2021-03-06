package com.cypay.merchant.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cypay.common.service.impl.AnalyseService;
import com.cypay.common.service.impl.MerchantService;
import com.cypay.common.service.impl.PartitionService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.DUtil;
import com.cypay.common.vo.OrderVo;
import com.cypay.common.vo.PartitionVo;

@Controller
@RequestMapping(value = "mer")
public class AnalyseController {
	
	@Autowired
	private AnalyseService analyseService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private PartitionService partitionService;
	
	/**
	 * 产品统计、时段统计页面
	 * @param model
	 * @param type
	 * @return
	 */
	@GetMapping(value = "/analyse/pay.html")
	public String pay(Model model, @RequestParam(value = "type", required = true) Integer type) {
		model.addAttribute("type", type);
		model.addAttribute("pattern", type==1?"yyyy-MM-dd HH:mm:ss":"yyyy-MM-dd 00:00:00");
		PartitionVo v = new PartitionVo(ShiroManager.getMerchant());
		v.setCreateDate(null);
		v.setUseDate(null);
		model.addAttribute("partition", partitionService.findAll(v));
		if (ShiroManager.hasRole("agency"))
			model.addAttribute("merchant", merchantService.findByParent(ShiroManager.getMerchant()));
		return "merchant/analyse/analyse1";
	}
	
	/**
	 * 日交易统计
	 * @param v
	 * @return
	 */
	@PostMapping(value = "/analyse/day")
	public @ResponseBody List<List<Object>> dayAnalye(OrderVo v) {
		v.setMerchant(ShiroManager.getMerchant());
		return analyseService.orderDayAnalye(v, 4);
	}
	
	/**
	 * 产品充值统计
	 * @param v
	 * @return
	 */
	@PostMapping(value = "/analyse/pay")
	public @ResponseBody List<List<Object>> productAnalye(OrderVo v) {
		if (v.getIsAgency() && ShiroManager.hasRole("agency")) {
			v.setAgent(ShiroManager.getMerchant());
		}else {
			v.setMerchant(ShiroManager.getMerchant());
		}
		List<Object[]> list = analyseService.analyse("product", v);
		List<List<Object>> productAnalye = new ArrayList<List<Object>>();
		for (int i = 0; i < 5; i++) {
			final int index = i;
			List<Object> o = new ArrayList<Object>();
			list.stream().forEach(obj -> {
				o.add(obj[index]);
			});
			productAnalye.add(o);
		}
		return productAnalye;
	}
	
	/**
	 * 分组、分区、充值排行统计页面
	 * @param model
	 * @param type
	 * @return
	 */
	@GetMapping(value = "/analyse/game.html")
	public String group(Model model, @RequestParam(value = "type", required = true) Integer type) {
		model.addAttribute("type", type);
		model.addAttribute("name", type==1?"所属分区":(type==2?"分组名称":"玩家账号"));
		if (ShiroManager.hasRole("agency"))
			model.addAttribute("merchant", merchantService.findByParent(ShiroManager.getMerchant()));
		
		if (type == 3) {
			PartitionVo v = new PartitionVo(ShiroManager.getMerchant());
			v.setCreateDate(null);
			v.setUseDate(null);
			model.addAttribute("partition", partitionService.findAll(v));
		}
		
		return "merchant/analyse/analyse2";
	}
	
	/**
	 * 时段统计
	 * @param v
	 * @return
	 */
	@PostMapping(value = "/analyse/hour")
	public @ResponseBody List<List<Object>> hourAnalye(OrderVo v) {
		v.setPayDate(DUtil.endOfDay(v.getOrderDate()));
		if (v.getIsAgency() && ShiroManager.hasRole("agency")) {
			v.setAgent(ShiroManager.getMerchant());
		}else {
			v.setMerchant(ShiroManager.getMerchant());
		}
		List<Object[]> list = analyseService.analyse("hour", v);
		List<List<Object>> productAnalye = new ArrayList<List<Object>>();
		for (int i = 0; i < 4; i++) {
			final int index = i;
			Object[] o = new Object[24];
			list.stream().forEach(obj -> {
				o[(int) obj[4]] = obj[index];
			});
			for (int j = 0; j < o.length; j++) {
				if (o[j] == null) {
					o[j] = 0;
				}
			}
			productAnalye.add(Arrays.asList(o));
		}
		
		productAnalye.add(CommonUtil.getNumberArray(24));
		return productAnalye;
	}
	
	/**
	 * ips统计页面
	 * @return
	 */
	@GetMapping(value = "/analyse/ips.html")
	public String ips() {
		return "merchant/analyse/ips";
	}
	
	@PostMapping(value = "/analyse/list")
	public @ResponseBody List<List<Object>> rankAnalye(OrderVo v, String mark) {
		if (v.getIsAgency() && ShiroManager.hasRole("agency")) {
			v.setAgent(ShiroManager.getMerchant());
		}else {
			v.setMerchant(ShiroManager.getMerchant());
		}
		return analyseService.orderRankRateAnalye(mark, v);
	}
}
