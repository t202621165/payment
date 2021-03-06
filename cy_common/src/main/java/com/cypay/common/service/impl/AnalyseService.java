package com.cypay.common.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cypay.common.entity.Order;
import com.cypay.common.pattern.template.AnalyseTemplate;
import com.cypay.common.repository.impl.AnalyseRepository;
import com.cypay.common.util.DUtil;
import com.cypay.common.vo.OrderVo;

@Service
public class AnalyseService extends BaseServiceImpl<AnalyseRepository, Order, OrderVo> {
	
	private Map<String, AnalyseTemplate> analyses = new HashMap<String, AnalyseTemplate>();
	
	public AnalyseService(List<AnalyseTemplate> analyseTemplates) {
		this.analyses = analyseTemplates.stream().collect(Collectors.toMap(AnalyseTemplate::getType, Function.identity()));
	}
	
	public List<Object[]> analyse(String type, OrderVo v) {
		try {
			
			return this.analyses.get(type).excute(v);
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	public List<List<Object>> orderRankRateAnalye(String type, OrderVo v) {
		List<Object[]> list = this.analyse(type, v);
		BigDecimal sum = list.parallelStream().map(obj -> {return (BigDecimal) obj[1];}).reduce(BigDecimal.ZERO, BigDecimal::add);
		List<List<Object>> rankAnalye = list.parallelStream().map(obj -> {
			List<Object> arr = new ArrayList<Object>();
			arr.addAll(Arrays.asList(obj));
			arr.add(sum);
			return arr;
		}).collect(Collectors.toList());
		return rankAnalye;
	}
	
	/**
	 * 订单日交易统计
	 * @param v
	 * @param count
	 * @return
	 */
	public List<List<Object>> orderDayAnalye(OrderVo v, int count) {
		v.setOrderDate(DUtil.beginOfDayByOffsetDay(-15));
		Date payDate = DUtil.endOfOffsetDay(-1);
		v.setPayDate(payDate);
		List<Object[]> list = analyse("day", v);
		List<List<Object>> dayAnalye = new ArrayList<List<Object>>();
		Object[] days = DUtil.getDayArray(15, payDate);
		for (int i = 0; i < count; i++) {
			List<Object> o = new ArrayList<Object>();
			for (int j = 0; j < days.length; j++) {
				boolean ifPresent = false;
				for (Object[] obj: list) {
					if (j == 0) {
						o.add(obj[i]);
					}
					if (days[j].equals(obj[count])) {
						ifPresent = true;
					}
				}
				if (!ifPresent) {
					o.add(j, 0);
				}
			}
			dayAnalye.add(o);
		}
		dayAnalye.add(Arrays.asList(days));
		return dayAnalye;
	}
	
}
