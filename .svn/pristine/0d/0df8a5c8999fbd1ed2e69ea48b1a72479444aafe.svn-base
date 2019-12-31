package com.cypay.pay.notice.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.MD5Util;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

@Notice
public class NoticeToQianTai extends BaseNotice {
	
	private String json;

	@Override
	public String notifyType() {
		// TODO Auto-generated method stub
		return PaymentType.QIANTAI.type();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void parseData(HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			this.json = new String(readInputStream(request.getInputStream()),"UTF-8");
			logger.info("钱台异步通知参数:{}",json);
			setData(JSONObject.parseObject(json,HashMap.class));
			getData().put("sign", request.getHeader("X-QF-SIGN"));
			logger.info("DATA参数:{}",getData());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}

	private byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		return outSteam.toByteArray();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub

		String paymoney = String.format("%.2f", Double.valueOf(getData("txamt")) * 0.01);

		setIsSuccess("1".equals(getData("status")));

		setOrderNumber(getData("out_trade_no"));

		setSupNumber(getData("syssn"));

		setPayAmount(new BigDecimal(paymoney));

		setSign(getData("sign"));
	}

	@Override
	protected void initPreprocess() {
		// TODO Auto-generated method stub
		setResultCode("SUCCESS");
	}
	
	@Override
	protected boolean verify(String secretKey) {
		// TODO Auto-generated method stub
		return MD5Util.verify(this.json, getData("sign"), secretKey, "utf-8");
	}

}
