package com.cypay.common.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 资费标准
 * @author iwano
 *
 */
public class FeeStandard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static List<FeeStandard> feeStandards = new ArrayList<FeeStandard>();
	
	static {
		feeStandards.add(new FeeStandard("网上银行","单笔金额50000以内,大客户洽谈分成！","联系客服","T0"));
		feeStandards.add(new FeeStandard("支付宝","单笔金额50000以内,大客户洽谈分成！","联系客服","T0"));
		feeStandards.add(new FeeStandard("微信","单笔金额50000以内,大客户洽谈分成！","联系客服","T0"));
		feeStandards.add(new FeeStandard("花呗","单笔金额50000以内,大客户洽谈分成！","联系客服","T0"));
		feeStandards.add(new FeeStandard("QQ钱包","单笔金额50000以内,大客户洽谈分成！","联系客服","T0"));
		feeStandards.add(new FeeStandard("财付通","单笔金额50000以内,大客户洽谈分成！","联系客服","T0"));
		feeStandards.add(new FeeStandard("银联扫码","单笔金额50000以内,大客户洽谈分成！","联系客服","T0"));
	}
	
	/**支付类型*/
	private String type;
	
	/**支持金额描述*/
	private String des;
	
	/**商户比例*/
	private String rate;
	
	/**结算周期*/
	private String settleType;
	
	public FeeStandard(){};

	public FeeStandard(String type, String des, String rate, String settleType) {
		super();
		this.type = type;
		this.des = des;
		this.rate = rate;
		this.settleType = settleType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getSettleType() {
		return settleType;
	}

	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
