package com.cypay.manage.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cypay.common.entity.Log;
import com.cypay.common.service.impl.LogService;
import com.cypay.common.util.DUtil;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.Result;

@RestController
@RequestMapping(value="/man")
public class LogController {

	@Value("${logging.path}")
	private String logPath;
	
	@Autowired
	private LogService logService;
	
	@GetMapping("/log/list")
	public Page<Log> list(Log v,PageData pageData){
		return logService.findAll(v, pageData);
	}
	
	@GetMapping("/log/clear")
	public Result clearLog(){
		return logService.deleteBeforeWeek(DUtil.offsetDay(-7));
	}
	
	@PostMapping("/log/syslog")
	public String sysLog() {
		String logFileName = System.getProperty("user.dir").split(":")[0] + ":" + logPath + "/spring.log";
		File file = new File(logFileName);
		String content = "";
		StringBuilder builder = new StringBuilder();
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while (content != null) {
				content = reader.readLine();
				if (content == null) {
					break;
				}
				builder.append(content).append("\r\n");
			}
		} catch (Exception e) {
			return "无法加载系统日志：" + e.getMessage();
		}
		return builder.toString();
	}
}
