package com.cypay.common.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.cypay.common.util.PageData;

import cn.hutool.core.collection.CollUtil;

/**
 * 创建JPA标准化查询
 * @author International
 * @param <T>
 * @2019年4月2日 下午6:35:54
 * @param <T>
 * 			查询对象-对应数据库表实体
 * @param <V>
 * @param <V>
 * 			查询条件-动态构建查询条件
 */
@SuppressWarnings("unchecked")
@Component
public class CriteriaData<T, V> implements Cloneable {
	
	@Autowired
	protected EntityManager entityManager;
	
	private CriteriaBuilder criteriaBuilder;
	
	private CriteriaQuery<?> criteriaQuery;
	
	private Class<T> rootClass;
	
	private Class<V> queryClass;
	
	private Root<T> root;
	// 查询字段
	private List<Selection<?>> selections;
	// 排序方式
	private List<Order> orders;
	
	private boolean isCache = false;
	
	@PostConstruct
	public void init() {
		this.criteriaBuilder = this.entityManager.getCriteriaBuilder();
	}
	
	public void init(Class<?> interfaceClass) {
		Type[] types = ((ParameterizedType) 
				interfaceClass.getGenericSuperclass()).getActualTypeArguments();
		
		this.rootClass = (Class<T>) types[1];
		
		this.queryClass = (Class<V>) types[2];
		
		this.criteriaQuery = this.criteriaBuilder.createQuery(queryClass);
		
		this.root = this.criteriaQuery.from(rootClass);
		
		this.selections = new ArrayList<>();
		
		this.orders = new ArrayList<>();
	}
	
	/**
	 * 获取查询结果
	 * @return
	 */
	public List<V> getResultList() {
		return getResultList(null);
	}
	
	/**
	 * 获取分页查询结果
	 * @param pageData
	 * @return
	 */
	public List<V> getResultList(PageData pageData) {
		setSelectionAndOrderBy();
		TypedQuery<V> query = (TypedQuery<V>) entityManager.createQuery(this.criteriaQuery);
		
		if (pageData != null) {
			Pageable pageable = pageData.ofPageable();
			int pageSize = pageable.getPageSize();
			query.setFirstResult(pageable.getPageNumber() * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.getResultList();
	}
	
	/**
	 * 设置查询字段和排序方式
	 */
	private void setSelectionAndOrderBy() {
		if (CollUtil.isNotEmpty(selections)) {
			this.criteriaQuery.multiselect(selections);
		}
		
		if (CollUtil.isNotEmpty(orders)) {
			this.criteriaQuery.orderBy(orders);
		}
	}
	
	/**
	 * 添加查询Selection
	 * @param selection
	 * @return
	 */
	public CriteriaData<T, V> addSelection(Selection<?> selection) {
		this.selections.add(selection);
		return this;
	}
	
	/**
	 * 设置查询条件
	 * @param wheles
	 * @return
	 */
	public Predicate getRestriction(List<Predicate> wheles) {
		this.criteriaQuery.where(wheles.toArray(new Predicate[wheles.size()]));
		return this.criteriaQuery.getRestriction();
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaBuilder;
	}

	public void setCriteriaBuilder(CriteriaBuilder criteriaBuilder) {
		this.criteriaBuilder = criteriaBuilder;
	}

	public CriteriaQuery<?> getCriteriaQuery() {
		return criteriaQuery;
	}

	public void setCriteriaQuery(CriteriaQuery<?> criteriaQuery) {
		this.criteriaQuery = criteriaQuery;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Root<T> getRoot() {
		return root;
	}

	public void setRoot(Root<T> root) {
		this.root = root;
	}

	public List<Selection<?>> getSelections() {
		return selections;
	}

	public void setSelections(List<Selection<?>> selections) {
		this.selections = selections;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public boolean isCache() {
		return isCache;
	}

	public void setCache(boolean isCache) {
		this.isCache = isCache;
	}
	
	public Class<T> getRootClass() {
		return rootClass;
	}

	public void setRootClass(Class<T> rootClass) {
		this.rootClass = rootClass;
	}

	public Class<V> getQueryClass() {
		return queryClass;
	}

	public void setQueryClass(Class<V> queryClass) {
		this.queryClass = queryClass;
	}

	/**
	 * 克隆并初始化
	 * @param interfaceClass
	 * @return
	 */
	public CriteriaData<T, V> clone(Class<?> interfaceClass) {
		CriteriaData<T, V> cd = null;
		try {
			cd = clone();
			cd.init(interfaceClass);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cd;
	}
	
	/**
	 * 缓存克隆
	 * <pre>
	 * 已初始化(rootClass、queryClass、root等属性已被创建)的对象
	 * 
	 * 克隆需重新构建criteriaQuery和root属性
	 * </pre>
	 * @return
	 */
	public CriteriaData<T, V> cacheClone() {
		CriteriaData<T, V> cd = null;
		try {
			cd = clone();
			cd.criteriaQuery = this.criteriaBuilder.createQuery(queryClass);
			cd.root = cd.criteriaQuery.from(rootClass);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cd;
	}
	
	public CriteriaData<T, V> clone(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
		CriteriaData<T, V> cd = null;
		try {
			cd = clone();
			cd.root = root;
			cd.criteriaQuery = criteriaQuery;
			cd.criteriaBuilder = criteriaBuilder;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cd;
	}
	
	@Override
	protected CriteriaData<T, V> clone() throws CloneNotSupportedException {
		return (CriteriaData<T, V>) super.clone();
	}

}
