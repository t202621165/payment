package com.cypay.common.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.cypay.common.entity.User;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.service.BaseService;
import com.cypay.common.service.CriteriaData;
import com.cypay.common.service.JpaCriteriaQuery;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.PageData;
import com.cypay.common.util.SnowflakeIdWorker;
import com.cypay.common.vo.Result;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

@Service
public abstract class BaseServiceImpl<R extends BaseRepository<T, Long>, T, V> extends JpaCriteriaQuery<T, V> implements BaseService<R, T, V> {

	@Autowired
	protected R baseRepository;

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	protected RestTemplate restTemplate;
	
	@Autowired
	protected SnowflakeIdWorker snowflakeIdWorker;
	
	@Autowired
	protected ApplicationContext applicationContext;
	
	protected ExecutorService futureTaskPool = Executors.newCachedThreadPool();
	
	/**
	 * 系统本次启动生成的唯一标识
	 */
	protected static final String CODE = IdUtil.fastSimpleUUID();
	
	/**
	 * 系统授权token
	 */
	public static String token = "";
	
	/**
	 * 加载所有通道枚举
	 */
	public static final Map<String, PaymentType> PAYMENT_ENUMS = EnumUtil.getEnumMap(PaymentType.class);

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public BaseRepository<T, Long> getRepository() {
		return baseRepository;
	}

	public boolean isExist(T t) {
		return false;
	}
	
	protected User getUserLogin() {
		return ShiroManager.getUser();
	}
	
	/**
	 * 添加
	 */
	@Override
	public Result save(T t) {
		if (isExist(t))
			return Result.error("添加失败，已存在当前记录！");
		baseRepository.save(t);
		return Result.success("添加成功！");
	}

	/**
	 * 批量添加
	 */
	@Override
	public Result saveAll(List<T> list) {
		if (list == null || list.isEmpty())
			return Result.error("添加失败！");

		baseRepository.saveAll(list);
		return Result.success("批量添加成功！");
	}

	@Transactional
	@Override
	public T update(T t) {
		return baseRepository.save(t);
	}

	/**
	 * 根据ID删除
	 */
	@Transactional
	@Override
	public Result deleteById(Long id) {
		baseRepository.deleteById(id);
		return Result.success("删除成功！");
	}

	/**
	 * 根据ID查询
	 */
	@Override
	public T findById(Long id) {
		Optional<T> optional = baseRepository.findById(id);

		if (optional.isPresent())
			return optional.get();

		return null;
	}

	/**
	 * 查询所有记录
	 */
	@Override
	public List<T> findAll() {
		return baseRepository.findAll();
	}

	@Override
	public List<T> findAll(V v) {
		return baseRepository.findAll(super.getSpecification(v));
	}

	@Override
	public Page<T> findAll(V v, PageData pageData) {
		return baseRepository.findAll(super.getSpecification(v), pageData.ofPageable());
	}
	
	@Override
	public Page<T> findAll(PageData pageData) {
		return baseRepository.findAll(pageData.ofPageable());
	}

	@Override
	public T findOne(V v) {
		Optional<T> optional = baseRepository.findOne(super.getSpecification(v));
		if (optional.isPresent())
			return optional.get();
		return null;
	}

	@Override
	public Long count() {
		return baseRepository.count();
	}
	
	@Override
	public Long count(V v) {
		return baseRepository.count(super.getSpecification(v));
	}
	
	/**
	 * 自定义查询字段-分页查询
	 * 
	 * @param v
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<V> findVoPageList(V v, PageData pageData) {
		Assert.notNull(v, "V cannot be null.");
		Assert.notNull(pageData, "PageData cannot be null.");
		
		CriteriaData<T, V> cd = this.getCriteriaData(this.getClass().getName(), v);
		
		// 动态获取查询条件
		Predicate predicate = super.dynamicWhele(cd, v);
		
		return PageableExecutionUtils.getPage(cd.getResultList(pageData), pageData.ofPageable(),
				() -> getRepository().count(this.getSecification(predicate)));
	}
	
	protected Specification<T> getSecification(Predicate predicate) {
		return new Specification<T>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return predicate;
			}
		};
	}

	/**
	 * 自定义字段-不分页
	 * @param v
	 * @return
	 */
	public List<V> findVoList(V v) {
		Assert.notNull(v, "V cannot be null.");
		
		CriteriaData<T, V> cd = this.getCriteriaData(this.getClass().getName(), v);
		
		// 动态获取查询条件
		super.dynamicWhele(cd, v);
		
		return cd.getResultList();
	}
	
	public void doExcel(String filename, List<?> data, HttpServletResponse response, Consumer<ExcelWriter> consumer) {
		if (CollUtil.isNotEmpty(data)) {
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition","attachment;filename=" + filename + ".xlsx");
			
			ExcelWriter writer = ExcelUtil.getWriter();
			
			if (consumer != null) {
				consumer.accept(writer);
			}
			
			writer.write(data, true);
			ServletOutputStream out = null;
			try {
				out = response.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				writer.flush(out, true);
				writer.close();
				IoUtil.close(out);
			}
		}
	}

}
