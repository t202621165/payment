package com.cypay.common.pattern.template.payee.qiyi;

import java.util.List;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.cypay.common.entity.DaiFu;
import com.cypay.common.pattern.template.payee.PayeeTemplate;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.SettleMentVo;

@Component
public class QiyiPayee extends PayeeTemplate{

	@Override
	public String mark() {
		// TODO Auto-generated method stub
		return "qiyi";
	}

	@Override
	protected String getSerialNumber() {
		// TODO Auto-generated method stub
		return "A" + snowflakeIdWorker.nextId();
	}

	@Override
	protected Result init(List<SettleMentVo> settlements, DaiFu daiFu, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Predicate<? super SettleMentVo> getPredicate() {
		// TODO Auto-generated method stub
		return null;
	}

}
