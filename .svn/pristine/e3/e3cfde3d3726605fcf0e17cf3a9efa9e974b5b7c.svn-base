package com.cypay.merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Order;
import com.cypay.common.entity.Product;
import com.cypay.common.service.impl.OrderService;
import com.cypay.common.service.impl.ProductService;
import com.cypay.common.service.impl.ReissueRecordService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.OrderVo;
import com.cypay.common.vo.ProductVo;
import com.cypay.common.vo.ReissueRecordVo;
import com.cypay.common.vo.Result;
import com.cypay.merchant.aop.MerchantLogs;

@Controller
@RequestMapping(value = "mer")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReissueRecordService reissueRecordService;
	
	/**
	 * 订单管理页面
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/order.html")
	public String order(Model model) {
		return "merchant/order/order";
	}
	
	/**
	 * 订单列表
	 * @param v
	 * @param pageData
	 * @return
	 */
	@PostMapping(value = "/order/list")
	public @ResponseBody JSONObject list(OrderVo v, PageData pageData) {
		v.setGallery(null);
		v.setIsAdmin(false);
		v.setMerchant(ShiroManager.getMerchant());
		return orderService.findOrderData(v, pageData);
	}
	
	/**
	 * 订单详细信息
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/order/detail")
	public @ResponseBody Order detail(@RequestParam(value = "id", required = true) Long id) {
		return orderService.findOrderDetail(id);
	}
	
	/**
	 * 订单补发
	 * @param id
	 * @return
	 */
	@MerchantLogs(value = "订单补发")
	@PostMapping(value = "/order/reissue")
	public @ResponseBody Result reissue(@RequestParam(value = "id", required = true) Long id) {
		ReissueRecordVo vo = orderService.findReissueRecordById(id, ShiroManager.getMerchant());
		if (vo == null)
			return Result.error("当前订单不存在，或已下发成功！");
		vo.setMerchant(ShiroManager.getMerchant());
		vo.setUuid(ShiroManager.getMerchant().getUuid());
		Result json = reissueRecordService.reissue(vo, "manual", 2);
		if (json.getState()) {
			orderService.updateState(1, id);
		}
		return json;
	}
	
	/**
	 * 支付产品列表
	 * @param p
	 * @return
	 */
	@GetMapping(value = "/product/list")
	public @ResponseBody List<Product> product(ProductVo p) {
		p.setState(true);
		return productService.findAll(p);
	}
	
	/**
	 * 根据商户密钥查询订单 (API网关)
	 * @param v 入参条件
	 * @param pageData 分页条件
	 * @return
	 */
	@GetMapping("/wg/order")
	public @ResponseBody Page<?> wgOrders(OrderVo v,PageData pageData) {
		pageData.setPageSize(18);
		v.setState(1);
		return orderService.findVoPageList(v, pageData);
	}

}
