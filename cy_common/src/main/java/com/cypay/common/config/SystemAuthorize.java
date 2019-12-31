package com.cypay.common.config;

import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cypay.common.enums.AuthorizePermissions;
import com.cypay.common.enums.Edition;
import com.cypay.common.enums.PaymentType;

import cn.hutool.core.collection.ConcurrentHashSet;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author International
 */
public class SystemAuthorize {
	
private static Map<String, BiConsumer<String, Object>> handlers = new ConcurrentHashMap<>();
	
	private static Set<String> permissions = new ConcurrentHashSet<>();

	private static final String SUPPORT = "1";
	
	private static final String NOT_SUPPORT = "-1";

	private static final String GATEWAY_TYPE_SQL = "0";

	private static final String GATEWAY_TYPE_CQ = "1";

	private static final String GATEWAY_TYPE_CS = "2";

	private static final String GATEWAY_TYPE_CQ3 = "3";

	private static final String GATEWAY_TYPE_WEB = "4";

	static {
		// 支付宝代付
		handlers.put("A", (k, v) -> {
			Edition.current_edition.setPayeeAlipay(SUPPORT.equals(v));
			if (SUPPORT.equals(v)) {
				permissions.add(AuthorizePermissions.PAYEE_ALIPAY.of());
			}
		});
		// 微信代付
		handlers.put("W", (k, v) -> {
			Edition.current_edition.setPayeeWechat(SUPPORT.equals(v));
			if (SUPPORT.equals(v)) {
				permissions.add(AuthorizePermissions.PAYEE_WECHAT.of());
			}
		});
		// 个人版最大商户注册数
		handlers.put("N", (k, v) -> {
			int n = Integer.parseInt(v.toString());
			Edition.current_edition.setMax_allowed_regist_number(n > 0 ? n : 10);
		});
		// 授权网关
		handlers.put("B", (k, v) -> {
			String b = v.toString();
			Edition.current_edition.setSql(b.contains(GATEWAY_TYPE_SQL)); // 通用网关
			if (b.contains(GATEWAY_TYPE_SQL)) {
				permissions.add(AuthorizePermissions.GATEWAY_SQL.of());
			}
			Edition.current_edition.setCq(b.contains(GATEWAY_TYPE_CQ)); // 传奇
			if (b.contains(GATEWAY_TYPE_CQ)) {
				permissions.add(AuthorizePermissions.GATEWAY_CQ.of());
			}
			Edition.current_edition.setCs(b.contains(GATEWAY_TYPE_CS)); // 传世
			if (b.contains(GATEWAY_TYPE_CS)) {
				permissions.add(AuthorizePermissions.GATEWAY_CS.of());
			}
			Edition.current_edition.setCq3(b.contains(GATEWAY_TYPE_CQ3)); // 传奇三
			if (b.contains(GATEWAY_TYPE_CQ3)) {
				permissions.add(AuthorizePermissions.GATEWAY_CQ3.of());
			}
			Edition.current_edition.setWeb(b.contains(GATEWAY_TYPE_WEB)); // web
			if (b.contains(GATEWAY_TYPE_WEB)) {
				permissions.add(AuthorizePermissions.GATEWAY_WEB.of());
			}
		});
		// 授权通道
		handlers.put("G", (k, v) -> {
			oAuthGallery(k, v, "G");
		});
		// 授权通道（开启风控金额）
		handlers.put("P", (k, v) -> {
			
			oAuthGallery(k, v, "P");
		});
	}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	static final String AES_KEY = "c34a315844944c6da979a201dac0425e";
	
	private static final String MD5_KEY = "66ee9dd09f5647fbac9d4e9eb6081fa1";
	
	private JSONObject data;
	
	private Boolean pass = Boolean.FALSE;
	
	private Long expirationDate;
	
	public boolean parse(String ip, String token) {
		try {
			this.decryptToken(ip, token);
			
			this.signVerify();
			
			this.checkTime();
			
			this.parseVersion();
			
			this.parseData();
		} catch (Exception e) {
			this.pass = false;
		}
		
		if (!this.pass) {
			logger.info("【授权】授权信息验证未通过！");
			permissions.clear();
			Edition.current_edition = Edition.DEFAULT;
		}
		return this.pass;
	}
	
	/**
	 * Token解密
	 * @param ip
	 * @param token
	 */
	private void decryptToken(String ip, String token) {
		// 对IP进行MD5签名生成AES解密密钥
		String key = SecureUtil.md5(String.format("%s@%s", ip, AES_KEY));
		// 解密token信息
		String data = SecureUtil.aes(key.getBytes()).decryptStr(token.split("\\.")[0]);
		this.data = JSON.parseObject(data);
	}
	
	private void signVerify() {
		Object sign = this.data.remove("S");
		if (sign.equals(SecureUtil.md5(String.format("%s@@%s", this.data.toJSONString(), MD5_KEY)))) {
			logger.info("【授权】签名验证通过，获取授权信息！");
			this.pass = true;
			return;
		}
		logger.info("【授权】签名验证未通过！");
		this.pass =  false;
	}
	
	/**
	 * 校验授权到期时间
	 */
	private void checkTime() {
		if (this.pass) {
			// 网络时间
			long currTime = this.getNetworkTime();
			logger.info("【授权】获取当前时间：" + DateUtil.date(currTime));
			// 授权到期时间
			long time = DateUtil.parse(this.data.getString("D"), "yyMMdd").getTime();
			logger.info("【授权】授权到期时间：" + DateUtil.date(time));
			// 检验系统过期时间
			if (time > currTime) {
				this.expirationDate = time;
				this.pass = true;
				return;
			}
			this.pass = false;
			logger.info("【授权】授权已过期！");
		}
	}
	
	/**
	 * 获取授权版本
	 */
	private void parseVersion() {
		if (this.pass) {
			if (SUPPORT.equals(data.get("E"))) {
				// 商业版
				Edition.current_edition = Edition.BUSINESS.reset();
			} else { // 个人版
				Edition.current_edition = Edition.PERSONAL.reset();
			}
		}
	}
	
	/**
	 * 解析授权信息
	 */
	private void parseData() {
		if (this.pass) {
			permissions.clear();
			Edition.current_edition.setExpiration_date(this.expirationDate);
			this.data.keySet().parallelStream().forEach(key -> {
				BiConsumer<String, Object> handler = handlers.get(key.startsWith("G") ? "G" : key);
				if (key.startsWith("G")) {
					handler = handlers.get("G");
				} else if (key.startsWith("P")) {
					handler = handlers.get("P");
				} else {
					handler = handlers.get(key);
				}
				Object value = this.data.get(key);
				if (handler != null && value != null) {
					handler.accept(key, value);
				}
			});
			this.pass = true;
			logger.info("【授权】SUCCESS！{}", Edition.current_edition);
		}
	}
	
	private static void oAuthGallery(String key, Object obj, String mark) {
		Edition.current_edition.setOauth_gallerys(obj);
		String count = key.replace(mark, "");
		if (!"".equals(count)) {
			int i = Integer.parseInt(count);
			Edition.current_edition.setGalleryCount(Math.max(i, 1));
		} else {
			Edition.current_edition.setGalleryCount(-1); // 不限制通道个数
		}
		
		InitialLoader.USABLE_GALLERY.clear();
		if (SUPPORT.equals(obj) || NOT_SUPPORT.equals(obj)) {
			// 添加所有通道至可用通道列表
			InitialLoader.USABLE_GALLERY.addAll(PaymentType.allGalleryMark(NOT_SUPPORT.equals(obj)));
		} else {
			try {
				// 添加已授权通道至可用通道列表
				InitialLoader.USABLE_GALLERY.addAll(PaymentType.dynamicAuthorMark(JSONUtil.parseArray(obj).toList(Integer.class), "P".equals(mark)));
			} catch (Exception ignored) {}
			InitialLoader.USABLE_GALLERY.addAll(PaymentType.openGalleryMark());
		}
	}
	
	/**
	 * 获取网络时间
	 * @return
	 */
	private long getNetworkTime() {
		try {
			// 取得资源对象
			URL url = new URL("https://www.baidu.com");
			// 生成连接对象
			URLConnection uc = url.openConnection();
			// 设置访问超时时间 5s
			uc.setReadTimeout(5000);
			// 发出连接
			uc.connect();
			// 读取网站日期时间
			return uc.getDate();
		} catch (Exception e) {
			logger.error("【授权】Get network time exception!");
		}
		return 1285862400000L;
	}
	
	public static Set<String> permissions() {
		return permissions;
	}
}
