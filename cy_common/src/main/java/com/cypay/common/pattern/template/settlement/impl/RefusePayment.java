package com.cypay.common.pattern.template.settlement.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cypay.common.entity.SettleMent;
import com.cypay.common.enums.SettlementBusiness;
import com.cypay.common.pattern.template.settlement.SettlementTemplate;

/**
 * 拒绝付款
 * @author International
 * @2019年3月18日 下午5:55:12
 */
@Component
public class RefusePayment extends SettlementTemplate {

	@Override
	protected SettlementBusiness getSettlementBus() {
		return SettlementBusiness.REFUSE_PAYMENT;
	}
	
	@Override
	protected Consumer<? super SettleMent> getAction(String discription) {
		return s -> {
			s.setState(getSettlementBus().nextState());
			s.setComplateDate(new Date());
			if (!StringUtils.isEmpty(discription)) {
				s.setDiscription(discription);
			}
		};
	}
	
	@Override
	protected void postProcess(List<SettleMent> settlements) {
		jdbcTemplate.batchUpdate("UPDATE cy_bank b SET b.over_money = b.over_money + ?, b.all_pay = b.all_pay - ? WHERE b.id = ?", 
				new BatchPreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						SettleMent s = settlements.get(i);
						BigDecimal amount = s.getAmount().add(s.getCost());
						ps.setBigDecimal(1, amount);
						ps.setBigDecimal(2, amount);
						ps.setLong(3, s.getBank().getId());
					}
					
					@Override
					public int getBatchSize() {
						return settlements.size();
					}
				});
	}
}
