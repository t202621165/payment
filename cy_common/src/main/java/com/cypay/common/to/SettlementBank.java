package com.cypay.common.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 结算银行
 * @author International
 *
 */
public class SettlementBank implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static List<SettlementBank> banks = new ArrayList<SettlementBank>();

	private String mark;
	
	private String name;
	
	static {
		banks.add(new SettlementBank("ALI", "支付宝"));
		banks.add(new SettlementBank("ABC", "农业银行"));
		banks.add(new SettlementBank("BOC", "中国银行"));
		banks.add(new SettlementBank("CCB", "建设银行"));
		banks.add(new SettlementBank("CMB", "招商银行"));
		banks.add(new SettlementBank("ICBC", "工商银行"));
		banks.add(new SettlementBank("PSBC", "邮政储蓄"));
	}
	
	public SettlementBank() {
		
	}
	
	public SettlementBank(String mark, String name) {
		this.mark = mark;
		this.name = name;
	}
	
	public static String getMarkByName(String name){
		return banks.parallelStream().filter(bank -> bank.getName().equals(name)).findFirst().get().getMark();
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bank [mark=" + mark + ", name=" + name + "]";
	}
	
}
