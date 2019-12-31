package com.cypay.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.MerchantProduct;
import com.cypay.common.repository.impl.MerchantProductRepository;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.vo.MerchantProductVo;
import com.cypay.common.vo.Result;

@Service
public class MerchantProductService extends BaseServiceImpl<MerchantProductRepository, MerchantProduct, MerchantProductVo> {
	
	public List<MerchantProductVo> findAllByMerchant(Merchant merchant) {
		return baseRepository.findAllByMerchant(merchant);
	}

	public Result updateState(Long productId, Long merchantId) {
		int i = baseRepository.updateState(productId, merchantId);
		if(i == 0){
			MerchantProduct mp = new MerchantProduct(productId, ShiroManager.getMerchant());
			baseRepository.save(mp);
		}
		return Result.success("操作成功");
	}
}
