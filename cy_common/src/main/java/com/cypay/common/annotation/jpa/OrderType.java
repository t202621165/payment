package com.cypay.common.annotation.jpa;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;

public enum OrderType {

	ASC {

		@Override
		public Order order(CriteriaBuilder cb, Path<?> path) {
			return cb.asc(path);
		}
		
	}, 
	DESC {
		
		@Override
		public Order order(CriteriaBuilder cb, Path<?> path) {
			return cb.desc(path);
		}
	};
	
	public abstract Order order(CriteriaBuilder cb, Path<?> path);
}
