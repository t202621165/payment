package com.cypay.manage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cypay.common.entity.Group;
import com.cypay.common.service.impl.GroupService;
import com.cypay.common.util.PageData;
import com.cypay.common.vo.GroupVo;
import com.cypay.common.vo.Result;

@RestController
@RequestMapping(value = "/man")
public class ManGroupController {
	@Autowired
	private GroupService groupService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping("/group/groups")
	public List<Group> groups(){
		return groupService.findGroupIdAndName();
	}
	
	@GetMapping("/group/list")
	public Page<Group> groupList(GroupVo v,PageData pageData){
		return groupService.findAll(v, pageData);
	}
	
	@GetMapping("/group/del")
	public Result del(@RequestParam(value="id") Long id){
		return groupService.deleteById(id);
	}
}
