package com.cypay.payment;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.config.SystemAuthorize;
import com.cypay.common.enums.PaymentType;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

public class Authorize {
	
	private static String ssid = "author-1";

	private static String url = "jdbc:mysql://localhost:8889/payment";
	
	private static String username = "root";
	
	private static String password = "lypcj1216....";

	public static void main(String[] args) throws Exception {
		System.out.println("=======================系统授权===========================");
		System.out.println("ssid:"+SecureUtil.md5(String.format("%s@iwanol@%s", ssid, url.split("\\?")[0])));
		// 数据源授权
		authorizeWithDataSource();
		// IP授权：ip + 端口 https授权ip前加‘+’号
		authorizeWithIP("154.223.60.40");
		System.out.println("======================数据源加密===========================");
		environmentEncrypt();
		System.out.println("======================可授权通道===========================");
		gallerys();
	}
	
	private static void authorize(int type, String... auts) {
		JSONObject json = new JSONObject();
		String aes_key = "c34a315844944c6da979a201dac0425e";
		String md5_key = "66ee9dd09f5647fbac9d4e9eb6081fa1";
		
//		int[] g = new int[]{0,1,2,3,7}; // 授权通道的index
//		json.put("G", g); // 授权通道（包含默认开放通道）-G：不限制通道个数、G0/G1：一个 、G2：两个...Gn：n个
//		json.put("G0", "1"); // 授权通道：1：全部通道
		// 授权通道的index(从1开始)，负数：风控金额授权
		int[] p = new int[] {-1,-2,3,4,5,6,7,8,-9,-10,-11,12,13};
		json.put("P", p); // 授权通道（不包含默认开放通道，需手动授权）-P：不限制通道个数、P0/P1：一个 、P2：两个...Pn：n个
//		json.put("P3", "-1"); // 授权通道：1：全部通道 -1：全部通道，并授权风控金额
		json.put("E", "1"); // 1：企业版；0：个人版
//		json.put("N", "5"); // 个人版最大允许注册商户数：默认 10
		json.put("A", "1"); // 支付宝代付
		json.put("W", "1"); // 微信代付
		json.put("B", "12"); // 授权网关-0：通用 1：传奇 2：传世 3：传奇三 4：web 默认：全部
		json.put("D", "201217"); // 到期时间：yyMMdd
//		String ip = "110.42.2.32:88"; // 授权的ip + 端口：https授权ip前加‘+’号
		System.out.println(json);
		json.put("S", SecureUtil.md5(String.format("%s@@%s", json, md5_key)));
		String data = json.toJSONString();
		System.out.println(data);
		for (String aut : auts) {
			String key = SecureUtil.md5(String.format("%s@%s", aut, aes_key));
			String token = SecureUtil.aes(key.getBytes()).encryptBase64(data);
			System.out.printf("授权%s：%s\r\n", (type == 0 ? "URL" : "IP"), aut);
			System.out.println(token + (type == 0 ? "" : ("." + SecureUtil.aes(aes_key.getBytes()).encryptBase64(aut))));
			System.out.println("------------------------------------------------------");
			SystemAuthorize sa = new SystemAuthorize();
			sa.parse(aut, token);
		}
		System.out.println("=======================================================");
	}
	
	/**
	 * DataSource授权
	 */
	public static void authorizeWithDataSource() {
		authorize(0, url.split("\\?")[0]);
	}
	
	/**
	 * IP+端口授权
	 * @param ips
	 */
	public static void authorizeWithIP(String... ips) {
		authorize(1, ips);
	}
	
	public static void gallerys() {
		int i = 1, j = 0;
		System.out.println("P-index\tG-index\tname");
		for (PaymentType type : PaymentType.values()) {
			if (type.getIsOpen()) {
				System.out.printf("%s\t--\t%s\r\n", i++, type.getName());
			} else {
				System.out.printf("%s\t%s\t%s\r\n", i++, j++, type.getName());
			}
		}
	}
	
	public static void environmentEncrypt() {
		AES aes = SecureUtil.aes("70c8163dbc3141df92dc8d650961a574".getBytes());
		System.out.println();
		
        System.out.printf("    url: %s\r\n    username: %s\r\n    password: %s", 
        		aes.encryptBase64(url), 
        		aes.encryptBase64(username), 
        		aes.encryptBase64(password));
        System.out.println();
        System.out.printf("    url: %s\r\n    username: %s\r\n    password: %s\r\n", 
        		aes.decryptStr("icTVHN8Jc5HgJNv2HrCEPM4FUFTZ7i9vLTL5Vt/KXOep5bpV3atjBF2+4pgbz1yycfk/hLAnw7uICfA1k6Y1qKB+vIYs9cb1D3+k4GIqAEo="), 
        		aes.decryptStr("633hID2K5ZqPMbpEKOJSrg=="), 
        		aes.decryptStr("xMvV1u+dKggGVkR+nkO3rA=="));
	}
}
