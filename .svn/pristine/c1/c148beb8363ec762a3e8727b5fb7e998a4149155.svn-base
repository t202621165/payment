package com.cypay.common.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

/**
 * 过滤器-已认证或签名通过
 * @author International
 *
 */
public class AuthcOrFilter extends AccessControlFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object obj) throws Exception {
		Subject subject = getSubject(request, response);
		// 已登陆
		if (subject.getPrincipal() != null)
			return true;
			
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		response.setCharacterEncoding("GBK");
		// 未登录-签名认证
		if ("0".equals(request.getParameter("type")))
			return true;
		
		response.getWriter().print("{\"state\": 0, \"msg\": \"没有足够的访问权限！\"}");
		return false;
	}

}
