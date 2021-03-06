package com.cypay.common.enums;

/**
 * 结算业务-结算流程
 * @author International
 * @2019年3月19日 下午6:09:56
 */
public enum SettlementBusiness {

	/**
	 * 审核未通过（拒绝审核）->资金退回
	 * state: 0 等待审核
	 * nextState: -1 拒绝审核
	 */
	REFUSE_TO_AUDIT("拒绝审核", 0, -1, "驳回成功,资金已退回至账户余额！"), 
	/**
	 * 审核通过->等待付款
	 * state: 0 等待审核
	 * nextState: 2 等待付款
	 */
	AGREE_TO_AUDIT("审核通过", 0, 2, "请前往‘资金管理 ->提现业务->待付款’列表完成结算！"), 
	/**
	 * 拒绝付款->资金退回
	 * state: 2 等待付款
	 * nextState: -2 拒绝付款
	 */
	REFUSE_PAYMENT("拒绝付款", 2, -2, "驳回成功,资金已退回至账户余额！"), 
	/**
	 * 同意付款->批复处理
	 * state: 0 等待审核
	 * nextState: 3 批复处理中
	 */
	AGREE_PAYMENT0("同意付款", 0, 3, "请前往‘资金管理 ->批复记录’中查看处理结果！"),
	/**
	 * 同意付款->批复处理
	 * state: 2 等待付款
	 * nextState: 3 批复处理中
	 */
	AGREE_PAYMENT("同意付款", 2, 3, "请前往‘资金管理 ->批复记录’中查看处理结果！")
	;
	
	/**
	 * 业务名称
	 */
	private String name;
	/**
	 * 当前状态值
	 */
	private Integer state;
	/**
	 * 下一步流程状态值
	 */
	private Integer nextState;
	/**
	 * 业务处理完成描述
	 */
	private String msg;
	
	private SettlementBusiness(String name, Integer state, Integer nextState, String msg) {
		this.name = name;
		this.state = state;
		this.nextState = nextState;
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public Integer state() {
		return state;
	}
	
	public Integer nextState() {
		return nextState;
	}

	public String mark() {
		return this.toString();
	}
	
	public String msg() {
		return msg;
	}
}
