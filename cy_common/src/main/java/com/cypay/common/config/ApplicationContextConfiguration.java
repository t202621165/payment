package com.cypay.common.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

@Configuration
public class ApplicationContextConfiguration {

	private ExecutorService threadPool = Executors.newCachedThreadPool();
	
	/**
	 * 事件广播器
	 * @return
	 */
	@Bean
	public ApplicationEventMulticaster applicationEventMulticaster() {
		SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
		multicaster.setTaskExecutor(threadPool); // 设置线程池：异步执行广播事件
		return multicaster;
	}
}
