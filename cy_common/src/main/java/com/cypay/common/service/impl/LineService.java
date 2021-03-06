package com.cypay.common.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cypay.common.config.InitialLoader;
import com.cypay.common.entity.Line;
import com.cypay.common.repository.impl.LineRepository;
import com.cypay.common.util.RegExpUtil;
import com.cypay.common.vo.Result;

import cn.hutool.core.util.ReUtil;

@Service
public class LineService extends BaseServiceImpl<LineRepository, Line, Line> {
	
	@Override
	@Cacheable(key="'line_list'",cacheNames = "line_all")
	public List<Line> findAll() {
		return baseRepository.findAll();
	}
	
	@Cacheable(key="'line_map'",cacheNames = "line_all")
	public Map<String, Integer> findAllAndGroup() {
		return baseRepository.findAll().parallelStream().collect(Collectors.toMap(Line::getDomainName, Line::getType, (v1, v2) -> v2));
	}
	
	public Integer getTypeByDomain(HttpServletRequest request) {
		return ((LineService) AopContext.currentProxy()).findAllAndGroup()
				.get(String.format("%s://%s", request.getScheme(), request.getServerName()));
	}
	
	public boolean isPass(int lineType,HttpServletRequest request) {
		String serverName = request.getServerName();
		Integer type = getTypeByDomain(request);
		if (InitialLoader.communicationUrl.contains(serverName))
			type = 1;
		if (type == null && ReUtil.isMatch(RegExpUtil.IP, serverName)) {
			return true;
		}
		if (type == 3 && lineType == 1)
			return true;
			
		return type != null && type == lineType;
	}
	
	@Override
	public Result save(Line t) {
		baseRepository.save(t);
		return Result.success("【"+ t.getName() +"】"+(t.getId() != null ? "添加":"修改")+"成功");
	}
	
	public List<Line> findByType(Integer type){
		return baseRepository.findByTypeOrderByIsDefaultDesc(type);
	}
	
	public Result lineDefault(Long id,Integer type){
		int i = baseRepository.lineDefault(id,type);
		if (i > 0){
			return Result.success("默认线路设置成功");
		}else{
			return Result.error("默认线路设置失败");
		}
	}
}
