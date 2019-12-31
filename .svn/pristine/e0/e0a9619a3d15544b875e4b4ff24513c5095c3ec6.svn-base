package com.cypay.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cypay.common.entity.Notice;
import com.cypay.common.repository.impl.NoticeRepository;
import com.cypay.common.vo.Result;

@Service
public class NoticeService extends BaseServiceImpl<NoticeRepository, Notice, Notice>{
	
	public List<Notice> findAllByState(Boolean state) {
		return baseRepository.findByState(state);
	}
	
	public Result updateState(Long id){
		int i = baseRepository.updateState(id);
		if(i > 0){
			return Result.success("公告状态更改成功");
		}else{
			return Result.error("公告状态更改失败");
		}
	}
	
}
