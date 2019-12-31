package com.cypay.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cypay.common.entity.TemplateProduct;
import com.cypay.common.repository.impl.TemplateProductRepository;
import com.cypay.common.vo.TemplateProductVo;

@Service
public class TemplateProductService extends BaseServiceImpl<TemplateProductRepository, TemplateProduct, TemplateProduct> {

	public List<TemplateProduct> findWithProduct(Long id) {
		return baseRepository.findWithProduct(id);
	}
	
	public List<TemplateProductVo> findTemplateProduct(Long id){
		return baseRepository.findTemplateProduct(id);
	}

}
