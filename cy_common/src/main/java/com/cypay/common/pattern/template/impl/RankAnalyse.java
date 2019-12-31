package com.cypay.common.pattern.template.impl;

import org.springframework.stereotype.Component;

import com.cypay.common.pattern.template.AnalyseTemplate;

/**
 * 订单-玩家充值排行数据分析
 * @author International
 *
 */
@Component
public class RankAnalyse extends AnalyseTemplate {

	@Override
	public String getType() {
		return "rank";
	}
	
	@Override
	public void select(StringBuilder sql) {
		sql.append(", o.player_account");
	}

	@Override
	public void group(StringBuilder sql) {
		sql.append(" GROUP BY o.player_account");
	}

}
