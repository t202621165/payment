package com.cypay.merchant.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresUser;
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
import com.cypay.common.entity.Line;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Partition;
import com.cypay.common.service.impl.GroupService;
import com.cypay.common.service.impl.LineService;
import com.cypay.common.service.impl.MerchantService;
import com.cypay.common.service.impl.PartitionService;
import com.cypay.common.service.impl.TemplateService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.MD5Util;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.PartitionVo;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.TemplateVo;
import com.cypay.merchant.aop.MerchantLogs;

@Controller
@RequestMapping(value = "mer")
public class PartitionController {

	@Autowired
	private GroupService groupService;
	@Autowired
	private TemplateService templateService;
	@Autowired
	private PartitionService partitionService;
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private LineService lineService;

	@GetMapping(value = "/partition")
	public String home() {
		return "redirect:/mer/partition.html";
	}

	/**
	 * 商户-分区管理
	 * 
	 * @return
	 */
	@GetMapping(value = "/partition.html")
	public String partiiton(Model model) {
		List<Line> list = lineService.findByType(0);
		String line = "";
		if (list!= null && !list.isEmpty()) {
			line = CommonUtil.getWholeDomainName(list.get(0).getDomainName(), list.get(0).getPort());
		}
		model.addAttribute("line", line);
		return "merchant/partition/partition";
	}

	/**
	 * 商户-分区管理
	 * 
	 * @return
	 */
	@PostMapping(value = "/partition/list")
	public @ResponseBody Page<?> list(PartitionVo v, PageData pageData) {
		v.setMerchant(ShiroManager.getMerchant());
		v.setCreateDate(null);
		v.setUseDate(null);
		return partitionService.findVoPageList(v, pageData);
	}

	@GetMapping(value = "/partition/list")
	public @ResponseBody List<Partition> all(PartitionVo v) {
		v.setMerchant(ShiroManager.getMerchant());
		v.setCreateDate(null);
		v.setUseDate(null);
		return partitionService.findAll(v);
	}

	/**
	 * 添加/编辑分区
	 * 
	 * @param model
	 * @param v
	 * @return
	 */
	@RequiresUser
	@GetMapping(value = "/partition/add.html")
	public String merge(Model model, PartitionVo v, boolean isClone) {
		Merchant merchant = ShiroManager.getMerchant();
		if (v.getId() == null) { // 添加
			v.setType(1);
			model.addAttribute("isAdd", true);
			model.addAttribute("partition", v);
		} else { // 编辑
			PartitionVo vo = partitionService.findOneVo(v.getId());
			if (vo == null) {
				return "forword:error";
			}
			model.addAttribute("isAdd", false);
			model.addAttribute("partition", vo);
		}
		model.addAttribute("isClone", isClone);
		model.addAttribute("group", groupService.findByPartitionAndMerchant(v.getId(), merchant.getId()));
		model.addAttribute("template", templateService.findAll(new TemplateVo(merchant)));
		return "merchant/partition/merge";
	}
	
	@PostMapping(value = "/partition")
	public @ResponseBody Partition merge(Long id) {
		return partitionService.findOneVo(id);
	}

	@PostMapping(value = "/partition/add")
	public @ResponseBody Result add(Partition p, boolean isCreate, boolean isClone) {
		return partitionService.save(p, isCreate, isClone, false);
	}
	
	/**
	 * 分区批量排序
	 * @param ids
	 * @param sort
	 * @return
	 */
	@PostMapping(value = "/partition/sort")
	public @ResponseBody Result sort(Long[] ids, Integer[] sort) {
		return partitionService.sort(ids, sort);
	}

	/**
	 * 删除单个分区
	 * @param id
	 * @return
	 */
	@MerchantLogs(value = "删除分区")
	@PostMapping(value = "/partition/delete")
	public @ResponseBody Result delete(@RequestParam(value = "id") Long id) {
		return partitionService.deleteById(id);
	}
	
	/**
	 * 批量删除分区
	 * @param ids
	 * @return
	 */
	@MerchantLogs(value = "批量删除分区")
	@PostMapping(value = "/partition/batch_delete")
	public @ResponseBody Result batchDelete(Long[] ids) {
		return partitionService.batchDelete(Arrays.asList(ids));
	}

	/**
	 * 分区启用/禁用
	 */
	@PostMapping(value = "/partition/state")
	public @ResponseBody Result state(@RequestParam(value = "id", required = true) Long id) {
		return partitionService.updateState(id);
	}
	
	/**
	 * 检测分区
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping(value ="/partition/check")
	public @ResponseBody Result check(@RequestParam(value = "id", required = true) Long id) {
		return partitionService.checkPartition(id);
	}
	
	/**
	 * 加载分区
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping(value ="/partition/load")
	public @ResponseBody Result load(@RequestParam(value = "id", required = true) Long id) {
		return partitionService.loadPartition(id);
	}

	/**
	 * 根据商户密钥和分区服务器ip查询分区 (网关API)
	 * 
	 * @param key
	 *            商户密钥
	 * @param ip
	 *            分区服务器ip
	 * @return
	 */
	@GetMapping("/wg/partitions")
	public @ResponseBody List<PartitionVo> wgPartitions(@RequestParam(value = "key") String key,
			@RequestParam(value = "ip") String ip) {
		return partitionService.findPartitionByMerchantKeyAndServerIp(key, ip);
	}

	/**
	 * 分区安装 (网关API)
	 * 
	 * @param param
	 *            网关json参数
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@PostMapping("/wg/partition/install")
	public @ResponseBody Result wgPartitionInstall(@RequestBody String param) throws UnsupportedEncodingException {
		Partition v = JSONObject.parseObject(URLDecoder.decode(param, "utf-8"), Partition.class);
		Merchant merchant = merchantService.findMerchantIdAndKeyAndUUIDByKey(v.getMerchant().getSecretKey());
		v.setMerchant(merchant);
		String field = v.getName() + v.getServerIp() + v.getServerPort();
		if (MD5Util.verify(field, v.getSign(), merchant.getUuid(), "utf-8")) {
			try{
				return partitionService.save(v, v.getIsCreate(), true, true);
			}catch (Exception e) {
				// TODO: handle exception
				return Result.error("添加分区失败");
			}
			
		} else {
			return Result.error("签名认证失败");
		}
	}
	
	/**
	 * 加载分区 (网关API)
	 * @param partitionId
	 * 			分区ID
	 * @param key
	 * @param sign
	 * @return
	 */
	@GetMapping("wg/partition/load")
	public @ResponseBody Result wgPartitionLoad(@RequestParam(value="partitionId") Long partitionId,@RequestParam(value="key") String key,@RequestParam(value="sign") String sign){
		Merchant merchant = merchantService.findMerchantIdAndKeyAndUUIDByKey(key);
		if (MD5Util.verify(String.valueOf(partitionId), sign, merchant.getUuid(), "utf-8")){
			return partitionService.partitionLoad(partitionId);
		}else{
			return Result.error("签名认证失败");
		}
	}
	
	
	/**
	 * 根据分区ID查询分区信息(网关API)
	 * @param partitionId
	 * @param key
	 * @param sign
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GetMapping("/wg/partition")
	public @ResponseBody Result wgPartition(@RequestParam(value="partitionId") Long partitionId,@RequestParam(value="key") String key,@RequestParam(value="sign") String sign) throws UnsupportedEncodingException{
		Merchant merchant = merchantService.findMerchantIdAndKeyAndUUIDByKey(key);
		if (MD5Util.verify(String.valueOf(partitionId), sign, merchant.getUuid(), "utf-8")){
			return Result.success("获取分区成功",partitionService.wgFindOneVo(partitionId, merchant));
		}else{
			return Result.error("签名认证失败");
		}
	}
	
	/**
	 * 根据分区ID删除分区(网关API)
	 * @param partitionId
	 * @param key
	 * @param sign
	 * @return
	 */
	@GetMapping("/wg/partition/del")
	public @ResponseBody Result wgPartitionDel(@RequestParam(value="partitionId") Long partitionId,@RequestParam(value="key") String key,@RequestParam(value="sign") String sign){
		Merchant merchant = merchantService.findMerchantIdAndKeyAndUUIDByKey(key);
		if (MD5Util.verify(String.valueOf(partitionId), sign, merchant.getUuid(), "utf-8")){
			return partitionService.wgDeleteById(partitionId);
		}else{
			return Result.error("签名认证失败");
		}
	}

}
