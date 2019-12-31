package com.cypay.common.repository.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.ReissueRecord;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface ReissueRecordRepository extends BaseRepository<ReissueRecord, Long> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM ReissueRecord r WHERE r.partition.id = ?1")
	int deleteByPartitionId(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM ReissueRecord r WHERE r.partition.id IN(?1)")
	int deleteByPartitionIds(List<Long> ids);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM ReissueRecord r WHERE r.reissueDate >= ?1 AND r.reissueDate <= ?2 And r.merchant.id = ?3")
	int deleteByDate(Date startDate, Date endDate, Long id);

}
