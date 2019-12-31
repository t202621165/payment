package com.cypay.common.quartz.job;

import javax.annotation.PostConstruct;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cypay.common.entity.SchedulerJob;
import com.cypay.common.service.impl.ReissueRecordService;
import com.cypay.common.service.impl.SchedulerJobService;
import com.cypay.common.util.CommonUtil;
import com.cypay.common.vo.ReissueRecordVo;
import com.cypay.common.vo.Result;

/**
 * 整区补发定时Job
 * @author International
 *
 */
@Component
public class WholeReissueTask implements Job {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Scheduler scheduler;
	
	@Autowired
	private SchedulerJobService schedulerJobService;
	
	@Autowired
	private ReissueRecordService reissueRecordService;
	
	public static WholeReissueTask wholeReissueTask;
	
	@PostConstruct
    public void init() {    
		wholeReissueTask = this;
		wholeReissueTask.scheduler = this.scheduler;
		wholeReissueTask.schedulerJobService = this.schedulerJobService;
		wholeReissueTask.reissueRecordService = this.reissueRecordService;
    }
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Integer state = -1;
		SchedulerJob job = null;
		JobKey jobKey = null;
		try {
			jobKey = context.getJobDetail().getKey();
			job = wholeReissueTask.schedulerJobService.findByNameAndGroupNameAndState(jobKey.getName(), jobKey.getGroup(), 0);
			
			if (job!= null) {
				ReissueRecordVo reissue = CommonUtil.parseObject(job.getJsonData(), ReissueRecordVo.class);
				if (reissue != null) {
					reissue.setAuto(false);
					Result json = wholeReissueTask.reissueRecordService.reissue(reissue, "whole", 4);
					if (json.getState())
						state = 1;
				}
			}
			
			wholeReissueTask.scheduler.deleteJob(jobKey);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			if (job != null)
				wholeReissueTask.schedulerJobService.updateStateById(state, job.getId());
		}
	}

}
