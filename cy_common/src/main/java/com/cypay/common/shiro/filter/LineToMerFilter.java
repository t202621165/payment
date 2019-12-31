package com.cypay.common.shiro.filter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cypay.common.service.impl.LineService;
import com.cypay.common.service.impl.SystemSetService;

/**
 * 过滤器-商户域名
 * @author International
 *
 */
@Component
public class LineToMerFilter extends AccessControlFilter {
	
	@Autowired
	private LineService lineService;
	
	@Autowired
	private SystemSetService systemSetService;
	
	private static final Set<String> ANON_URI = new HashSet<>(Arrays.asList("/mer/wechat-bind"));
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object obj) throws Exception {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		if (ANON_URI.contains(req.getRequestURI())) {
			return true;
		}
		
		if (lineService.isPass(1, req)) {
			
			if ("GET".equalsIgnoreCase(req.getMethod())) {
				req.getSession().setAttribute("title", systemSetService.findWebInfo().getWebName());
			}
			return true;
		} else {
			res.sendRedirect("/");
		}
		
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		return false;
	}

}
