package com.cypay.common.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.MerchantProduct;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.vo.MerchantProductVo;

@Repository
public interface MerchantProductRepository extends BaseRepository<MerchantProduct, Long> {

	@Query(value = "SELECT new com.cypay.common.vo.MerchantProductVo"
			+ "(mp.id, p.id, p.name, r.rate, p.type, mp.state) FROM RankRate r "
			+ "LEFT JOIN Merchant m ON m.rank = r.rank LEFT JOIN r.product p LEFT "
			+ "JOIN MerchantProduct mp ON mp.product=p AND mp.merchant = m WHERE "
			+ "m = ?1 ORDER BY p.sort asc")
	List<MerchantProductVo> findAllByMerchant(Merchant merchant);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_merchant_product SET state = CASE WHEN  state=0 then 1 "
			+ "when state=1 then 0 else 0 end WHERE product_id=?1 AND merchant_id=?2", nativeQuery = true)
	int updateState(Long productId, Long merchantId);
}
