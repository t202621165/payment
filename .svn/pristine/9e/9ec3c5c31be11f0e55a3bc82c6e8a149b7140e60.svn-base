package com.cypay.common.util;

import java.io.Serializable;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import cn.hutool.core.util.StrUtil;

public class PageData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int number;
	
	private int pageSize;
	
	private Direction direction = Direction.DESC;
	
	private String[] properties = {};
	
	public PageData() {
		
	}
	
	public PageData(int number, int pageSize) {
		this.number = number;
		this.pageSize = pageSize;
	}
	
	public Pageable ofPageable() {
		if (!StrUtil.hasBlank(properties)) {
			return PageRequest.of(number, pageSize, direction, properties);
		}
		return PageRequest.of(number, pageSize);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number < 0 ? 0 : number;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize < 5 ? 10 : pageSize > 100 ? 10 : pageSize;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public String[] getProperties() {
		return properties;
	}

	public void setProperties(String... properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "PageData [number=" + number + ", pageSize=" + pageSize + "]";
	}

}
