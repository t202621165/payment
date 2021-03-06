package com.cypay.pay.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Merchant;
import com.cypay.common.repository.BaseRepository;
import com.cypay.pay.vo.MerchantVo;

@Repository("pMerchantRepository")
public interface MerchantRepository extends BaseRepository<Merchant, Long> {

	@Query(value = "SELECT new com.cypay.pay.vo.MerchantVo(m.phoneState, m.servicePhone, m.serviceQQ, "
			+ "m.serviceState, m.leaveState) FROM Merchant m WHERE m.uuid = ?1")
	MerchantVo findServiceInfoByUuid(String uuid);
	
	@Query(value = "SELECT new com.cypay.pay.vo.MerchantVo(m.phoneState, m.servicePhone, m.serviceQQ, "
			+ "m.serviceState, m.leaveState) FROM Partition p INNER JOIN p.merchant m WHERE p.uuid = ?1")
	MerchantVo findServiceInfoByPartitionUuid(String uuid);
	
	@Query(value = "SELECT new com.cypay.pay.vo.MerchantVo(m.phoneState, m.servicePhone, m.serviceQQ, "
			+ "m.serviceState, m.leaveState) FROM Group g INNER JOIN g.merchant m WHERE g.uuid = ?1")
	MerchantVo findServiceInfoByGroupUuid(String uuid);
}
