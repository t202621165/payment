package com.cypay.merchant.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cypay.common.entity.SchedulerJob;
import com.cypay.common.service.impl.PartitionService;
import com.cypay.common.service.impl.ReissueRecordService;
import com.cypay.common.service.impl.SchedulerJobService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.PartitionVo;
import com.cypay.common.vo.ReissueRecordVo;
import com.cypay.common.vo.Result;
import com.cypay.merchant.aop.MerchantLogs;

@Controller
@RequestMapping(value = "mer")
public class ReissueRecordController {
	
	@Autowired
	private PartitionService partitionService;
	
	@Autowired
	private ReissueRecordService reissueRecordService;
	
	@Autowired
	private SchedulerJobService schedulerJobService;
	
	@GetMapping(value = "/reissue.html")
	public String reissue(Model model, PartitionVo v) {
		v.setMerchant(ShiroManager.getMerchant());
		v.setCreateDate(null);
		v.setUseDate(null);
		v.setState(Boolean.TRUE);
		if (v.getId() != null) {
			model.addAttribute("partitionId", v.getId());
			v.setId(null);
		}
		
		model.addAttribute("partition", partitionService.findAll(v));
		return "merchant/reissue/reissue";
	}
	
	@PostMapping(value = "/reissue/list")
	public @ResponseBody Page<?> list(ReissueRecordVo v, PageData pageData) {
		v.setMerchant(ShiroManager.getMerchant());
		return reissueRecordService.findVoPageList(v, pageData);
	}
	
	/**
	 * 补发记录
	 * @param model
	 * @param v
	 * @return
	 */
	@GetMapping(value = "/record.html")
	public String record(Model model) {
		return "merchant/reissue/record";
	}
	
	/**
	 * 手动充值
	 * @param v
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@MerchantLogs(value = "手动充值")
	@PostMapping(value = "/reissue/manual")
	public @ResponseBody Result manual(ReissueRecordVo v) {
		return reissueRecordService.orderReissue(v, "manual", 0);
	}
	
	/**
	 * 整区补发
	 * @param v
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@MerchantLogs(value = "整区补发")
	@PostMapping(value = "/reissue/whole")
	public @ResponseBody Result whole(ReissueRecordVo v) {
		return reissueRecordService.orderReissue(v, "whole", 3);
	}
	
	/**
	 * 定时任务列表
	 * @param v
	 * @param pageData
	 * @return
	 */
	@PostMapping(value = "/job/list")
	public @ResponseBody Page<?> jobList(SchedulerJob v, PageData pageData) {
		v.setMerchant(ShiroManager.getMerchant());
		return schedulerJobService.findAll(v, pageData);
	}
	
	/**
	 * 删除定时任务
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/job/delete")
	public @ResponseBody Result jobDelete(@RequestParam(value = "id") Long id) {
		return schedulerJobService.deleteById(id);
	}
	
	/**
	 * 停止定时任务
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/job/stop")
	public @ResponseBody Result jobStop(@RequestParam(value = "id") Long id) {
		return schedulerJobService.stop(id);
	}
	
	/**
	 * 清除补发记录
	 * @param v
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@MerchantLogs(value = "清除补发记录")
	@PostMapping(value = "/reissue/clean")
	public @ResponseBody Result clean(ReissueRecordVo v) {
		return reissueRecordService.deleteReissueRecord(v);
	}
}
