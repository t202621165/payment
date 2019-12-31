package com.cypay.common.pattern.template.impl;

import org.springframework.stereotype.Component;

import com.cypay.common.pattern.template.AnalyseTemplate;

/**
 * 订单-商户数据分析
 * @author International
 *
 */
@Component
public class MerchantAnalyse extends AnalyseTemplate {

	@Override
	public String getType() {
		return "merchant";
	}
	
	@Override
	public void select(StringBuilder sql) {
		sql.append(", m.account");
	}

	@Override
	public void group(StringBuilder sql) {
		sql.append(" GROUP BY m.id");
	}

}
