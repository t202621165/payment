package com.cypay.manage.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.bo.SettlementBo;
import com.cypay.common.entity.SettleMent;
import com.cypay.common.entity.SettleMentReply;
import com.cypay.common.entity.User;
import com.cypay.common.service.impl.BankService;
import com.cypay.common.service.impl.SettleMentReplyService;
import com.cypay.common.service.impl.SettleMentService;
import com.cypay.common.service.impl.UserService;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.BankVo;
import com.cypay.common.vo.Result;
import com.cypay.common.vo.SettleMentReplyVo;
import com.cypay.common.vo.SettleMentVo;

import cn.hutool.core.date.DateUtil;

@RestController
@RequestMapping(value = "/man")
public class SettleMentController {
	@Autowired
	private SettleMentService settleMentService;
	@Autowired
	private SettleMentReplyService settleMentReplyService;
	@Autowired
	private BankService bankService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/funds/list")
	public Page<BankVo> funds(BankVo v,PageData pageData) throws ParseException{
		v.setActivated(true);
		return bankService.findVoPageList(v, pageData);
	}

	/**
	 * t0/t1列表
	 * 
	 * @param v
	 * @param pageData
	 * @return
	 * @throws ParseException
	 */
	@GetMapping("/tSettlement/list")
	public Page<BankVo> tSettleMents(BankVo v, PageData pageData) throws ParseException {
		v.setStartDate(DateUtil.beginOfDay(new Date()));
		v.setEndDate(DateUtil.endOfDay(new Date()));
		v.setActivated(true);
		v.setBankState(true);
		return bankService.findVoPageList(v, pageData);
	}
	
	@GetMapping("/reply/conditions")
	public Map<String,Object> conditions(){
		Map<String,Object> map = new HashMap<String, Object>();
		List<User> users = userService.findAll();
		map.put("users",users);
		return map;
	}

	/**
	 * 提现业务列表
	 * 
	 * @param v
	 * @param pageData
	 * @return
	 * @throws ParseException
	 */
	@GetMapping("/settlement/list")
	public JSONObject settlement(SettleMentVo v, PageData pageData) throws ParseException {
		if (v.getState() == null)
			v.setState(2);
		if (v.getState() != 1) {
			v.setStartDate(null);
			v.setEndDate(null);
		}
		return settleMentService.findSettlementDData(v, pageData);
	}

	/**
	 * 资金批复列表
	 * 
	 * @param v
	 * @param pageData
	 * @return
	 */
	@GetMapping("/reply/list")
	public SettlementBo settlementReply(SettleMentReplyVo v, PageData pageData) {
		SettlementBo bo = new SettlementBo();
		bo.setPage(settleMentReplyService.findVoPageList(v, pageData));
		bo.setTotalAmount(settleMentReplyService.findTotalAmount(v.getStartDate(), v.getEndDate()).getTotalAmount());
		return bo;
	}

	@GetMapping("/reply/settlement/list")
	public Page<SettleMentVo> replySettlement(SettleMentVo v, PageData pageData) throws ParseException {
		return settleMentService.findVoPageList(v, pageData);
	}
	
	/**
	 * T0/T1结算
	 * 
	 * @param list
	 *            结算列表数据
	 * @param flag
	 *    t0/t1
	 */
	@PostMapping("/settlement/{flag}")
	public Result settleList(@RequestBody List<SettleMentVo> list, @PathVariable(value = "flag") String flag) {
		return settleMentService.settlement(list, flag);
	}
	
	/**
	 * 提现业务
	 * 
	 * @param ids
	 *            结算列表数据
	 * @param mark
	 *            结算业务标识
	 */
	@PostMapping("/payment/{mark}")
	public Result payment(@RequestBody List<Long> ids, @PathVariable(value = "mark") String mark, String disc) {
		return settleMentService.payment(ids, mark, disc);
	}

	/**
	 * 批复
	 * 
	 * @param v
	 * @return
	 */
	@PutMapping("/reply/update")
	public Result updateReply(SettleMentReplyVo v) {
		return settleMentReplyService.updateReplyState(v.getId());
	}
	
	@PostMapping("/reply/ret")
	public Result replyRet(@RequestParam(value="serialNumber") String serialNumber){
		SettleMentReply reply = settleMentReplyService.findBySerialNumber(serialNumber);
		if (!StringUtils.isEmpty(reply)){
			List <SettleMent> list = reply.getSettleMents().stream().map(s -> {
				s.setState(2);
				s.setSettleMentReply(null);
				return s;
			}).collect(Collectors.toList());
			settleMentService.saveAll(list);
		}else{
			SettleMent settle = settleMentService.findBySerialNumber(serialNumber);
			settle.setState(2);
			settle.setSettleMentReply(null);
			settleMentService.save(settle);
		}
		
		return Result.success("批复驳回成功");
	}
	
	@GetMapping("/reply/excel")
	public void excel(SettleMentReply reply,@RequestParam(value = "type") String type, HttpServletResponse response) {
		settleMentReplyService.excel(reply,type, response);
	}
	
	@GetMapping("/settlement/clear")
	public Result clear(SettleMentVo v){
		return settleMentService.clear(v);
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
