package com.cypay.merchant.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.cypay.common.entity.Line;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Visit;
import com.cypay.common.service.impl.LineService;
import com.cypay.common.service.impl.SystemSetService;
import com.cypay.common.service.impl.VisitService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.to.GatewayIni;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.util.FileUtil;
import com.cypay.common.vo.Result;

@Controller
@RequestMapping(value = "mer")
public class GetCodeController {
	
	@Autowired
	private LineService lineService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private SystemSetService systemSetService;

	/**
	 * 获取代码
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/code.html")
	public String code(Model model, HttpServletRequest request) {
		String domain = CommonUtil.getRequestDomain(request);
		List<Line> lines = lineService.findByType(3);
		model.addAttribute("merchant", ShiroManager.getMerchant());
		model.addAttribute("system", systemSetService.findIpsAndLoginState());
		model.addAttribute("domain", lines.isEmpty() ? domain : lines.get(0).getDomainName());
		return "merchant/index/code";
	}
	
	@PostMapping(value = "/code")
	public @ResponseBody Map<String, Object> code() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("merchant", ShiroManager.getMerchant());
		map.put("system", systemSetService.findIpsAndLoginState());
		return map;
	}
	
	/**
	 * 下载多线路充值文件
	 * @param model
	 * @param uuid
	 * @return
	 */
	@GetMapping(value = "/payurls")
	public String payurls(Model model, @RequestParam(value = "uuid") String uuid, @RequestParam(value = "type") String type) {
		List<Line> list = lineService.findByType(0);
		if (list != null) {
			list.parallelStream().forEach(line -> {
				Integer port = line.getPort();
				String domainName = CommonUtil.getWholeDomainName(line.getDomainName());
				line.setDomainName(CommonUtil.getBufferString(
						domainName, port==80?"":":"+port, "/pay/partition_", type, "/", uuid));
				line.setName(StringEscapeUtils.escapeHtml(line.getName()));
			});
		}
		model.addAttribute("list", list);
		return "merchant/index/payurls";
	}
	
	/**
	 * 下载网关
	 * @param type
	 * @param response
	 */
	@RequestMapping(value = "/download_wg")
	public void gateway(@RequestParam(value = "type") Integer type, HttpServletRequest request, HttpServletResponse response) {
		Line line = lineService.findByType(1).get(0);
		String url = CommonUtil.getBufferString(CommonUtil.getWholeDomainName(line.getDomainName()),line.getPort() == 80 ?"":":"+line.getPort());
		String version = systemSetService.findVersionByMark(type);
		Merchant merchant = ShiroManager.getMerchant();
		GatewayIni gateway = new GatewayIni(merchant.getSecretKey(), merchant.getUuid(), url, request);
		gateway.download(response,version,type);
	}
	
	/**
	 * 网关版本检测
	 * @return
	 */
	@GetMapping("/version/check")
	public @ResponseBody Result versionCheck(HttpServletRequest request){
		String type = request.getParameter("type");
		if (StringUtils.isEmpty(type))
			type = "1";
		String version = systemSetService.findVersionByMark(Integer.valueOf(type));
		return Result.success("检测成功", version);
	}
	
	/**
	 * 网关版本更新
	 * @param request
	 * @param response
	 */
	@GetMapping("/version/upgrade")
	public void upgrade(HttpServletRequest request,HttpServletResponse response){
		String filePath = Thread.currentThread().getContextClassLoader().getResource("").toString();
        filePath = filePath.replace("file:/", "").trim();
        filePath = filePath.replace("/", "\\").trim();
        String type = request.getParameter("type");
        String fileName = "gate.exe";
        if (!StringUtils.isEmpty(type) && type.equals("0"))
        	 fileName = "Sql.exe";
		if (!StringUtils.isEmpty(type) && type.equals("3"))
			 fileName = "cq3.exe";
		FileUtil.fileDownload(fileName, filePath, request, response);
	}
	
	/**
	 * 充值线路
	 * @return
	 */
	@GetMapping(value = "/line")
	public @ResponseBody List<Line> line() {
		List<Line> list = lineService.findByType(0);
		list.parallelStream().forEach(line -> {
			line.setDomainName(
					CommonUtil.getWholeDomainName(line.getDomainName(), line.getPort()));
		});
		return list;
	}
	
	/**
	 * ips统计结果集
	 * @param v
	 * @return
	 * @throws ParseException
	 */
	@PostMapping("/visit/list")
	public @ResponseBody Page<?> list(Visit v) throws ParseException{
		return new PageImpl<>(visitService.findVisitList(v));
	}
	
	/**
	 * 流量统计
	 * @param request
	 * @throws ParseException 
	 */
	@GetMapping("/flow/record")
	public @ResponseBody void flow(HttpServletRequest request){
		int visitTime = systemSetService.findVisitTime();
		visitService.visit(request,visitTime);
	}
	
	/**
	 * 进入游戏人数统计
	 * @param request
	 */
	@GetMapping("/game/record")
	public @ResponseBody void game(HttpServletRequest request){
		int loginTime = systemSetService.findLoginTime();
		visitService.game(request,loginTime);
	}
	
}
