package com.expressway.electronicbill.api.schedule;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.quartz.SchedulerException;

import com.expressway.electronicbill.api.helper.IConfigPropertiesHelper;
import com.expressway.electronicbill.api.schedule.beans.ScheduleJob;

/**
 * Schedule Manager Interface
 * 
 * @author Ajaxfan
 */
public interface IScheduleManager {
	/**
	 * @return All ScheduleJob
	 */
	public List<ScheduleJob> listAll();

	/**
	 * Get Specificated ScheduleJob
	 * 
	 * @param jobId
	 * @return
	 */
	public ScheduleJob getScheduleJob(String jobId);

	/**
	 * Disable Specificated ScheduleJob
	 * 
	 * @param jobId
	 * @return
	 */
	public boolean disableScheduleJob(String jobId);

	/**
	 * Enable Specificated ScheduleJob
	 * 
	 * @param jobId
	 * @return
	 */
	public boolean enableScheduleJob(String jobId);

	/**
	 * @param jobId
	 * @return
	 */
	public boolean changeCornExpression(String jobId);

	/**
	 * @param jobId
	 * @return
	 */
	public boolean immediateScheduleJob(String jobId);
}
