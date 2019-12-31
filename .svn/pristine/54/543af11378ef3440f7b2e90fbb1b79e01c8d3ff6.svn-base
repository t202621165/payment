package com.cypay.common.pattern.template.payee;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cypay.common.entity.DaiFu;
import com.cypay.common.entity.SettleMentReply;
import com.cypay.common.repository.impl.SettleMentReplyRepository;
import com.cypay.common.repository.impl.SettleMentRepository;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.SnowflakeIdWorker;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.SettleMentVo;

@Component
public abstract class PayeeTemplate {
	
	@Autowired
	protected SnowflakeIdWorker snowflakeIdWorker;
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	@Autowired
	protected SettleMentRepository settleMentRepository;
	
	@Autowired
	private SettleMentReplyRepository settleMentReplyRepository;
	
	public abstract String mark();
	
	protected abstract String getSerialNumber();
	
	protected abstract Result init(List<SettleMentVo> settlements, DaiFu daiFu, HttpServletRequest request);
	
	protected abstract Predicate<? super SettleMentVo> getPredicate();
	
	protected void updateSettlements(SettleMentReply settleMentReply, List<SettleMentVo> settlements) {
		List<Long> ids = settlements.parallelStream().map(SettleMentVo::getSettlementId).collect(Collectors.toList());
		settleMentRepository.updateByIds(settleMentReply, 3, ids);
	}
	
	public final Result payee(List<Long> ids, DaiFu daiFu, HttpServletRequest request) {
		// 查询等待待付款记录
		List<SettleMentVo> settlements = settleMentRepository.findPayeeRecords(2, ids);
		System.out.println("待付款记录:"+settlements.size());
		// 获取可代付记录
		List<SettleMentVo> payeeList = settlements.parallelStream().filter(getPredicate()).collect(Collectors.toList());
		if (!payeeList.isEmpty()) {
			return init(payeeList, daiFu, request);
		}
		return Result.error("暂无可代付记录(支付宝代付：需要绑定银行账户为支付宝的用户；微信代付：需要用户绑定微信账号)");
	}
	
	protected SettleMentReply saveBatchRecord(List<SettleMentVo> settlements) {
		SettleMentReply settleMentReply = new SettleMentReply();
		settleMentReply.setReplyDate(new Date());
		settleMentReply.setSerialNumber(getSerialNumber());
		settleMentReply.setState(false);
		settleMentReply.setUser(ShiroManager.getUser());
		
		// 保存批复记录
		settleMentReplyRepository.save(settleMentReply);
		updateSettlements(settleMentReply, settlements);
		return settleMentReply;
	}
}
