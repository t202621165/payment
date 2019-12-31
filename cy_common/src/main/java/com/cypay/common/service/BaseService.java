package com.cypay.common.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cypay.common.repository.BaseRepository;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.Result;

/**
 * 公共service
 * @author leo
 *
 * @param <T>
 */
public interface BaseService <R extends BaseRepository<T, Long>, T,V> {
	/**
	 * 新增
	 * @param t
	 * @return
	 */
	Result save(T t);
	
	/**
	 * 批量新增
	 * @param t
	 * @return
	 */
	Result saveAll(List<T> list);
	
	/**
	 * 更新实体
	 * @param t
	 * @return
	 */
	T update(T t);
	
	
	/**
	 * 通过ID删除实体
	 * @param id
	 */
	Result deleteById(Long id);
	
	/**
	 * 通过id查找实体
	 * @param id
	 * @return
	 */
	T findById(Long id);
	
	/**
	 * 查询所有实体列表
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 分页查询 (自定义查询字段)
	 * @param v
	 * @param pageable
	 * @return
	 */
	Page<V> findVoPageList(V v, PageData pageData);
	
	/**
	 * 动态查询条件分页查询
	 * @param pageable
	 * @param v
	 * @return
	 */
	Page<T> findAll(V v, PageData pageData);
	
	/**
	 * 分页查询
	 * @param pageable
	 * @param v
	 * @return
	 */
	Page<T> findAll(PageData pageData);
	
	/**
	 * 动态查询条件查询(不分页)
	 * @param v
	 * @return
	 */
	List<T> findAll(V v);
	
	T findOne(V v);
	
	/**
	 * 查询记录条数
	 * @return
	 */
	Long count();
	
	/**
	 * 动态条件查询记录条数
	 * @param v
	 * @return
	 */
	Long count(V v);
}
