package com.cypay.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cypay.common.config.InitialLoader;
import com.cypay.common.service.impl.LineService;
import com.cypay.common.service.impl.SystemSetService;
import com.cypay.common.util.RegExpUtil;
import com.cypay.common.vo.Result;

import cn.hutool.core.util.ReUtil;

/**
 * 路径中转
 * 
 * @author iwano
 *
 */
@Controller
public class TransferController {
	
	@Autowired
	private LineService lineService;
	
	@Autowired
	private SystemSetService systemSetService;
	
	@GetMapping(value = "/")
	public String root(HttpServletRequest request) {
		String domain = request.getServerName();
		Integer type = lineService.getTypeByDomain(request);
		
		if (InitialLoader.communicationUrl.contains(domain))
			type = 1;
		
		// domain未配置，且为IP：总管理后台登录
		if (type == null && ReUtil.isMatch(RegExpUtil.IP, domain)){
			type = 2;
		}
		
		type = type == null ? -1 : type;
		
		switch (type) {
		case 0:
			
			return "forward:/pay/";
		case 1:
			
			return "forward:/mer/login";
		case 2: 
			
			return "manage/login/login";
		default: // domain未配置，拒绝访问
			
			return "forward:/mer/login";
		}
	}
	
	/**
	 * 线路测试
	 * @return
	 */
	@PostMapping(value = "/test-line")
	public @ResponseBody Result testLine() {
		return Result.success();
	}
	
	/**
	 * 系统授权
	 * @param token
	 * @return
	 */
	@PostMapping(value = "/authorize")
	public @ResponseBody Object oAuth(@RequestParam(value = "type") String type, @RequestParam(value = "code") String code, HttpServletRequest request) {
		String serverName = request.getServerName();
		// 只允许通过IP方式访问授权
		if (ReUtil.isMatch(RegExpUtil.IP, serverName)) {
			if ("1".equals(type) || "2".equals(type)) {
				int i = systemSetService.updateTokenByMark(code);
				if (i == 1) {
					if ("1".equals(type)) {
						int port = request.getServerPort();
						if (port != 80 && port != 443) {
							serverName = serverName + ":" + port;
						}
						systemSetService.token(serverName, code);
						InitialLoader.token = code;
					}
					return Result.success("授权成功");
				}
			} else if ("0".equals(type)) {
				return code.equals(InitialLoader.CODE) ? "success" : "failed";
			}
		}
		return Result.error("授权失败");
	}
	
	@GetMapping("/403")
	public String error403() {
		return "error/403";
	}
	
}
