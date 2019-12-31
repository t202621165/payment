package com.cypay.common.pattern.template.impl;

import org.springframework.stereotype.Component;

import com.cypay.common.pattern.template.AnalyseTemplate;

/**
 * 订单-时间段(小时)数据分析
 * @author International
 *
 */
@Component
public class HourAnalyse extends AnalyseTemplate {

	@Override
	public String getType() {
		return "hour";
	}
	
	@Override
	public void select(StringBuilder sql) {
		sql.append(", HOUR(o.order_date) AS orderDate");
	}

	@Override
	public void group(StringBuilder sql) {
		sql.append(" GROUP BY orderDate");
	}
	
	@Override
	public void order(StringBuilder sql) {
		sql.append(" ORDER BY orderDate");
	}

}
