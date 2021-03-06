package com.cypay.common.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.Template;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.vo.PartitionVo;

@Repository
public interface PartitionRepository extends BaseRepository<Partition, Long> {
	
	/**
	 * 根据商户UUID查询分区
	 * @param uuid
	 * @return
	 */
	@Query(value = "SELECT p FROM Partition p WHERE p.merchant.uuid = ?1 ORDER BY p.sort DESC, p.id DESC")
	List<Partition> findByMerchantUuid(String uuid);
	
	/**
	 * 根据分组UUID查询分区
	 * @param uuid
	 * @return
	 */
//	@Query(value = "SELECT p FROM Partition p WHERE p.group.uuid = ?1 ORDER BY p.sort, p.createDate DESC")
//	List<Partition> findByGroupUuid(String uuid);

	@Query(value = "SELECT p FROM Partition p WHERE p.uuid = ?1 ORDER BY p.sort DESC, p.id DESC")
	List<Partition> findByPartitionUuid(String uuid);
	
	@Query(value = "select p from Partition p "
			+ "inner join PartitionGroup pg on p.id = pg.partition.id "
			+ "and pg.group.id = ?1 order by p.sort DESC,p.id DESC")
	List<Partition> findByGroupId(Long gId);
	
	/**
	 * 查询当前登录商户的所有分区
	 * @param merchant
	 * @return
	 */
	List<Partition> findByMerchantOrderBySort(Merchant merchant);
	
	
	@Query(value = "select p.id from Partition p where p.merchant = ?1 and p.id in(?2)")
	List<Long> findByMerchantAndIds(Merchant merchant, List<Long> ids);
	
	@Query(value = "SELECT new com.cypay.common.vo.PartitionVo(p.id, p.name, p.createDate, p.useDate, p.changeDate, "
			+ "p.useName, p.serverIp, p.serverPort, p.scriptPath, p.type, p.notice, p.noticeState, p.ybEgg, "
			+ "p.dbInfo, p.sort, p.state, p.isChangeInTime, p.webUrl, p.successMark, p.dataFormat, t.id) FROM "
			+ "Partition p LEFT JOIN p.template t WHERE p.id = ?1 AND p.merchant = ?2")
	Optional<PartitionVo> findOneVo(Long id, Merchant merchant);
	
	@EntityGraph(value = "partitionWithTemplate", type = EntityGraphType.FETCH)
	Partition findByIdAndMerchant(Long id, Merchant m);
	
	@Query(value = "SELECT new com.cypay.common.vo.PartitionVo(p.id,p.name,p.useName,p.changeDate,p.useDate,p.isChangeInTime,p.merchant.id,m.parent.id) "
			+ "FROM Partition p INNER JOIN p.merchant m WHERE p.uuid = ?1 AND p.state = 1")
	PartitionVo findByUuid(String uuid);
	
	@Query(value = "SELECT new com.cypay.common.vo.PartitionVo(p.merchant.id,p.name) FROM Partition p WHERE p.id = ?1")
	PartitionVo findMerchantById(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_partition SET state = "
			+ "CASE WHEN state = 0 THEN 1 ELSE 0 END "
			+ "WHERE id = ?1 AND merchant_id = ?2", nativeQuery = true)
	int updateState(Long id, Long merchantId);
	
	Long countByIdAndMerchant(Long id, Merchant merchant);
	
	Long countByTemplateAndMerchant(Template template, Merchant merchant);

	/**
	 * 根据商户密钥和服务器ip查询分区
	 * @param key 商户密钥
	 * @param ip 服务器ip
	 * @return
	 */
	@Query(value="select new com.cypay.common.vo.PartitionVo(p.id,p.name,t.currencyName,p.serverIp,p.scriptPath) from Partition p "
			+ "inner join Merchant m on p.merchant.id = m.id "
			+ "inner join Template t on p.template.id = t.id "
			+ "and m.secretKey = ?1 "
			+ "and p.serverIp = ?2 "
			+ "order by p.sort DESC,p.createDate DESC")
	List<PartitionVo> findPartitionByMerchantKeyAndServerIp(String key,String ip);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Partition p WHERE p.merchant = ?1")
	int deleteByMerchant(Merchant m);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Partition p WHERE p.id IN(?1)")
	int deleteByIds(List<Long> ids);

	@Query(value = "SELECT IFNULL(MAX(sort), 0) FROM cy_partition p where p.merchant_id = ?1", nativeQuery = true)
	Integer findMaxSortByMerchant(Long id);

}
