package com.cypay.common.pattern.template.payee.wechat;

/**
 * 微信公众号开发-应用授权
 * @author International
 * @2019年3月16日 下午2:17:42
 */
public class WechatAuthorize {

	/**
	 * 应用授权作用域
	 * snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid）
	 */
	public static final String AUTHORIZE_SCOPE_BASE = "snsapi_base";
	
	/**
	 * 应用授权作用域
	 * snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且， 即使在未关注的情况下，只要用户授权，也能获取其信息 ）
	 */
	public static final String AUTHORIZE_SCOPE_USERINFO = "snsapi_userinfo";
	
	/**
	 * 应用授权URL-获取code
	 * code作为换取access_token的票据，每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
	 */
	public static final String AUTHORIZE_URL = 
			"https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s&#wechat_redirect";
	
	/**
	 * 网页授权URL-获取access_token
	 * 通过code换取网页授权access_token和openid
	 */
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
	
	/**
	 * 获取用户信息URL
	 * 如果网页授权作用域为snsapi_userinfo，则此时开发者可以通过access_token和openid拉取用户信息了。
	 */
	public static final String USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
	
}
