package com.cypay.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.util.DigestUtils;

/**
 * MD5签名、验签工具类
 * @author Administrator
 *
 */
public class MD5Util {
	
	private static Logger logger = LoggerFactory.getLogger(MD5Util.class);
	
	private MD5Util() {
		MD5Util.logger.error("Utility Class: " + this.getClass());
	}
	
	/**
	 * MD5签名-小写
	 * 
	 * @param content
	 *            需要签名的字符串
	 * @param key
	 *            密钥
	 * @param charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static String signToLowerCase(String content, String key, String charset) {
		return DigestUtils.md5DigestAsHex(getContentBytes(content + key, charset));
	}
	
	/**
	 * MD5签名-大写
	 * 
	 * @param content
	 *            需要签名的字符串
	 * @param key
	 *            密钥
	 * @param charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static String signToUpperCase(String content, String key, String charset) {
		return signToLowerCase(content, key, charset).toUpperCase();
	}
	
	/**
	 * MD5签名验证
	 * 
	 * @param content
	 *            验证字符串
	 * @param sign
	 *            待验证签名
	 * @param key
	 *            密钥
	 * @param charset
	 *            编码格式
	 * @return 验证结果
	 */
	public static boolean verify(String content, String sign, String key, String charset) {
		return sign.equalsIgnoreCase(signToLowerCase(content, key, charset));
	}
	
	/**
	 * 将签名串转换成Byte数组
	 * @param content
	 * @param charset
	 * @return
	 */
	private static byte[] getContentBytes(String content, String charset) {
		if (charset == null || "".equals(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			logger.error("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
			return null;
		}
	}
	
	
	/**
	 * hmac
	 * @param aValue
	 * @param aKey
	 * @return
	 */
	public static String hmacSign(String aValue, String aKey,String encodingCharset) {
		byte[] k_ipad = new byte[64], k_opad = new byte[64], keyb, value;
		try {
			keyb = aKey.getBytes(encodingCharset);
			value = aValue.getBytes(encodingCharset);
		} catch (UnsupportedEncodingException e) {
			keyb = aKey.getBytes();
			value = aValue.getBytes();
		}

		Arrays.fill(k_ipad, keyb.length, 64, (byte) 54);
		Arrays.fill(k_opad, keyb.length, 64, (byte) 92);
		for (int i = 0; i < keyb.length; i++) {
			k_ipad[i] = (byte) (keyb[i] ^ 0x36);
			k_opad[i] = (byte) (keyb[i] ^ 0x5c);
		}

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
			return null;
		}
		md.update(k_ipad);
		md.update(value);
		byte[] dg = md.digest();
		md.reset();
		md.update(k_opad);
		md.update(dg, 0, 16);
		dg = md.digest();
		return toHex(dg);
	}
	
	/**
	 * hmac签名验证
	 * @param content 待验证内容
	 * @param aValue 待加密串
	 * @param aKey 密钥
	 * @return
	 */
	public static boolean hmacVerify(@NonNull String content, String aValue, String aKey,String encodingCharset) {
		return content.equals(hmacSign(aValue,aKey,encodingCharset));
	}

	public static String toHex(byte[] input) {
		if (input == null)
			return null;
		StringBuilder output = new StringBuilder(input.length * 2);
		for (int i = 0; i < input.length; i++) {
			int current = input[i] & 0xff;
			if (current < 16)
				output.append("0");
			output.append(Integer.toString(current, 16));
		}

		return output.toString();
	}

	/**
	 * 
	 * @param args
	 * @param key
	 * @return
	 */
	public static String getHmac(String[] args, String key,String encodingCharset) {
		if (args == null || args.length == 0) {
			return (null);
		}
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			str.append(args[i]);
		}
		return (hmacSign(str.toString(), key,encodingCharset));
	}

	/**
	 * @param aValue
	 * @return
	 */
	public static String digest(String aValue,String encodingCharset) {
		aValue = aValue.trim();
		byte[] value;
		try {
			value = aValue.getBytes(encodingCharset);
		} catch (UnsupportedEncodingException e) {
			value = aValue.getBytes();
		}
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
			return null;
		}
		return toHex(md.digest(value));

	}

}
