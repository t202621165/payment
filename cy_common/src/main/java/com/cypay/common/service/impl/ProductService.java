package com.cypay.common.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.JoinType;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Service;

import com.cypay.common.entity.Product;
import com.cypay.common.repository.impl.ProductRepository;
import com.cypay.common.service.CriteriaData;
import com.cypay.common.vo.ProductVo;
import com.cypay.common.vo.Result;
@Service
public class ProductService extends BaseServiceImpl<ProductRepository, Product, ProductVo>{

	@Override
	protected CriteriaData<Product, ProductVo> getCriteriaData(String name, ProductVo v) {
		CriteriaData<Product, ProductVo> cd = super.getCriteriaData(name, v);
		cd.getRoot().join("gallery", JoinType.LEFT);
		return cd;
	}
	
	@Override
	public Result saveAll(List<Product> list) {
		String sql = "INSERT INTO cy_product(name, mark, state, type, type_mark, mark_name, sort) VALUES(?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, list.get(i).getName());
				ps.setString(2, list.get(i).getMark());
				ps.setBoolean(3, list.get(i).getState());
				ps.setInt(4, list.get(i).getType());
				ps.setString(5, list.get(i).getTypeMark());
				ps.setString(6, list.get(i).getMarkName());
				ps.setInt(7, list.get(i).getSort());
			}
			
			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
		return Result.success("添加成功！");
	}
	
	/**
	 * 更新产品默认通道
	 * @param list
	 * @return
	 */
	public Result updateEbankGallery(Long id){
		String sql = "update cy_product set gallery_id = "+id+" where type = 1";
		jdbcTemplate.execute(sql);
		return Result.success("默认通道更新成功");
	}
	
	public Result updateState(Long id){
		int i = baseRepository.updateState(id);
		if(i > 0){
			return Result.success("产品状态更改成功");
		}else{
			return Result.error("产品状态更改失败");
		}
	}
	
	public Result updateSort(Long id,Integer sort){
		int i = baseRepository.updateSort(id,sort);
		if(i > 0){
			return Result.success("产品重新排序成功");
		}else{
			return Result.error("产品重新排序失败");
		}
	}
	
	public List<Product> findIdAndProductNameList(){
		return baseRepository.findIdAndProductNameList();
	}
	
	public List<Product> findProductsByTypeMark(List<String> typeMarks){
		return baseRepository.findProductsByTypeMark(typeMarks);
	}
	
	public List<Product> findByState(Boolean state){
		return baseRepository.findByState(state);
	}
	
	public Object[] findProductNameGroupByTypeMark(){
		return baseRepository.findProductNameGroupByTypeMark();
	}
}
