package com.cypay.common.pattern.template.payee.wechat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.NotParam;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.MD5Util;

import cn.hutool.core.util.IdUtil;

/**
 * 微信代付请求参数
 * @author International
 * @2019年3月15日 下午5:22:37
 */
@XmlRootElement(name="xml")
public class WechatPayRequest implements Serializable{

	@NotParam
	private static final long serialVersionUID = -4571921068591361954L;
	
	private String mch_appid;
	
	private String mchid;
	
	private String nonce_str = IdUtil.fastSimpleUUID();
	
	private String partner_trade_no;
	
	private String openid;
	
	private String check_name = "NO_CHECK";
	
	private String amount;
	
	private String desc;
	
	private String spbill_create_ip;
	
	@NoSignature
	private String sign;
	
	public WechatPayRequest() {}
	
	public WechatPayRequest(BigDecimal amount, String desc, String mch_appid, 
			String mchid, String openid, String partner_trade_no, String ip) {
		this.amount = String.format("%.0f", amount.doubleValue()*100);
		this.desc = desc;
		this.mch_appid = mch_appid;
		this.mchid = mchid;
		this.openid = openid;
		this.partner_trade_no = partner_trade_no;
		this.spbill_create_ip = ip;
	}

	public void MD5Sign(String key) {
		this.sign = MD5Util.signToUpperCase(CommonUtil.getSignStr(this), "&key="+key, "UTF-8");
	}
	
	@XmlElement(name="mch_appid")
	public String getMch_appid() {
		return mch_appid;
	}

	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}

	@XmlElement(name="mchid")
	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}
	
	@XmlElement(name="nonce_str")
	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	
	@XmlElement(name="partner_trade_no")
	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	@XmlElement(name="openid")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@XmlElement(name="check_name")
	public String getCheck_name() {
		return check_name;
	}

	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}

	@XmlElement(name="amount")
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@XmlElement(name="desc")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@XmlElement(name="spbill_create_ip")
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	@XmlElement(name="sign")
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	@Override
	public String toString() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			JAXBContext context = JAXBContext.newInstance(this.getClass());
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(this, out);
			return new String(out.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
