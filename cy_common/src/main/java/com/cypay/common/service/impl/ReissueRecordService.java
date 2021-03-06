package com.cypay.common.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.ReissueRecord;
import com.cypay.common.entity.Template;
import com.cypay.common.enums.Edition;
import com.cypay.common.pattern.strategy.reissue.GatewayReissue;
import com.cypay.common.repository.impl.PartitionRepository;
import com.cypay.common.repository.impl.ReissueRecordRepository;
import com.cypay.common.repository.impl.SystemSetRepository;
import com.cypay.common.service.CriteriaData;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.vo.ReissueRecordVo;
import com.cypay.common.vo.Result;

@Service
public class ReissueRecordService extends BaseServiceImpl<ReissueRecordRepository, ReissueRecord, ReissueRecordVo> {
	
	@Value("${com.payment.mark}")
	private String sysMark;

	@Autowired
	private SchedulerJobService schedulerJobService;
	
	@Autowired
	private PartitionRepository partitionRepository;
	
	@Autowired
	private SystemSetRepository systemSetRepository;
	
	private ReentrantLock lock = new ReentrantLock();
	
	private Map<String, GatewayReissue> reissueMap = new HashMap<String, GatewayReissue>();
	
	public ReissueRecordService(List<GatewayReissue> reissues) {
		this.reissueMap = reissues.parallelStream().collect(Collectors.toMap(GatewayReissue::getType, Function.identity()));
	}
	
	/**
	 * 手动充值、整区补发
	 * @param vo
	 * @param type
	 * @return
	 */
	public Result orderReissue(ReissueRecordVo vo, String mark, Integer type) {
		try{
			lock.lock();
			logger.info("补发请求参数：{}",JSONObject.toJSONString(vo));
			Merchant merchant = ShiroManager.getMerchant();
			vo.setSerialNumber("R_" + snowflakeIdWorker.nextId());
			vo.setMerchantId(merchant.getId());
			vo.setUuid(merchant.getUuid());
			return reissue(vo, mark, type);
		}catch (Exception e) {
			// TODO: handle exception
			return Result.error(String.format("补发异常:【%s】", e.getMessage()));
		}finally{
			lock.unlock();
		}
	}
	
	/**
	 * 订单补发
	 * @param vo
	 * @param type
	 * @return
	 */
	public Result reissue(ReissueRecordVo vo, String mark, Integer type) {
		Long partitionId = vo.getPartitionId();
		Merchant merchant = vo.getMerchant();
		if ("whole".equals(mark) && vo.isAuto()) {
			Date autoDate = vo.getAutoDate();
			if (autoDate == null || new Date().compareTo(autoDate) > 1) {
				return Result.error("请选择有效的自动补发时间", "autoDate");
			}
			if (systemSetRepository.findTaskCount(sysMark, merchant.getId()) < 1) {
				return Result.error("定时任务添加失败，已达到最大可执行任务数");
			}
		}
		
		Partition p = partitionRepository.findByIdAndMerchant(partitionId, merchant);
		if (p == null) {
			return Result.error("当前分区不存在或不可用！");
		}
		
		Template t = p.getTemplate();
		if (t == null) {
			return Result.error("未检测对应充值模板，请前往完善分区信息！");
		}
		if (!Edition.hasWGPermission(p.getType())) { // 网关未授权
			return Result.error("GATEWAY_UNAUTHORIZED");
		}
		t.parse();
		vo.setPartition(p);
		// 定时整区补发
		if ("whole".equals(mark) && vo.isAuto()) {
			return schedulerJobService.wholeReissueTask(vo);
		}
		
		GatewayReissue gatewayReissue = reissueMap.get(mark);
		if (gatewayReissue != null) {
			gatewayReissue.setReissueRecordService((ReissueRecordService) AopContext.currentProxy());
			return gatewayReissue.reissue(vo, type);
		}
		return Result.error("系统异常！");
	}
	
	/**
	 * 保存手动充值和整区补发记录
	 * @param records
	 */
	@Async
	public void saveRecord(List<ReissueRecordVo> records) {
		if (records != null && !records.isEmpty()) {
			String sql = "insert into cy_reissue_record(reissue_date, amount, player_account, type, product_id, partition_id, merchant_id, serial_number,p_name) values(?, ?, ?, ?, ?, ?, ?, ?,?)";
			jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
				Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ReissueRecordVo v = records.get(i);
					Partition partition = v.getPartition();
					String partitionName = partition.getName(); 
					if (partition.getChangeDate() != null && new Date().compareTo(partition.getChangeDate()) > 0) {
						partitionName = partition.getIsChangeInTime() ? partition.getUseName() : partition.getName();
					}
					ps.setTimestamp(1, timeStamp);
					ps.setBigDecimal(2, v.getAmount());
					ps.setString(3, v.getPlayerAccount());
					ps.setBoolean(4, v.getType());
					ps.setLong(5, v.getProductId());
					ps.setLong(6, v.getPartitionId());
					ps.setLong(7, v.getMerchant().getId());
					ps.setString(8, v.getSerialNumber());
					ps.setString(9, partitionName);
				}

				@Override
				public int getBatchSize() {
					return records.size();
				}
				
			});
		}
	}

	@Override
	protected CriteriaData<ReissueRecord, ReissueRecordVo> getCriteriaData(String name, ReissueRecordVo v) {
		CriteriaData<ReissueRecord, ReissueRecordVo> cd = super.getCriteriaData(name, v);
		cd.getRoot().join("partition", JoinType.LEFT);
		return cd;
	}
	
	@Override
	protected List<Predicate> additionalWhele(CriteriaData<ReissueRecord, ReissueRecordVo> cd, List<Predicate> wheles,
			ReissueRecordVo v) {
		// TODO Auto-generated method stub
		if (!StringUtils.isEmpty(v.getpName())){
			wheles.add(cd.getCriteriaBuilder().like(cd.getRoot().get("pName"), "%"+v.getpName()+"%"));
		}
		return super.additionalWhele(cd, wheles, v);
	}

	public Result deleteReissueRecord(ReissueRecordVo v) {
		int i = baseRepository.deleteByDate(v.getStartDate(), v.getEndDate(), ShiroManager.getMerchant().getId());
		return i > 0 ? Result.success("共清除补发记录【"+i+"】条。") : Result.error("没有可清除的补发记录！");
	}
}