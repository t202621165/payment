package com.cypay.common.shiro.realm;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.cypay.common.config.SystemAuthorize;
import com.cypay.common.repository.BaseRepository;
import com.cypay.common.shiro.token.MyUsernamePasswordToken;
import com.cypay.common.to.Login;

import cn.hutool.core.collection.ConcurrentHashSet;

@SuppressWarnings("unchecked")
public abstract class AbstractRealm<T extends Login, R extends BaseRepository<T, Long>> extends AuthorizingRealm {

	@Autowired
	protected R repository;
	
	protected Class<T> clazz;
	
	public static Set<String> permissions = new ConcurrentHashSet<String>();
	
	public AbstractRealm() {
		Type[] types = ((ParameterizedType) 
				this.getClass().getGenericSuperclass()).getActualTypeArguments();
		this.clazz = (Class<T>) types[0];
	}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {

		MyUsernamePasswordToken myToken = (MyUsernamePasswordToken) token;
		
		String account = myToken.getUsername();
		String password = new String(myToken.getPassword());
		
		T login = repository.findByAccount(account);
		
		if (login == null)
			throw new UnknownAccountException("用户名或密码错误！");
		
		if (login.isUnusable())
			throw new LockedAccountException("用户已被禁用！");
		
		if (login.isInAudit())
			throw new AccountException("当前用户正在审核中！");
		
		String salt = login.getSalt();
		String md5Pwd = new Md5Hash(password, salt).toHex();
		
		if (myToken.getEncrypt()) {
			if (!login.getPassword().equals(md5Pwd))
				throw new AccountException("用户名或密码错误！");
		}else {
			if (!md5Pwd.equals(new Md5Hash(login.getPassword(), salt).toHex()))
				throw new AccountException("用户名或密码错误！");
		}
		
		SimpleAuthenticationInfo authenticationInfo = 
				new SimpleAuthenticationInfo(login, md5Pwd, 
						ByteSource.Util.bytes(salt.getBytes()), getName());
		
		return authenticationInfo;
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalcollection) {
		
		Assert.notNull(principalcollection, "The 'principalCollection' cannot be null.");
		
		Object principal = principalcollection.getPrimaryPrincipal();
		
		if (!principal.getClass().equals(clazz)) {
			return null;
		}
		
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		
		autho((T) principal, info);
		
		info.addStringPermissions(SystemAuthorize.permissions());
		
		return info;
	}
	
	protected abstract void autho(T principal, SimpleAuthorizationInfo info);
}
