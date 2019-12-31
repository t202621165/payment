package com.cypay.pay.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Product;
import com.cypay.common.entity.Template;
import com.cypay.common.repository.BaseRepository;
import com.cypay.pay.vo.ProductVo;
import com.cypay.pay.vo.RechargeVo;

@Repository("pProductRepository")
public interface ProductRepository extends BaseRepository<Product, Long> {

	@Query(value = "SELECT new com.cypay.pay.vo.ProductVo("
			+ "p.id,p.mark,p.name,p.type,p.typeMark,tp.rate,tp.amountRate) "
			+ "FROM TemplateProduct tp RIGHT JOIN tp.product p WITH tp.template = ?1 "
			+ "LEFT JOIN p.merchantProducts mp WITH mp.merchant = ?2 WHERE p.state = 1 "
			+ "AND mp.state = 1 AND p.gallery != null ORDER BY p.sort asc")
	List<ProductVo> findProducts(Template template, Merchant merchant);
	
	@Query(value = "SELECT new com.cypay.pay.vo.ProductVo(p.id,p.typeMark,p.markName) "
			+ "FROM Product p GROUP BY p.typeMark ORDER BY p.id")
	List<ProductVo> findProducts();
	
	@Override
	@EntityGraph(value = "productWithGallery", type = EntityGraphType.FETCH)
	Optional<Product> findById(Long id);
	
	@Query(value = "SELECT new com.cypay.pay.vo.RechargeVo(p.type, p.mark, p.typeMark, p.name, "
			+ "g.id, g.mark, g.account, g.appId, COALESCE(g.md5Key, g.privateKey), g.des, g.minAmount, "
			+ "g.maxAmount, g.state, g.isRedirect, gr.reqUrl) FROM Product p LEFT JOIN p.gallery g LEFT "
			+ "JOIN g.galleryRate gr WITH gr.product=p WHERE p.id = ?1 AND p.state = 1")
	RechargeVo findProductAndGallery(Long id);

}
