package com.cypay.payment;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.assertj.core.util.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.cypay.common.annotation.jpa.Conditional;
import com.cypay.common.annotation.jpa.JpaQuery;
import com.cypay.common.config.InitialLoader;
import com.cypay.common.entity.Bank;
import com.cypay.common.entity.Gallery;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Order;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.Product;
import com.cypay.common.entity.Rank;
import com.cypay.common.entity.Template;
import com.cypay.common.repository.impl.BankRepository;
import com.cypay.common.repository.impl.MerchantRepository;
import com.cypay.common.repository.impl.PartitionRepository;
import com.cypay.common.repository.impl.RankRepository;
import com.cypay.common.repository.impl.SystemSetRepository;
import com.cypay.common.service.impl.AnalyseService;
import com.cypay.common.service.impl.OrderService;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.DUtil;
import com.cypay.common.util.SnowflakeIdWorker;
import com.cypay.common.vo.RankVo;
import com.cypay.pay.repository.OrderRepository;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class MyTest {

	@Autowired
	public PartitionRepository partitionRepository;

	@Autowired
	public MerchantRepository merchantRepository;
	
	@Autowired
	public OrderRepository pOrderRepository;
	
	@Autowired
	public OrderService orderService;
	
	@Autowired
	public BankRepository bankRepository;
	
	@Autowired
	public RankRepository rankRepository;
	
	@Autowired
	public SystemSetRepository systemSetRepository;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	private SnowflakeIdWorker snowflakeIdWorker;
	
	@Autowired
	public AnalyseService analyseService;

	private static Random r = new Random();
	
	private static final String[] pNames = { "通用", "热血传奇", "传奇世界", "传奇三" };
	
	private static final String[] accounts = {"iwanol", "abu", "2562", "britt", "traveler", "9277", "admin", "9527", "payment_", "admin123"};
	private static final String[] discriptions = {"爱玩在线-⭐", "时空猎人-⭐", "贪玩蓝月-⭐", "热血传奇-⭐"};

	public static void main(String[] args) throws Exception {
		System.out.println("666ss");
		WxMpServiceImpl wms = new WxMpServiceImpl();
		WxMpDefaultConfigImpl wmdc = new WxMpDefaultConfigImpl();
		wmdc.setAppId("wxc3447b7683161b70");
		Map<String, WxMpConfigStorage> configStorages = Maps.newHashMap("232", wmdc);
		wms.setMultiConfigStorages(configStorages);
		String url = wms.buildQrConnectUrl("/wx-login", "snsapi_login", "123");
		System.out.println(url);
//		System.out.println(MyTest.class.getClassLoader().getResource(""));
//		System.out.println(MyTest.class.getClassLoader().getSystemResource(""));
//		String signStr = "partner=10024&ordernumber=68376271877971968&orderstatus=1&paymoney=10.00glhxqkwfq46amaa6pip59u0s4qcf23g1xh7";
//		String sign = SecureUtil.md5(signStr);
//		System.out.println("partner=10024&ordernumber=68376271877971968&orderstatus=1&paymoney=1000&sysnumber=10772019062911114267607&attach=&sign=" + sign);
	}
	
	@Test
	public void tests() {
        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("type", "0");
        requestBody.add("code", InitialLoader.CODE);
		String result = restTemplate.postForObject("https://110.42.2.32/authorize", requestBody, String.class);
		System.out.println(result);
	}
	
	public static void excel() {
		ExcelWriter writer = ExcelUtil.getWriter("D:/aaa.xlsx");
		List<Order> orders = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			orders.add(order());
		}
		writer.write(orders, true);
		writer.close();
	}
	
	public static void xml() throws Exception {
		Document doc = XmlUtil.readXML(new File("D:/spring.xml"));
		NodeList node = doc.getElementsByTagName("bean");
		for (int i = 0; i < node.getLength(); i++) {
			Element ele = (Element) node.item(i);
			System.out.println("id: " + ele.getAttribute("id") + ", class: " + ele.getAttribute("class"));
		}
		
		// 1、创建DocumentBuilderFactory，由newInstance()方法获取工厂实例
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		// 2、由工厂创建DocumentBuilder
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 3、读取xml文档创建dom对象
		Document document = builder.parse(MyTest.class.getClassLoader().getResourceAsStream("spring.xml"));
//		Document document = builder.parse("src\\test\\resources\\spring.xml");
		Element element = document.getElementById("dataSource");
		System.out.println(element);
		System.out.println(document.getElementsByTagName("bean").getLength());
	}
	
	public static Order order() {
		Order order = new Order();
		order.setOrderNumber(String.valueOf(IdUtil.createSnowflake(r.nextInt(32), r.nextInt(32)).nextId()));
		Integer amount = (r.nextInt(7) + 3) * 100;
		order.setAmount(new BigDecimal(amount));
		order.setOrderDate(DateUtil.offsetMinute(new Date(), 500));
		order.setGallery(new Gallery(1L));
		order.setProduct(new Product(Long.valueOf(r.nextInt(10) + 3)));
		int mid = r.nextInt(10) + 1;
		order.setMerchant(new Merchant(Long.valueOf(mid)));
//		order.setGroup(new Group(Long.valueOf(r.nextInt(2) + 1)));
		order.setPartition(new Partition(Long.valueOf(r.nextInt(10) + 50)));
		order.setPlayerAccount(RandomUtil.randomString(8));
		order.setPlayerIp(getIp());
		order.setState(1);
		order.setVersion(1);
		order.setGiveAmount(new BigDecimal(amount));
		// 计算商户利润、平台利润
		Double rate1 = Double.valueOf(String.format("%.2f", Math.random()));
		rate1 = rate1 >= 1 ? rate1 - 0.05 : rate1;
		Double rate2 = Double.valueOf(String.format("%.2f", Math.random()));
		rate2 = rate2 >= 1 ? rate2 - 0.05 : rate2;

		Double rate = Math.abs(rate1 - rate2);
		order.setPayDate(DateUtil.offsetMinute(new Date(), 495));
		order.setPayAmount(new BigDecimal(amount));
		order.setPlatformProfit(new BigDecimal(amount * rate));
		order.setMerchantProfit(new BigDecimal(amount * rate1));
		order.setSupNumber("sup" + IdUtil.createSnowflake(r.nextInt(32), r.nextInt(32)).nextId());
		order.setRemarks("元宝x" + (amount * 100));
		return order;
	}
	
	public static void dynamic() {
		List<String> selects = new ArrayList<>();
		List<String> wheles = new ArrayList<>();
		Field[] fields = ReflectUtil.getFields(RankVo.class);
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(JpaQuery.class)) {
				JpaQuery query = field.getAnnotation(JpaQuery.class);
				String value = query.value();
				String fieldName = "".equals(value) ? field.getName() : value;
				if (query.select()) {
					String[] chain = query.chain();
					if (chain.length > 0) {
						for (String c : chain) {
							selects.add(fieldName + "." + c);
						}
					} else {
						selects.add(fieldName);
					}
				}
				
				Conditional pType = query.cond();
				if (pType != Conditional.SELECT) {
					String[] subField = query.subField();
					for (String s : subField) {
						fieldName = fieldName + "." + s;
					}
					wheles.add(fieldName + "：" + pType);
				}
			}
		}
		System.out.println("_________________________________");
		selects.forEach(System.out::println);
		System.out.println("_________________________________");
		wheles.forEach(System.out::println);
	}
	
	public static void f(char data[], int k) { // 当前关注点k
		if (k == data.length) {
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
		// 把第一个元素放这里，后面的元素再进行全排列
		// 后面的元素不能简单放过来：会覆盖！！交换即可。
		for (int i = k; i < data.length; i++) { // 循环中的递归就是出口
			// 将数组每个元素和后面的元素进行交换，然后递归
			{
				char temp = data[k]; // 试探
				data[k] = data[i];
				data[i] = temp;
			}
			f(data, k + 1);
 
			{
				char temp = data[k];
				data[k] = data[i];
				data[i] = temp;
			}
		}
	}
	
	@Test
	public void test() {
		Merchant m = new Merchant(1L);
//		m.setAccount("iwanol");
//		m.setUuid(IdUtil.fastSimpleUUID());
//		m.setPassword(new Md5Hash("000000", m.getUuid()).toHex());
//		m.setSecretKey(IdUtil.fastSimpleUUID());
//		merchantRepository.save(m);
		Bank b = new Bank();
		b.setMerchant(m);
		bankRepository.save(b);
	}
	
	@Test
	public void insertMerchant() {
		List<Merchant> list = new ArrayList<Merchant>();
		Rank rank = new Rank(2L);
		for (int i = 0; i < 10; i++) {
			Merchant m = new Merchant();
			m.setAccount(RandomUtil.randomString(8));
			m.setNickname(RandomUtil.randomString(8));
			m.setType(Boolean.TRUE);
			m.setSettlementType(r.nextInt(2));
			m.setQqNumber(r.nextInt(89999) + 10000 + "");
			m.setSecretKey(UUID.randomUUID().toString().replaceAll("-", ""));
			m.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			m.setPassword(new Md5Hash("000000", m.getUuid()).toHex());
			m.setState(r.nextInt(3));
			m.setRank(rank);
			m.setJoinDate(DateUtil.offsetMinute(new Date(), i - 8 * 100));
			m.setFinalDate(DateUtil.offsetMinute(new Date(), i - 8 * 90));
			list.add(m);
		}
//		merchantRepository.saveAll(list);
	}

	@Test
	public void insertPartition() {
		List<Partition> list = new ArrayList<Partition>();
		for (int i = 0; i < 100; i++) {
			Partition p = new Partition();
			Integer type = r.nextInt(4);
			p.setName(pNames[type] + i);
			p.setUseDate(new Date());
			p.setUseName(pNames[type] + i);
			p.setState(r.nextBoolean());
			p.setType(type);
			p.setSort(i + 3);
			p.setServerIp(getIp());
			p.setYbEgg(r.nextBoolean());
			p.setScriptPath("D:/" + pNames[type] + i);
			p.setMerchant(new Merchant(Long.valueOf(r.nextInt(10) + 1)));
			p.setTemplate(new Template(Long.valueOf(type == 0 ? 4 : type)));
			p.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			list.add(p);
		}
//		partitionRepository.saveAll(list);
	}
	
	public void batch() {
		for (int i = 2; i < 15; i++) {
			
		}
	}

	@Test
	public void insertOrder() {
		for (int j = 0; j < 60; j++) {
			int day = j - 10;
			
			List<Order> list = new ArrayList<Order>();
			Long start = System.currentTimeMillis();
			Merchant agent = new Merchant(1L);
			for (int i = 0; i < 1000; i++) {
				Order order = new Order();
				order.setOrderNumber(String.valueOf(snowflakeIdWorker.nextId()));
				Integer amount = (r.nextInt(16) + 5) * 100;
				order.setAmount(new BigDecimal(amount));
//				order.setOrderDate(DateUtil.offsetMinute(new Date(), i - 500));
				
				order.setOrderDate(DateUtil.offsetSecond(DUtil.beginOfDayByOffsetDay(day), (i + 1) * 60));
				order.setGallery(new Gallery(new Long(r.nextInt(9) + 1)));
				int mid = r.nextInt(2) + 1;
//				int mid = 1;
				order.setMerchant(new Merchant(Long.valueOf(mid)));
				if (mid != 1)
					order.setAgent(agent);
				order.setProduct(new Product(Long.valueOf(r.nextInt(15) + 1)));
//				order.setGroup(new Group(Long.valueOf(r.nextInt(2) + 1)));
//				order.setPartition(new Partition(Long.valueOf(r.nextInt(3) + 1)));
//				order.setGroup(new Group(Long.valueOf(mid)));
				int pid = r.nextInt(2) + (mid * 2 - 1);
				order.setPartition(new Partition(Long.valueOf(pid)));
				order.setDiscription(discriptions[pid-1]);
				order.setPlayerAccount(accounts[r.nextInt(10)]);
				order.setPlayerIp(getIp());
				Integer state = r.nextInt(3);
				order.setState(state);
				order.setTailAmount(new BigDecimal(Math.random()));
				order.setTailRate(new BigDecimal((r.nextInt(7) + 2)*10));
				if (state != 0) {
					order.setVersion(1);
					order.setGiveAmount(new BigDecimal(amount));
					// 计算商户利润、平台利润
					Double rate1 = Double.valueOf(String.format("%.2f", Math.random()));
					rate1 = rate1 >= 1 ? rate1 - 0.05 : rate1;
					Double rate2 = Double.valueOf(String.format("%.2f", Math.random()));
					rate2 = rate2 >= 1 ? rate2 - 0.05 : rate2;
					
					Double rate = Math.abs(rate1 - rate2);
//					order.setPayDate(DateUtil.offsetMinute(new Date(), i - 495));
					order.setPayDate(DateUtil.offsetSecond(DUtil.beginOfDayByOffsetDay(day), (i + 1) * 2 + 15));
					order.setPayAmount(new BigDecimal(amount));
					order.setPlatformProfit(new BigDecimal(amount * rate));
					order.setMerchantProfit(new BigDecimal(amount * rate1));
					order.setSupNumber("sup" + snowflakeIdWorker.nextId());
					order.setRemarks("元宝x" + (amount * 100));
				}
				list.add(order);
			}
			orderService.saveAll(list);
			Long end = System.currentTimeMillis();
			System.out.println(">>>>>>>>>>>>>>>耗时：" + (end - start) / 1000 + "s");
		}
	}

	public static String getIp() {
		return CommonUtil.getBufferString(r.nextInt(246) + 10, ".", r.nextInt(246) + 10, ".", r.nextInt(246) + 10, ".",
				r.nextInt(246) + 10);
	}
}
