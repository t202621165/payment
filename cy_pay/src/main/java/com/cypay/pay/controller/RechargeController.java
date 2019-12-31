package com.cypay.pay.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.config.InitialLoader;
import com.cypay.common.entity.Gallery;
import com.cypay.common.entity.Message;
import com.cypay.common.entity.Order;
import com.cypay.common.enums.Edition;
import com.cypay.common.enums.PaymentType;
import com.cypay.common.service.impl.GalleryService;
import com.cypay.common.service.impl.MessageService;
import com.cypay.common.service.impl.PartitionService;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.DUtil;
import com.cypay.common.util.MD5Util;
import com.cypay.common.util.QRCodeUtil;
import com.cypay.common.vo.PartitionVo;
import com.cypay.common.vo.Result;
import com.cypay.pay.factory.GatewayFactory;
import com.cypay.pay.service.OrderService;
import com.cypay.pay.service.ProductService;
import com.cypay.pay.service.RechargeService;
import com.cypay.pay.vo.NoticeVo;
import com.cypay.pay.vo.OrderVo;
import com.cypay.pay.vo.RechargeVo;
import com.cypay.pay.vo.Resultful;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.HttpRequest;

@Controller
@RequestMapping(value = "/pay")
public class RechargeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private PartitionService partitionService;

	@Autowired
	private RechargeService rechargeService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private GalleryService galleryService;

	@Autowired
	private MessageService messageService;
	
	private File logoFile;
	
	@PostConstruct
	public void init() {
		String filePath = Thread.currentThread().getContextClassLoader().getResource("").toString();
        filePath = filePath.replace("file:/", "").trim();
        filePath = filePath.replace("/", "\\").trim();
        logoFile = new File(filePath + "\\static\\assets\\images\\web\\logo-min.png");
	}

	/**
	 * 充值
	 * 
	 * @param vo
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/recharge")
	public @ResponseBody Object recharge(OrderVo vo, @RequestParam(value = "token") String token,
			HttpServletRequest request) {
		// token验证，防止重复提交
		// if (!token.equals(request.getSession().getAttribute("token"))) {
		// return Result.error("页面已失效，请刷新");
		// }

		// 订单提交参数校验
		Result result = vo.validate();
		if (!result.getState())
			return result;

		// 获取当前充值分区信息
		PartitionVo partition = partitionService.findByUuid(vo.getUuid());
		if (partition == null) {
			return Resultful.error("PARTITION_NOT_EXIST！");
		}

		// 获取充值产品和通道信息
		RechargeVo recharge = productService.findProductAndGallery(vo.getProductId());
		if (recharge == null) {
			return Resultful.error("PRODUCT_UNUSABLE！");
		}

		// 校验产品信息和通道信息
		result = recharge.validate(vo.getAmount());
		if (!result.getState())
			return result;

		// 判断是否支持当前通道
		if (!GatewayFactory.payments.containsKey(recharge.getGalleryMark())) {
			return Resultful.error("NOT_SUPPORT！");
		}

		String galleryMark = recharge.getRealGalleryMark();
		// 判断当前通道是否已授权
		if (!InitialLoader.USABLE_GALLERY.contains(galleryMark)) {
			return Resultful.error("UNAUTHORIZED！");
		}

		// 判断当前通道是否支持此支付方式
		if (!PaymentType.isSupport(galleryMark, recharge.getTypeMark())) {
			return Resultful.error("GALLERY_NOT_SUPPORT_PRODUCT！");
		}

		int count = Edition.current_edition.getGalleryCount();
		if (count > 0 && galleryService.countByMark(galleryMark).longValue() > count) {
			return Resultful.error("GALLERY_COUNT_OVERFLOW！");
		}

		// 创建订单，获取充值链接
		Resultful resultful = rechargeService.recharge(vo, partition, recharge, request);
		if (resultful.isState()) {
			// 下单请求成功，移除token
			request.getSession().removeAttribute("token");
		}
		return resultful;
	}

	/**
	 * 异步通知
	 * 
	 * @param _gateway_type_
	 * @throws IOException
	 */
	@RequestMapping(value = "/notify")
	public String gatewayNotify(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "_gateway_type_") String _gateway_type_) {
		response.setCharacterEncoding("GBK");
		NoticeVo notice = rechargeService.gatewayNotice(request, response, _gateway_type_, 0);
		if (notice == null) {
			return null;
		}
		model.addAttribute("returnVo", notice);
		return "pay/success";
	}

	/**
	 * 同步跳转
	 * 
	 * @param _gateway_type_
	 */
	@RequestMapping(value = "/return")
	public String gatewayReturn(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value = "_gateway_type_") String _gateway_type_) {
		response.setCharacterEncoding("GBK");
		NoticeVo notice = rechargeService.gatewayNotice(request, response, _gateway_type_, 1);
		if (notice == null) {
			return null;
		}
		model.addAttribute("returnVo", notice);
		return "pay/success";
	}

	/**
	 * 生成二维码
	 * 
	 * @param qrcodeUrl
	 * @param response
	 */
	@GetMapping(value = "/qrcode")
	public void qrcode(@RequestParam(value = "qrcodeUrl") String qrcodeUrl, HttpServletResponse response) {
		QRCodeUtil.createQRCode(qrcodeUrl, response);
	}
	
	/**
	 * 生成带logo的二维码
	 * 
	 * @param qrcodeUrl
	 * @param response
	 */
	@GetMapping(value = "/qrcode2")
	public void qrcodeWithLogo(@RequestParam(value = "qrcodeUrl") String qrcodeUrl, HttpServletResponse response) {
		ServletOutputStream stream = null;
		try {
			stream = response.getOutputStream();
			QrConfig config = QrConfig.create();
			config.setWidth(240).setHeight(240);
			if (logoFile.exists()) {
				config.setImg(logoFile);
			}
			ImageIO.write(QrCodeUtil.generate(qrcodeUrl, config), "PNG", stream);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.flush();
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 查询订单是否支付成功
	 * 
	 * @param orderNumber
	 * @return
	 */
	@PostMapping(value = "/query")
	public @ResponseBody Long query(@RequestParam(value = "orderNumber") String orderNumber) {
		return orderService.countByOrderNumber(orderNumber);
	}

	/**
	 * 支付成功页面
	 * 
	 * @param orderNumber
	 * @return
	 */
	@GetMapping(value = "/success")
	public String success(@RequestParam(value = "orderNumber") String orderNumber, Model model) {
		model.addAttribute("returnVo", orderService.findReturnData(orderNumber));
		return "pay/success";
	}

	/**
	 * 玩家留言
	 * 
	 * @param message
	 * @return
	 */
	@PostMapping(value = "/leaving")
	public @ResponseBody Result leavingMessage(Message message) {
		return messageService.save(message);
	}

	/**
	 * 订单查询
	 * 
	 * @param message
	 * @return
	 */
	@PostMapping(value = "/oList")
	public @ResponseBody Object queryOrder(OrderVo v) {
		v.setOrderDate(DUtil.beginOfToday());
		return orderService.findVoList(v);
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping(value = "/callback/{type}/{orderNumber}")
	public void callback(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "type") String type, @PathVariable(value = "orderNumber") String orderNumber)
			throws IOException {
		switch (type) {
		case "qiantai":
			qiantai(request, response, type,orderNumber);
			break;

		default:
			break;
		}
	}

	public void qiantai(HttpServletRequest request, HttpServletResponse response, String type,String orderNumber) throws IOException {
		Gallery gallery = galleryService.findByMark(type);
		String mchid = gallery.getAccount().split("\\|")[0];
		String appCode = gallery.getAccount().split("\\|")[1];
		String code = request.getParameter("code");
		String content = "code=" + code + "&mchid=" + mchid;
		String sign = MD5Util.signToUpperCase(content, gallery.getMd5Key(), "UTF-8");
		String url = gallery.getGalleryRate().get(0).getReqUrl();
		String openid_json = HttpRequest.get(url.concat("/tool/v1/get_weixin_openid") + "?" + content)
				.header("X-QF-APPCODE", appCode).header("X-QF-SIGN", sign).execute().body();
		JSONObject open = JSONObject.parseObject(openid_json);
		if (open.getString("respcd").equals("0000")) {
			String openid = open.getString("openid");
			Order order = orderService.findByOrderNumber(orderNumber);
			Map<String, Object> form = new HashMap<String, Object>();
			form.put("txamt",String.format("%.0f",order.getAmount().doubleValue() * 100));
			form.put("txcurrcd","CNY");
			form.put("pay_type","800207");
			form.put("out_trade_no",orderNumber);
			form.put("txdtm", DUtil.format("yyyy-MM-dd HH:mm:ss"));
			form.put("sub_openid", openid);
			form.put("mchid",mchid);
			StringBuffer buffer = new StringBuffer();
			buffer.append("mchid="+form.get("mchid"));
			buffer.append("&out_trade_no="+form.get("out_trade_no"));
			buffer.append("&pay_type="+form.get("pay_type"));
			buffer.append("&sub_openid="+form.get("sub_openid"));
			buffer.append("&txamt="+form.get("txamt"));
			buffer.append("&txcurrcd="+form.get("txcurrcd"));
			buffer.append("&txdtm="+form.get("txdtm"));
			String resign = MD5Util.signToUpperCase(buffer.toString(), gallery.getMd5Key(), "UTF-8");
			String resp_json = HttpRequest.post(url.concat("/trade/v1/payment")).header("X-QF-APPCODE",appCode).header("X-QF-SIGN",resign).form(form).execute().body();
			JSONObject resp = JSONObject.parseObject(resp_json);
			if (resp.getString("respcd").equals("0000")){
				JSONObject pay_params = JSONObject.parseObject(resp.getString("pay_params"));
				StringBuffer buf = new StringBuffer();
				String redirect_url = CommonUtil.getBufferString(CommonUtil.getRequestDomain(request));
				System.out.println("支付成功跳转地址:"+redirect_url);
				buf.append("mchntnm="+URLEncoder.encode(gallery.getDes(),"utf-8"));
				buf.append("&txamt="+String.format("%.0f",order.getAmount().doubleValue() * 100));
				buf.append("&goods_name="+URLEncoder.encode("游戏","utf-8"));
				buf.append("&redirect_url="+URLEncoder.encode(redirect_url.concat("/pay/redirect/qiantai"),"utf-8"));
				buf.append("&package="+pay_params.getString("package"));
				buf.append("&timeStamp="+pay_params.getString("timeStamp"));
				buf.append("&signType="+pay_params.getString("signType"));
				buf.append("&paySign="+URLEncoder.encode(pay_params.getString("paySign"),"utf-8"));
				buf.append("&appId="+pay_params.getString("appId"));
				buf.append("&nonceStr="+pay_params.getString("nonceStr"));
				response.sendRedirect("https://o2.qfpay.com/q/direct?"+buf.toString());
			}else{
				response.getWriter().print("唤起微信支付失败【"+resp.getString("resperr")+"】");
			}
		} else {
			response.getWriter().print("openid error【"+open.getString("resperr")+"】");
		}
	}
	
	@GetMapping("/redirect/{type}")
	public void redirect(HttpRequest request,HttpServletResponse response,@PathVariable(value = "type") String type) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print("<h2>支付成功</h2>");
	}

}
