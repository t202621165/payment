package com.cypay.manage.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cypay.common.entity.Product;
import com.cypay.common.enums.ProductTypeEnum;
import com.cypay.common.service.impl.ProductService;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.ProductVo;
import com.cypay.common.vo.Result;

@RestController
@RequestMapping(value = "/man")
public class ManProductController {
	
	@Autowired
	private ProductService productService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 产品列表
	 * @param v
	 * @param pageData
	 * @return
	 */
	@GetMapping("/product/list")
	public Page<?> list(ProductVo v, PageData pageData) {
		return productService.findVoPageList(v, pageData);
	}
	
	/**
	 * 产品保存/编辑
	 * @param p
	 * @param v
	 * @return
	 */
	@PostMapping("/product/save")
	public Result save(@Valid Product p) {
		p.setSort(p.getSort());
		p.setState(true);
		p.setType(p.getTypeMark().equals("ebank") ? 1 : 0);
		p.setMarkName(ProductTypeEnum.productTypeMarkName(p.getTypeMark()));
		p.setMerchantProducts(null);
		return productService.save(p);
	}
	
	/**
	 * 产品状态更改
	 * @param p
	 * @return
	 */
	@PostMapping("/product/state")
	public Result updateState(Product p){
		return productService.updateState(p.getId());
	}
	
	/**
	 * 更改排序号
	 * @param id
	 * @param sort
	 * @return
	 */
	@PostMapping("/product/sort")
	public Result updateSort(@RequestParam(value="id") Long id,@RequestParam(value="sort") Integer sort){
		return productService.updateSort(id, sort);
	}
	
	/**
	 * 查询所有产品
	 * @return
	 */
	@GetMapping("/product/products")
	public List<Product> products(){
		return productService.findIdAndProductNameList();
	}
	
	/**
	 * 一键切换网银通道
	 * @param v
	 * @return
	 */
	@GetMapping("/product/switch")
	public Result wy_switch(@RequestParam(value = "id") Long id){
		return productService.updateEbankGallery(id);
	}
	
	@GetMapping("/product/del")
	public Result del(@RequestParam(value="id") Long id){
		return productService.deleteById(id);
	}
}
