package com.cypay.common.util;

import java.net.InetAddress;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AESUtil {

	AES;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private AESUtil() {

	}

	/**
	 * 对明文进行加密
	 * 
	 */
	private static final String KEY = "FB828E94ED20479F99B42847C5AAB91C";

	public String AES(String content) {
		try {
			byte[] byteRe = enCrypt(content, KEY);
			String encrytStr = parseByte2HexStr(byteRe);
			return encrytStr;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "";
	}

	/**
	 * 对加密数据进行校验 (true为校验成功，false为校验失败)
	 * 
	 * @throws Exception
	 */
	public boolean verify(String content) throws Exception {
		boolean flag = false;
		byte[] byteRe = enCrypt(content, KEY);
		String encrytStr = parseByte2HexStr(byteRe);
		if (encrytStr.equals(content)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 对密文进行解密
	 * 
	 * @param hexStr
	 * @return
	 * @throws Exception
	 */
	public String AESDeCrypt(String enCryptContent, HttpServletRequest request) throws Exception {
		try {
			byte[] encrytByte;
			encrytByte = parseHexStr2Byte(enCryptContent);
			String content = deCrypt(encrytByte, KEY);
			//根据域名获取IP
			if (request!=null) {
				//获取请求域名
				String domain = request.getServerName();
				//根据域名获取IP
				InetAddress[] address = InetAddress.getAllByName(domain);
				for (int i = 0; i < address.length; i++) {
					String ip = address[i].getHostAddress();
					if (content.contains(ip)) {
						return content.replace(ip, "");
					}
				}
			}else{
				return content;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "2000-10-01";
		}
		return "2000-10-01";
	}

	public byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	public String deCrypt(byte[] src, String strKey) throws Exception {
		KeyGenerator keygen;
		SecretKey desKey;
		Cipher c;
		byte[] cByte;

		keygen = KeyGenerator.getInstance("AES");
		keygen.init(128, new SecureRandom(strKey.getBytes()));

		desKey = keygen.generateKey();
		c = Cipher.getInstance("AES");

		c.init(Cipher.DECRYPT_MODE, desKey);

		cByte = c.doFinal(src);

		return new String(cByte, "UTF-8");
	}

	public byte[] enCrypt(String content, String strKey) throws Exception {
		KeyGenerator keygen;
		SecretKey desKey;
		Cipher c;
		byte[] cByte;
		String str = content;

		keygen = KeyGenerator.getInstance("AES");
		keygen.init(128, new SecureRandom(strKey.getBytes()));

		desKey = keygen.generateKey();
		c = Cipher.getInstance("AES");

		c.init(Cipher.ENCRYPT_MODE, desKey);

		cByte = c.doFinal(str.getBytes("UTF-8"));

		return cByte;
	}
}
