package com.cypay.common.shiro.filter;

import java.io.PrintWriter;
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

import com.alibaba.fastjson.JSON;
import com.cypay.common.service.impl.SystemSetService;
import com.cypay.common.vo.Result;

/**
 * 过滤器-总后台域名
 * @author International
 *
 */
@Component
public class LineToManFilter extends AccessControlFilter {
	
	@Autowired
	private SystemSetService systemSetService;
	
	private static final Set<String> ANON_URI = new HashSet<>(Arrays.asList("/man/logout", "/man/authorize", "/man/alipay/notify"));
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object obj) throws Exception {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		String uri = req.getRequestURI();
		if (ANON_URI.contains(uri)) {
			return true;
		}
		
		boolean isAjax = false;
		if ("XMLHttpRequest".equalsIgnoreCase(req.getHeader("X-Requested-With"))) {
			isAjax = true;
		}
		
		if (!systemSetService.oAuth(req)) {
			if (isAjax) {
				res.setContentType("application/json;charset=UTF-8");
				PrintWriter writer = res.getWriter();
				writer.write(JSON.toJSONString(Result.error("系统已到期,请联系平台商续约")));
				writer.flush();
				writer.close();
				return false;
			} else {
				res.sendRedirect("/403");
			}
		}
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		return false;
	}

}
