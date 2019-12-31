package com.cypay.common.annotation.jpa;

import java.lang.reflect.Field;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 查询条件类型
 * @author International
 * @2019年4月8日 下午6:09:53
 */
public enum Conditional {

	/**
	 * 只参与查询
	 */
	SELECT, 
	
	EQ {
		@Override
		public <T, V> Predicate predicate(Root<T> root, CriteriaBuilder cb, V v, Field field, JpaQuery jq)
				throws IllegalArgumentException, IllegalAccessException {
			String value = jq.value();
			String fName = "".equals(value) ? field.getName() : value;
			Path<?> path = root.get(fName);
			for (String f : jq.subField()) {
				path = path.get(f);
			}
			return cb.equal(path, field.get(v));
		}
	}, 
	
	EQ_OR {
		@Override
		public <T, V> Predicate predicate(Root<T> root, CriteriaBuilder cb, V v, Field field, JpaQuery jq)
				throws IllegalArgumentException, IllegalAccessException {
			String[] fields = jq.subField();
			Predicate[] predicates = new Predicate[fields.length];
			for (int i = 0; i < fields.length; i++) {
				predicates[i] = cb.equal(root.get(fields[i]), field.get(v));
			}
			return cb.or(predicates);
		}
	},
	
	BETWEEN_$LT {
		@Override
		public <T, V> Predicate predicate(Root<T> root, CriteriaBuilder cb, V v, Field field, JpaQuery jq)
				throws IllegalArgumentException, IllegalAccessException {
			return getPredicate(cb, root.get("".equals(
					jq.value()) ? field.getName() : jq.value()), jq.jType().transform(field.get(v)));
		}
		
		public <Y extends Comparable<? super Y>> Predicate getPredicate(CriteriaBuilder cb, Expression<? extends Y> x, Y y) {
			return cb.lessThan(x, y);
		}
	},
	
	BETWEEN_$GT {
		@Override
		public <T, V> Predicate predicate(Root<T> root, CriteriaBuilder cb, V v, Field field, JpaQuery jq)
				throws IllegalArgumentException, IllegalAccessException {
			return getPredicate(cb, root.get("".equals(jq.value()) ? field.getName() : jq.value()), jq.jType().transform(field.get(v)));
		}
		
		public <Y extends Comparable<? super Y>> Predicate getPredicate(CriteriaBuilder cb, Expression<? extends Y> x, Y y) {
			return cb.greaterThan(x, y);
		}
	}, 
	
	BETWEEN_$LTE {
		@Override
		public <T, V> Predicate predicate(Root<T> root, CriteriaBuilder cb, V v, Field field, JpaQuery jq)
				throws IllegalArgumentException, IllegalAccessException {
			return getPredicate(cb, root.get("".equals(
					jq.value()) ? field.getName() : jq.value()), jq.jType().transform(field.get(v)));
		}
		
		public <Y extends Comparable<? super Y>> Predicate getPredicate(CriteriaBuilder cb, Expression<? extends Y> x, Y y) {
			return cb.lessThanOrEqualTo(x, y);
		}
	},
	
	BETWEEN_$GTE {
		@Override
		public <T, V> Predicate predicate(Root<T> root, CriteriaBuilder cb, V v, Field field, JpaQuery jq)
				throws IllegalArgumentException, IllegalAccessException {
			return getPredicate(cb, root.get("".equals(
					jq.value()) ? field.getName() : jq.value()), jq.jType().transform(field.get(v)));
		}
		
		public <Y extends Comparable<? super Y>> Predicate getPredicate(CriteriaBuilder cb, Expression<? extends Y> x, Y y) {
			return cb.greaterThanOrEqualTo(x, y);
		}
	}, 
	
	IS_NOT_NULL {
		@Override
		public <T, V> Predicate predicate(Root<T> root, CriteriaBuilder cb, V v, Field field, JpaQuery jq)
				throws IllegalArgumentException, IllegalAccessException {
			return cb.isNotNull(root.get("".equals(jq.value()) ? field.getName() : jq.value()));
		}
	};
	
	public <T, V> Predicate predicate(Root<T> root, CriteriaBuilder cb, V v, Field field, JpaQuery jq)
			throws IllegalArgumentException, IllegalAccessException {
		return null;
	}
}
