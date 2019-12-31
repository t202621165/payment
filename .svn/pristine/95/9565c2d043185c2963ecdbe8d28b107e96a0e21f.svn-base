package com.cypay.common.pattern.template.payee.wechat;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cypay.common.entity.DaiFu;
import com.cypay.common.entity.SettleMentReply;
import com.cypay.common.pattern.template.payee.PayeeTemplate;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.SettleMentVo;

import cn.hutool.core.date.DateUtil;

@Component
public class WechatPayee extends PayeeTemplate {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public String mark() {
		return "wechat";
	}
	
	@Override
	protected String getSerialNumber() {
		return "W" + snowflakeIdWorker.nextId();
	}
	
	@Override
	protected void updateSettlements(SettleMentReply settleMentReply, List<SettleMentVo> settlements) {
		String sql = "update cy_settle_ment set state = 1, settle_ment_reply_id = ?, discription = ?, complate_date = ? where id = ?";
		Long replyId = settleMentReply.getId();
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				SettleMentVo v = settlements.get(i);
				ps.setLong(1, replyId);
				ps.setString(2, v.getDiscription());
				ps.setTimestamp(3, new Timestamp(v.getComplateDate().getTime()));
				ps.setLong(4, v.getSettlementId());
			}
			
			@Override
			public int getBatchSize() {
				return settlements.size();
			}
		});
	}

	@Override
	protected Result init(List<SettleMentVo> settlements, DaiFu daiFu, HttpServletRequest request) {
		List<SettleMentVo> list = settlements.parallelStream().map(s -> {
			try {
				WechatPayRequest wechat = new WechatPayRequest(s.getAmount(), daiFu.getRemark(), daiFu.getEmail(), 
						daiFu.getPartner(), s.getOpenid(), s.getSerialNumber(), CommonUtil.getIpAddr(request));
				wechat.MD5Sign(daiFu.getSecurityKey());
				WechatPayResponse response = WechatPayResponse.getResponse(wechat, daiFu.getReqUrl());
				logger.info("【微信代付-{}：{}】",s.getSerialNumber(), response == null ? "":response.toString());
				if (response != null && "SUCCESS".equals(response.getReturn_code()) 
						&& "SUCCESS".equals(response.getResult_code())) {
					s.setComplateDate(DateUtil.parse(response.getPayment_time()));
					s.setDiscription("微信代付");
					return s;
				}
			} catch (IOException e) {
				e.printStackTrace();
				logger.info("【微信代付-{}：{}】",s.getSerialNumber(), e.getMessage());
			}
			return null;
		}).filter(s -> s != null).collect(Collectors.toList());
		
		if (!list.isEmpty()) {
			saveBatchRecord(list);
			return Result.success("请前往‘资金管理 ->批复记录’中查看处理结果！");
		}
		return Result.error("付款失败(微信)，请检查代付账户信息！");
	}

	@Override
	protected Predicate<? super SettleMentVo> getPredicate() {
		return s -> !StringUtils.isEmpty(s.getOpenid());
	}
	
}
