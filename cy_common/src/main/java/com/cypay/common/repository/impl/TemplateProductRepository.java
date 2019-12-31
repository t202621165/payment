package com.cypay.common.repository.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Product;
import com.cypay.common.entity.Template;
import com.cypay.common.entity.TemplateProduct;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.vo.TemplateProductVo;

@Repository
public interface TemplateProductRepository extends BaseRepository<TemplateProduct, Long> {
	
	@Query(value = "SELECT new com.cypay.common.entity.TemplateProduct"
			+ "(t.id, t.rate, t.amountRate, p.id, p.type, p.name) "
			+ "FROM TemplateProduct t RIGHT JOIN t.product p "
			+ "WITH t.template.id = ?1 WHERE p.state=1 ORDER BY p.type,p.id")
	List<TemplateProduct> findWithProduct(Long id);
	
	@Query(value = "SELECT new com.cypay.common.entity.TemplateProduct"
			+ "(t.id, t.rate, t.amountRate, p.id, p.type, p.markName) "
			+ "FROM TemplateProduct t RIGHT JOIN t.product p "
			+ "WITH t.template = ?2 WHERE p = ?1")
	TemplateProduct findByProductAndTemplate(Product p, Template t);
	
	@Query(value = "SELECT new com.cypay.common.entity.TemplateProduct"
			+ "(t.id, t.rate, t.amountRate, p.id, p.type, p.markName) "
			+ "FROM TemplateProduct t RIGHT JOIN t.product p WITH t.template = ?2"
			+ " WHERE p.id IN(?1)")
	List<TemplateProduct> findByIdsAndTemplate(Set<Long> ids, Template t);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM TemplateProduct t WHERE t.template = ?1")
	int deleteByTemplate(Template template);
	
	@Query(value="select new com.cypay.common.vo.TemplateProductVo(tp.id,tp.rate,p.id,p.name) from TemplateProduct tp "
			+ "inner join Product p on tp.product.id = p.id "
			+ "inner join Template t on t.id = tp.template.id "
			+ "and t.id = ?1")
	List<TemplateProductVo> findTemplateProduct(Long id);
}
