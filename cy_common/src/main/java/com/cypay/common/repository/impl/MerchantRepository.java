package com.cypay.common.repository.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Rank;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.vo.MerchantVo;

@Repository
public interface MerchantRepository extends BaseRepository<Merchant, Long> {

	/**
	 * 根据商户帐号查询商户
	 * @param account
	 * @return
	 */
	@Override
	Merchant findByAccount(String account);

	@Override
	@EntityGraph(value = "merchantWithRank", type = EntityGraphType.FETCH)
	Page<Merchant> findAll(@Nullable Specification<Merchant> spec, Pageable pageable);
	
	List<Merchant> findByParent(Merchant merchant);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_merchant SET service_state = CASE WHEN service_state = 0 "
			+ "THEN 1 ELSE 0 END WHERE id = ?1", nativeQuery = true)
	int updateServiceState(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_merchant SET leave_state = CASE WHEN leave_state = 0 "
			+ "THEN 1 ELSE 0 END WHERE id = ?1", nativeQuery = true)
	int updateLeaveState(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_merchant SET is_ips = CASE WHEN is_ips = 0 "
			+ "THEN 1 ELSE 0 END WHERE id = ?1", nativeQuery = true)
	int updateIsIps(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_merchant SET is_logger = CASE WHEN is_logger = 0 "
			+ "THEN 1 ELSE 0 END WHERE id = ?1", nativeQuery = true)
	int updateIsLogger(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_merchant SET state = CASE WHEN state != 1 "
			+ "THEN 1 ELSE 0 END WHERE id = ?1 AND parent_id = ?2", nativeQuery = true)
	int updateAgentState(Long id, Long parentId);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_merchant SET state = CASE WHEN state != 1 "
			+ "THEN 1 ELSE 0 END WHERE id = ?1", nativeQuery = true)
	int updateState(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM cy_merchant WHERE id = ?1 AND parent_id = ?2", nativeQuery = true)
	int deleteByIdAndParentId(Long id, Long parentId);
	
	/**
	 * 商户个数
	 * @return
	 */
	@Query(value="select new com.cypay.common.vo.MerchantVo(COUNT(m.id)) from Merchant m")
	MerchantVo findMerchantCount();
	
	/**
	 * 根据商户密钥查询商户ID 商户密钥 商户 UUID
	 * @param key 商户密钥
	 * @return
	 */
	@Query(value="select new com.cypay.common.vo.MerchantVo(m.id,m.secretKey,m.uuid) from Merchant m where m.secretKey = ?1")
	MerchantVo findMerchantIdAndKeyAndUUIDByKey(String key);
	
	@Transactional
	@Modifying
	@Query(value="update Merchant m set m.secretKey = ?1,m.uuid = ?2 where m.secretKey = ?3")
	int updateKeyAndUuidByKey(String newKey,String uuid,String oldKey);
	
	Long countByRankAndParent(Rank rank, Merchant parent);

	Optional<Merchant> findByIdAndParent(Long id, Merchant parent);

	@Transactional
	@Modifying
	@Query(value="update cy_merchant m set m.final_date = ?2 where m.id = ?1", nativeQuery = true)
	int updateFinalDate(Long id, Date date);

	@Transactional
	@Modifying
	@Query(value="update Merchant m set m.password = ?2 where m = ?1")
	int updatePassword(Merchant m, String password);

	@Transactional
	@Modifying
	@Query(value="update Merchant m set m.secretKey = ?2 where m = ?1")
	int updateSecretKey(Merchant m, String secretKey);
	
	@Query(value="select m.id as id, m.is_ips as isIps,m.is_logger as isLogger from cy_merchant m where m.uuid = ?1",nativeQuery=true)
	Map<String,Object> findIpsLoggerByMerchantId(String uuid);
	
	@Transactional
	@Modifying
	@Query(value="update cy_merchant set is_ips = ?1",nativeQuery=true)
	int updateIsIps(Boolean state);
	
	@Transactional
	@Modifying
	@Query(value="update cy_merchant set is_logger = ?1",nativeQuery=true)
	int updateIsLogin(Boolean state);
	
	@Transactional
	@Modifying
	@Query(value = "update cy_merchant set rank_id = ?1 where id= ?2",nativeQuery = true)
	int updateMerchantRank(Long rankId,Long merchantId);

	@Query(value = "SELECT m.id as merchantId, r.id as rankId FROM cy_merchant m LEFT JOIN cy_rank r ON r.merchant_id = m.id WHERE m.uuid = ?1 ORDER BY r.is_default DESC LIMIT 1", nativeQuery = true)
	Map<String, BigInteger> findByUuid(String uuid);
	
	@Transactional
	@Modifying
	@Query(value="update cy_merchant set rank_id = ?2 where id = ?1 and parent_id = ?3",nativeQuery=true)
	int updateAgentRank(Long id, Long rankId, Long parentId);

	@Query(value = "SELECT t.rowno FROM(SELECT m.id,m.account, (@rowno \\:= @rowno + 1) AS rowno FROM cy_merchant m, (SELECT (@rowno \\:= 0))b ORDER BY m.id)t where t.account = :account", nativeQuery = true)
	int findRank(String account);

	@Transactional
	@Modifying
	@Query(value="update cy_merchant set authorize_ip = ?2 where id = ?1",nativeQuery=true)
	int updateAuthorizeIp(Long id, String ips);

}
