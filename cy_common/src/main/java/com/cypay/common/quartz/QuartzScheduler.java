package com.cypay.common.quartz;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cypay.common.entity.SchedulerJob;
import com.cypay.common.service.impl.SchedulerJobService;

/**
 * 任务调度
 * @author International
 *
 */
public class QuartzScheduler {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Scheduler scheduler;
	
	@Autowired
	private SchedulerJobService schedulerJobService;
	
	/**
	 * 开始执行所有Job
	 */
	public void startAllJob() throws SchedulerException {
		List<SchedulerJob> list = schedulerJobService.findByState(0);
		List<Long> ids = list.parallelStream().map(job -> {
			if (job.isExpired()) {
				return job.getId();
			}else {
				try {
					startJob(job);
				} catch (SchedulerException e) {
					logger.error(e.getMessage());
				}
			}
			return null;
		}).collect(Collectors.toList());
		ids.removeAll(Collections.singleton(null));
		
		if (ids != null && !ids.isEmpty())
			schedulerJobService.updateStateByIds(2, ids);
	}
	
	/**
	 * 开启单个Job
	 * @param schedulerJob
	 * @throws SchedulerException
	 */
	@SuppressWarnings("unchecked")
	public boolean startJob(SchedulerJob schedulerJob) throws SchedulerException {
		// JobDetail 是具体Job实例
	    Class<Job> jobClass = null;
	    try {
	      //实例化具体的Job任务
	      jobClass = (Class<Job>) Class.forName(schedulerJob.getClassName());
	      
	      scheduler.start();
	      JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(schedulerJob.getName(), schedulerJob.getGroupName()).build();
	      // 基于表达式构建触发器
	      CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(schedulerJob.getCronExpression());
	      
	      // CronTrigger表达式触发器 继承于Trigger
	      // TriggerBuilder 用于构建触发器实例
	      CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(schedulerJob.getName(), schedulerJob.getGroupName())
	    		  .withSchedule(cronScheduleBuilder).build();
	      
	      scheduler.scheduleJob(jobDetail, cronTrigger);
	      return true;
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	      return false;
	    }
	}
	
	/**
	 * 获取某个Job信息
	 * @return
	 */
	public String getJobInfo(String name, String group) throws SchedulerException {
		TriggerKey triggerKey = new TriggerKey(name, group);
		CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		if (cronTrigger != null) {
			return String.format("time:%s,state:%s", cronTrigger.getCronExpression(),
					scheduler.getTriggerState(triggerKey).name());
		}
		return null;
	}
	
	/**
	 * 修改某个Job执行时间
	 * @param name
	 * @param group
	 * @param time
	 * @return
	 * @throws SchedulerException
	 */
	public boolean updateJob(SchedulerJob schedulerJob) throws SchedulerException {
		Date date = null;
        TriggerKey triggerKey = new TriggerKey(schedulerJob.getName(), schedulerJob.getGroupName());
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        String oldTime = cronTrigger.getCronExpression();
        if (!oldTime.equalsIgnoreCase(schedulerJob.getCronExpression())) {
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(schedulerJob.getCronExpression());
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(schedulerJob.getName(), schedulerJob.getGroupName())
                    .withSchedule(cronScheduleBuilder).build();
            date = scheduler.rescheduleJob(triggerKey, trigger);
        }
        return date != null;
	}
	
	/**
	 * 暂停所有Job
	 */
	public void pauseAllJob() throws SchedulerException {
		scheduler.pauseAll();
	}
	
	/**
	 * 暂停某个Job
	 */
	public void pauseJob(String name, String group) throws SchedulerException {
		JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail != null)
        	scheduler.pauseJob(jobKey);
	}
	
	/**
	* 恢复所有Job
     * 
     * @throws SchedulerException
     */
    public void resumeAllJob() throws SchedulerException {
        scheduler.resumeAll();
    }

    /**
	* 恢复某个Job
     * 
     * @param name
     * @param group
     * @throws SchedulerException
     */
    public void resumeJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail != null)
        	scheduler.resumeJob(jobKey);
    }

    /**
	* 删除某个Job
     * 
     * @param name
     * @param group
     * @throws SchedulerException
     */
    public void deleteJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail != null)
        	scheduler.deleteJob(jobKey);
    }
    
}
