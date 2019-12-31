package com.cypay.common.pattern.template.payee.wechat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.fastjson.JSON;

/**
 * 微信代付响应结果
 * @author International
 * @2019年3月15日 下午5:22:16
 */
@XmlRootElement(name="xml")
public class WechatPayResponse implements Serializable{

	private static final long serialVersionUID = 4005186385466279956L;
	
	private static final String CHARSET = "UTF-8";
	
	private String return_code;
	
	private String return_msg;
	
	private String result_code;
	
	private String mch_appid;
	
	private String mchid;
	
	private String partner_trade_no;
	
	private String payment_no;
	
	private String payment_time;
	
	private String err_code;
	
	private String err_code_des;

	@XmlElement(name="return_code")
	public String getReturn_code() {
		return return_code;
	}
	
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	
	@XmlElement(name="return_msg")
	public String getReturn_msg() {
		return return_msg;
	}
	
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	
	@XmlElement(name="result_code")
	public String getResult_code() {
		return result_code;
	}
	
	public void setResult_code(String result_code) {
		this.result_code = result_code;
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

	@XmlElement(name="partner_trade_no")
	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	@XmlElement(name="payment_no")
	public String getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	@XmlElement(name="payment_time")
	public String getPayment_time() {
		return payment_time;
	}

	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}

	@XmlElement(name="err_code")
	public String getErr_code() {
		return err_code;
	}
	
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	
	@XmlElement(name="err_code_des")
	public String getErr_code_des() {
		return err_code_des;
	}
	
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	public static WechatPayResponse getResponse(WechatPayRequest request, String url) throws IOException {
		InputStream in = null;
		try {
			String result = ClientCustomSSL.SSL(url, request, CHARSET);
			in = new ByteArrayInputStream(result.getBytes(CHARSET));
			JAXBContext context = JAXBContext.newInstance(WechatPayResponse.class);
			Unmarshaller unmarshaller = context.createUnmarshaller(); 
			return (WechatPayResponse) unmarshaller.unmarshal(in);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return null;
	}
	
}
