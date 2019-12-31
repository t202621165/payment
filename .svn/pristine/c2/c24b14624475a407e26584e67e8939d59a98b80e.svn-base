package com.cypay.common.shiro.realm;

import org.apache.shiro.authz.SimpleAuthorizationInfo;

import com.cypay.common.entity.User;
import com.cypay.common.repository.impl.UserRepository;

/**
 * 自定义验证Realm-系统用户登录
 * @author International
 * 2018年8月1日 下午3:43:26
 */
public class UserRealm extends AbstractRealm<User, UserRepository> {

	/**
	 * 登录用户授权
	 */
	@Override
	protected void autho(User principal, SimpleAuthorizationInfo info) {
		info.addRole("admin");
	}
	
}
