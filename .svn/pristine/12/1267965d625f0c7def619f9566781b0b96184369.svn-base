package com.cypay.pay.payment.impl;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.annotation.NoSignature;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.DUtil;
import com.cypay.pay.payment.GenericSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;

@Payment
public class PayByYinLianShangWu extends GenericSignSortPayment{
	
	private String msgSrc;
	
	private String msgType;
	
	private String requestTimestamp;
	
	private String mid;
	
	private String tid;
	
	private String instMid;
	
	private String billNo;
	
	@PublicData(value = "orderNumber")
	private String memberId;
	
	private String billDate;
	
	@PublicData(value = "amount", type = AmountType.YUAN)
	private String totalAmount;
	
	@PublicData(value = "notifyUrl")
	private String notifyUrl;
	
	@NoSignature
	private String sign;

	@Override
	public void setPaymentType() {
		// TODO Auto-generated method stub
		this.paymentType = PaymentType.YINLIAN;
	}
	
	@Override
	protected void initPostProcess(RechargeVo recharge) {
		// TODO Auto-generated method stub
		super.initPostProcess(recharge);
		this.msgSrc = recharge.getAccount().split("\\|")[3];
		this.msgType = "bills.getQRCode";
		this.requestTimestamp = DUtil.format("yyyy-MM-dd HH:mm:ss");
		this.billNo = recharge.getAccount().split("\\|")[4].concat(DUtil.format("yyyyMMHHmmssSSS")).concat(RandomUtil.randomNumbers(7));
		this.billDate = DUtil.format("yyyy-MM-dd");
		this.mid = recharge.getAccount().split("\\|")[0];
		this.tid = recharge.getAccount().split("\\|")[1];
		this.instMid = recharge.getAccount().split("\\|")[2];
	}
	
	@Override
	protected Resultful getQRCodeURL() {
		// TODO Auto-generated method stub
		String result = HttpRequest.post(domainName).body(getParamStr()).execute().body();
		logger.info("【银联下单请求参数:{}】",getParamStr());
		logger.info("【银联商务下单响应:{}】：",result);
		if (!StringUtils.isEmpty(result)){
			JSONObject ob = JSONObject.parseObject(result);
			if ("SUCCESS".equals(ob.getString("errCode")))
				return Resultful.qrCodeURL(ob.getString("billQRCode"), billNo,String.format("%.2f", Double.valueOf(totalAmount)));	
			else
				return Resultful.error(ob.getString("errMsg"));
		}
		return Resultful.error("下单失败");
	}

	public String getMsgSrc() {
		return msgSrc;
	}

	public void setMsgSrc(String msgSrc) {
		this.msgSrc = msgSrc;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(String requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getInstMid() {
		return instMid;
	}

	public void setInstMid(String instMid) {
		this.instMid = instMid;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
}
