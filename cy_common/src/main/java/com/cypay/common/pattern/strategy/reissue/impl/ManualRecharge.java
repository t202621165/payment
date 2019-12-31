package com.cypay.common.pattern.strategy.reissue.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.TemplateProduct;
import com.cypay.common.pattern.strategy.reissue.GatewayReissue;
import com.cypay.common.repository.impl.TemplateProductRepository;
import com.cypay.common.vo.ReissueRecordVo;

/**
 * 手动充值
 * @author International
 *
 */
@Component
public class ManualRecharge extends GatewayReissue {
	
	@Autowired
	private TemplateProductRepository templateProductRepository;
	
	@Override
	public String getType() {
		return "manual";
	}

	@Override
	public List<JSONObject> manualOrWhole(ReissueRecordVo vo) {
		Partition partition = vo.getPartition();
		TemplateProduct tp = templateProductRepository.findByProductAndTemplate(vo.getProduct(), partition.getTemplate());
		if (tp == null)
			tp = new TemplateProduct();
		
		tp.setTemplate(partition.getTemplate());
		
		vo.getRecords().add(vo);
		vo.setProductName(tp.getProduct().getName());
		List<JSONObject> list = new ArrayList<>();
		list.add(tp.channelAmount(vo, vo.getUuid()));
		return list;
	}
}
