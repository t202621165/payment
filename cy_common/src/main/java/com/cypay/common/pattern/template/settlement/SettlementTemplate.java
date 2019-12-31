package com.cypay.common.pattern.template.settlement;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cypay.common.entity.SettleMent;
import com.cypay.common.enums.SettlementBusiness;
import com.cypay.common.repository.impl.SettleMentRepository;
import com.cypay.common.util.SnowflakeIdWorker;
import com.cypay.common.vo.Result;

/**
 * 资金结算模板
 * @author International
 * @2019年3月18日 下午5:57:11
 */
@Component
public abstract class SettlementTemplate {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	@Autowired
	protected SnowflakeIdWorker snowflakeIdWorker;
	
	@Autowired
	private SettleMentRepository settleMentRepository;

	protected abstract Consumer<? super SettleMent> getAction(String discription);
	
	protected abstract SettlementBusiness getSettlementBus();
	
	public String mark() {
		return getSettlementBus().mark();
	}
	
	protected  void postProcess(List<SettleMent> settlements) {}
	
	public final Result settlement(List<Long> ids, String discription) {
		// 根据当前业务处理的state查询待结算记录
		List<SettleMent> settlements = settleMentRepository.findByStateAndIdIn(getSettlementBus().state(), ids);
		if (!settlements.isEmpty()) {
			settlements.stream().forEach(getAction(discription));
			
			postProcess(settlements);
			return Result.success(getSettlementBus().msg());
		}
		
		return Result.error("暂无可结算记录");
	}
}
