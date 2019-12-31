package com.cypay.common.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cypay.common.entity.Log;
import com.cypay.common.service.impl.LogService;

@Component
public class LogExcute {
	@Autowired
	private LogService logService;
	
	public void log(Log log){
		logService.save(log);
	}
}
