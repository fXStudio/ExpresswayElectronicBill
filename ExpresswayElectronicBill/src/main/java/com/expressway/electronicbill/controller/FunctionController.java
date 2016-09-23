package com.expressway.electronicbill.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expressway.electronicbill.api.helper.IConfigPropertiesHelper;
import com.expressway.electronicbill.message.FeedBackMessage;

/**
 * 会话控制器
 * 
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = RequestMethod.POST)
public class FunctionController {
	private @Autowired IConfigPropertiesHelper configPropertiesHelper;

	/**
	 * @return 系统登录
	 */
	@RequestMapping("systemLogin")
	public Object systemLogin(HttpServletRequest request,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {
		// 判断用户名密码是否正确
		if (username.equals(configPropertiesHelper.getProperty("bill.username"))
				&& password.equals(configPropertiesHelper.getProperty("bill.password"))) {
			// 登陆用户信息存储在Session中
			request.getSession().setAttribute("LoginUser", username);

			return new FeedBackMessage(true);
		}
		return new FeedBackMessage(false, "Username or Passwor Invalid");
	}
}
