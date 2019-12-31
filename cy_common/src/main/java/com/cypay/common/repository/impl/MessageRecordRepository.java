package com.cypay.common.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.MessageRecord;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface MessageRecordRepository extends BaseRepository<MessageRecord, Long> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM MessageRecord r WHERE r.message.id = ?1")
	int deleteByMessageId(Long id);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM MessageRecord r WHERE r.message.id IN(?1)")
	int deleteByMessageIds(List<Long> list);

}
