package com.cypay.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.NotParam;

/**
 * 公共工具类
 * 
 * @author leo
 *
 */
public class CommonUtil {

	private static Logger logger = LoggerFactory.getLogger(CommonUtil.class);

	private static final String UNKNOWN = "unknown";

	private CommonUtil() {
		CommonUtil.logger.error("Utility Class: " + this.getClass());
	}

	/**
	 * BigDecimal比较：是否不为null，且大于 0
	 * 
	 * @param decimal
	 * @return
	 */
	public static boolean isDecimal(BigDecimal decimal) {
		if (decimal == null)
			return false;
		return decimal.compareTo(BigDecimal.ZERO) > 0;
	}

	/***
	 * 获取浏览器IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		try {
			String ip = request.getHeader("x-forwarded-for");
			if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
				ip = request.getHeader("http_client_ip");
			}
			if (StringUtils.isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			// 如果是多级代理，那么取第一个非‘unknown’的字符串为客户端ip
			if (!StringUtils.isEmpty(ip)) {
				String[] ips = ip.split(",");
				for (String str : ips) {
					if (!StringUtils.isEmpty(ip) && !UNKNOWN.equalsIgnoreCase(ip))
						return str.trim();
				}
			}
			return ip;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 多字符串拼接
	 * 
	 * @param strings
	 * @return StringBuffer
	 */
	public static StringBuilder getBuffer(Object... strings) {
		final StringBuilder buf = new StringBuilder();
		for (Object object : strings) {
			if (object != null) {
				buf.append(object);
			}
		}
		return buf;
	}

	/**
	 * 多字符串拼接
	 * 
	 * @param strings
	 * @return String
	 */
	public static String getBufferString(Object... strings) {
		return getBuffer(strings).toString();
	}

	/**
	 * 获取当前请求的域名
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestDomain(HttpServletRequest request) {
		if (request == null)
			return null;

		StringBuilder buf = getBuffer(request.getScheme(), "://", request.getServerName());
		if (request.getServerPort() != 80)
			buf.append(":").append(request.getServerPort());

		return buf.toString();
	}

	/**
	 * 域名请求协议检测—默认添加Http
	 */
	public static String getWholeDomainName(String domainName) {
		if (StringUtils.isEmpty(domainName))
			return "";
		String scheme = "";
		int index = domainName.indexOf("://");
		if (index == 4 || index == 5) {
			scheme = domainName.substring(0, index);
		}
		if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
			scheme = "";
		} else {
			scheme = "http://";
		}
		return getBufferString(scheme, domainName);
	}

	/**
	 * 域名请求协议检测—默认添加Http
	 */
	public static String getWholeDomainName(String domainName, Integer port) {
		StringBuilder buf = getBuffer(getWholeDomainName(domainName));
		if (port != 80) {
			buf.append(":").append(port);
		}
		return buf.toString();
	}

	/**
	 * JSONArray字符串转为指定Class<T>对象数组
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> parseArray(String jsonStr, Class<T> clazz) {
		return parseArray(jsonStr, clazz, Collections.emptyList());
	}

	/**
	 * JSONArray字符串转为指定Class<T>对象数组
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @param defaults
	 *            JSON解析异常默认返回
	 * @return
	 */
	public static <T> List<T> parseArray(String jsonStr, Class<T> clazz, List<T> defaults) {
		try {
			Assert.hasText(jsonStr, "The 'jsonStr' to parse cannot be empty or null.");
			return JSON.parseArray(jsonStr, clazz);
		} catch (Exception e) {
			return defaults;
		}
	}

	/**
	 * JSONObject字符串转为指定Class<T>对象
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static <T> T parseObject(String jsonStr, Class<T> clazz) {
		try {
			return JSON.parseObject(jsonStr, clazz);
		} catch (Exception e) {
			return null;
		}
	}

	public static List<Object> getNumberArray(int size) {
		List<Object> array = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			array.add((i < 10 ? "0" + i : i));
		}
		return array;
	}

	public static String truncateHalf(String content, String pattern) {
		if (StringUtils.isEmpty(content))
			return content;

		StringBuilder bf = new StringBuilder();
		char[] array = content.toCharArray();
		for (int i = 0; i < array.length; i++) {
			bf.append((i < content.length() / 2) ? array[i] : pattern);
		}

		return bf.toString();
	}

	/**
	 * 
	 * @param t
	 *            实体对象
	 * @return 签名排序串
	 */
	public static <T> String getSignStr(T t) {
		return joinByPredicate(t,
				field -> field.getAnnotation(NoSignature.class) == null && field.getAnnotation(NotParam.class) == null);
	}

	public static <T> String getQueryString(T t) {
		return joinByPredicate(t, field -> field.getAnnotation(NotParam.class) == null);
	}

	/**
	 * 获取对象属性值为空的所有属性
	 * 
	 * @param t
	 * @return
	 */
	public static <T> String[] getNoValuePropertyNames(T t) {
		Assert.notNull(t, "传递的参数对象不能为空");
		final BeanWrapper beanWrapper = new BeanWrapperImpl(t);
		PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();

		Set<String> noValuePropertySet = new HashSet<>();
		for (PropertyDescriptor pd : pds) {
			Object propertyValue = beanWrapper.getPropertyValue(pd.getName());
			if (propertyValue == null || "".equals(propertyValue)) {
				noValuePropertySet.add(pd.getName());
			} else {
				if (Iterable.class.isAssignableFrom(propertyValue.getClass())) {
					Iterable<?> iterable = (Iterable<?>) propertyValue;
					Iterator<?> iterator = iterable.iterator();
					if (!iterator.hasNext())
						noValuePropertySet.add(pd.getName());
				}
				if (Map.class.isAssignableFrom(propertyValue.getClass())) {
					Map<?, ?> map = (Map<?, ?>) propertyValue;
					if (map.isEmpty())
						noValuePropertySet.add(pd.getName());
				}
			}
		}

		String[] result = new String[noValuePropertySet.size()];
		return noValuePropertySet.toArray(result);
	}

	public static BigDecimal tailAmount(String scope) {
		Random rand = new Random();
		float f = rand.nextFloat();
		BigDecimal tailAmount = BigDecimal.valueOf(f).setScale(2, RoundingMode.FLOOR);
		if (tailAmount.compareTo(new BigDecimal(scope)) < 0) {
			tailAmount = tailAmount(scope);
		}
		return tailAmount;
	}

	/**
	 * SQL注入过滤
	 * 
	 * @param str
	 *            待验证的字符串
	 */
	public static String sqlInject(String str) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}

		// 去掉'|"|;|\字符
		str = StringUtils.replace(str, "'", "");
		str = StringUtils.replace(str, "\"", "");
		str = StringUtils.replace(str, ";", "");
		str = StringUtils.replace(str, "\\", "");

		// 转换成小写
		String sql = str.toLowerCase();

		// 非法字符
		String[] keywords = { "master", "truncate", "insert", "select", "delete", "update", "declare", "alter",
				"drop" };

		// 判断是否包含非法字符
		for (String keyword : keywords) {
			if (sql.indexOf(keyword) != -1) {
				return null;
			}
		}

		return str;
	}

	/**
	 * 根据List集合大小自动获取列并拆分为表格格式
	 * @param minColum
	 * 			最小列
	 * @param maxColum
	 * 			最大列
	 * @param diff
	 * 			行查
	 * @param list
	 * 		需要拆分的集合	
	 * @return
	 */
	public static <T> List<List<T>> listToAutoColumFormat(int minColum, int maxColum, int diff, List<T> list) {
		int size = list.size();
		for (int m = 0, k = maxColum - minColum; m <= k; m++) {
			int colum = minColum + m;
			if (size <= (colum + diff) * colum) {
				return listToTableFormat(colum, list);
			} else if (size > (maxColum + diff) * maxColum) {
				return listToTableFormat(maxColum, list);
			}
		}
		return Collections.emptyList();
	}
	
	/**
	 * 将List集合拆分为指定列的表格格式
	 * 
	 * @param column
	 *            表格的列数
	 * @param list
	 *            需要拆分的集合
	 * @return
	 */
	public static <T> List<List<T>> listToTableFormat(int column, List<T> list) {
		List<List<T>> result = new ArrayList<>();
		if (list.size() <= column) {
			result.add(list);
			return result;
		}

		int row = list.size() / column + ((list.size() % column) == 0 ? 0 : 1);
		for (int i = 0; i < row; i++) {
			List<T> rows = new ArrayList<>();
			for (int j = 0; j < column; j++) {
				if ((i * column + j) == list.size()) {
					break;
				}
				rows.add(list.get(i * column + j));
			}
			result.add(rows);
		}
		return result;
	}

	private static <T> String joinByPredicate(T t, Predicate<? super Field> predicate) {
		Field[] fields = t.getClass().getDeclaredFields();
		return Arrays.stream(fields).filter(predicate).map(field -> {
			// 设置字段可访问
			field.setAccessible(true);
			try {
				return getBufferString(field.getName(), "=", field.get(t));
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return "";
		}).filter(s -> !s.isEmpty()).sorted().collect(Collectors.joining("&"));
	}

	// 去除字符串中的空格、回车、换行符、制表符
	public static String replaceBlank(String str) {
		String dest = "";
		String value = "";
		String change = "";
		if (!StringUtils.isEmpty(str)) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}

		for (int i = 0; i < dest.length(); i++) {
			if (str.codePointAt(i) != 10 && str.codePointAt(i) != 13 && str.codePointAt(i) != 32)
				value += str.charAt(i);
			else
				change = "LOW";
		}

		if (!StringUtils.isEmpty(change))
			return value + "_" + change;

		return value;
	}

	public static String drawRandomCode(int width, int height, BufferedImage verifyImg) {
		Graphics2D graphics = (Graphics2D) verifyImg.getGraphics();
		graphics.setColor(Color.WHITE);// 设置画笔颜色-验证码背景色
		graphics.fillRect(0, 0, width, height);// 填充背景
		graphics.setFont(new Font("微软雅黑", Font.BOLD, 40));
		// 数字和字母的组合
		String baseNumLetter = "0123456789";
		StringBuffer sBuffer = new StringBuffer();
		int x = 10; // 旋转原点的 x 坐标
		String ch = "";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			graphics.setColor(getRandomColor());
			// 设置字体旋转角度
			int degree = random.nextInt() % 30; // 角度小于30度
			int dot = random.nextInt(baseNumLetter.length());
			ch = baseNumLetter.charAt(dot) + "";
			sBuffer.append(ch);
			// 正向旋转
			graphics.rotate(degree * Math.PI / 180, x, 45);
			graphics.drawString(ch, x, 45);
			// 反向旋转
			graphics.rotate(-degree * Math.PI / 180, x, 45);
			x += 48;
		}
		// 画干扰线
		for (int i = 0; i < 6; i++) {
			// 设置随机颜色
			graphics.setColor(getRandomColor());
			// 随机画线
			graphics.drawLine(random.nextInt(width), random.nextInt(height),
					random.nextInt(width), random.nextInt(height));
		}
		// 添加噪点
		for (int i = 0; i < 30; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			graphics.setColor(getRandomColor());

			graphics.fillRect(x1, y1, 2, 2);
		}
		return sBuffer.toString();
	}
	/**
	 * 随机取色
	 */
	private static Color getRandomColor() {
//		Random ran = new Random();
//		Color color = new Color(ran.nextInt(256),
//		ran.nextInt(256), ran.nextInt(256));
		Color color = new Color(0, 0, 0);
		return color;
	}
	
	public static List<?> getQQNumbers(String qqNumbersStr) {
		JSONArray array = new JSONArray();
		try {
			array.addAll(JSONArray.parseArray(qqNumbersStr));
		} catch (Exception e) {}

		return array.parallelStream().filter(a -> {
			if (a instanceof JSONArray) {
				if (((JSONArray) a).size() > 1) {
					return true;
				}
			}
			return false;
		}).collect(Collectors.toList());
	}
	/**
	 * @param html 
	 * @param retFlag
	 * @return 获取html中form value内容
	 */
	public static String getHtmlUrl(String html,String retFlag){
		Pattern p = Pattern.compile("name=\""+retFlag+"\".*?value=\"(.*?)\"");
		Matcher m = p.matcher(html);
		if (m.find())
			return m.group(1);
		return null;
	}
}
