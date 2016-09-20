package com.expressway.electronicbill.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expressway.electronicbill.api.helper.IConfigPropertiesHelper;

/**
 * 通用控制器
 * 
 * @author Ajaxfan
 */
@Controller
public class RedirectController {
	private @Autowired IConfigPropertiesHelper configPropertiesHelper;

	/**
	 * @return 主页面
	 */
	@RequestMapping(value = { "/", "index" })
	public String index() {
		return "index";
	}

	/**
	 * @return Database Config Page
	 */
	@RequestMapping(value = { "dbconfig" })
	public String dbconfig(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {
		if (request.getSession().getAttribute("LoginUser") != null) {
			// 已经存在的配置信息
			model.addAttribute("serverAddress", configPropertiesHelper.getProperty("datasource.serverAddress"));
			model.addAttribute("serviceName", configPropertiesHelper.getProperty("datasource.serviceName"));
			model.addAttribute("port", configPropertiesHelper.getProperty("datasource.port"));
			model.addAttribute("username", configPropertiesHelper.getProperty("datasource.username"));
			model.addAttribute("password", configPropertiesHelper.getProperty("datasource.password"));

			return "dbconfig";
		}
		return "index";
	}
	
	/**
	 * @return FTP Config Page
	 */
	@RequestMapping(value = { "ftpconfig" })
	public String ftpconfig(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {
		if (request.getSession().getAttribute("LoginUser") != null) {
			// 已经存在的配置信息
			model.addAttribute("serverAddress", configPropertiesHelper.getProperty("ftp.serverAddress"));
			model.addAttribute("username", configPropertiesHelper.getProperty("ftp.username"));
			model.addAttribute("password", configPropertiesHelper.getProperty("ftp.password"));
			model.addAttribute("port", configPropertiesHelper.getProperty("ftp.port"));
			model.addAttribute("remoteDir", configPropertiesHelper.getProperty("ftp.remoteDir"));
			model.addAttribute("localDir", configPropertiesHelper.getProperty("ftp.localDir"));
			model.addAttribute("localBackup", configPropertiesHelper.getProperty("ftp.localBackup"));

			return "ftpconfig";
		}
		return "index";
	}

	/**
	 * @param path
	 * 
	 * @return 系统内部页面跳转
	 */
	@RequestMapping(value = "{path}")
	public String forward(HttpServletRequest request, @PathVariable("path") String path) {
		// 检查用户是否登陆，没有登陆用户需要跳转到首页先登陆
		if (request.getSession().getAttribute("LoginUser") != null) {
			return path;
		}
		return "index";
	}
}
