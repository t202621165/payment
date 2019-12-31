package com.cypay.common.repository.impl;

import org.springframework.stereotype.Repository;

import com.cypay.common.entity.Order;
import com.cypay.common.repository.BaseRepository;

@Repository
public interface AnalyseRepository extends BaseRepository<Order, Long> {
	
}
