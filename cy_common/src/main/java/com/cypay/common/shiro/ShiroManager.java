package com.cypay.common.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.User;
import com.cypay.common.shiro.token.MyUsernamePasswordToken;
import com.cypay.common.to.Login;

/**
 * Shiro管理工具
 * @author International
 * 2018年8月8日 下午4:38:13
 */
public class ShiroManager {
	
	private static final long MAXIDLETIMEINMILLIS = -1000l;
	
	/**
	 * 登录
	 * @param <T>
	 * @param login
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Login> T login(T login) {
		MyUsernamePasswordToken token = 
				new MyUsernamePasswordToken(login.getAccount(), login.getPassword(), login.getRealm());
		token.setEncrypt(login.isEncrypt());
		getSubject().login(token);
		setSessionTimeout(MAXIDLETIMEINMILLIS);
		return (T) getPrincipal();
	}
	
	/**
	 * 判断是否登录
	 * @return
	 */
	public static boolean isLogin(Class<?> clazz) {
		Object obj = getPrincipal();
		if (obj != null && obj.getClass().equals(clazz))
			return true;
		
		return false;
	}
	
	/**
	 * 商户登陆
	 * @return
	 */
	public static boolean isMerchant() {
		return getPrincipal() instanceof Merchant;
	}
	
	/**
	 * 管理员用户登陆
	 * @return
	 */
	public static boolean isAdminUser() {
		return getPrincipal() instanceof User;
	}
	
	/**
	 * 退出登录
	 */
	public static void logout() {
		getSubject().logout();
	}
	
//	/**
//	 * 清空当前用户的权限信息
//	 */
//	public static void clearCurrentUserAuth() {
//		REALM.clearCachedAuthorizationInfo();
//	}

	/**
	 * 获取认证主体
	 * @return
	 */
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 获取当前登陆商户
	 * @return
	 */
	public static Merchant getMerchant() {
		Merchant merchant = getPrincipal(Merchant.class);
		return merchant == null ? new Merchant(1L) : merchant;
	}
	
	/**
	 * 获取当前登陆用户
	 * @return
	 */
	public static User getUser() {
		return getPrincipal(User.class);
	}
	
	public static boolean hasRole(String role) {
		return getSubject().hasRole(role);
	}
	
	public static <T> T getPrincipal(Class<T> clazz) {
		return clazz.cast(getSubject().getPrincipal());
	}
	
	public static Object getPrincipal() {
		return getSubject().getPrincipal();
	}
	
	public static Session getSession() {
		return getSubject().getSession();
	}
	
	public static Object getValueBySession(Object key) {
		return getSession().getAttribute(key);
	}
	
	public static void setValue2Session(Object key, Object value) {
		getSession().setAttribute(key, value);
	}
	
	/**
	 * 设置session有效时间
	 * @param maxIdleTimeInMillis
	 */
	public static void setSessionTimeout(long maxIdleTimeInMillis) {
		getSession().setTimeout(maxIdleTimeInMillis);
	}
}
