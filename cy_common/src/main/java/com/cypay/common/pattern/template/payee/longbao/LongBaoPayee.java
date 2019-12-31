package com.cypay.common.pattern.template.payee.longbao;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.DaiFu;
import com.cypay.common.entity.SettleMentReply;
import com.cypay.common.pattern.template.payee.PayeeTemplate;
import com.cypay.common.service.impl.SettleMentReplyService;
import com.cypay.common.service.impl.SettleMentService;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.SettleMentVo;

import cn.hutool.http.HttpRequest;

@Component
public class LongBaoPayee extends PayeeTemplate {

	@Autowired
	private SettleMentReplyService settleMentReplyService;
	@Autowired
	private SettleMentService settleMentService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String mark() {
		// TODO Auto-generated method stub
		return "longbao";
	}

	@Override
	protected String getSerialNumber() {
		// TODO Auto-generated method stub
		return "A" + snowflakeIdWorker.nextId();
	}

	@Override
	protected Result init(List<SettleMentVo> settlements, DaiFu daiFu, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int i = 0;
		String msg = "";
		SettleMentReply reply = saveBatchRecord(settlements);
		try {
			for (SettleMentVo settlement : settlements) {
				LongBaoRequest longBao = new LongBaoRequest(daiFu.getPartner(), settlement.getSerialNumber(),
						String.format("%.2f", settlement.getAmount().doubleValue()), settlement.getBankNumber(),
						settlement.getRealName(), daiFu.getSecurityKey(),this.getBankCode(settlement.getMark()));
				logger.info("请求报文:{}",daiFu.getReqUrl()+"?"+new String(longBao.requestParam().getBytes()),"GB2312");
				String result = HttpRequest.post(daiFu.getReqUrl()).body(longBao.requestParam().getBytes("GB2312")).charset("GB2312").execute().body();
				logger.info("龙宝代付响应参数:{}",result);
				if (!StringUtils.isEmpty(result)){
					JSONObject resp = JSONObject.parseObject(result);
					if (resp.getString("code").equals("0000")){
						i++;
						settleMentService.updateStateById(1, settlement.getSettlementId(),new Date(),"龙宝代付");
						logger.info("龙宝代付调用成功");					
					}else{
						msg = resp.getString("msg");
						logger.info("龙宝代付调用失败");
					}
				}
			}
			if (i == settlements.size()) {
				// 根据批次号更新付款状态
				reply.setState(true);
				settleMentReplyService.update(reply);
				return Result.success("【龙宝】付款成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("龙宝代付异常:{}" + e.getMessage());
		}
		return Result.error("【龙宝】付款失败"+msg+"！");
	}
	
	public String getBankCode(String mark){
		
		if (mark.equals("CITIC")) return "ECITIC";
		
		if (mark.equals("COMM")) return "BOCOM";
		
		if (mark.equals("PINGAN")) return "PAB";
		
		if (mark.equals("CGB")) return "HXB";
		
		return mark;
	}

	@Override
	protected Predicate<? super SettleMentVo> getPredicate() {
		// TODO Auto-generated method stub
		return s -> !StringUtils.isEmpty(s.getBankNumber());
	}

}
