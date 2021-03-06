package com.cypay.common.shiro;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import com.cypay.common.config.MyUrlRewriteFilter;
import com.cypay.common.quartz.QuartzScheduler;
import com.cypay.common.shiro.filter.LineToManFilter;
import com.cypay.common.shiro.filter.LineToMerFilter;
import com.cypay.common.shiro.filter.LineToPayFilter;
import com.cypay.common.shiro.realm.MerchantRealm;
import com.cypay.common.shiro.realm.MyModularRealmAuthenticator;
import com.cypay.common.shiro.realm.UserRealm;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfiguration {
	@Autowired 
	private LineToPayFilter lineToPayFilter;
	
	@Autowired 
	private LineToMerFilter lineToMerFilter;
	
	@Autowired 
	private LineToManFilter lineToManFilter;
	
	@Autowired
	private MyModularRealmAuthenticator myModularRealmAuthenticator;
	
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new MyShiroFilterFactoryBean();
		
		// 设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 登录页面
		//shiroFilterFactoryBean.setLoginUrl("/");
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		
		// shiro请求过滤链
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/test-line", "anon");
		//系统授权
		filterChainDefinitionMap.put("/authorize", "anon");
		// 静态资源匿名访问
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/assets/**", "anon");
		
		// 系统用户登录页面、登录验证
		filterChainDefinitionMap.put("/man/login", "anon");
		filterChainDefinitionMap.put("/man/logout", "anon");
		
		filterChainDefinitionMap.put("/man/alipay/notify", "anon");
		
		// 商户登录页面、登录验证
		filterChainDefinitionMap.put("/mer/login", "anon,mer");
		filterChainDefinitionMap.put("/mer/sign_in", "anon");
		filterChainDefinitionMap.put("/mer/signin", "anon");
		filterChainDefinitionMap.put("/mer/code", "anon,mer");
		filterChainDefinitionMap.put("/mer/logout", "anon,mer");
		
		filterChainDefinitionMap.put("/mer/tomerchant", "anon");
		
		filterChainDefinitionMap.put("/mer/wechat-bind", "anon");
		filterChainDefinitionMap.put("/mer/wechat-login", "anon");
		
		//商户注册页面
		filterChainDefinitionMap.put("/mer/register", "anon,mer");
		
		//商户资费
		filterChainDefinitionMap.put("/mer/fee", "anon,mer");
		
		//关于我们
		filterChainDefinitionMap.put("/mer/us", "anon,mer");
		
		//网关接口
		filterChainDefinitionMap.put("/mer/wg/**", "anon");
		
		//ips统计
		filterChainDefinitionMap.put("/mer/flow/**", "anon");
		
		filterChainDefinitionMap.put("/mer/game/**", "anon");
		
		//网关版本检测/更新
		filterChainDefinitionMap.put("/mer/version/**", "anon");
		filterChainDefinitionMap.put("/mer/conn/**", "anon");
		
		filterChainDefinitionMap.put("/wechat/**", "anon");
		
		// 匿名访问所有充值页面
		filterChainDefinitionMap.put("/pay/**", "anon,pay");
		filterChainDefinitionMap.put("/druid/**", "authc,roles[admin]");
		
//		filterChainDefinitionMap.put("/mer/agent/**", "authc,roles["+MerchantRolesEnum.agency.getMark()+"]");
//		filterChainDefinitionMap.put("/mer/**", "authc,mer,roles["+MerchantRolesEnum.merchant.getMark()+"]");
		filterChainDefinitionMap.put("/mer/**", "anon");
		filterChainDefinitionMap.put("/man/**", "authc,man");
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		Map<String, Filter> filterMap = new HashMap<String, Filter>();
		filterMap.put("pay", lineToPayFilter);
		filterMap.put("mer", lineToMerFilter);
		filterMap.put("man", lineToManFilter);
		shiroFilterFactoryBean.setFilters(filterMap);
		return shiroFilterFactoryBean;
	}
	
	/**
	 * Shiro安全管理器
	 * @return
	 */
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setCacheManager(memoryConstrainedCacheManager());
		// 设置Realm认证器
		securityManager.setAuthenticator(modularRealmAuthenticator());
		securityManager.setRealms(Arrays.asList(userRealm(), merchantRealm()));
		// Cookie管理器(RememberMe功能)
		securityManager.setRememberMeManager(rememberMeManager());
		return securityManager;
	}
	
	/**
	 * 缓存管理器 用户授权信息缓存
	 * @return
	 */
	@Bean
	public MemoryConstrainedCacheManager memoryConstrainedCacheManager() {
		return new MemoryConstrainedCacheManager();
	}
	
	/**
	 *  自定义模块化Realm认证器
	 * @return
	 */
	@Bean
	public ModularRealmAuthenticator modularRealmAuthenticator() {
		myModularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
		myModularRealmAuthenticator.put("User", userRealm());
		myModularRealmAuthenticator.put("Merchant", merchantRealm());
		return myModularRealmAuthenticator;
	}
	
	/**
	 * 自定义系统用户登录验证Realm
	 * @return
	 */
	@Bean
	public UserRealm userRealm() {
		UserRealm realm = new UserRealm();
		realm.setCredentialsMatcher(hashedCredentialsMatcher());
		return realm;
	}
	
	/**
	 * 自定义商户登录验证Realm
	 * @return
	 */
	@Bean
	public MerchantRealm merchantRealm() {
		MerchantRealm realm = new MerchantRealm();
		realm.setCredentialsMatcher(hashedCredentialsMatcher());
		return realm;
	}
	
	/**
	 * 记住我Cookie管理器
	 * @return
	 */
	public CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		// rememberMe cookie加密密钥(默认：AES算法)
		cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
		return cookieRememberMeManager;
	}
	
	/**
	 * remember me cookie
	 * @return
	 */
	public SimpleCookie rememberMeCookie() {
		SimpleCookie simpleCookie = new SimpleCookie("v_v-baidu-re");
		// cookie有限期30天
		simpleCookie.setMaxAge(2592000);
		return simpleCookie;
	}
	
	/**
	 * 密码加密算法：MD5
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		// 散列算法：MD5
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");
		return hashedCredentialsMatcher;
	}
	
	/**
	 * Thymeleaf-Shiro方言
	 * thymeleaf模板中使用shiro标签
	 * @return
	 */
	@Bean  
	public ShiroDialect shiroDialect() {  
	    return new ShiroDialect();  
	}
	
	/**
	 * 开启shiro注解
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor 
			authorizationAttributeSourceAdvisor = 
				new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
    }
	
	@Bean
	public UrlRewriteFilter urlRewriteFilter() {
		return new MyUrlRewriteFilter();
	}
	
	@Bean
    public Scheduler scheduler() throws SchedulerException{
        SchedulerFactory schedulerFactoryBean = new StdSchedulerFactory();
        return schedulerFactoryBean.getScheduler(); 
    }
	
	@Bean(name = "myQuartScheduler")
	public QuartzScheduler quartzScheduler() {
		return new QuartzScheduler();
	}
	
	@Bean
	public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
		return new ShallowEtagHeaderFilter();
	}
	
}
