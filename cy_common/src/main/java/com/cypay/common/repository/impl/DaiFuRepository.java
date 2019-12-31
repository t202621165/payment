package com.cypay.common.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.cypay.common.entity.DaiFu;
import com.cypay.common.repository.BaseRepository;

public interface DaiFuRepository extends BaseRepository<DaiFu,Long>{
	@Query(value = "select id,markName from DaiFu where mark = ?1")
	List<DaiFu> findMarkNameByMark(String mark);
	
	DaiFu findByMarkName(String markName);

	DaiFu findByMark(String mark);
}
