package com.expressway.electronicbill.schedule;

import org.quartz.Job;

import com.expressway.electronicbill.schedule.jobs.BillDetailJob;
import com.expressway.electronicbill.schedule.jobs.BillSummaryJob;
import com.expressway.electronicbill.schedule.jobs.BillUploadJob;

/**
 *
 * @author Ajaxfan
 */
final class JobFactory {
	/**
	 * @param clazz
	 * @return
	 */
	public static Job createJob(String clazz) {
		if ("billDetail".equals(clazz)) {
			return new BillDetailJob();
		} else if ("billSummary".equals(clazz)) {
			return new BillSummaryJob();
		} else if ("billUpload".equals(clazz)) {
			return new BillUploadJob();
		}
		return null;
	}
}
