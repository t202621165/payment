package com.cypay.pay.payment.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.annotation.NotParam;
import com.cypay.common.annotation.PublicData;
import com.cypay.common.enums.AmountType;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.util.DUtil;
import com.cypay.pay.payment.GenericSignSortPayment;
import com.cypay.pay.payment.Payment;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;

@Payment(upperCase = true)
public class PayByQianTaiZfb extends GenericSignSortPayment{
	
	@PublicData(value = "amount",type = AmountType.CENT)
	private String txamt;
	
	private String txcurrcd = "CNY";
	
	private String pay_type = "800101";
	
	@PublicData(value = "orderNumber")
	private String out_trade_no;
	
	private String txdtm;
	
	private String mchid;
	
	@NotParam
	private String sign;
	
	@NotParam
	private String code;

	@Override
	public void setPaymentType() {
		// TODO Auto-generated method stub
		this.paymentType = PaymentType.QIANTAI;
	}
	
	@Override
	public String mark() {
		return super.mark() + "_alipay";
	}

	@Override
	protected void initPostProcess(RechargeVo recharge) {
		// TODO Auto-generated method stub
		this.txdtm = DUtil.format("yyyy-MM-dd HH:mm:ss");
		this.mchid = recharge.getAccount().split("\\|")[0];
		this.code = recharge.getAccount().split("\\|")[1];
	}
	
	@Override
	protected Resultful getQRCodeURL() {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("X-QF-APPCODE",this.code);
		headers.add("X-QF-SIGN",this.getSign());
		ResponseEntity<String> result = restTemplate.postForEntity(domainName.concat("/trade/v1/payment"), getEntitys(headers), String.class);
		if (!StringUtils.isEmpty(result.getBody())){
			JSONObject ob = JSONObject.parseObject(result.getBody());
			if ("0000".equals(ob.getString("respcd"))){
				String url = ob.getString("qrcode");	
				return Resultful.qrCodeURL(url, this.getOut_trade_no(),String.format("%.2f", Double.valueOf(this.getTxamt()) * 0.01));
			}
						
		}
		logger.info("【钱台-同步获取二维码URL】：" + result.getBody());
		return Resultful.error("下单失败");
	}

	public String getTxamt() {
		return txamt;
	}

	public void setTxamt(String txamt) {
		this.txamt = txamt;
	}

	public String getTxcurrcd() {
		return txcurrcd;
	}

	public void setTxcurrcd(String txcurrcd) {
		this.txcurrcd = txcurrcd;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTxdtm() {
		return txdtm;
	}

	public void setTxdtm(String txdtm) {
		this.txdtm = txdtm;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
