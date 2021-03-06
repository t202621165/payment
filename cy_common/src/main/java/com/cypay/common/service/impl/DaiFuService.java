package com.cypay.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cypay.common.entity.DaiFu;
import com.cypay.common.enums.Edition;
import com.cypay.common.pattern.template.payee.PayeeTemplate;
import com.cypay.common.repository.impl.DaiFuRepository;
import com.cypay.common.vo.Result;

@Service
public class DaiFuService extends BaseServiceImpl<DaiFuRepository, DaiFu, DaiFu>{
	
	private Map<String, PayeeTemplate> payeeTemplates = new HashMap<>();
	
	public DaiFuService(List<PayeeTemplate> list) {
		this.payeeTemplates = list.parallelStream().collect(Collectors.toMap(PayeeTemplate::mark, Function.identity()));
	}

	/**
	 * 资金代付
	 * @param list
	 * @param daifu
	 * @param request
	 * @return
	 */
	@Transactional
	public Result payee(Long id, List<Long> ids, String mark, HttpServletRequest request) {
		logger.info("id:{},ids:{},mark:{}",id,ids,mark);
		if (!Edition.current_edition.isPayeeAlipay() && "alipay".equals(mark)) {
			return Result.error("【支付宝代付】未授权！");
		} else if (!Edition.current_edition.isPayeeWechat() && "wechat".equals(mark)) {
			return Result.error("【微信代付】未授权！");
		}
		
		PayeeTemplate payee = payeeTemplates.get(mark);
		if (payee == null) {
			return Result.error("当前付款方式不可用");
		}
		
		Optional<DaiFu> optional = baseRepository.findById(id);
		if (optional.isPresent()) {
			return payee.payee(ids, optional.get(), request);
		}
		return Result.error("付款失败,请设置代付信息");
	}

	@Override
	public Result save(DaiFu t) {
		if ("wechat".equals(t.getMark())) {
			DaiFu daiFu = baseRepository.findByMark(t.getMark());
			if (daiFu != null && daiFu.getId() != t.getId()) {
				return Result.error("微信代付账号已存在，不可重复添加", "mark");
			}
			if (StringUtils.isEmpty(t.getAppSecret())) {
				return Result.error("微信代付请填写网页授权密钥", "appSecret");
			}
			if (StringUtils.isEmpty(t.getRedirectUrl())) {
				return Result.error("微信代付请填写网页授权域名", "redirectUrl");
			}
		}
		if ("alipay".equals(t.getMark())) {
			if (StringUtils.isEmpty(t.getAccountName())) {
				return Result.error("付款账户名不能为空", "accountName");
			}
		}
		return super.save(t);
	}

	public List<DaiFu> findMarkNameByMark(String mark){
		return baseRepository.findMarkNameByMark(mark);
	}
	
	public DaiFu findByMarkName(String markName){
		return baseRepository.findByMarkName(markName);
	}

}
