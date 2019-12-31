package com.cypay.common.shiro.realm;

import org.apache.shiro.authz.SimpleAuthorizationInfo;

import com.cypay.common.entity.Merchant;
import com.cypay.common.enums.MerchantRolesEnum;
import com.cypay.common.repository.impl.MerchantRepository;

/**
 * 自定义验证Realm-商户登录
 * @author International
 * 2018年8月1日 下午3:43:26
 */
public class MerchantRealm extends AbstractRealm<Merchant, MerchantRepository> {

	/**
	 * 登录商户授权
	 */
	@Override
	protected void autho(Merchant principal, SimpleAuthorizationInfo info) {
		
		// 是否为代理
		if (principal.getType()) {
			info.addRole(MerchantRolesEnum.agency.getMark());
		}
		
		info.addRole(MerchantRolesEnum.merchant.getMark());
	}
}
