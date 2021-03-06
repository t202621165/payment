package com.cypay.common.pattern.strategy.reissue.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Template;
import com.cypay.common.entity.TemplateProduct;
import com.cypay.common.pattern.strategy.reissue.GatewayReissue;
import com.cypay.common.repository.impl.OrderRepository;
import com.cypay.common.repository.impl.TemplateProductRepository;
import com.cypay.common.vo.ReissueRecordVo;

/**
 * 整区补发
 * @author International
 *
 */
@Component
public class WholeDistrictReissue extends GatewayReissue {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private TemplateProductRepository templateProductRepository;
	
	@Override
	public String getType() {
		return "whole";
	}

	@Override
	public List<JSONObject> manualOrWhole(ReissueRecordVo vo) {
		Merchant merchant = vo.getMerchant();
		// 充值成功订单
		List<ReissueRecordVo> oList = orderRepository.findReissueRecord(
				vo.getStartDate(), vo.getEndDate(), vo.getPartition(), merchant);
		// 是否包含手动充值
		if (vo.isContainManual()) {
			List<ReissueRecordVo> rList = reissueRecordService.findVoList(vo);
			oList.addAll(rList);
		}
		if (oList.isEmpty())
			return null;
		
		Set<Long> productIds = oList.parallelStream().map(r -> {
			r.setAdded(vo.getAdded());
			r.setOnlyYB(vo.isOnlyYB());
			r.setType(Boolean.FALSE);
			r.setPartition(vo.getPartition());
			r.setContainManual(vo.isContainManual());
			r.setContainRedPacket(vo.isContainRedPacket());
			r.setContainGiveAmount(vo.isContainGiveAmount());
			return r.getProductId();
		}).collect(Collectors.toSet());
		
		Template template = vo.getPartition().getTemplate();
		List<TemplateProduct> tps = templateProductRepository.findByIdsAndTemplate(productIds, template);
		Map<Long, List<TemplateProduct>> tpMap = tps.stream().collect(Collectors.groupingBy(tp -> tp.getProduct().getId()));
		
		String uuid = vo.getUuid();
		List<JSONObject> result = oList.parallelStream().map(r -> {
			List<TemplateProduct> list = tpMap.get(r.getProductId());
			TemplateProduct tp = (list == null || list.isEmpty())?new TemplateProduct():list.get(0);
			tp.setTemplate(template);
			
			r.setMerchant(merchant);
			r.setProductName(tp.getProduct().getName());
			return tp.channelAmount(r, uuid);
		}).collect(Collectors.toList());
		vo.getRecords().addAll(oList);
		return result;
	}
}
