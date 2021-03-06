package com.cypay.common.pattern.template.payee.alipay;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.cypay.common.entity.DaiFu;
import com.cypay.common.entity.SettleMentReply;
import com.cypay.common.pattern.template.payee.PayeeTemplate;
import com.cypay.common.service.impl.SettleMentReplyService;
import com.cypay.common.service.impl.SettleMentService;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.SettleMentVo;

@Component
public class AlipayPayee extends PayeeTemplate {

	@Autowired
	private SettleMentReplyService settleMentReplyService;
	@Autowired
	private SettleMentService settleMentService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String mark() {
		return "alipay";
	}

	@Override
	protected String getSerialNumber() {
		return "A" + snowflakeIdWorker.nextId();
	}

	@Override
	protected Result init(List<SettleMentVo> settlements, DaiFu daiFu, HttpServletRequest request) {
		int i = 0;
		SettleMentReply reply = saveBatchRecord(settlements);
		try{
			for (SettleMentVo settlement : settlements) {				
				AlipayRequest alipay = new AlipayRequest(daiFu.getReqUrl(),settlement.getSerialNumber(),daiFu.getPartner(), settlement.getBankNumber(),
						String.format("%.2f", settlement.getAmount()), daiFu.getRemark());		
				
				AlipayFundTransToaccountTransferRequest req = new AlipayFundTransToaccountTransferRequest();
				
				req.setBizContent(alipay.biz_content());
				
				AlipayFundTransToaccountTransferResponse resp = alipay.alipayClient(daiFu.getSecurityKey(),daiFu.getPublicKey()).execute(req);
				
				if (resp.isSuccess()){	
					i++;
					settleMentService.updateStateById(1, settlement.getSettlementId(),new Date(),"支付宝代付");
					logger.info("支付宝代付调用成功");					
				}else{
					logger.info("支付宝调用失败");
				}
			}
			if (i == settlements.size()){
				//根据批次号更新付款状态
				reply.setState(true);
				settleMentReplyService.update(reply);
			}
			return Result.success("【支付宝】付款成功");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}

		return Result.error("【支付宝】付款失败，请检查付款账户信息！");
	}

	@Override
	protected Predicate<? super SettleMentVo> getPredicate() {
		return s -> "ALI".equals(s.getMark()) && !StringUtils.isEmpty(s.getBankNumber());
	}

}
