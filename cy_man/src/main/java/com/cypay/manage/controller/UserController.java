package com.cypay.manage.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cypay.common.entity.Log;
import com.cypay.common.entity.Role;
import com.cypay.common.entity.User;
import com.cypay.common.log.LogExcute;
import com.cypay.common.service.impl.RoleService;
import com.cypay.common.service.impl.UserService;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.vo.Result;

import cn.hutool.core.util.IdUtil;

@RestController
@RequestMapping(value = "man")
public class UserController {
	@Autowired
	private LogExcute logExcute;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@PostMapping(value = "/login")
	public Map<String, Object> loginAjax(User user,Log log,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User u = ShiroManager.login(user);
			map.put("state", true);
			map.put("msg", "身份校验成功,登陆跳转中...");
			map.put("url", "/man/index");
			/*************日志封装**************/
			log.setDateTime(new Date());
			log.setDiscription("管理员登陆");
			log.setUser(u);
			logExcute.log(log);
		} catch (AccountException e) {
			map.put("state", false);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 用户录入
	 * @param user
	 * @param roleIds
	 * @return
	 */
	@PostMapping("/user/save")
	public Result save(@Valid User user,@RequestParam(value="roleIds[]") List<Long> roleIds){
		List<Role> roles = new ArrayList<Role>();
		user.setSalt(IdUtil.fastSimpleUUID());
		user.setState(true);
		user.setPassword(new Md5Hash("000000",user.getSalt()).toHex());//初始化密码 000000
		roleIds.forEach(id ->{
			Role role = roleService.findById(id);
			role.getUsers().add(user);
			roles.add(role);
		});	
		user.setRoles(new HashSet<>(roles));
		return userService.save(user);
	}
	
	@PostMapping("/user/edit")
	public Result edit(@Valid User user,HttpServletRequest request){
		Set<Role> roles = new HashSet<Role>();
		User u = userService.findById(user.getId());
		u.setUsername(user.getUsername());
		u.setNickname(user.getNickname());
		String[] roleIds = request.getParameterValues("roleIds[]");
		if(!StringUtils.isEmpty(roleIds)){
			u.getRoles().forEach(r->r.removeUser(u));
			for(String id : roleIds){
				Role role = roleService.findById(Long.valueOf(id));
				role.getUsers().add(u);
				roles.add(role);
			}
			u.setRoles(roles);
		}
		return userService.save(u);
	}
	
	/**
	 * 修改密码
	 * @param id 用户id
	 * @param old 原密码
	 * @param newPwd 新密码
	 * @return
	 */
	@PostMapping("/user/password")
	public Result password(@RequestParam(value="id") Long id,@RequestParam(value="old") String old,@RequestParam(value="newPwd") String newPwd){
		User user = userService.findById(id);
		if(user.getPassword().equals(new Md5Hash(old, user.getSalt()).toHex())){
			user.setPassword(new Md5Hash(newPwd,user.getSalt()).toHex());
			userService.save(user);
			return Result.success("密码修改成功");
		}else{
			return Result.error("原密码错误");
		}
	}
	
	@GetMapping("/user/delete")
	public Result del(@RequestParam(value = "id") Long id){
		User user = userService.findById(id);
		user.getRoles().forEach(r ->{
			r.removeUser(user);
		});
		return userService.deleteById(id);
	}
}
