package com.cypay.payment;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cypay.common.entity.Gallery;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Order;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.Product;
import com.cypay.common.vo.OrderVo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class MyTest2 {

	public static void main(String[] args) {
//		System.out.println(IdUtil.fastSimpleUUID());
//		System.out.println(IdUtil.fastSimpleUUID());
//		System.out.println(IdUtil.fastSimpleUUID());
//		System.out.println(IdUtil.fastSimpleUUID());
//		System.out.println(IdUtil.fastSimpleUUID());
//		System.out.println(IdUtil.fastSimpleUUID());
//		try {  
//	        long start = System.currentTimeMillis();  
//	        Process process = Runtime.getRuntime().exec(  
//	        new String[] { "wmic", "cpu", "get", "ProcessorId" });  
//	        process.getOutputStream().close();  
//	        Scanner sc = new Scanner(process.getInputStream());  
//	        String property = sc.next();  
//	        String serial = sc.next();  
//	        System.out.println(property + ": " + serial);  
//	        System.out.println("time:" + (System.currentTimeMillis() - start));  
//	    } catch (IOException e) {  
//	        e.printStackTrace();  
//	    } 
//		test();
		excelReader();
	}
	
	public static void strTest() {
		int count = 100000;
		String[] arr = new String[count];
		for (int i = 0; i < count; i++) {
			arr[i] = String.valueOf(i);
		}
		StringBuilder s2 = new StringBuilder();
		long start = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			s2.append(i);
		}
		System.out.println("StringBuilder：" + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		String.join("", arr);
		System.out.println("String.join：" + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		StringUtils.join(arr);
		System.out.println("StringUtils.join：" + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		org.apache.commons.lang.StringUtils.join(arr);
		System.out.println("StringUtils.join：" + (System.currentTimeMillis() - start));
	}

	public static void test() {
		Order order = new Order();
		Date d = new Date();
		Date p = DateUtil.offsetSecond(d, 600);
		order.setOrderNumber("p" + d.getTime());
		int amount = 1000;
		order.setAmount(new BigDecimal(amount));
		order.setOrderDate(new Date());
		order.setGallery(new Gallery(6L));
		order.setMerchant(new Merchant(1L));
		order.setProduct(new Product(9L));
		order.setPartition(new Partition(1L));
		order.setDiscription("传奇");
		order.setPlayerAccount("iwanol");
		order.setPlayerIp("114.55.94.50");
		order.setState(1);
		order.setTailAmount(new BigDecimal("0.98"));
		order.setVersion(1);
		order.setGiveAmount(new BigDecimal(amount));
		order.setPayDate(p);
		order.setPayAmount(new BigDecimal(amount));
		order.setPlatformProfit(new BigDecimal(amount * 0.05));
		order.setMerchantProfit(new BigDecimal(amount * 0.9));
		order.setSupNumber("sup" + p.getTime());
		order.setRemarks("元宝x10000");
		BeanCopier copier = BeanCopier.create(Order.class, OrderVo.class, false);
		OrderVo v = new OrderVo();
//		copier.copy(order, v, null);
//		System.out.println(JSON.toJSONString(v));
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			copier.copy(order, v, null);
		}
		System.out.println("BeanCopier: " + (System.currentTimeMillis() - start) + "ms");
	}
	
	public static void excelReader() {
		String filePath = "D:\\P77045482451820544.xlsx";
		ExcelReader reader = ExcelUtil.getReader(filePath);
		List<List<Object>> readAll = reader.read();
		System.out.println(readAll);
		List<Map<String,Object>> readAll2 = reader.readAll();
		System.out.println(readAll2);
	}
	
	private static void timer(Consumer<?> consumer) {
		long start = System.currentTimeMillis();
		consumer.accept(null);
		System.out.printf("耗时：%sms.\r\n", System.currentTimeMillis() - start);
	}
	
	private static int fib(int n) {
		if (n <= 2) {
			System.out.println("end: " + n);
			return n;
		}
		int m = fib(n - 1) + fib(n - 2);
		System.out.println("fib - "+n+": " + m);
		return m;
	}
}
