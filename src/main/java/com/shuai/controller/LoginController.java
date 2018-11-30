package com.shuai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * LoginController
 *
 * @author shuai
 * @date 2018/11/29
 */
@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping(value = "/user/login")
//	@RequestMapping(value="/user/login",method = RequestMethod.POST)
	public String login(ModelMap modelMap, HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {
		logger.info("开始登录验证");
		logger.debug("登录名：{}", username);
		logger.debug("登录密码：{}", password);
		if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
			logger.info("登录成功");
			session.setAttribute("loginUser", username);
			//登录成功，防止表单重复提交，可以重定向到主页
			return "redirect:/main.html";
		} else {
			logger.error("用户名密码错误");
			modelMap.put("msg", "用户名密码错误");
			return "login";
		}
	}
}
