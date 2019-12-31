package com.cypay.pay.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Product;
import com.cypay.common.entity.Template;
import com.cypay.common.service.impl.BaseServiceImpl;
import com.cypay.pay.repository.ProductRepository;
import com.cypay.pay.vo.ProductVo;
import com.cypay.pay.vo.RechargeVo;

@Service("pProductService")
public class ProductService extends BaseServiceImpl<ProductRepository, Product, Product> {
	
	/**
	 * 根据产品UUID查询模版信息
	 * @param uuid
	 * @return
	 */
	public void findProducts(Model model, Long merchantId, Long templateId) {
		List<ProductVo> list = baseRepository.findProducts(new Template(templateId),new Merchant(merchantId));
		Map<Integer, List<ProductVo>> groups = list.parallelStream().collect(Collectors.groupingBy(ProductVo::getType));
		model.addAttribute("products0", groups.get(0)==null?Collections.emptyList():groups.get(0));
		model.addAttribute("products1", groups.get(1)==null?Collections.emptyList():groups.get(1));
	}
	
	/**
	 * 查询所有产品
	 * @param uuid
	 * @return
	 */
	public List<ProductVo> findProducts() {
		return baseRepository.findProducts();
	}
	
	public RechargeVo findProductAndGallery(Long id) {
		return baseRepository.findProductAndGallery(id);
	}
}
