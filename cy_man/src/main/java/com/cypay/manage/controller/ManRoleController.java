package com.cypay.manage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cypay.common.entity.Role;
import com.cypay.common.service.impl.RoleService;
import com.cypay.common.vo.Result;

@RestController
@RequestMapping(value = "/man")
public class ManRoleController {
	@Autowired
	private RoleService roleService;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping("/role/roles")
	public List<Role> roles(){
		return roleService.findAll();
	}
	
	@PostMapping("/role/save")
	public Result save(Role role){
		role.setState(true);
		return roleService.save(role);
	}
	
	@GetMapping("/role/delete")
	public Result del(@RequestParam(value = "id") Long id){
		return roleService.deleteById(id);
	}
}
