package com.cypay.common.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cypay.common.annotation.jpa.Conditional;
import com.cypay.common.annotation.jpa.JpaOrderBy;
import com.cypay.common.annotation.jpa.JpaQuery;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;

/**
 * JPA标准化查询
 * <p>自定义查询字段、动态查询条件数据封装类</p>
 * @author International
 * @2019年4月8日 下午12:28:39
 * @param <T>
 * @param <V>
 */
@Service
public class JpaCriteriaQuery<T, V> {
	
	@Autowired
	protected EntityManager entityManager;
	
	@Autowired
	protected CriteriaData<T, V> criteriaData;
	
	protected static final Map<String, CriteriaData<?, ?>> CRITERIA_DATA_MAP = new ConcurrentHashMap<>(64);

	/**
	 * 创建新的标准化Data
	 * @return
	 */
	protected final CriteriaData<T, V> getCriteriaData() {
		return criteriaData.clone(getClass());
	}
	
	/**
	 * 根据名称创建标准化Data
	 * <p>并同时构建查询字段和动态查询条件</p>
	 * @param name
	 * @param v
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected CriteriaData<T, V> getCriteriaData(String name, V v) {
		// 从缓存中获取CriteriaData
		CriteriaData<T, V> cd = (CriteriaData<T, V>) CRITERIA_DATA_MAP.get(name);
		if (cd == null) {
			// 创建新的CriteriaData，并添加到缓存中
			cd = criteriaData.clone(getClass());
			
			if (v != null) {
				// 动态获取查询字段和排序方式
				dynamicQuery(cd, v);
			}
			
			CRITERIA_DATA_MAP.put(name, cd);
			return cd;
		} else {
			cd.setCache(true);
			return cd.cacheClone();
		}
	}
	
	/**
	 * 动态查询
	 * <p>动态获取查询字段和排序方式</p>
	 * @param root
	 * @param query
	 * @param cb
	 * @param v
	 * @param className
	 * @return
	 */
	protected final void dynamicQuery(CriteriaData<T, V> cd, V v) {
		// 查询字段
		List<Selection<?>> selections = new ArrayList<>();
		// 排序方式
		List<Order> orders = new ArrayList<>();
		
		// 获取当前查询对象的所有属性(包括父类)
		Field[] fields = ReflectUtil.getFields(v.getClass());
		for (Field field : fields) {
			field.setAccessible(true);
			
			// 根据@JpaOrderBy注解动态获取排序方式
			dynamicOrderBy(cd.getRoot(), cd.getCriteriaBuilder(), v, field, orders);
			
			// 根据@JpaQuery注解动态获取查询字段和查询条件
			JpaQuery jq = field.getAnnotation(JpaQuery.class);
			if (jq != null) {
				// 动态获取查询字段
				dynamicSelect(cd.getRoot(), jq, field, selections);
			}
		}
			
		cd.setSelections(selections);
		cd.setOrders(orders);
	}
	
	/**
	 * 动态获取查询字段
	 * @param root
	 * @param jq
	 * @param field
	 * @return
	 */
	private List<Selection<?>> dynamicSelect(Root<T> root, JpaQuery jq, Field field, List<Selection<?>> selections) {
		if (jq.select()) {
			String value = jq.value();
			String fieldName = "".equals(value) ? field.getName() : value;
			String[] chain = jq.chain();
			if (chain.length > 0) {
				for (String c : chain) {
					selections.add(root.get(fieldName).get(c));
				}
			} else {
				selections.add(root.get(fieldName));
			}
		}
		return selections;
	}
	
	/**
	 * 动态获取查询条件
	 * <p>不加载排序方式</p>
	 * @param cd
	 * @param v
	 * @return
	 */
	protected final Predicate dynamicWhele(CriteriaData<T, V> cd, V v) {
		return dynamicWhele(cd, v, false);
	}
	
	/**
	 * 动态获取查询条件
	 * @param cd
	 * @param v
	 * @param isOrder
	 * 			是否加载排序方式
	 * @return
	 */
	protected final Predicate dynamicWhele(CriteriaData<T, V> cd, V v, boolean isOrder) {
		// 查询条件
		List<Predicate> wheles = new ArrayList<Predicate>();
		// 排序方式
		List<Order> orders = new ArrayList<>();
		// 获取当前查询对象的所有属性(包括父类)
		Field[] fields = ReflectUtil.getFields(v.getClass());
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				
				if (isOrder) {
					// 根据@JpaOrderBy注解动态获取排序方式
					dynamicOrderBy(cd.getRoot(), cd.getCriteriaBuilder(), v, field, orders);
				}
				
				// 根据@JpaQuery注解动态获取查询条件
				JpaQuery jq = field.getAnnotation(JpaQuery.class);
				if (jq != null && jq.verify().verify(field.get(v))) {
					Conditional pType = jq.cond();
					if (pType != Conditional.SELECT) {
						// 动态获取查询条件
						wheles.add(pType.predicate(cd.getRoot(), cd.getCriteriaBuilder(), v, field, jq));
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		additionalWhele(cd, wheles, v);
		if (!orders.isEmpty()) {
			cd.getCriteriaQuery().orderBy(orders);
		}
		return cd.getRestriction(wheles);
	}
	
	/**
	 * 附加查询条件-给子类实现
	 * @param wheles
	 */
	protected List<Predicate> additionalWhele(CriteriaData<T, V> cd, List<Predicate> wheles, V v) {
		return wheles;
	}
	
	/**
	 * 动态获取排序方式
	 * @param root
	 * @param cb
	 * @param v
	 * @param field
	 * @param orders
	 * @return
	 */
	private List<Order> dynamicOrderBy(Root<T> root, CriteriaBuilder cb, V v, Field field, List<Order> orders) {
		// 根据@JpaOrderBy注解动态获取排序条件
		JpaOrderBy orderBy = field.getAnnotation(JpaOrderBy.class);
		if (orderBy != null) {
			Path<?> path = root.get(field.getName());
			String chain = orderBy.chain();
			if (!StrUtil.isBlank(chain)) {
				path.get(chain);
			}
			orders.add(orderBy.sort(), orderBy.type().order(cb, path));
		}
		return orders;
	}
	
	/**
	 * 动态构建查询条件
	 * @param v
	 * @return
	 */
	public Specification<T> getSpecification (V v) {
		return new Specification<T>() {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return dynamicWhele(criteriaData.clone(root, query, cb), v, true);
			}
		};
	}
}
