package com.cypay.common.vo;

import java.io.Serializable;

/**
 * 操作结果
 * @author International
 *
 */
public class Result implements Serializable ,Cloneable {

	private static final long serialVersionUID = 1L;

	/**成功*/
	private static final Result SUCCESS = new Result(true, "操作成功！", "", null);
	
	/**失败*/
	private static final Result ERROR = new Result(false, "操作失败！", "","");
	
	private Boolean state;
	
	private String msg;
	
	private String ele;
	
	private Object data;
	
	private Result(Boolean state, String msg, String ele,Object data) {
		this.state = state;
		this.msg = msg;
		this.ele = ele;
		this.data = data;
	}
	
	public static Result success() {
		try {
			return SUCCESS.clone();
		} catch (CloneNotSupportedException e) {
			return new Result(true, "操作成功！", "", null);
		}
	}
	
	public static Result success(String msg) {
		return success().setMsg(msg);
	}
	
	public static Result success(String msg, String ele) {
		return success().setMsg(msg).setEle(ele);
	}
	
	public static Result success(String msg, Object data) {
		return success().setMsg(msg).setData(data);
	}
	
	public static Result error() {
		try {
			return ERROR.clone();
		} catch (CloneNotSupportedException e) {
			return new Result(false, "操作失败！", "","");
		}
	}
	
	public static Result error(String msg) {
		return error().setMsg(msg);
	}
	
	public static Result error(String msg, String ele) {
		return error().setMsg(msg).setEle(ele);
	}
	
	public static Result error(String msg, Object data) {
		return error().setMsg(msg).setData(data);
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public Result setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public String getEle() {
		return ele;
	}

	public Result setEle(String ele) {
		this.ele = ele;
		return this;
	}

	public Object getData() {
		return data;
	}

	public Result setData(Object data) {
		this.data = data;
		return this;
	}
	
	@Override
	protected Result clone() throws CloneNotSupportedException {
		return (Result) super.clone();
	}

	@Override
	public String toString() {
		return "Result [state=" + state + ", msg=" + msg + ", ele=" + ele + ", data=" + data + "]";
	}
	
}
