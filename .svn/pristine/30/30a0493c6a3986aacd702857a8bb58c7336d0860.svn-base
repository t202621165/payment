package com.cypay.merchant.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Product;
import com.cypay.common.entity.Template;
import com.cypay.common.service.impl.MerchantService;
import com.cypay.common.service.impl.ProductService;
import com.cypay.common.service.impl.TemplateService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.MD5Util;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.TemplateVo;
import com.cypay.merchant.aop.MerchantLogs;

@Controller
@RequestMapping(value = "mer")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	@Autowired
	private ProductService productService;
	@Autowired
	private MerchantService merchantService;
	
	@GetMapping(value = "/template.html")
	public String template() {
		return "merchant/template/template";
	}
	
	/**
	 * 模板分页查询
	 * @param v
	 * @param pageData
	 * @return
	 */
	@PostMapping(value = "/template/list")
	public @ResponseBody Page<?> list(TemplateVo v, PageData pageData) {
		v.setMerchant(ShiroManager.getMerchant());
		return templateService.findAll(v, pageData);
	}
	
	/**
	 * 查询所有模板
	 * @param v
	 * @param pageData
	 * @return
	 */
	@GetMapping(value = "/template/list")
	public @ResponseBody List<Template> all(TemplateVo v) {
		v.setMerchant(ShiroManager.getMerchant());
		return templateService.findAll(v);
	}
	
	/**
	 * 添加/编辑模板
	 * @param model
	 * @param v
	 * @return
	 */
	@RequiresUser
	@GetMapping(value = "/template/add.html")
	public String merge(Model model, TemplateVo v) {
		templateService.findInfo(model, v);
		return "merchant/template/merge";
	}
	
	@PostMapping(value = "/template/add")
	public @ResponseBody Result add(Template t) {
		return templateService.save(t,false);
	}
	
	/**
	 * 删除模板
	 * @param id
	 * @return
	 */
	@MerchantLogs(value = "删除模板")
	@PostMapping(value = "/template/delete")
	public @ResponseBody Result delete(@RequestParam(value = "id", required = true) Long id) {
		return templateService.deleteById(id, null);
	}
	
	/**
	 * 模板充值赠送开启/关闭
	 */
	@PostMapping(value = "/template/state")
	public @ResponseBody Result state(@RequestParam(value = "id", required = true) Long id) {
		return templateService.updateState(id);
	}
	
	/**
	 * 根据商户密钥查询模板 (网关API)
	 * @param key 商户密钥 
	 * @return
	 */
	@GetMapping("/wg/templates")
	public @ResponseBody List<TemplateVo> wgTemplates(@RequestParam(value = "key") String key){
		return templateService.findTemplatesByMerchantKey(key);
	}
	
	/**
	 * 查询充值渠道 (网关API)
	 * @return
	 */
	@GetMapping("/wg/product")
	public @ResponseBody List<Product> wgProducts(){
		return productService.findIdAndProductNameList();
	}
	
	/**
	 * 模板安装 (网关API)
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("wg/template/install")
	public @ResponseBody Result wgTemplateInstall(@RequestBody String param) throws UnsupportedEncodingException{
		Template v = JSONObject.parseObject(URLDecoder.decode(param, "utf-8"),Template.class);
		Merchant merchant = merchantService.findMerchantIdAndKeyAndUUIDByKey(v.getMerchant().getSecretKey());
		v.setMerchant(merchant);
		return templateService.save(v, true);
	}
	
	/**
	 * 根据模板ID删除模板 (网关API)
	 * @param templateId 模板ID
	 * @param key 通讯密钥
	 * @param sign	签名结果
	 * @return
	 */
	@GetMapping("/wg/template/del")
	public @ResponseBody Result wgTemplateDelete(@RequestParam(value="templateId") Long templateId,@RequestParam(value="key") String key,@RequestParam(value="sign") String sign){
		Merchant merchant = merchantService.findMerchantIdAndKeyAndUUIDByKey(key);
		if (MD5Util.verify(String.valueOf(templateId), sign, merchant.getUuid(), "utf-8")){
			return templateService.deleteById(templateId,merchant);
		}else{
			return Result.error("签名认证失败");
		}
	}
	
	/**
	 * 根据模板ID查找模板 (网关API)
	 * @param templateId  模板ID
	 * @param key 通讯密钥
	 * @param sign 签名结果
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GetMapping("/wg/template")
	public @ResponseBody Result wgTemplate(@RequestParam(value="templateId") Long templateId,@RequestParam(value="key") String key,@RequestParam(value="sign") String sign) throws UnsupportedEncodingException{
		Merchant merchant = merchantService.findMerchantIdAndKeyAndUUIDByKey(key);
		if (MD5Util.verify(String.valueOf(templateId), sign, merchant.getUuid(), "utf-8")){
			return Result.success("获取分组模板成功",templateService.findTemplateByTemplateId(templateId));
		}else{
			return Result.error("签名认证失败");
		}
	}
	
	/**
	 * 根据商户key获取模板下拉列表值(网关API)
	 * @param key
	 * @return
	 */
	@GetMapping("/wg/template/sel")
	public @ResponseBody Result wgTemplateSel(@RequestParam(value="key") String key){
		List<TemplateVo> templateVos = templateService.findTemplatesByMerchantKey(key);
		if (StringUtils.isEmpty(templateVos))
			return Result.error("模板列表不存在");
		else
			return Result.success("获取模板列表成功", templateVos);
	}

}
