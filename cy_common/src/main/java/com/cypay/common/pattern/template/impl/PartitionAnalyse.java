package com.cypay.common.pattern.template.impl;

import org.springframework.stereotype.Component;

import com.cypay.common.pattern.template.AnalyseTemplate;

/**
 * 订单-游戏分区数据分析
 * @author International
 *
 */
@Component
public class PartitionAnalyse extends AnalyseTemplate {

	@Override
	public String getType() {
		return "partition";
	}
	
	@Override
	public void select(StringBuilder sql) {
		sql.append(", IF(p.is_change_in_time,IF(NOW() > p.change_date, p.use_name, p.name),p.name)");
	}

	@Override
	public void join(StringBuilder sql) {
		sql.append(" LEFT JOIN cy_partition p ON p.id = o.partition_id");
	}

	@Override
	public void group(StringBuilder sql) {
		sql.append(" GROUP BY p.id");
	}

}
