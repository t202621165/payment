package com.cypay.merchant.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Rank;
import com.cypay.common.service.impl.MerchantService;
import com.cypay.common.service.impl.OrderService;
import com.cypay.common.service.impl.RankRateService;
import com.cypay.common.service.impl.RankService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.PageData;
import com.cypay.common.util.RegExpUtil;
import com.cypay.common.vo.MerchantVo;
import com.cypay.common.vo.OrderVo;
import com.cypay.common.vo.RankVo;
import com.cypay.common.vo.Result;
import com.cypay.merchant.aop.MerchantLogs;

import cn.hutool.core.collection.CollUtil;

@Controller
@RequiresRoles({"agency"})
@RequestMapping(value = "mer/agent")
public class AgentController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RankService rankService;
	
	@Autowired
	private RankRateService rankRateService;
	
	@Autowired
	private MerchantService merchantService;
	
	@GetMapping(value = "/agent.html")
	public String agent(Model model) {
		model.addAttribute("ranks", rankService.findAllByMerchant(ShiroManager.getMerchant()));
		return "merchant/agent/agent";
	}
	
	@GetMapping(value = "/order.html")
	public String order(Model model) {
		model.addAttribute("merchant", merchantService.findByParent(ShiroManager.getMerchant()));
		return "merchant/agent/order";
	}
	
	@GetMapping(value = "/group.html")
	public String group() {
		return "merchant/agent/group";
	}

	@PostMapping(value = "/list")
	public @ResponseBody Page<MerchantVo> list(MerchantVo v, PageData pageData) {
		v.setParent(ShiroManager.getPrincipal(Merchant.class));
		return merchantService.findVoPageList(v, pageData);
	}

	/**
	 * 添加下属商户
	 * @param merchant
	 * @return
	 */
	@MerchantLogs(value = "【代理】添加下属商户！")
	@PostMapping(value = "/merchant/add")
	public @ResponseBody Result merchantAdd(@Valid Merchant merchant) {
		if (!Pattern.matches(RegExpUtil.PWD, merchant.getPassword())) {
			return Result.error(RegExpUtil.PWD_ERROR_MESSAGE, "password");
		}
		return merchantService.saveAgent(merchant);
	}
	
	@PostMapping(value = "/merchant/state")
	public @ResponseBody Result merchantState(@RequestParam(value = "id") Long id) {
		return merchantService.updateAgentState(id, ShiroManager.getMerchant().getId());
	}
	
	/**
	 * 修改下属商户比率组
	 * @param merchant
	 * @return
	 */
	@PostMapping(value = "/merchant/rank")
	public @ResponseBody Result merchantRank(Merchant merchant) {
		return merchantService.updateAgentRank(merchant);
	}
	
	/**
	 * 删除下属商户
	 * @param id
	 * @return
	 */
	@MerchantLogs(value = "【代理】删除下属商户！")
	@PostMapping(value = "/merchant/delete")
	public @ResponseBody Result merchantDelete(@RequestParam(value = "id") Long id) {
		return merchantService.deleteByIdAndParentId(id);
	}
	
	@PostMapping(value = "/group/list")
	public @ResponseBody Page<RankVo> groupList(RankVo v, PageData pageData) {
		return new PageImpl<>(rankService.findAllByMerchant(ShiroManager.getMerchant()));
	}
	
	@PostMapping(value = "/group/merge")
	public @ResponseBody Result groupMerge(Rank rank) {
		return rankService.saveWithRate(rank);
	}
	
	@PostMapping(value = "/group/default")
	public @ResponseBody Result groupDefault(@RequestParam(value = "id", required = true) Long id) {
		return rankService.updateIsDefault(id, ShiroManager.getMerchant().getId());
	}
	
	@PostMapping(value = "/group/delete")
	public @ResponseBody Result groupDelete(@RequestParam(value = "id", required = true) Long id) {
		return rankService.deleteByIdAndMerchant(id);
	}
	
	@PostMapping(value = "/rate")
	public @ResponseBody Map<String, Object> rate(@RequestParam(value = "id", required = true) Long id) {
		Map<String, Object> rateMap = new HashMap<>();
		List<Map<String, Object>> list = rankRateService.findByRankIdAndMerchant(id, ShiroManager.getMerchant());
		Map<Object, List<Map<String, Object>>> groupMap = list.stream().collect(Collectors.groupingBy(map -> {return map.get("type");}));

		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> type1 = groupMap.get(1);
		if (CollUtil.isNotEmpty(type1)) {
			rateMap.put("type1", type1);
			map.putAll(type1.get(0));
			map.put("name", "网银支付");
			map.put("type", 2);
			type1.remove(0);
		}
		List<Map<String, Object>> type0 = groupMap.get(0);
		if (CollUtil.isNotEmpty(type0)) {
			if (!map.isEmpty()) {
				type0.add(map);
			}
			rateMap.put("showSize", type0.size());
			
			List<List<Map<String, Object>>> rr = new ArrayList<>();
			int m = type0.size()/3 + ((type0.size()%3)>0?1:0);
			for (int i = 0; i < m; i++) {
				List<Map<String, Object>> r = new ArrayList<>();
				
				for (int j = 3 * i, k = 0; j < type0.size() && k < 3; j++, k++) {
					r.add(type0.get(j));
				}
				rr.add(r);
			}
			rateMap.put("type0", rr);
		}
		return rateMap;
	}
	
	@PostMapping(value = "/order/list")
	public @ResponseBody JSONObject orderList(OrderVo v, PageData pageData) {
		v.setGallery(null);
		v.setIsAdmin(false);
		v.setAgent(ShiroManager.getMerchant());
		return orderService.findOrderData(v, pageData);
	}

	@MerchantLogs(value = "【代理登录】！", isLogin = true)
	@PostMapping(value = "/login")
	public @ResponseBody Result login(@RequestParam(value = "id", required = true) Long id) {
		Optional<Merchant> optional = merchantService.findByIdAndParent(id, ShiroManager.getMerchant());
		if (!optional.isPresent())
			return Result.error("商户不存在，或已被删除！");
		
		try {
			ShiroManager.login(optional.get().setEncrypt(false));
			return Result.success("登陆成功！");
		} catch (Exception e) {
			return Result.error(e.getMessage());
		}
	}
}
