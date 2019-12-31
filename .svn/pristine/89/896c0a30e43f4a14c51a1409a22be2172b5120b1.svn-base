package com.cypay.common.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Notice;
import com.cypay.common.repository.BaseRepository;
@Repository
public interface NoticeRepository extends BaseRepository<Notice,Long>{
	@Transactional
	@Query(value = "UPDATE cy_notice SET state = CASE WHEN state=0 then 1 "
			+ "when state=1 then 0 else 0 end WHERE id=?1", nativeQuery = true)
	@Modifying
	int updateState(Long id);

	List<Notice> findByState(Boolean state);
}
