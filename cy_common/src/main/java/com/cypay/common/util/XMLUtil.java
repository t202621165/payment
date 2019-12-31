package com.cypay.common.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.alibaba.fastjson.JSONObject;

/**
 * XML工具类
 * 
 * @author International
 * @2019年1月7日 下午5:38:52
 */
public class XMLUtil {
	
	private static Logger logger = LoggerFactory.getLogger(XMLUtil.class);

	/**
	 * 将对象转为xml格式
	 * 
	 * @param clazz
	 * @return
	 */
	public static String toXML(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		StringBuilder buf = new StringBuilder();
		buf.append("<xml>");
		for (Field field : fields) {
			field.setAccessible(true);
			
			try {
				buf.append("<").append(field.getName()).append(">");
				buf.append("<![CDATA[").append(field.get(obj)).append("]]>");
				buf.append("</").append(field.getName()).append(">");
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		buf.append("</xml>");
		return buf.toString();
	}

	/**
	 * 解析xml为json对象
	 * 
	 * @param xml
	 * @param charset
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject parseXmlToJson(String xml, String charset) {
		try {
			JSONObject json = new JSONObject();
			SAXReader reader = new SAXReader(false);
			reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
			reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			InputSource source = new InputSource(new ByteArrayInputStream(xml.getBytes()));
			source.setEncoding(charset);
			List<Element> elements = reader.read(source).getRootElement().elements();
			elements.parallelStream().forEach(el -> {
				json.put(el.getName(), el.getTextTrim());
			});
			return json;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 解析RequestBody
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request) {
		Map<String, String> data = new HashMap<String, String>();
		try {
			// 从request中取得输入流
			InputStream inputStream = request.getInputStream();
			// 读取输入流
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputStream);
			// 得到xml根元素
			Element root = document.getRootElement();
			// 得到根元素的所有子节点
			
			List<Element> elements = root.elements();
			data = elements.parallelStream().collect(Collectors.toMap(Element::getName, Element::getTextTrim));
			inputStream.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return data;
	}
}
