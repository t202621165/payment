package com.cypay.pay.service;

import org.springframework.stereotype.Service;

import com.cypay.common.entity.Merchant;
import com.cypay.common.service.impl.BaseServiceImpl;
import com.cypay.pay.repository.MerchantRepository;
import com.cypay.pay.vo.MerchantVo;

@Service("pMerchantService")
public class MerchantService extends BaseServiceImpl<MerchantRepository, Merchant, Merchant> {
	
	public MerchantVo findServiceInfoByUuid(String uuid, String type) {
		if ("m".equals(type)) {
			return baseRepository.findServiceInfoByUuid(uuid);
		}else if ("g".equals(type)) {
			return baseRepository.findServiceInfoByGroupUuid(uuid);
		}else {
			return baseRepository.findServiceInfoByPartitionUuid(uuid);
		}
	}
}
