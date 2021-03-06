package com.cypay.common.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.bo.TemplateBo;
import com.cypay.common.entity.Group;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.PartitionGroup;
import com.cypay.common.repository.impl.GroupRepository;
import com.cypay.common.repository.impl.LineRepository;
import com.cypay.common.repository.impl.PartitionGroupRepository;
import com.cypay.common.repository.impl.PartitionRepository;
import com.cypay.common.repository.impl.TemplateRepository;
import com.cypay.common.service.CriteriaData;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.util.PageData;
import com.cypay.common.util.SocketTemplate;
import com.cypay.common.vo.PartitionVo;
import com.cypay.common.vo.Result;

@Service
public class PartitionService extends BaseServiceImpl<PartitionRepository, Partition, PartitionVo> {
	
	@Autowired
	private TemplateRepository templateRepository;
	
	@Autowired
	private LineRepository lineRepository;

	//@Autowired
	//private ReissueRecordRepository reissueRecordRepository;
	
	@Autowired
	private PartitionGroupRepository partitionGroupRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	
	public Map<Integer, List<Partition>> findByMerchant() {
		List<Partition> list = baseRepository.findByMerchantOrderBySort(ShiroManager.getPrincipal(Merchant.class));
		return list.parallelStream().collect(Collectors.groupingBy(Partition::getType));
	}
	
	@Override
	protected CriteriaData<Partition, PartitionVo> getCriteriaData(String name, PartitionVo v) {
		name += ShiroManager.isAdminUser() ? "-plus" : "";
		CriteriaData<Partition, PartitionVo> cd = super.getCriteriaData(name, v);
		
		if (ShiroManager.isAdminUser() && !cd.isCache()) {
			cd.setOrders(Arrays.asList(cd.getCriteriaBuilder().desc(cd.getRoot().get("createDate"))));
		}
		return cd;
	}
	
	@Override
	protected List<Predicate> additionalWhele(CriteriaData<Partition, PartitionVo> cd, List<Predicate> wheles,
			PartitionVo v) {
		Group g = v.getGroup();
		if (g != null && g.getId() != null) {
			Join<Partition, PartitionGroup> pg = cd.getRoot().join("partitionGroups", JoinType.LEFT);
			pg.alias("pGroup");
			wheles.add(cd.getCriteriaBuilder().equal(pg.get("group"), g));
		}
		return super.additionalWhele(cd, wheles, v);
	}
	
	@Override
	public List<Partition> findAll(PartitionVo v) {
		return changeNameInTime(super.findAll(v));
	}
	
	/**
	 * 平台加载分区
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public Result loadPartition(Long id) {
		Partition partition = baseRepository.findByIdAndMerchant(id, ShiroManager.getMerchant());
		if (partition == null)
			return Result.error("分区不存在或已被删除！");
		
		if (partition.getType() != 1 && partition.getType() != 2)
			return Result.error("【分区加载】：当前分区不支持此操作！");
			
		TemplateBo templateBo = templateRepository.findTemplateByPartitionId(id);
		if (templateBo == null)
			return Result.error("请前往完善分区模板信息！");
		
		templateBo.setLines(lineRepository.findByTypeOrderByIsDefaultDesc(0));
		templateBo.setUuid(null);
		JSONObject json = new JSONObject();
		json.put("type", "load");
		json.put("flag", partition.getType());
		json.put("data", templateBo);
		return SocketTemplate.SMS.send(partition.getServerIp(), 
				partition.getServerPort(), json);
	}

	/**
	 * 检测分区
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public Result checkPartition(Long id) {
		Optional<Partition> optional = baseRepository.findById(id);
		if (!optional.isPresent())
			return Result.error("网关通讯异常【分区不存在】！");
		
		if (optional.get().getType() == 4)
			return Result.error("【分区检测】：当前分区不支持此操作！");
		
		JSONObject json = new JSONObject();
		json.put("type", "check");
		json.put("flag", optional.get().getType());
		
		return SocketTemplate.SMS.send(optional.get().getServerIp(), optional.get().getServerPort(), json);
	}
	
	/**
	 * 添加或更新分区信息
	 * @param v
	 * @return
	 */
	@Transactional
	public Result save(Partition p, boolean isCreate, boolean isClone,boolean isWg) {
		// 参数校验
		Result result = p.validate(isWg);
		if (!result.getState())
			return result;
		
		String msg = "分区【"+p.getName()+"】安装成功！";
		Merchant merchant = isWg ? p.getMerchant() : ShiroManager.getMerchant();
		if (p.getId() != null) { // 更新操作
			msg = "更新成功！";
			// 判断分区是否为当前商户所有
			Long count = baseRepository.countByIdAndMerchant(p.getId(), merchant);
			if (count == 0)
				return Result.error("更新失败，当前分区不存在或已被删除！");
			
			partitionGroupRepository.deletePartitionGroupByPId(p.getId());
		}
		// 排序号为空/非克隆分区
		if (!isClone || p.getSort() == null) {
			// 查询用户分区最大排序号
			Integer maxSort = baseRepository.findMaxSortByMerchant(merchant.getId());
			p.setSort(++maxSort);
		}
//		Integer maxSort = baseRepository.findMaxSortByMerchant(merchant.getId());
//		p.setSort(++maxSort);
		
		Partition partition = baseRepository.save(p);
		List<BigInteger> groupIds = groupRepository.findIds(p.getGroupIds(), merchant.getId());
		savePartitionGroup(groupIds,partition.getId());
		
		TemplateBo templateBo = null;
		if (!isWg){ //平台创建分区
			if (isCreate && (p.getType() == 1 || p.getType() == 2)){
				 templateBo = templateRepository.findTemplateByPartitionId(partition.getId());
				 templateBo.setLines(lineRepository.findByTypeOrderByIsDefaultDesc(0));
				 JSONObject json = new JSONObject();
				 json.put("type", "install");
				 json.put("flag", partition.getType());
				 json.put("data", templateBo);
				 return SocketTemplate.SMS.send(p.getServerIp(), p.getServerPort(), json);
			}
		}else{ //网关创建分区
			templateBo = templateRepository.findTemplateByPartitionId(partition.getId());
			templateBo.setLines(lineRepository.findByTypeOrderByIsDefaultDesc(0));
		}
		return Result.success(msg,templateBo);
	}
	
	public Result partitionLoad(Long id){
		TemplateBo templateBo = templateRepository.findTemplateByPartitionId(id);
		templateBo.setLines(lineRepository.findByTypeOrderByIsDefaultDesc(0));
		return Result.success("分区加载成功",templateBo);
	}
	
	/**
	 * 分区批量排序
	 * @param ids
	 * @param sorts
	 * @return
	 */
	@Transactional
	public Result sort(Long[] ids, Integer[] sorts) {
		String sql = "UPDATE cy_partition p SET p.sort = ? WHERE p.id = ? AND p.merchant_id = ?";
		Long merchantId = ShiroManager.getMerchant().getId();
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, sorts[i]);
				ps.setLong(2, ids[i]);
				ps.setLong(3, merchantId);
			}
			
			@Override
			public int getBatchSize() {
				return Math.max(ids.length, sorts.length);
			}
		});
		return Result.success("分区排序更新成功");
	}
	
	@Transactional
	@Override
	public Result deleteById(Long id) {
		Long result = baseRepository.countByIdAndMerchant(id, ShiroManager.getMerchant());
		if (result == 0)
			return Result.error("删除失败，当前分区【ID: "+id+"】不存在或已被删除！");
		partitionGroupRepository.deletePartitionGroupByPId(id);
		//reissueRecordRepository.deleteByPartitionId(id);
		baseRepository.deleteById(id);
		return Result.success("删除成功！");

	}
	
	@Transactional
	public Result wgDeleteById(Long id){
		partitionGroupRepository.deletePartitionGroupByPId(id);
		//reissueRecordRepository.deleteByPartitionId(id);
		baseRepository.deleteById(id);
		return Result.success("删除成功！");
	}
	
	/**
	 * 更新分区状态
	 * @param p
	 * @return
	 */
	public Result updateState(Long id) {
		baseRepository.updateState(id, ShiroManager.getMerchant().getId());
		return Result.success("操作成功");
	}
	
	/**
	 * 批量删除分区
	 * @param ids
	 * @return
	 */
	@Transactional
	public Result batchDelete(List<Long> ids) {
		List<Long> list = baseRepository.findByMerchantAndIds(ShiroManager.getMerchant(), ids);
		if (list != null && !list.isEmpty()) {
			partitionGroupRepository.deletePartitionGroupByPIds(ids);
			//reissueRecordRepository.deleteByPartitionIds(list);
			baseRepository.deleteByIds(list);
		}
		return Result.success("删除成功");
	}
	
	/**
	 * 根据分区uuid查询分区
	 * @param uuid
	 * @return
	 */
	public PartitionVo findByUuid(String uuid) {
		return baseRepository.findByUuid(uuid);
	}
	
	public List<Partition> findByUuid(String uuid, String type) {
		List<Partition> list = null;
		if ("m".equals(type)) {
			list = baseRepository.findByMerchantUuid(uuid);
		}else if ("g".equals(type)) {
			Long gId = groupRepository.findByUuid(uuid);
			list = baseRepository.findByGroupId(gId);
		}else {
			list = baseRepository.findByPartitionUuid(uuid);
		}
		return changeNameInTime(list);
	}
	
	/**
	 * 根据商户密钥和分区服务器ip查询分区
	 * @param key 商户密钥
	 * @param ip  分区服务器ip
	 * @return
	 */
	public List<PartitionVo> findPartitionByMerchantKeyAndServerIp(String key,String ip){
		return baseRepository.findPartitionByMerchantKeyAndServerIp(key, ip);
	}
	
	/**
	 * 根据分区ID和商户查询分区信息
	 * @param id
	 * @return
	 */
	public PartitionVo findOneVo(Long id) {
		Optional<PartitionVo> optional = baseRepository.findOneVo(id, 
				ShiroManager.getMerchant());
		if (optional.isPresent())
			return optional.get();
		
		return null;
	}
	
	public PartitionVo wgFindOneVo(Long id,Merchant merchant){
		Optional<PartitionVo> optional = baseRepository.findOneVo(id,merchant);
		if (optional.isPresent()){
			return optional.get();
		}
		return null;
	}
	
	public void savePartitionGroup(List<BigInteger> list,Long pId){
		
		String sql = "insert cy_partition_group (group_id,partition_id) values(?,?)";
		
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setLong(1,list.get(i).longValue());
				ps.setLong(2,pId);
			}
			
			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
	}
	
	public List<Partition> findByGroupId(Long gId){
		return baseRepository.findByGroupId(gId);
	}
	
	@Override
	public Page<PartitionVo> findVoPageList(PartitionVo v, PageData pageData) {
		Assert.notNull(v, "V cannot be null.");
		Assert.notNull(pageData, "PageData cannot be null.");
		
		CriteriaData<Partition, PartitionVo> cd = this.getCriteriaData(this.getClass().getName(), v);
		
		// 动态获取查询条件
		Predicate predicate = super.dynamicWhele(cd, v);
		
		return PageableExecutionUtils.getPage(cd.getResultList(pageData), pageData.ofPageable(),
				() -> getRepository().count(this.getSecification(predicate, v)));
	}
	
	protected Specification<Partition> getSecification(Predicate predicate, PartitionVo v) {
		return new Specification<Partition>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Partition> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Group g = v.getGroup();
				if (g != null && g.getId() != null) {
					Join<Partition, PartitionGroup> pg = root.join("partitionGroups", JoinType.LEFT);
					pg.alias("pGroup");
				}
				return predicate;
			}
		};
	}
	
	private List<Partition> changeNameInTime(List<Partition> list) {
		list.parallelStream().forEach(p -> {
			if (p.getIsChangeInTime()) {
				p.setName(new Date().compareTo(p.getChangeDate()) > 0 ? p.getUseName() : p.getName());
			}
		});
		return list;
	}
}
