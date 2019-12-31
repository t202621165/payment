package com.cypay.common.service.impl;

import org.springframework.stereotype.Service;

import com.cypay.common.entity.User;
import com.cypay.common.repository.impl.UserRepository;
import com.cypay.common.vo.Result;

@Service
public class UserService extends BaseServiceImpl<UserRepository, User, User> {

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		return baseRepository.findByAccount(username);
	}

	public Result updateState(Long id){
		int i = baseRepository.updateState(id);
		if(i > 0)
			return Result.success("用户状态更新成功");
		else
			return Result.error("用户状态更新失败");
	}

}
