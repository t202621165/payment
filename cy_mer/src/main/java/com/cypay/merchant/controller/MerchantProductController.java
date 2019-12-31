package com.cypay.merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cypay.common.service.impl.MerchantProductService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.vo.MerchantProductVo;
import com.cypay.common.vo.Result;

@Controller
@RequestMapping(value = "mer")
public class MerchantProductController {
	
	@Autowired
	private MerchantProductService merchantProductService;
	
	@PostMapping(value = "/merproduct/list")
	public @ResponseBody Page<?> list() {
		List<MerchantProductVo> list = merchantProductService.findAllByMerchant(ShiroManager.getMerchant());
		return new PageImpl<MerchantProductVo>(list);
	}
	
	@PostMapping(value = "/merproduct/state")
	public @ResponseBody Result state(@RequestParam(value = "productId", required = true) Long productId) {
		return merchantProductService.updateState(productId, ShiroManager.getMerchant().getId());
	}
}