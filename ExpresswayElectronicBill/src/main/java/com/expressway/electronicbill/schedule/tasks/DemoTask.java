package com.expressway.electronicbill.schedule.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.expressway.electronicbill.api.schedule.IScheduleManager;

@Component
public class DemoTask {
	private @Autowired IScheduleManager scheduleManager;

	@Scheduled(cron = "0/30 * * * * ?")
	public void test() {
		// System.out.println("***********Change BillDetail Status
		// ******************");
		// ScheduleJob job = scheduleManager.getScheduleJob("billDetail");
		//
		// if (job.isEnabled()) {
		// job.setEnabled(false);
		// scheduleManager.disableScheduleJob(job.getJobId());
		// } else {
		// job.setEnabled(true);
		// job.setCronExpression("0/2 * * * * ?");
		// scheduleManager.changeCornExpression(job.getJobId());
		// }
		// scheduleManager.immediateScheduleJob("billDetail");
	}
}
