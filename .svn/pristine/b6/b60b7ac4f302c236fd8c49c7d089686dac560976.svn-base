package com.cypay.common.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.GalleryRate;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.vo.GalleryRateVo;
@Repository
public interface GalleryRateRepository extends BaseRepository<GalleryRate, Long> {

	/**
	 * 根据通道ID查询通道费率
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT new com.cypay.common.vo.GalleryRateVo("
			+ "p.id, p.name, p.typeMark, gr.id, gr.rate, gr.reqUrl) "
			+ "FROM Product p LEFT JOIN p.galleryRates gr WITH gr.gallery.id = ?1 "
			+ "ORDER BY p.id")
	List<GalleryRateVo> findRateByGalleryId(Long id);

}
