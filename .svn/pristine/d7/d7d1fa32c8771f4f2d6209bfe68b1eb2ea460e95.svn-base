package com.cypay.common.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.cypay.common.entity.MerchantLog;
import com.cypay.common.repository.impl.MerchantLogRepository;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.vo.Result;

import cn.hutool.core.date.DateUtil;

@Service
public class MerchantLogService extends BaseServiceImpl<MerchantLogRepository, MerchantLog, MerchantLog> {

	public Result deleteLog() {
		int i = baseRepository.deleteLog(
				ShiroManager.getMerchant(), DateUtil.offsetDay(new Date(), -3));
		if (i < 1)
			return Result.error("已清理【"+i+"条】日志！");
		
		return Result.success("已清理【"+i+"条】日志！");
	}

}
