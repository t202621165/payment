package com.cypay.common.pattern.template.impl;

import org.springframework.stereotype.Component;

import com.cypay.common.pattern.template.AnalyseTemplate;
import com.cypay.common.shiro.ShiroManager;

/**
 * 订单-产品数据分析
 * @author International
 *
 */
@Component
public class ProductAnalyse extends AnalyseTemplate {

	@Override
	public String getType() {
		return "product";
	}
	
	@Override
	public void select(StringBuilder sql) {
		if (ShiroManager.isAdminUser()) {
			sql.append(", p.mark_name");
		} else {
			sql.append(", IF(p.type_mark='ebank', p.mark_name, p.name)");
		}
	}

	@Override
	public void join(StringBuilder sql) {
		sql.append(" RIGHT JOIN cy_product p ON p.id = o.product_id");
	}

	@Override
	public void group(StringBuilder sql) {
		if (ShiroManager.isAdminUser()) {
			sql.append(" GROUP BY p.type_mark");
		} else {
			sql.append(" GROUP BY IF(p.type_mark='ebank', p.type_mark, p.mark)");
		}
	}

}
