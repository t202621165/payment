package com.cypay.payment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.util.ZipUtil;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class Client {

	private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

	static {
		// 指定加载模板所在的路径
		CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(Client.class, "/template"));
		CONFIGURATION.setDefaultEncoding("UTF-8");
		CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
	}

	public static Template getTemplate(String templateName) throws IOException {
		return CONFIGURATION.getTemplate(templateName);
	}

	public static void clearCache() {
		CONFIGURATION.clearTemplateCache();
	}

	public static void main(String[] args) throws Exception {
		final String templateName = "Entity.java.ftl";
		File file = new File("payment.java");
		Template template = getTemplate(templateName);
		FileOutputStream fos = new FileOutputStream(file);
		List<String> colums = new ArrayList<>();
		colums.add("id");
		colums.add("name");
		colums.add("age");
		colums.add("size");
		colums.add("des");
		Map<String, String> alias = new HashMap<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("tableName", "支付网关");
		map.put("comments", "iwanol");
		map.put("className", "PayByAaa");
		map.put("classname", "PayByAaa");
		map.put("columns", colums);
		map.put("hasBigDecimal", true);
		map.put("package", "com.cypay.pay");
		map.put("moduleName", "payment");
		map.put("author", "Traveler");
		map.put("email", "912656157@qq.com");
		map.put("date", new Date());
		map.put("alias", alias);
		Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
		template.process(map, out);
		ZipUtil.zip(new File("D:/pay.zip"), false, file);
		System.out.println("代码生成完毕！！！");
	}
}
