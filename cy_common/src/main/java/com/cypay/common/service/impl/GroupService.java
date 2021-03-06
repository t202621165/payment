package com.cypay.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.cypay.common.entity.Group;
import com.cypay.common.entity.Merchant;
import com.cypay.common.repository.impl.GroupRepository;
import com.cypay.common.repository.impl.PartitionGroupRepository;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.vo.GroupVo;
import com.cypay.common.vo.Result;

import cn.hutool.core.util.IdUtil;

@Service
public class GroupService extends BaseServiceImpl<GroupRepository, Group, Group> {
	
	@Autowired
	private PartitionGroupRepository partitionGroupRepository;

	public Result save(Group t,Boolean isWg) {
		String name = t.getName().trim();
		String msg = "分组【"+name+"】添加成功!";
		if (StringUtils.isEmpty(name)) {
			return Result.error("分组名称不能为空！", "name");
		}
		
		Long id = t.getId();
		Merchant merchant = null;
		if(isWg)
			merchant = t.getMerchant();
		else
		    merchant = ShiroManager.getMerchant();
		if (id != null) {
			msg = "更新成功！";
			Long count = baseRepository.countByIdAndMerchant(id, merchant);
			if (count == 0) {
				return Result.error("更新失败，当前分组不存在或已被删除！");
			}
		}
		
		Group group = baseRepository.findByMerchantAndName(merchant, name);
		if (group != null && group.getId() != id) {
			return Result.error("分组【"+name+"】已存在！", "name");
		}
		
		t.setUuid(IdUtil.fastSimpleUUID());
		t.setMerchant(merchant);
		baseRepository.save(t);
		return Result.success(msg);
	}
	
	public Result deleteById(Long id,Merchant merchant) {
//		Group g = new Group(id);
		if (merchant == null)
			merchant = ShiroManager.getMerchant();
//		Long count = partitionRepository.countByGroupAndMerchant(g, merchant);
//		if (count > 0)
//			return Result.error("删除失败，当前‘"+count+"’个分区正在使用该分组！");
		partitionGroupRepository.deletePartitionGroupByGId(id);
		int result = baseRepository.deleteByIdAndMerchant(id, merchant);
		if (result == 0)
			return Result.error("删除失败，当前分组不存在或已被删除！");
		
		return Result.success("删除成功！");
	}

	/**
	 * 根据商户UUID查询分组
	 * @param uuid
	 * @return
	 */
	public List<Group> findByMerchantUuid(String uuid) {
		return baseRepository.findByMerchantUuid(uuid);
	}
	
	public List<Group> findGroupIdAndName(){
		return baseRepository.findGroupIdAndName();
	}
	
	public List<GroupVo> findGroupsByMerchantKey(String key){
		return baseRepository.findGroupsByMerchantKey(key);
	}
	
	public Long findByUuid(String guid){
		return baseRepository.findByUuid(guid);
	}
	
	public List<Map<String, Object>> findByPartitionAndMerchant(Long partitionId, Long merchantId) {
		return baseRepository.findByPartitionAndMerchant(partitionId, merchantId);
	}
}
