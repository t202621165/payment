package com.cypay.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.RankRate;
import com.cypay.common.repository.impl.RankRateRepository;

@Service
public class RankRateService extends BaseServiceImpl<RankRateRepository, RankRate,RankRate>{
	
	public List<Map<String, Object>> findByRankIdAndMerchant(Long rankId, Merchant merchant) {
		return baseRepository.findByRankIdAndMerchant(rankId, merchant.getId());
	}

	/**
	 * 根据费率分组ID查询费率
	 * @param id
	 */
	public List<RankRate> findRankRateByRankId(Long id) {
		return baseRepository.findRankRateByRankId(id);
	}

}
