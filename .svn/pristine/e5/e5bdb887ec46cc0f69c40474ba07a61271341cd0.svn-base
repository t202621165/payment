package com.cypay.common.util;

import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hutool.core.date.DateUtil;

public class DUtil extends DateUtil {
	
	private static Logger logger = LoggerFactory.getLogger(DUtil.class);
	
	private DUtil() {
		DUtil.logger.error("Utility Class: " + this.getClass());
	}
	
	/**
	 * 根据特定格式格式化当天日期
	 * @param format
	 * @return
	 */
	public static String format(String format) {
		return format(new Date(), format);
	}
	
	public static Date currentDate(Date date,String pattern){
		return parse(format(date, pattern), pattern);
	}
	
	/**
	 * 获取当天的开始时间：yyyy-MM-dd 00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date beginOfToday() {
		return beginOfDay(new Date());
	}
	
	/**
	 * 获取当天的结束时间：yyyy-MM-dd 23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date endOfToday() {
		return endOfDay(new Date());
	}
	
	/**
	 * 偏移天-从当天日期开始
	 * 
	 * @param offset 偏移天数，正数向未来偏移，负数向历史偏移
	 * @return 偏移后的日期
	 */
	public static Date offsetDay(int offset) {
		return offsetDay(new Date(), offset);
	}
	
	
	/**
	 * 获取当天日期偏移指定天数后的开始时间
	 * 
	 * <pre>
	 * 比如：当天日期为：2019-01-01 10:10:10 
	 * >> 偏移天数为：5 >> 2019-01-06 10:10:10
	 * >> 最后日期为：2019-01-01 00:00:00
	 * </pre>
	 * @param offset 偏移天数，正数向未来偏移，负数向历史偏移
	 * @return 偏移后的日期
	 */
	public static Date beginOfDayByOffsetDay(int offset) {
		return beginOfDay(offsetDay(offset));
	}
	
	/**
	 * 获取当天指定天数内的所有日期
	 * @param pattern
	 * @param counts
	 * @return
	 */
	public static Object[] getDayArray(Integer counts) {
		return getDayArray(counts, new Date());
	}
	
	public static Object[] getDayArray(Integer counts, Date date) {
		String[] dates = new String[counts];
		int index = counts-1;
		for (int i = 0; i < counts; i++) {
			dates[i] = offsetDay(date, -index--).toString("yyyy-MM-dd");
		}
		return dates;
	}
	
	/**
	 * 获取指定偏移后的结束时间
	 * @param offset
	 * @return
	 */
	public static Date endOfOffsetDay(int offset) {
		return endOfDay(offsetDay(offset));
	}
	
	public static long getNetworkTime(String format) {
		try {
			URL url = new URL("http://www.baidu.com");// 取得资源对象
			URLConnection uc = url.openConnection();// 生成连接对象
			uc.setReadTimeout(5000);// 设置访问超时时间 5s
			uc.connect();// 发出连接
			long ld = uc.getDate();// 读取网站日期时间
			return new Date(ld).getTime();// 转换为标准时间对象
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parse("2010-10-01").getTime();
	}
	
}
