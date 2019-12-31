package com.cypay.common.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cypay.common.entity.Merchant;
import com.cypay.common.entity.Partition;
import com.cypay.common.entity.SchedulerJob;
import com.cypay.common.quartz.QuartzScheduler;
import com.cypay.common.repository.impl.SchedulerJobRepository;
import com.cypay.common.shiro.ShiroManager;
import com.cypay.common.vo.ReissueRecordVo;
import com.cypay.common.vo.Result;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;

@Service
public class SchedulerJobService extends BaseServiceImpl<SchedulerJobRepository, SchedulerJob, SchedulerJob> {

	private final static SchedulerJob SCHEDULER_JOB = new SchedulerJob();
	
	static {
		SCHEDULER_JOB.setName("t1AutoSettlement");
		SCHEDULER_JOB.setClassName("com.cypay.common.quartz.job.T1AutoSettlementTask");
		// 0 0 0 * * ? *  每天的00:00
		SCHEDULER_JOB.setCronExpression("0 0 0 * * ? *");
		SCHEDULER_JOB.setGroupName("system@t1Settlement");
	}
	
	@Autowired
	@Qualifier("myQuartScheduler")
	private QuartzScheduler quartzScheduler;
	
	public SchedulerJob findByNameAndGroupNameAndState(String name, String groupName, Integer state) {
		return baseRepository.findByNameAndGroupNameAndState(name, groupName, state);
	}
	
	public void startT1AutoSettlementTask() {
		try {
			quartzScheduler.startJob(SCHEDULER_JOB);
			logger.info("【T1定时结算任务已开启】");
		} catch (SchedulerException e) {
			logger.error("【T1自动结算任务启动异常】：{}", e.getMessage());
		}
	}
	
	/**
	 * 定时整区补发
	 * @param vo
	 * @return
	 */
	public Result wholeReissueTask(ReissueRecordVo vo) {
		try {
			Merchant merchant = ShiroManager.getMerchant();
			Partition p = vo.getPartition();
			String jobName = RandomUtil.randomStringUpper(8);
			SchedulerJob job = new SchedulerJob(jobName, "whole@"+merchant.getAccount(), 
					"com.cypay.common.quartz.job.WholeReissueTask", DateUtil.format(
							vo.getAutoDate(), "s m H d M ? yyyy"), merchant);
			
			boolean isAdded = vo.getAdded().compareTo(BigDecimal.ONE) == 1;
			job.setDiscription(String.format("分区【%s：%s】充值时间【%s 至 %s】。%s手动充值、%s红包赠送、%s赠送金额%s%s【执行：%s】", 
					p.getId(), p.getName(), DateUtil.formatDateTime(vo.getStartDate()), DateUtil.formatDateTime(vo.getEndDate()), 
					vo.isContainManual()?"包含":"不包含", vo.isContainRedPacket()?"包含":"不包含", vo.isContainGiveAmount()?"包含":"不包含", 
				isAdded?("、额外补发："+vo.getAdded().intValue()+"%"):"", isAdded&&vo.isOnlyYB()?"(仅补发元宝)。":"。", DateUtil.formatDateTime(vo.getAutoDate())));
			job.setJsonData(vo.toJSONString());
			
			if (quartzScheduler.startJob(job)) {
				baseRepository.save(job);
			}
			return Result.success("任务名称【"+jobName+"】定时补发！");
		} catch (SchedulerException e) {
			e.printStackTrace();
			return Result.error("【系统异常】定时补发任务未成功启动！");
		}
	}

	/**
	 *更新定时任务状态
	 * @param state
	 * @param id
	 * @return
	 */
	public Result updateStateById(Integer state, Long id) {
		int i = baseRepository.updateStateById(state, id);
		if (i == 1)
			return Result.success("更新成功！");
		
		return Result.error("更新失败！");
	}
	
	public Result updateStateByIds(Integer state, List<Long> ids) {
		int i = baseRepository.updateStateByIds(state, ids);
		if (i >= 1)
			return Result.success("更新成功！");
		
		return Result.error("更新失败！");
	}
	
	@Override
	public Result deleteById(Long id) {
		SchedulerJob job = baseRepository.findByIdAndMerchant(id, ShiroManager.getMerchant());
		if (job == null)
			return Result.error("当前任务不存在！");
		try {
			quartzScheduler.deleteJob(job.getName(), job.getGroupName());
			baseRepository.deleteById(id);
			return Result.success("任务【"+job.getName() +"】已删除！");
		} catch (SchedulerException e) {
			logger.error(e.getMessage());
			return Result.error("系统异常！");
		}
	}

	/**
	 * 停止定时任务
	 * @param id
	 * @return
	 */
	public Result stop(Long id) {
		SchedulerJob job = baseRepository.findByIdAndMerchant(id, ShiroManager.getMerchant());
		if (job == null)
			return Result.error("当前任务不存在！");
		try {
			quartzScheduler.deleteJob(job.getName(), job.getGroupName());
			baseRepository.updateStateById(-1, id);
			return Result.success("任务【"+job.getName() +"】已停止！");
		} catch (SchedulerException e) {
			logger.error(e.getMessage());
			return Result.error("系统异常！");
		}
	}

	public List<SchedulerJob> findByState(Integer state) {
		return baseRepository.findByState(state);
	}
}
