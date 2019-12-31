package com.cypay.manage.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cypay.common.entity.Notice;
import com.cypay.common.service.impl.NoticeService;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.Result;

@RestController
@RequestMapping(value="/man")
public class ManNoticeController {
	@Autowired
	private NoticeService noticeService;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 公告列表
	 * @param v
	 * @param pageData
	 * @return
	 */
	@GetMapping("/notice/list")
	public Page<?> list(Notice v,PageData pageData) {
		return noticeService.findAll(v, pageData);
	}
	
	/**
	 * 公告添加修改
	 * @param notice
	 * @return
	 */
	@PostMapping("/notice/save")
	public Result save(Notice notice){
		if(StringUtils.isEmpty(notice.getId())){
			notice.setDate(new Date());
			return noticeService.save(notice);
		}else{
			Notice v = noticeService.findById(notice.getId());
			v.setContent(notice.getContent());
			v.setPublisher(notice.getPublisher());
			v.setTitle(notice.getTitle());
			return noticeService.save(v);
		}
	}
	
	/**
	 * 公告状态更改
	 * @param v
	 * @return
	 */
	@PostMapping("/notice/state")
	public Result updateState(Notice v){
		return noticeService.updateState(v.getId());
	}
	
	/**
	 * 公告删除
	 * @param id
	 * @return
	 */
	@GetMapping("/notice/del")
	public Result del(@RequestParam(value="id") Long id){
		return noticeService.deleteById(id);
	}
}
