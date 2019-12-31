package com.cypay.manage.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Gallery;
import com.cypay.common.entity.Order;
import com.cypay.common.entity.Product;
import com.cypay.common.service.impl.GalleryService;
import com.cypay.common.service.impl.OrderService;
import com.cypay.common.service.impl.ProductService;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.OrderVo;
import com.cypay.common.vo.Result;

@RestController
@RequestMapping(value="/man")
public class ManOrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private GalleryService galleryService;
	@Autowired
	private ProductService prodcutService;
	
	/**
	 * 订单页
	 * @param v
	 * @param pageData
	 * @return
	 * @throws ParseException
	 */
	@GetMapping("/order/list")
	public JSONObject orderList(OrderVo v,PageData pageData) throws ParseException{
		return orderService.findOrderData(v, pageData);
	}
	
	/**
	 * 产品通道集合
	 * @return
	 */
	@GetMapping("/order/conditions")
	public Map<String,Object> conditions() {
		
		Map<String,Object> map = new HashMap<String, Object>();
		List<Gallery> gallerys = galleryService.findIdAndGalleryNameList();
		List<Product> products = prodcutService.findIdAndProductNameList();
		/****************产品通道集合****************/
		map.put("gallerys",gallerys);
		map.put("products", products);
		
		return map;
	}
	
	/**
	 * 订单详情
	 * @return
	 */
	@PostMapping("/order/detail")
	public Map<String, Object> detail(@RequestParam(value="id") Long id){
		return orderService.findAdminOrderDetail(id);
	}
	
	/**
	 * 退款
	 * @return
	 */
	@GetMapping("/order/refund")
	public Result refund(@RequestParam(value="orderNumber") String orderNumber){
		return orderService.refund(orderNumber);
	}
	
	@GetMapping("/order/exports")
	public @ResponseBody void exports(Order v,@RequestParam(value="type") String type,HttpServletResponse response){
		orderService.exports(v.getOrderDate(), v.getPayDate(), type,response);
	}
	
	@GetMapping("/order/clear")
	public Result clear(OrderVo v){
		return orderService.clear(v);
	}
	
}
