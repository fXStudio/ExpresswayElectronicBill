package com.expressway.electronicbill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通用控制器
 * @author Ajaxfan
 */
@Controller
public class GenericController {
	@RequestMapping(value = { "/", "index" })
	public String index() {
		return "index";
	}
}
