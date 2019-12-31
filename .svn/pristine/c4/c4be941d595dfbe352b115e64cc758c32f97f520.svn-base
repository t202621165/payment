package com.cypay.common.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Rank;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.vo.RankVo;

@Repository
public interface RankRepository extends BaseRepository<Rank, Long> {
	
	@Query(value = "SELECT new com.cypay.common.vo.RankVo(r.id, r.createDate,r.name,r.isDefault,r.isAgency, mm.id, mm.account,COUNT(m.id)) "
			+ "FROM Merchant m RIGHT JOIN m.rank r LEFT JOIN r.merchant mm GROUP BY r.id ORDER BY mm.id, r.createDate DESC")
	List<RankVo> findAllRankAndMerchantCount(Pageable pageable);
	
	/**
	 * 设置默认级别
	 * @param id
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(value = "update cy_rank set cy_rank.is_default = case when cy_rank.id = ?1 then 1 when cy_rank.id != ?1 then 0 else cy_rank.is_default end where is_agency = ?2", nativeQuery = true)
	int updateIsDefault(Long id,Boolean isAgency);
	
	/**
	 * 查询级别id和名称集合
	 * @return
	 */
	@Query(value="select new com.cypay.common.vo.RankVo(r.id,r.name,r.merchant.id) from Rank r")
	List<RankVo> findAllByIdAndName();
	
	@Query(value = "SELECT new com.cypay.common.vo.RankVo(r.id, r.createDate,r.name,r.isDefault,COUNT(m.id)) "
			+ "FROM Merchant m RIGHT JOIN m.rank r WHERE r.merchant = ?1 GROUP BY r.id ORDER BY r.id")
	List<RankVo> findAllByMerchant(Merchant merchant);

	@Query(value = "DELETE FROM Rank r WHERE r.id = ?1 AND r.merchant = ?2")
	@Transactional
	@Modifying
	int deleteByIdAndMerchant(Long id, Merchant merchant);
	
	@Query(value = "UPDATE cy_rank SET is_default = CASE WHEN id = ?1 THEN 1 ELSE 0 END WHERE merchant_id = ?2", nativeQuery = true)
	@Transactional
	@Modifying
	int updateIsDefault(Long id, Long merchantId);

	Optional<Rank> findByIdAndMerchant(Long id, Merchant merchant);
	

	Optional<Rank> findByIsDefaultAndIsAgency(Boolean isdefault,Boolean isAgency);

	@Query(value = "SELECT r FROM Rank r WHERE r.isAgency = false ORDER BY r.isDefault DESC")
	List<Rank> findDefaultRank();

}
