package com.cypay.common.config;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.cypay.common.entity.Product;
import com.cypay.common.entity.Rank;
import com.cypay.common.entity.SchedulerJob;
import com.cypay.common.entity.SystemSet;
import com.cypay.common.entity.Token;
import com.cypay.common.entity.User;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.service.impl.GalleryService;
import com.cypay.common.service.impl.LineService;
import com.cypay.common.service.impl.ProductService;
import com.cypay.common.service.impl.RankService;
import com.cypay.common.service.impl.SchedulerJobService;
import com.cypay.common.service.impl.SystemSetService;
import com.cypay.common.service.impl.UserService;
import com.cypay.common.util.CommonUtil;

import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * 系统初始化加载器
 * @author International
 * @2019年1月17日 下午2:10:24
 */
@Component
public class InitialLoader {

	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 系统本次启动生成的唯一标识
	 */
	public static final String CODE = IdUtil.fastSimpleUUID();
	
	/**
	 * 系统授权token
	 */
	public static String token = "";
	
	public static String communicationUrl = "";
	
	/**
	 * 当前系统可用通道 (开放通道 + 已授权通道)
	 */
	public static final Set<String> USABLE_GALLERY = new HashSet<>();
	
	/**
	 * 加载所有通道枚举
	 */
	public static final Map<String, PaymentType> PAYMENT_ENUMS = EnumUtil.getEnumMap(PaymentType.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private GalleryService galleryService;
	
	@Autowired
	private SystemSetService systemSetService;
	
	@Autowired
	private SchedulerJobService schedulerJobService;
	
	@Autowired
	private LineService lineService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RankService rankService;
	
	@Value("${com.payment.name}")
	private  String name; //网站名
	
	@Value("${com.payment.mark}")
	private  String mark; // 系统唯一标识
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	@Value("${com.payment.url}")
	private String url; //网关域名
	
	/** T1自动结算开关 */
	@Value("${com.payment.t1_auto_settlement}")
	private boolean t1_auto_settlement;
	
	/**
	 * 初始化系统设置
	 */
	@Async
	public void initSystemSet() {
		
		communicationUrl = url;
		
		Optional<SystemSet> optional =  systemSetService.findByMark(mark);
		
		if (!optional.isPresent()) // 未初始化系统设置
			systemSetService.save(new SystemSet(mark, name));
		
		if (userService.count() == 0){ //初始化管理员
			User user = new User();
			user.setSalt(IdUtil.fastSimpleUUID());
			user.setNickname("超级管理员");
			user.setPassword(new Md5Hash("000000",user.getSalt()).toHex());
			user.setState(true);
			user.setUsername("admin");
			userService.save(user);
		}
		
		logger.info("系统设置初始化完毕！");
	}
	
	@Async
	public void initRank() {
		if (rankService.count() == 0) {
			Rank rank = new Rank();
			rank.setName("默认费率");
			rank.setIsDefault(true);
			rankService.save(rank);
		}
	}
	
	/**
	 * 检查定时任务有效期
	 */
	@Async
	public void initTask() {
		if (t1_auto_settlement) {
			// 开启T1自动结算定时任务
			schedulerJobService.startT1AutoSettlementTask();
		}
		
		List<SchedulerJob> jobs = schedulerJobService.findByState(0);
		List<Long> ids = jobs.parallelStream().filter(
				job -> job.isExpired()).map(SchedulerJob::getId).collect(Collectors.toList());
		if (!ids.isEmpty()) {
			schedulerJobService.updateStateByIds(2, ids);
		}
	}
	
	/**
	 * 产品初始化
	 */
	@Async
	public void initProduct() {
		Long count = productService.count();
		if (count == 0) {
			logger.info("产品初始化。。。");
			productService.saveAll(Product.DEFAULT_PRODUCT);
			logger.info("产品初始化完毕！");
		}
	}
	
	/**
	 * 通道初始化
	 */
	@Async
	public void initGallery() {
		Long count = galleryService.count();
		if (count == 0) {
			logger.info("通道初始化。。。");
			galleryService.saveAll(PaymentType.openGallery());
			logger.info("通道初始化完毕！");
		}
	}
	
	/**
	 * 加载系统授权信息
	 */
	@Async
	public void loadOAuth() {
		Optional<Token> optional = systemSetService.findTokenByMark();
		if (optional.isPresent() && StrUtil.isNotBlank(token = optional.get().getToken())) {
			String[] parts = token.split("\\.");
			String result = "success";
			String key = dbUrl.split("\\?")[0];
			if (parts.length == 2) {
				String ip = key = SecureUtil.aes(SystemAuthorize.AES_KEY.getBytes()).decryptStr(parts[1]);
				StringBuilder builder = new StringBuilder();
				if (ip.indexOf("+") == 0) {
					builder.append("https://").append(ip.substring(1, ip.length()));
				} else {
					builder.append("http://").append(ip);
				}
				builder.append("/authorize");
		        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
		        requestBody.add("type", "0");
		        requestBody.add("code", CODE);
		        try {
		        	result = restTemplate.postForObject(builder.toString(), requestBody, String.class);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
		        logger.info("【授权】Authorize With IP...");
			}
			
			if ("success".equals(result)) {
        		logger.info("【授权】正在解析授权码...");
        		systemSetService.token(key, token);
        		logger.info("【授权】授权码解析完成！");
        	} else {
        		logger.info("【授权】加载授权信息失败！");
        	}
		}
	}
	
	/**
	 * 获取当前线路类型
	 * @param request
	 * @return
	 */
	public Integer getTypeByDomain(HttpServletRequest request) {
		return lineService.findAllAndGroup().get(CommonUtil.getBufferString(request.getScheme(), "://", request.getServerName()));
	}
}
