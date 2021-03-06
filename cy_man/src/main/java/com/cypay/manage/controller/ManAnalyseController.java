package com.cypay.manage.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cypay.common.bo.AnalyseBo;
import com.cypay.common.service.impl.AnalyseService;
import com.cypay.common.service.impl.ProductService;
import com.cypay.common.util.DUtil;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.OrderVo;

@RestController
@RequestMapping(value="/man")
public class ManAnalyseController {
	@Autowired
	private AnalyseService analyseService;
	@Autowired
	private ProductService productService;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 产品日交易分析
	 * @param v
	 * @return
	 * @throws ParseException 
	 */
	@GetMapping("/product/analyse")
	public AnalyseBo pro_analyses(OrderVo v) throws ParseException{
		AnalyseBo bo = new AnalyseBo();
		v.setOrderDate(DUtil.beginOfToday());
		v.setPayDate(DUtil.endOfToday());
		Object[] x = productService.findProductNameGroupByTypeMark();
		List<Object[]> list = analyseService.analyse("product",v);
		bo.productNames = Arrays.asList(x);
		for (int i = 0; i < x.length;i++){
			if (!list.isEmpty()){
				Boolean isExit = Boolean.FALSE;
				for (int j = 0; j < list.size(); j++){
					if (x[i].equals(list.get(j)[5])){
						bo.payAmounts.add(list.get(j)[1]);
						bo.merchantProfits.add(list.get(j)[2]);
						bo.platformProfits.add(list.get(j)[4]);
						isExit = Boolean.TRUE;
					}
				}
				if (!isExit){
					bo.merchantProfits.add(0);
					bo.payAmounts.add(0);
					bo.platformProfits.add(0);
				}
			}else{
				bo.payAmounts.add(0);
				bo.merchantProfits.add(0);
				bo.platformProfits.add(0);
			}
		}
		return bo;
	}
	
	/**
	 * 商户日交易分析
	 * @param v
	 * @return
	 * @throws ParseException 
	 */
	@GetMapping("/merchant/analyse")
	public AnalyseBo mer_analyses(OrderVo v) throws ParseException{
		v.setOrderDate(DUtil.beginOfToday());
		v.setPayDate(DUtil.endOfToday());
		AnalyseBo bo = new AnalyseBo();
		bo.setMerchantDayReports(analyseService.analyse("merchant",v));
		return bo;
		
	}
	
	/**
	 * 日交易订单时间段分析
	 * @param v
	 * @return
	 * @throws ParseException 
	 */
	@GetMapping("/order/analyse")
	public AnalyseBo order_analyses(OrderVo v) throws ParseException{
		v.setPayDate(DUtil.endOfToday());
		Object[] x = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		List<Object[]> list = analyseService.analyse("hour",v);
		AnalyseBo bo = new AnalyseBo();
		bo.dates = Arrays.asList(x);
		for (int i = 0; i < x.length; i++){
			if (!list.isEmpty()){
				Boolean isExit = Boolean.FALSE;
				for (int j = 0; j < list.size(); j++){
					if (Integer.valueOf(x[i].toString()).equals(Integer.valueOf(list.get(j)[5].toString()))){			
						bo.payAmounts.add(list.get(j)[1]);
						bo.merchantProfits.add(list.get(j)[2]);
						bo.platformProfits.add(list.get(j)[4]);
						isExit = Boolean.TRUE;
					}
				}
				if (!isExit){
					bo.merchantProfits.add(0);
					bo.payAmounts.add(0);
					bo.platformProfits.add(0);
				}
			}else{
				bo.merchantProfits.add(0);
				bo.payAmounts.add(0);
				bo.platformProfits.add(0);
			}
		}
		return bo;
	}
	
	@GetMapping(value = "/day/analyse")
	public List<List<Object>> dayAnalye(OrderVo v) {
		return analyseService.orderDayAnalye(v, 5);
	}
	
	@GetMapping("/statistics/merchant_rank")
	public List<List<Object>> merchantDayStatistics(OrderVo v,PageData pageData) throws ParseException{
		return analyseService.orderRankRateAnalye("merchant", v);
	}
	
	@GetMapping("/statistics/partition_rank")
	public List<List<Object>> partitionDayStatistics(OrderVo v) {
		return analyseService.orderRankRateAnalye("partition", v);
	}
	
	/**
	 * 日期格式自动转换
	 * 
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}
