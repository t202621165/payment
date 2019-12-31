package com.cypay.common.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Line;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface LineRepository extends BaseRepository<Line, Long> {
	/**
	 * 通过线路类型查找
	 * @param type
	 * @return
	 */
	List<Line> findByTypeOrderByIsDefaultDesc(Integer type);
	
	/**
	 * 查找默认线路
	 * @param type
	 * @param isdefault
	 * @return
	 */
	@Query(value = "select l from Line l where l.type = ?1 and l.state = true order by l.isDefault desc")
	List<Line> findByType(Integer type);
	
	/**
	 * 设置默认线路
	 * @param id
	 * @param type
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(value="update cy_line set is_default = case when is_default = 1 and id=?1 then 0 when is_default = 0 and id=?1 then 1 else 0 end where type = ?2",nativeQuery=true)
	int lineDefault(Long id,Integer type);
}
