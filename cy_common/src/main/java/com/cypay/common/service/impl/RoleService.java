package com.cypay.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cypay.common.entity.Role;
import com.cypay.common.repository.impl.RoleRepository;
import com.cypay.common.vo.Result;

@Service
public class RoleService extends BaseServiceImpl<RoleRepository, Role, Role>{
	
	public Result updateState(Long id){
		int i = baseRepository.updateState(id);
		if(i > 0)
			return Result.success("角色状态更新成功");
		else
			return Result.error("角色状态更新失败");
	}
	
	public List<Role> findByIds(List<Long> ids){
		return baseRepository.findByIds(ids);
	}

	public String findRoleMarkByUserId(Long id){
		return baseRepository.findRoleMarkByUserId(id);
	}
}
