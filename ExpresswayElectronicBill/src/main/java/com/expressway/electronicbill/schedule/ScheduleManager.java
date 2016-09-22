package com.expressway.electronicbill.schedule;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.BeanUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import com.expressway.electronicbill.api.helper.IConfigPropertiesHelper;
import com.expressway.electronicbill.api.schedule.IScheduleManager;
import com.expressway.electronicbill.api.schedule.beans.ScheduleJob;

/**
 * Schedule Manager
 * 
 * @author Ajaxfan
 */
@Component
final class ScheduleManager implements IScheduleManager {
	/** System properties parser */
	private @Autowired IConfigPropertiesHelper configPropertiesHelper;

	/** Schedule Factory Class */
	private @Autowired SchedulerFactoryBean schedulerFactoryBean;

	/** ScheduleJob List */
	private List<ScheduleJob> list = new ArrayList<ScheduleJob>();

	/**
	 */
	@Override
	public List<ScheduleJob> listAll() {
		return Collections.unmodifiableList(list);
	}

	/**
	 * 
	 */
	@Override
	public ScheduleJob getScheduleJob(String jobId) {
		for (ScheduleJob job : list) {
			if (job.getJobId().equals(jobId)) {
				return job;
			}
		}
		return null;
	}

	/**
	 * 
	 */
	@Override
	public boolean disableScheduleJob(String jobId) {
		ScheduleJob job = getScheduleJob(jobId);

		if (job != null) {
			try {
				return schedulerFactoryBean.getScheduler().unscheduleJob(createTriggerKey(job));
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 
	 */
	@Override
	public boolean enableScheduleJob(String jobId) {
		return changeCornExpression(jobId);
	}

	/**
	 * 
	 */
	@Override
	public boolean changeCornExpression(String jobId) {
		ScheduleJob job = getScheduleJob(jobId);

		if (job != null) {
			try {
				TriggerKey key = createTriggerKey(job);
				// 获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
				CronTrigger trigger = (CronTrigger) schedulerFactoryBean.getScheduler().getTrigger(key);
				// 表达式调度构建器
				CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

				if (trigger != null) {
					// 按新的trigger重新设置job执行
					schedulerFactoryBean.getScheduler().rescheduleJob(key, trigger);
				} else {
					// Job的描述对象
					JobDetail detail = JobBuilder.newJob(JobFactory.createJob(job.getJobId()).getClass())
							.withIdentity(job.getJobId(), job.getJobGroup()).build();
					schedulerFactoryBean.getScheduler().scheduleJob(detail,
							TriggerBuilder.newTrigger().withIdentity(key).withSchedule(builder).build());
				}
				return true;
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 
	 */
	@Override
	public boolean immediateScheduleJob(String jobId) {
		ScheduleJob job = getScheduleJob(jobId);

		if (job != null) {
			try {
				JobFactory.createJob(job.getJobId()).execute(null);

				return true;
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Schedule Initialize
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws SchedulerException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	@PostConstruct
	public void init() throws IllegalAccessException, InvocationTargetException, SchedulerException,
			InstantiationException, ClassNotFoundException {
		// get all job names
		String jobNames = configPropertiesHelper.getProperty("schedule.jobNames");

		// if job exists then load jobs to buffer
		if (jobNames != null && jobNames.trim().length() > 0) {
			for (String jobName : jobNames.split(",")) {
				ScheduleJob job = new ScheduleJob();

				// Setter Bean
				for (Field field : ScheduleJob.class.getDeclaredFields()) {
					BeanUtils.setProperty(job, field.getName(),
							configPropertiesHelper.getProperty("schedule." + jobName + "." + field.getName()));
				}
				list.add(process(job, schedulerFactoryBean.getScheduler()));
			}
		}
	}

	/**
	 * @param job
	 * @param scheduler
	 * @throws SchedulerException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private ScheduleJob process(ScheduleJob job, Scheduler scheduler)
			throws SchedulerException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// 创建触发器对象，其key由Job的ID和Job的Group组成
		TriggerKey key = createTriggerKey(job);

		// 表达式调度构建器
		CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

		// Job的描述对象
		JobDetail detail = JobBuilder.newJob(JobFactory.createJob(job.getJobId()).getClass())
				.withIdentity(job.getJobId(), job.getJobGroup()).build();

		// 判断状态决定是否启用作业
		if (job.isEnabled()) {
			scheduler.scheduleJob(detail, TriggerBuilder.newTrigger().withIdentity(key).withSchedule(builder).build());
		}
		return job;
	}

	/**
	 * @param job
	 * @return
	 */
	private TriggerKey createTriggerKey(ScheduleJob job) {
		return TriggerKey.triggerKey(job.getJobId(), job.getJobGroup());
	}
}
