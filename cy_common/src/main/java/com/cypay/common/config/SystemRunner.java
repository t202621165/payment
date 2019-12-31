package com.cypay.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 系统初始化
 * @author International
 * 2018年7月3日 下午1:46:10
 */
@Component
public class SystemRunner implements CommandLineRunner{
	
	@Autowired
	private InitialLoader initialLoader;
	
	@Override
	public void run(String... args) throws Exception {
		initialLoader.initSystemSet();
		
		initialLoader.initRank();
		
		initialLoader.initTask();
		
		initialLoader.initProduct();
		
		initialLoader.initGallery();
		
		initialLoader.loadOAuth();
	}
	
}
