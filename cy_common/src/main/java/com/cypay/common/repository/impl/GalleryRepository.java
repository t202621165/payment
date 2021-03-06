package com.cypay.common.repository.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Gallery;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface GalleryRepository extends BaseRepository<Gallery, Long> {
	
	@Query(value="select new com.cypay.common.entity.Gallery(g.id,g.name,g.mark) from Gallery g")
	public List<Gallery> findIdAndGalleryNameList();
	
	/**
	 * 开启/关闭通道
	 * @param id
	 * @return
	 */
	@Transactional
	@Query(value = "UPDATE cy_gallery SET state = CASE WHEN  state=0 then 1 "
			+ "when state=1 then 0 else 0 end WHERE id=?1", nativeQuery = true)
	@Modifying
	int updateState(Long id);
	
	@Query(value = "select count(id) as count, mark from cy_gallery group by mark", nativeQuery = true)
	List<Map<String, Object>> findCountGroupByMark();

	@Query(value="SELECT COUNT(g) FROM Gallery g WHERE g.mark = ?1")
	public Long countByMark(String mark);
	
	Gallery findByMark(String mark);
}
