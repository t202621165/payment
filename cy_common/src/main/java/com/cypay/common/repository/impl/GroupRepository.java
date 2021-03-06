package com.cypay.common.repository.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Group;
import com.cypay.common.entity.Merchant;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.vo.GroupVo;

@Repository
public interface GroupRepository extends BaseRepository<Group, Long> {

	/**
	 * 根据商户UUID查询分组
	 * @param uuid
	 * @return
	 */
	List<Group> findByMerchantUuid(String uuid);

	@Override
	@EntityGraph(value = "groupWithPartition", type = EntityGraphType.FETCH)
	List<Group> findAll(@Nullable Specification<Group> spec);
	
	@Override
	@EntityGraph(value = "groupWithPartition", type = EntityGraphType.FETCH)
	Page<Group> findAll(@Nullable Specification<Group> spec, Pageable pageable);
	
	@Query("select new com.cypay.common.vo.GroupVo(g.id,g.name) from Group g")
	List<Group> findGroupIdAndName();

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Group g WHERE g.id = ?1 AND g.merchant = ?2")
	int deleteByIdAndMerchant(Long id, Merchant merchant);

	Group findByMerchantAndName(Merchant merchant, String name);

	Long countByIdAndMerchant(Long id, Merchant merchant);
	
	/**
	 * 根据商户密钥查询分组
	 * @param key 商户密钥
	 * @return
	 */
	@Query(value="select new com.cypay.common.vo.GroupVo(g.id,g.name) from Group g "
			+ "inner join Merchant m on g.merchant.id = m.id "
			+ "and m.secretKey=?1")
	List<GroupVo> findGroupsByMerchantKey(String key);
	
	@Query(value = "select g.id from cy_group g where g.uuid = ?1",nativeQuery = true)
	Long findByUuid(String uuid);
	
	@Query(value = "SELECT g.id,g.name,p.id as isChecked FROM cy_partition_group pg inner join "
			+ "cy_partition p on p.id = pg.partition_id and p.id = ?1 RIGHT JOIN cy_group g on "
			+ "g.id = pg.group_id where g.merchant_id = ?2", nativeQuery = true)
	List<Map<String, Object>> findByPartitionAndMerchant(Long partitionId, Long merchantId);
	
	@Query(value = "SELECT g.id FROM cy_group g WHERE g.id IN(?1) AND g.merchant_id = ?2", nativeQuery = true)
	List<BigInteger> findIds(List<Long> ids, Long merchantId);
}
