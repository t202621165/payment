package com.cypay.common.vo;

import com.cypay.common.entity.Product;

public class ProductVo extends Product{
	private static final long serialVersionUID = 1L;
	
	private Long galleryId;
	
	private String galleryName;
	
	public ProductVo(){}
	
	public ProductVo(Long id,String name){
		this.setId(id);
		this.setName(name);
	}
	
	public ProductVo(Long productId,String productName,String mark,Boolean state,Integer type,String typeMark,Long galleryId,String galleryName,Integer sort){
		setSort(sort);
		this.setId(productId);
		this.setMark(mark);
		this.galleryName = galleryName;
		this.galleryId = galleryId;
		this.setName(productName);
		this.setType(type);
		this.setTypeMark(typeMark);
		this.setState(state);
	}
	
	public Long getGalleryId(){
		return galleryId;
	}

	public void setGalleryId(Long galleryId) {
		this.galleryId = galleryId;
	}
	

	public String getGalleryName() {
		return galleryName;
	}
	
	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}
}
