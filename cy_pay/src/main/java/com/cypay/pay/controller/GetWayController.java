package com.cypay.pay.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cypay.common.entity.Line;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.SystemSet;
import com.cypay.common.service.impl.LineService;
import com.cypay.common.service.impl.PartitionService;
import com.cypay.common.service.impl.SystemSetService;
import com.cypay.common.service.impl.TemplateService;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.QRCodeUtil;
import com.cypay.common.vo.TemplateVo;
import com.cypay.pay.service.MerchantService;
import com.cypay.pay.service.OrderService;
import com.cypay.pay.service.ProductService;
import com.cypay.pay.vo.ReturnVo;

import cn.hutool.core.util.IdUtil;

@Controller
@RequestMapping(value = "pay")
public class GetWayController {
	
	@Autowired
	private LineService lineService;
	
	@Autowired
	private PartitionService partitionService;
	
	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private MerchantService pMerchantService;
	
	@Autowired
	private ProductService pProductService;
	
	@Autowired
	private SystemSetService systemSetService;
	
	@Autowired
	private OrderService orderService;
	
	@ModelAttribute
	public void getEntity(@RequestParam(value="uuid", required = false) String uuid, 
			@RequestParam(value="type", required = false) String type, Model model) {
		String guid = null;
		String puid = uuid;
		SystemSet webInfo = systemSetService.findWebInfo();
		model.addAttribute("webInfo", webInfo);
		if (type != null) {
			model.addAttribute("type", type);
		}		
		if (uuid != null) {
			if (uuid.length() == 64){
				puid = uuid.substring(0,32);
				guid = uuid.substring(32,64);
			}
			model.addAttribute("guid",guid);
			model.addAttribute("uuid", puid);
			model.addAttribute("platformQQNumbers", CommonUtil.getQQNumbers(webInfo.getServiceQQ()));
			Merchant service = pMerchantService.findServiceInfoByUuid(puid, type);
			if (service != null) {
				model.addAttribute("gameQQNumbers", CommonUtil.getQQNumbers(service.getServiceQQ()));
				model.addAttribute("service", service);
			}
		}
	}
	
	/**
	 * 充值页面
	 * @param model
	 * @param merchant
	 * @return
	 */
	@GetMapping(value = "/recharge")
	public String recharge(Model model, @RequestParam(value="uuid") String uuid, HttpServletRequest request) {
		if (uuid.length() == 64)
			uuid = uuid.substring(0, 32);
		String token = IdUtil.fastSimpleUUID();
		request.getSession().setAttribute("token", token);
		
		TemplateVo template = templateService.findByProdutUuid(uuid);
		
		if (template == null)
			return "forward:/pay/error?type=1";
		
		model.addAttribute("template", template);
		model.addAttribute("token", token);
		pProductService.findProducts(model,template.getMerchantId(),template.getId());
		return "pay/recharge";
	}
	
	/**
	 * 选择充值线路
	 * @param model
	 * @param merchant
	 * @return
	 */
	@GetMapping(value = "/line")
	public String lineui(Model model, @RequestParam(value="type") String type, @RequestParam(value="uuid") String uuid,HttpServletRequest request) {
		List<Line> list = lineService.findByType(0);
		if (list != null) {
			list.parallelStream().forEach(line -> {
				Integer port = line.getPort();
				line.setDomainName(CommonUtil.getBufferString(
						line.getDomainName(), port==80?"":port, "/pay/partition_", type, "/", uuid));
			});
		}
		model.addAttribute("list", list);
		return "pay/line";
	}

	/**
	 *选择分区
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/partition")
	public String partitionui(Model model, @RequestParam(value="type") String type, @RequestParam(value="uuid") String uuid,HttpServletRequest request) {
		model.addAttribute("list", partitionService.findByUuid(uuid, type));
		if (type.equals("g"))
			model.addAttribute("guid",uuid);		
		return "pay/partition";
	}
	
	/**
	 * 玩家留言
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/message")
	public String leavingMessage(Model model, @RequestParam(value="type") String type, @RequestParam(value="uuid") String uuid,HttpServletRequest request) {
		model.addAttribute("list", partitionService.findByUuid(uuid, type));
		return "pay/message";
	}
	
	/**
	 * 订单查询
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/query")
	public String query(Model model,HttpServletRequest request) {
		model.addAttribute("products", pProductService.findProducts());
		return "pay/query";
	}
	
	/**
	 * 客服中心
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/service")
	public String service(Model model,HttpServletRequest request) {
		return "pay/service";
	}
	
	/**
	 * 支付成功页面
	 * @param orderNumber
	 * @return
	 */
	@GetMapping(value = "/successful")
	public String success(@RequestParam(value = "orderNumber") String orderNumber, Model model) {
		ReturnVo order = orderService.findReturnData(orderNumber);
		if (order == null)
			return "forward:/pay/error?type=2";
		model.addAttribute("returnVo", order);
		return "pay/successful";
	}
	
	/**
	 * 错误页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "", "/error" })
	public String error(Model model, @RequestParam(defaultValue = "0") Integer type) {
		 if (type == 1) {
			model.addAttribute("code", "PARTITION_NOT_FIND");
			model.addAttribute("msg", "分区不存在或已被删除");
		} else if (type == 2) {
			model.addAttribute("code", "ORDER_NOT_FIND");
			model.addAttribute("msg", "订单不存在,请核对您的订单编号或联系客服");
		} else {
			model.addAttribute("code", "INVALID_REQUEST");
			model.addAttribute("msg", "请求无效");
		}
		return "pay/error";
	}
	
	/**
	 * 生成二维码
	 * @param url
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("/ercode/{url}")
	public void createErcode(@PathVariable String url,HttpServletResponse response) throws UnsupportedEncodingException{
		QRCodeUtil.createQRCode(URLDecoder.decode(url, "UTF-8"), response);
	}
}
