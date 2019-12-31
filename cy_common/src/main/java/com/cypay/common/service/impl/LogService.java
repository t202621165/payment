package com.cypay.common.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cypay.common.entity.Log;
import com.cypay.common.repository.impl.LogRepository;
import com.cypay.common.vo.Result;

@Service
public class LogService extends BaseServiceImpl<LogRepository, Log,Log>{

	/**
	 * 获取管理员最后一次登录日志
	 * @param id
	 * @return
	 */
	public Map<String, Object> findLastLoginByUser(Long userId){
		return baseRepository.findLastLoginByUser(userId);
	}
	
	public Result deleteBeforeWeek(Date date){
		int i = baseRepository.deleteBeforeWeek(date);
		if (i > 0)
			return Result.success("日志清除成功");
		else
			return Result.error("暂无可清除的日志数据");
	}

}
