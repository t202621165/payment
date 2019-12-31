package com.cypay.common.vo;

import com.cypay.common.entity.Gallery;

public class GalleryVo extends Gallery {
	private static final long serialVersionUID = 1L;

	public GalleryVo() {
	};

	public GalleryVo(Long id, String galleryName) {
		this.setId(id);
		this.setName(galleryName);
	}
}
