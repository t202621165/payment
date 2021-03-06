package com.cypay.common.repository.impl;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.WechatInfo;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface WechatInfoRepository extends BaseRepository<WechatInfo, Long> {

	Optional<WechatInfo> findByOpenid(String openid);
	
	Optional<WechatInfo> findByUnionid(String unionid);

	WechatInfo findByMerchantId(Long merchantId);

	@Query(value = "SELECT new com.cypay.common.entity.WechatInfo(w.id, m.id) FROM Merchant m LEFT JOIN WechatInfo w ON m.id = w.merchantId WHERE m.account=?1")
	WechatInfo findByMerchantAccount(String account);

}
