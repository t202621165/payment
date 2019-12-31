package com.cypay.common.shiro.realm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cypay.common.enums.Edition;
import com.cypay.common.repository.impl.MerchantRepository;
import com.cypay.common.shiro.token.MyUsernamePasswordToken;

/**
 * 自定义模块化Realm认证器
 * @author International
 * 2018年8月1日 下午3:36:02
 */
@Component
public class MyModularRealmAuthenticator extends ModularRealmAuthenticator {
	
	private Map<String, AuthorizingRealm> customRealms = new HashMap<>();
	
	@Autowired
	private MerchantRepository merchantRepository;
	
	/**
	 * 调用单个Reaml执行操作
	 */
	@Override
	protected AuthenticationInfo doSingleRealmAuthentication(Realm realm, AuthenticationToken token) {
		if (!realm.supports(token)) {
			throw new ShiroException("token错误!");
		}
		
		AuthenticationInfo info = realm.getAuthenticationInfo(token);
		
		MyUsernamePasswordToken myToken = (MyUsernamePasswordToken) token;
		
		// 个人版商户登录
		if ("Merchant".equals(myToken.getLoginType()) && Edition.current_edition == Edition.PERSONAL) {
			// 获取当前登录商户在列表中的排名
			int rowno = merchantRepository.findRank(myToken.getUsername());
			if (rowno > Edition.current_edition.getMax_allowed_regist_number()) {
				// 排名超过最大允许注册商户数， 禁止登录
				info = null;
				throw new AccountException("当前用户无效，无法登录！");
			}
		}
		
		if (info == null) {
			throw new ShiroException("登陆无效!");
		}
		
		return info;
	}
	
	/**
	 * 判断根据登录获取对应的Realm执行操作
	 */
	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		
		// 判断是否存在Realm
		assertRealmsConfigured();
		
		MyUsernamePasswordToken token = (MyUsernamePasswordToken) authenticationToken;
		
		// 获取登录类型
		String loginType = token.getLoginType();
		
		Realm realm = customRealms.get(loginType);
		
		if (realm == null) {
			return null;
		}
		
		return doSingleRealmAuthentication(realm, token);
	}
	
	@Override
	protected void assertRealmsConfigured() throws IllegalStateException {
		if (this.customRealms.isEmpty()) {
			throw new ShiroException("没有可用的Realm！");
		}
	}

	public void put(String realmName, AuthorizingRealm realm) {
		this.customRealms.put(realmName, realm);
	}

	public Collection<AuthorizingRealm> getCustomRealms() {
		return customRealms.values();
	}
	
}
