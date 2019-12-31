package com.cypay.common.config;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

public class EnvironmentDecrypt implements EnvironmentPostProcessor {
	
	private AES aes;
	
	public EnvironmentDecrypt() {
		this.aes = SecureUtil.aes("70c8163dbc3141df92dc8d650961a574".getBytes());
	}
	
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		// 获取application.yml配置文件中的属性资源
		OriginTrackedMapPropertySource applicationConfigSource = 
				(OriginTrackedMapPropertySource) environment.getPropertySources().get("applicationConfig: [classpath:/application.yml]");
		if (applicationConfigSource != null) {
			// 获取配置属性
			Map<String, Object> source = applicationConfigSource.getSource();
			// 解密数据源-url
			Object url = source.get("spring.datasource.url");
			if (url != null) {
				try {
					source.put("spring.datasource.url", aes.decryptStr(url.toString()));
				} catch (Exception e) {
					System.out.println("【DECRYPT】：Property 'url' decrypt fail or is doesn't need to be decrypted.");
				}
			}
			// 解密数据源-用户名
			Object username = source.get("spring.datasource.username");
			if (username != null) {
				try {
					source.put("spring.datasource.username", aes.decryptStr(username.toString()));
				} catch (Exception e) {
					System.out.println("【DECRYPT】：Property 'username' decrypt fail or is doesn't need to be decrypted.");
				}
			}
			// 解密数据源-密码
			Object password = source.get("spring.datasource.password");
			if (password != null) {
				try {
					source.put("spring.datasource.password", aes.decryptStr(password.toString()));
				} catch (Exception e) {
					System.out.println("【DECRYPT】：Property 'password' decrypt fail or is doesn't need to be decrypted.");
				}
			}
		}
	}

}
