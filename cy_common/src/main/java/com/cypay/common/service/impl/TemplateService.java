package com.cypay.common.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

import javax.transaction.Transactional;

import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cypay.common.bo.TemplateBo;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Product;
import com.cypay.common.entity.Template;
import com.cypay.common.entity.TemplateProduct;
import com.cypay.common.repository.impl.PartitionRepository;
import com.cypay.common.repository.impl.TemplateProductRepository;
import com.cypay.common.repository.impl.TemplateRepository;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.to.GameEngine;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.TemplateVo;

@Service
public class TemplateService extends BaseServiceImpl<TemplateRepository, Template, TemplateVo> {
	
	@Value("${com.payment.mark}")
	private String mark;
	
	@Autowired
	private PartitionRepository partitionRepository;
	
	@Autowired
	private SystemSetService systemSetService;
	
	@Autowired
	private TemplateProductRepository templateProductRepository;
	
	@Transactional
	public Result save(Template t,Boolean isWg) {
		// 参数校验
		Result result = t.validate(isWg);
		if (!result.getState())
			return result;
		
		String msg = "模板【"+t.getName()+"】创建成功！";
		if (t.getId() != null) { // 模板更新
			msg = "模板【"+t.getName()+"】更新成功！";
			Merchant merchant = null;
			if (isWg)
				merchant = t.getMerchant();
			else
				merchant = ShiroManager.getMerchant();
			Long count = baseRepository.countByIdAndMerchant(t.getId(), merchant);
			if (count == 0)
				return Result.error("更新失败，当前模板不存在或已被删除！");
			templateProductRepository.deleteByTemplate(t);
		}
		
		baseRepository.save(t);
		List<TemplateProduct> products = t.getProducts();
		String sql = "insert into cy_template_product(rate, amount_rate, product_id, template_id) values(?, ?, ?, ?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				TemplateProduct tp = products.get(i);
				ps.setInt(1, tp.getRate());
				ps.setString(2, tp.parse());
				ps.setLong(3, tp.getProduct().getId());
				ps.setLong(4, t.getId());
			}
			
			@Override
			public int getBatchSize() {
				return products.size();
			}
		});
		return Result.success(msg);
	}
	
	public void findInfo(Model model, final TemplateVo v) {
		try {
			model.addAttribute("isAdd", false);
			v.setMerchant(ShiroManager.getMerchant());
			
			Future<Template> templateFuture = futureTaskPool.submit(() ->{
				if (v.getId() == null) {
					v.setType(1);
					model.addAttribute("isAdd", true);
					return v;
				}
					
				return findOne(v);
			});
			Future<List<TemplateProduct>> productFuture = futureTaskPool.submit(() -> {
				List<TemplateProduct> list = templateProductRepository.findWithProduct(v.getId());
				for (TemplateProduct tp : list) {
					Product p = tp.getProduct();
					if (p.getType() == 1) {
						p.setName("网银支付").setType(2);
						break;
					}
				}
				return list;
			});
			Future<List<GameEngine>> gameEngineFuture = futureTaskPool.submit(() -> {
				return systemSetService.findGameEngine();
			});
			
			Template template = templateFuture.get();
			Assert.notNull(template);
			template.parse();
			template.setPartitions(Collections.emptySet());
			template.setProducts(productFuture.get());
			
			
			model.addAttribute("template", template);
			model.addAttribute("gameEngines", gameEngineFuture.get());
		} catch (Exception e) {
			v.setType(1);
			model.addAttribute("isAdd", true);
			model.addAttribute("template", v);
		}
	}
	
	@Transactional
	public Result deleteById(Long id,Merchant merchant) {
		Template t = new Template(id);
		if(merchant == null){
			merchant = ShiroManager.getMerchant();
		}
		Long count = partitionRepository.countByTemplateAndMerchant(t, merchant);
		if (count > 0)
			return Result.error("删除失败，当前‘"+count+"’个分区正在使用该模板！");
		
		templateProductRepository.deleteByTemplate(t);
		
		int result = baseRepository.deleteByIdAndMerchant(id, merchant);
		if (result == 0)
			return Result.error("删除失败，当前模板不存在或已被删除！");
		
		return Result.success("删除成功！");
	}
	
	public TemplateBo findTemplateByTemplateId(Long id){
		TemplateBo templateBo = baseRepository.findTemplateByTemplateId(id);
		templateBo.setProducts(templateProductRepository.findTemplateProduct(id));
		return templateBo;
	}
	
	public Result updateState(Long id) {
		baseRepository.updateState(id, ShiroManager.getMerchant().getId());
		return Result.success("操作成功");
	}
	
	public List<TemplateVo> findTemplatesByMerchantKey(String key){
		return baseRepository.findTemplatesByMerchantKey(key);
	}
	
	/**
	 * 根据产品唯一标识（uuid）查询模板信息
	 * @param uuid
	 * @return
	 */
	public TemplateVo findByProdutUuid(String uuid) {
		return baseRepository.findByProdutUuid(uuid);
	}
}
