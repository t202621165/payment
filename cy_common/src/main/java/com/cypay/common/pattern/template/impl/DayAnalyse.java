package com.cypay.common.pattern.template.impl;

import org.springframework.stereotype.Component;

import com.cypay.common.pattern.template.AnalyseTemplate;

/**
 * 订单-日交易数据分析
 * @author International
 *
 */
@Component
public class DayAnalyse extends AnalyseTemplate {

	@Override
	public String getType() {
		return "day";
	}
	
	@Override
	public void select(StringBuilder sql) {
		sql.append(", DATE_FORMAT(o.order_date,'%Y-%m-%d') AS days");
	}

	@Override
	public void group(StringBuilder sql) {
		sql.append(" GROUP BY days");
	}
	
	@Override
	public void order(StringBuilder sql) {
		sql.append(" ORDER BY days");
	}

}
