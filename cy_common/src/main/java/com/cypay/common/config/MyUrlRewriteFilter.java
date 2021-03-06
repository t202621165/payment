package com.cypay.common.config;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;
public class MyUrlRewriteFilter extends UrlRewriteFilter{
	
	private final static String CONFIG_LOCATION = "classpath:/urlrewrite.xml";
	
	@Value(CONFIG_LOCATION)
	private Resource resource;
	
	@Override
	protected void loadUrlRewriter(FilterConfig arg0) throws ServletException {
		try {
			Conf conf = new Conf(arg0.getServletContext(), 
					resource.getInputStream(), resource.getFilename(),"@@payment@@");
			checkConf(conf);
		} catch (IOException e) {
			throw new ServletException(
					"Unable to load URL rewrite configuration file from " + CONFIG_LOCATION, e);
		}
	}
}
