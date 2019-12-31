package com.cypay.manage.controller;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cypay.common.service.impl.PartitionService;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.PartitionVo;
import com.cypay.common.vo.Result;

@RestController
@RequestMapping(value="/man")
public class ManPartitionController {
	@Autowired
	private PartitionService partitionService;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping("/partition/list")
	public Page<?> partition(PartitionVo v,PageData pageData){
		return partitionService.findVoPageList(v, pageData);
	}
	
	@GetMapping("/partition/del")
	public Result del(@RequestParam(value="id") Long id){
		try{
			return partitionService.wgDeleteById(id);
		}catch (Exception e) {
			logger.info(e.getMessage());
			return Result.error("删除分区失败");
		}
		
	}
	
	/**
	 * 检测分区
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping(value ="/partition/check")
	public @ResponseBody Result check(@RequestParam(value = "id", required = true) Long id) {
		return partitionService.checkPartition(id);
	}
}
