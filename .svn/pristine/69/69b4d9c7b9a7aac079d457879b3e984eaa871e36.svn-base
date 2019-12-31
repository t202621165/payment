package com.cypay.common.pattern.template.impl;

import org.springframework.stereotype.Component;

import com.cypay.common.pattern.template.AnalyseTemplate;

/**
 * 订单-分组数据分析
 * @author International
 *
 */
@Component
public class GroupAnalyse extends AnalyseTemplate {

	@Override
	public String getType() {
		return "group";
	}
	
	@Override
	public void select(StringBuilder sql) {
		sql.append(", g.name");
	}

	@Override
	public void join(StringBuilder sql) {
		if (getGroupModle() == 0){
			sql.append(" LEFT JOIN cy_group g ON g.id = o.group_id");
		}		
		if (getGroupModle() == 1){
			sql.append(" LEFT JOIN cy_partition p ON p.id = o.partition_id");
			sql.append(" LEFT JOIN cy_partition_group pg ON pg.partition_id = p.id");
			sql.append(" LEFT JOIN cy_group g ON g.id = pg.group_id");
		}
	}

	@Override
	public void group(StringBuilder sql) {
		sql.append(" GROUP BY g.id");
	}

}
