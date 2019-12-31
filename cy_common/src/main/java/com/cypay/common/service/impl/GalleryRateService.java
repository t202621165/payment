package com.cypay.common.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Service;

import com.cypay.common.entity.GalleryRate;
import com.cypay.common.repository.impl.GalleryRateRepository;
import com.cypay.common.vo.GalleryRateVo;
import com.cypay.common.vo.Result;
@Service
public class GalleryRateService extends BaseServiceImpl<GalleryRateRepository, GalleryRate, GalleryRateVo>{
	
	@Transactional
	public Result saveRate(Set<GalleryRate> galleryRate){
		List<GalleryRate> addList = new ArrayList<>();
		List<GalleryRate> updateList = new ArrayList<>();
		
		galleryRate.parallelStream().forEach(gr -> {
			if (gr.getId() == null) {
				addList.add(gr);
			} else {
				updateList.add(gr);
			}
		});
		
		if (!updateList.isEmpty()) {
			String sql = "update cy_gallery_rate set rate = ?,req_url = ? where gallery_id = ? and product_id = ?";
			jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					GalleryRate gr = updateList.get(i);
					ps.setBigDecimal(1, gr.getRate());
					ps.setString(2,gr.getReqUrl());
					ps.setLong(3, gr.getGallery().getId());
					ps.setLong(4, gr.getProduct().getId());
				}
				
				@Override
				public int getBatchSize() {
					return updateList.size();
				}
			});
		}
		
		if (!addList.isEmpty()) {
			baseRepository.saveAll(addList);
		}
		return Result.success("通道费率设置成功");
	}

	/**
	 * 根据通道ID查询通道费率
	 * @param id
	 * @return
	 */
	public List<GalleryRateVo> findRateByGalleryId(Long id) {
		return baseRepository.findRateByGalleryId(id);
	}

}
