package com.cypay.manage.controller;

import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cypay.common.entity.Gallery;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.service.impl.GalleryRateService;
import com.cypay.common.service.impl.GalleryService;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.Result;

@RestController
@RequestMapping(value = "/man")
public class ManGalleryController {
	@Autowired
	private GalleryService galleryService;
	@Autowired
	private GalleryRateService galleryRateService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @return 返回通道ID和名称集合
	 */
	@GetMapping("/gallerys")
	public List<Gallery> gallerys() {
		return galleryService.findIdAndGalleryNameList();
	}

	/**
	 * 
	 * @param v 查询参数
	 * @param pageData 分页参数
	 * @return 通道集合
	 */
	@GetMapping("/gallery/list")
	public Page<Gallery> list(PageData pageData) {
		Page<Gallery> page = galleryService.findAll(pageData);
		page.getContent().parallelStream().forEach(PaymentType::loadGallery);
		return page;
	}

	/**
	 * 
	 * @param g 接收通道ID
	 * @return 更改通道状态结果
	 */
	@PutMapping("/gallery/state")
	public Result updateState(Gallery g) {
		return galleryService.updateState(g.getId());
	}

	/**
	 * 
	 * @param marks 通道标识
	 * @return 保存通道结果
	 */
	@PostMapping("/gallery/save")
	public Result save(@RequestParam(value = "mark") List<String> marks) {
		return galleryService.save(marks);
	}

	/**
	 * 
	 * @param g 通道参数
	 * @param typeMarks 产品类型标识集合
	 * @return 编辑通道结果
	 */
	@PostMapping("/gallery/edit")
	public Result edit(@Valid Gallery g) {		
		return galleryService.save(g);
	}

	/**
	 * 
	 * @param id 费率ID集合
	 * @param galleryId 通道ID集合
	 * @param productId 产品ID集合
	 * @param reqUrl 提交地址集合
	 * @param rate 费率集合
	 * @return 通道费率设置结果
	 */
	@PostMapping("/gallery/rate/save")
	public Result saveGalleryRate(Gallery g) {
		return galleryRateService.saveRate(new HashSet<>(g.getGalleryRate()));
	}
	
	/**
	 * 
	 * @param id 通道ID
	 * @return 删除通道结果
	 */
	@GetMapping("/gallery/del")
	public Result del(@RequestParam(value="id") Long id){
		return galleryService.deleteById(id);
	}

}
