package com.cypay.common.vo;

import java.math.BigDecimal;

import com.cypay.common.entity.GalleryRate;

public class GalleryRateVo extends GalleryRate {

	private static final long serialVersionUID = 1L;
	
	private String typeMark;
	
	public GalleryRateVo(Long productId, String productName,String typeMark, Long id, BigDecimal rate, String reqUrl) {
		this.typeMark = typeMark;
		setProductId(productId);
		setProductName(productName);
		setId(id);
		setRate(rate);
		setReqUrl(reqUrl);
	}

	public String getTypeMark() {
		return typeMark;
	}

	public void setTypeMark(String typeMark) {
		this.typeMark = typeMark;
	}
	
}
