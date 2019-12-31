package com.cypay.pay.vo;

import java.io.Serializable;

public class Resultful implements Serializable {

	private static final long serialVersionUID = 1L;

	/**是否下单成功*/
	private boolean state;
	
	/**付款类型-true：二维码 false：付款跳转链接*/
	private boolean type;
	
	private boolean isIframe;
	
	/**是否后台创建二维码*/
	private boolean createQrCode = true;
	
	/**返回信息*/
	private String msg = "";
	
	/*风控提示*/
	private String tip = "";
	
	/**订单号*/
	private String orderNumber;
	
	/*订单金额*/
	private String amount;
	
	private Resultful() {
		
	}
	
	private Resultful(boolean state, boolean type, String msg) {
		this.state = state;
		this.type = type;
		this.msg = msg;
	}
	
	private Resultful(boolean state, boolean type, String msg, String orderNumber,String amount) {
		this(state, type, msg);
		this.orderNumber = orderNumber;
		this.amount = amount;
	}
	
	private Resultful(boolean state, boolean type, String msg, String orderNumber,String amount,boolean createQrCode) {
		this(state, type, msg, orderNumber, amount);
		this.createQrCode = createQrCode;
	}
	
	private Resultful(boolean state, boolean type, String msg,String tip, String orderNumber,String amount) {
		this(state, type, msg, orderNumber, amount);
		this.tip = tip;
	}
	
	/**
	 * 下单成功：返回付款跳转链接
	 * @param msg
	 * @return
	 */
	public static Resultful redirectURL(String msg) {
		return new Resultful(true, false, msg);
	}
	
	/**
	 * 下单成功：返回二维码URL和订单号
	 * @param msg
	 * @return
	 */
	public static Resultful qrCodeURL(String msg, String orderNumber,String amount) {
		return new Resultful(true, true, msg, orderNumber,amount);
	}
	
	public static Resultful qrCodeURL(String msg, String orderNumber,String amount,boolean createQrCode){
		return new Resultful(true,true,msg,orderNumber,amount,createQrCode);
	}
	
	/**
	 * 下单成功：返回二维码URL和订单号
	 * @param msg
	 * @return
	 */
	public static Resultful qrCodeURL(String msg,String tip, String orderNumber,String amount) {
		return new Resultful(true, true, msg,tip, orderNumber,amount);
	}
	
	/**
	 * 下单失败：返回错误信息
	 * @param msg
	 * @return
	 */
	public static Resultful error(String msg) {
		return new Resultful(false, false, msg);
	}

	public boolean isState() {
		return state;
	}

	public Resultful setState(boolean state) {
		this.state = state;
		return this;
	}

	public boolean isType() {
		return type;
	}

	public Resultful setType(boolean type) {
		this.type = type;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public Resultful setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public Resultful setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}
	

	public String getAmount() {
		return amount;
	}

	public Resultful setAmount(String amount) {
		this.amount = amount;
		return this;
	}

	public String getTip() {
		return tip;
	}

	public Resultful setTip(String tip) {
		this.tip = tip;
		return this;
	}

	public boolean isIframe() {
		return isIframe;
	}

	public Resultful setIframe(boolean isIframe) {
		this.isIframe = isIframe;
		return this;
	}

	public boolean isCreateQrCode() {
		return createQrCode;
	}

	public Resultful setCreateQrCode(boolean createQrCode) {
		this.createQrCode = createQrCode;
		return this;
	}

	@Override
	public String toString() {
		return "ResultfulVo [state=" + state + ", type=" + type + ", msg=" + msg + ", orderNumber=" + orderNumber + "]";
	}
	
}
