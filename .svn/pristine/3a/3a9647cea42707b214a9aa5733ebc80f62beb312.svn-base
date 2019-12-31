package com.cypay.common.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Product;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface ProductRepository extends BaseRepository<Product,Long>{
	/**
	 * 开启/关闭产品
	 * @param id
	 * @return
	 */
	@Transactional
	@Query(value = "UPDATE cy_product SET state = CASE WHEN  state=0 then 1 "
			+ "when state=1 then 0 else 0 end WHERE id=?1", nativeQuery = true)
	@Modifying
	int updateState(Long id);
	
	@Transactional
	@Query(value = "UPDATE cy_product SET sort = ?2 WHERE id=?1", nativeQuery = true)
	@Modifying
	int updateSort(Long id,Integer sort);
	
	@Query(value="select new com.cypay.common.vo.ProductVo(p.id,p.name) from Product p where p.state = 1 order by sort asc")
	public List<Product> findIdAndProductNameList();
	
	@Query(value="SELECT p FROM Product p WHERE p.typeMark IN (:typeMarks)")
	public List<Product> findProductsByTypeMark(@Param("typeMarks") List<String> typeMarks);
	
	@Query(value="select p.mark_name from cy_product p group by p.type_mark order by p.sort asc",nativeQuery = true)
	public Object[] findProductNameGroupByTypeMark();
	
	public List<Product> findByState(Boolean state);
}
