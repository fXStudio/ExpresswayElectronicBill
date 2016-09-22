import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdScheduler;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.expressway.electronicbill.api.schedule.beans.ScheduleJob;
import com.expressway.electronicbill.schedule.jobs.BillDetailJob;

public class Demo {
	@Test
	public void print() throws SchedulerException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-core.xml");
		StdScheduler scheduler = (StdScheduler) context.getBean("schedulerFactoryBean");

		for (int i = 0; i < 1; i++) {
			ScheduleJob job = new ScheduleJob();
			job.setJobId("10001" + i);
			job.setJobName("data_import" + i);
			job.setJobGroup("dataWork");
			job.setJobStatus("1");
			job.setCronExpression("0/5 * * * * ?");
			job.setDesc("数据导入任务");

			process(job, scheduler);
		}

		while (true)
			;
	}

	private void process(ScheduleJob job, Scheduler scheduler) throws SchedulerException {
		TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobId(), job.getJobGroup());
		// 获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

		// 表达式调度构建器
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

		// 不存在，创建一个
		if (null == trigger) {
			JobDetail jobDetail = JobBuilder.newJob(BillDetailJob.class).withIdentity(job.getJobId(), job.getJobGroup())
					.build();
			// jobDetail.getJobDataMap().put(job.getJobGroup(), job);
			// 按新的cronExpression表达式构建一个新的trigger
			trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

			scheduler.scheduleJob(jobDetail, trigger);
		} else {
			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		}
		
		scheduler.pauseTrigger(triggerKey);
		scheduler.resumeTrigger(triggerKey);
	}
}
