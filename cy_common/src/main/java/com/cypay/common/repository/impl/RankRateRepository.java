package com.cypay.common.repository.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.RankRate;
import com.cypay.common.repository.BaseRepository;
@Repository
public interface RankRateRepository extends BaseRepository<RankRate,Long>{

	@Query(value = "SELECT p.id,p.name,p.type,r1.rate as rate1,r2.rate as rate2 "
			+ "FROM cy_product p LEFT JOIN cy_rank_rate r1 ON r1.product_id = p.id "
			+ "AND r1.rank_id = ?1 LEFT JOIN cy_rank_rate r2 ON r2.product_id = p.id "
			+ "INNER JOIN cy_merchant m ON m.rank_id = r2.rank_id AND m.id = ?2 ORDER BY p.type,p.id", nativeQuery = true)
	List<Map<String, Object>> findByRankIdAndMerchant(Long rankId, Long merchantId);

	@Query(value = "DELETE FROM cy_rank_rate WHERE rank_id = ?1", nativeQuery = true)
	@Transactional
	@Modifying
	int deleteByRankId(Long id);

	@Query(value = "SELECT new com.cypay.common.entity.RankRate(rr.id,rr.rate,p.id,p.name) "
			+ "FROM Product p LEFT JOIN p.rankRates rr WITH rr.rank.id = ?1 ORDER BY p.sort")
	List<RankRate> findRankRateByRankId(Long id);
}
