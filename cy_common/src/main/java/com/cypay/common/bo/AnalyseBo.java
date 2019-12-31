package com.cypay.common.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyseBo {
	
	public List<Object[]> productDayReports; //产品日交易统计
	
	public List<Object[]> merchantDayReports; //商户日交易统计
	
	public List<Object[]> orderHourReports; //订单时段交易统计
	
	public List<Object> productNames = new ArrayList<Object>(); //产品名称
	
	public List<Object> payAmounts = new ArrayList<Object>(); //充值金额
	
	public List<Object> merchantProfits = new ArrayList<Object>(); //商户利润
	
	public List<Object> platformProfits = new ArrayList<Object>(); //平台利润
	
	public List<Object> nickNames = new ArrayList<Object>(); //商户昵称
	
	public List<Map<String,Object>> pie = new ArrayList<Map<String,Object>>(); //商户日交易
	
	public List<Object> dates = new ArrayList<Object>(); //日期时间段

	public List<Object[]> getProductDayReports() {
		return productDayReports;
	}
	

	public List<Object[]> getMerchantDayReports() {
		return merchantDayReports;
	}


	public List<Object[]> getOrderHourReports() {
		return orderHourReports;
	}
	
	public void setMerchantDayReports(List<Object[]> merchantDayReports) {
		if (merchantDayReports.size() == 0){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("name","暂无交易记录");
			map.put("value",0);
			this.nickNames.add("暂无交易记录"); //商户昵称
			this.pie.add(map);
		}else{
			for(Object[] objects : merchantDayReports){
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("name", objects[5]);
				map.put("value",objects[1]);
				this.nickNames.add(objects[5]); //商户昵称
				this.pie.add(map);
			}
		}
		this.merchantDayReports = merchantDayReports;
	}

}
