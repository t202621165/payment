package com.cypay.common.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.SchedulerJob;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface SchedulerJobRepository extends BaseRepository<SchedulerJob, Long> {

	SchedulerJob findByNameAndGroupNameAndState(String name, String groupName, Integer state);

	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_scheduler_job SET state = ?1 WHERE id = ?2", nativeQuery = true)
	int updateStateById(Integer state, Long id);

	SchedulerJob findByIdAndMerchant(Long id, Merchant merchant);

	List<SchedulerJob> findByState(Integer state);

	@Transactional
	@Modifying
	@Query(value = "UPDATE cy_scheduler_job SET state = ?1 WHERE id IN(?2)", nativeQuery = true)
	int updateStateByIds(Integer state, List<Long> ids);

}
