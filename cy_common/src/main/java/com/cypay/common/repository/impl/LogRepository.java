package com.cypay.common.repository.impl;

import java.util.Date;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Log;
import com.cypay.common.repository.BaseRepository;
@Repository
public interface LogRepository extends BaseRepository<Log,Long>{
	/**
	 * 根据用户查找最近一次登录日志
	 * @param id
	 * @return
	 */
	@Query(value="SELECT * FROM cy_log WHERE user_id = ?1 ORDER BY date_time DESC LIMIT 1", nativeQuery = true)
	Map<String, Object> findLastLoginByUser(Long userId);
	
	@Transactional
	@Modifying
	@Query(value = "delete from Log where dateTime < ?1")
	int deleteBeforeWeek(Date date);
}
