package com.expressway.electronicbill.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expressway.electronicbill.api.schedule.IScheduleManager;
import com.expressway.electronicbill.api.schedule.beans.ScheduleJob;

@RestController
@RequestMapping(value = "datas", method = RequestMethod.POST)
public class DataController {
	private @Autowired IScheduleManager scheduleManager;

	/**
	 * @return tasklist
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping("taskList")
	public Object taskList(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
		List<ScheduleJob> list = new ArrayList<ScheduleJob>();

		// Check User Login Status
		if (request.getSession().getAttribute("LoginUser") != null) {
			list.addAll(scheduleManager.listAll());
		}
		// Json Module
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("draw", "1");
		map.put("recordsTotal", list.size());
		map.put("recordsFiltered", list.size());
		map.put("data", list);

		return map;
	}
}
