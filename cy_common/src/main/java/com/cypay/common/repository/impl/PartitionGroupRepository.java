package com.cypay.common.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.PartitionGroup;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface PartitionGroupRepository extends BaseRepository<PartitionGroup,Long>{
	@Transactional
	@Modifying
	@Query(value = "delete from cy_partition_group where partition_id = ?1",nativeQuery = true)
	int deletePartitionGroupByPId(Long pId);
	
	@Transactional
	@Modifying
	@Query(value = "delete from cy_partition_group where partition_id IN(?1)",nativeQuery = true)
	int deletePartitionGroupByPIds(List<Long> ids);
	
	@Transactional
	@Modifying
	@Query(value = "delete from cy_partition_group where group_id = ?1",nativeQuery = true)
	int deletePartitionGroupByGId(Long gId);
	
}
