package com.cypay.merchant.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Group;
import com.cypay.common.entity.Line;
import com.cypay.common.entity.Merchant;
import com.cypay.common.service.impl.GroupService;
import com.cypay.common.service.impl.LineService;
import com.cypay.common.service.impl.MerchantService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.MD5Util;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.GroupVo;
import com.cypay.common.vo.Result;
import com.cypay.merchant.aop.MerchantLogs;

@Controller
@RequestMapping(value = "mer")
public class GroupController {

	@Autowired
	private LineService lineService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private MerchantService merchantService;
	
	@GetMapping(value = "/group.html")
	public String group(Model model) {
		List<Line> list = lineService.findByType(0);
		String line = "";
		if (list!= null && !list.isEmpty())
			line = CommonUtil.getWholeDomainName(list.get(0).getDomainName(), list.get(0).getPort());
		model.addAttribute("line", line);
		return "merchant/group/group";
	}
	
	@PostMapping(value = "/group/list")
	public @ResponseBody Page<Group> list(Group v, PageData pageData) {
		v.setMerchant(ShiroManager.getMerchant());
		return groupService.findAll(v, pageData);
	}

	@GetMapping(value = "/group/list")
	public @ResponseBody List<Group> all(Group v) {
		v.setMerchant(ShiroManager.getMerchant());
		return groupService.findAll(v);
	}
	
	@GetMapping(value = "/groups")
	public @ResponseBody List<Map<String, Object>> all(Long id) {
		return groupService.findByPartitionAndMerchant(id, ShiroManager.getMerchant().getId());
	}
	
	@PostMapping(value = "/group/add")
	public @ResponseBody Result add(Group v) {
		return groupService.save(v,false);
	}

	@MerchantLogs(value = "删除分组")
	@PostMapping(value = "/group/delete")
	public @ResponseBody Result delete(@RequestParam(value = "id", required = true) Long id) {
		return groupService.deleteById(id,null);
	}
	
	/**
	 * 根据商户密钥查找分组 (网关API)
	 * @param key 商户密钥
	 * @return
	 */
	@GetMapping("/wg/group")
	public @ResponseBody List<GroupVo> wgGroups(@RequestParam(value = "key") String key){
		return groupService.findGroupsByMerchantKey(key);
	}
	
	/**
	 * 分组添加(网关API)
	 * @param g
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping(value="/wg/group/save")
	public @ResponseBody Result wgGroupSave(@RequestBody String param) throws UnsupportedEncodingException{
		Group g = JSONObject.parseObject(URLDecoder.decode(param, "utf-8"),Group.class);
		Merchant merchant = merchantService.findMerchantIdAndKeyAndUUIDByKey(g.getMerchant().getSecretKey());
		g.setMerchant(merchant);
		return groupService.save(g, true);
	}
	
	/**
	 * 分组删除(网关API)
	 * @param groupId
	 * @param key
	 * @param sign
	 * @return
	 */
	@GetMapping(value="wg/group/del")
	public @ResponseBody Result wgGroupDel(@RequestParam(value="groupId") Long groupId,@RequestParam(value="key") String key,@RequestParam(value="sign") String sign){
		Merchant merchant = merchantService.findMerchantIdAndKeyAndUUIDByKey(key);
		if (MD5Util.verify(String.valueOf(groupId), sign, merchant.getUuid(), "utf-8")){
			return groupService.deleteById(groupId,merchant);
		}else{
			return Result.error("签名认证失败");
		}
	} 
}
