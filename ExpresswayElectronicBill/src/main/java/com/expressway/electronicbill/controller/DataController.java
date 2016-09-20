package com.expressway.electronicbill.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expressway.electronicbill.api.helper.IConfigPropertiesHelper;
import com.expressway.electronicbill.schedule.beans.ScheduleJob;

@RestController
@RequestMapping(value = "datas", method = RequestMethod.POST)
public class DataController {
	private @Autowired IConfigPropertiesHelper configPropertiesHelper;

	/**
	 * @return 系统登录
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping("taskList")
	public Object taskList(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
		List<ScheduleJob> list = new ArrayList<ScheduleJob>();

		if (request.getSession().getAttribute("LoginUser") != null) {
			String jobNames = configPropertiesHelper.getProperty("schedule.jobNames");

			if (jobNames != null && jobNames.trim().length() > 0) {
				for (String jobName : jobNames.split(",")) {
					ScheduleJob job = new ScheduleJob();

					for (Field field : ScheduleJob.class.getDeclaredFields()) {
						BeanUtils.setProperty(job, field.getName(),
								configPropertiesHelper.getProperty("schedule." + jobName + "." + field.getName()));
					}
					list.add(job);
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("draw", "1");
		map.put("recordsTotal", list.size());
		map.put("recordsFiltered", list.size());
		map.put("data", list);
		
		return map;
	}
}
