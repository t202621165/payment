package com.cypay.payment;

import java.util.Random;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import com.cypay.common.util.SnowflakeIdWorker;

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableJpaRepositories(basePackages = {"com.cypay.common.repository", "com.cypay.pay.repository"})
@EntityScan(basePackages = {"com.cypay.common", "com.cypay.pay"})
@ComponentScan(basePackages = {
		"com.cypay.payment", "com.cypay.common", "com.cypay.manage", 
		"com.cypay.merchant", "com.cypay.pay"
		})
public class PaymentApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PaymentApplication.class);
    }

	/**
	 * 雪花算法生成订单号
	 * @return
	 */
	@Bean
	public SnowflakeIdWorker snowflakeIdWorker() {
		Random r = new Random();
		return new SnowflakeIdWorker(r.nextInt(32), r.nextInt(32));
	}

    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("10240KB"); //KB,MB
        factory.setMaxRequestSize("10240KB");
        return factory.createMultipartConfig();
    }
	
}
