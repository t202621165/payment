package com.cypay.pay.notice.impl;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.huilian.Config;
import com.cypay.common.util.huilian.HuiLianTool;
import com.cypay.common.util.huilian.XmlSignUtil;
import com.cypay.pay.notice.BaseNotice;
import com.cypay.pay.notice.Notice;

@Notice
public class NoticeToHuiLian extends BaseNotice {

	@Override
	public String notifyType() {
		// TODO Auto-generated method stub
		return PaymentType.HUILIAN.type();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		setIsSuccess(true);
		
		setOrderNumber(getData("OutTradeNo"));
		
		setSupNumber(getData("PayChannelOrderNo"));
		
		setPayAmount(new BigDecimal(
				String.format("%.2f", Double.valueOf(getData("TotalAmount")) * 0.01)));
	}

	@Override
	protected void initPreprocess() {
		// TODO Auto-generated method stub
		setResultCode("SUCCESS");
	}

	@Override
	protected void parseData(HttpServletRequest request) {
		setData(HuiLianTool.INSTANCE.parseReceive(request, ""));
	}
	
	@Override
	protected boolean verify(String secretKey) {
		String response = getData("response");
		try {
			return XmlSignUtil.verify(response, Config.huiLianRsaPublicKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

}
