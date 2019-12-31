package com.cypay.pay.payment;

import com.cypay.common.util.MD5Util;

import cn.hutool.crypto.SecureUtil;

public enum SignHandler {
	
	MD5 {
		@Override
		public String sign(String content, String secretKey, String charset) {
			return MD5Util.signToLowerCase(content, secretKey, charset);
		}

		@Override
		public boolean verify(String content, String sign, String key, String charset) {
			return MD5Util.verify(content, sign, key, charset);
		}
	},
	
	HMAC {
		@Override
		public String sign(String content, String secretKey, String charset) {
			return MD5Util.hmacSign(content, secretKey, charset);
		}

		@Override
		public boolean verify(String content, String sign, String key, String charset) {
			return MD5Util.hmacVerify(sign, content, key, charset);
		}
	},
	
	SHA1 {
		@Override
		public String sign(String content, String secretKey, String charset) {
			return SecureUtil.sha1(content);
		}

		@Override
		public boolean verify(String content, String sign, String key, String charset) {
			return sign.equalsIgnoreCase(SecureUtil.sha1(content));
		}
	};
	
	/**
	 * 参数签名
	 * @param fields
	 * @param secretKey
	 * @param charset
	 * @return
	 */
	public abstract String sign(String content, String secretKey, String charset);
	
	/**
	 * 签名验证
	 * @param content
	 * @param sign
	 * @param key
	 * @param charset
	 * @return
	 */
	public abstract boolean verify(String content, String sign, String key, String charset);
}
