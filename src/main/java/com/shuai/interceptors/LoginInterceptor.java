/**
 * Copyright © 2018北京鼎九信息工程研究院有限公司. All rights reserved.
 *
 * @author jinxin_itmaster@163.com
 * @date 2018-07-24 16:21
 * @version V1.0
 **/
package com.shuai.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();

		if (session.isNew()) {
			log.error("这是一个新的session");
			response.sendRedirect(contextPath + "/plan/index");
			return false;
		} else if (session.getAttribute("username") == null) {
			log.error("该session中并没有当前用户的信息");
			response.sendRedirect(contextPath + "/plan/index");
			return false;
		}
		log.info("当前username->{}",session.getAttribute("username") );
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
