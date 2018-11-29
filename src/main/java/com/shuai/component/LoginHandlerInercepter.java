package com.shuai.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginHandlerInercepter
 * 登录检测
 * @author shuai
 * @date 2018/11/29
 */
public class LoginHandlerInercepter implements HandlerInterceptor {
	/**
	 * 方法执行之前
	 * @param request
	 * @param response
	 * @param o
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		Object loginUser = request.getSession().getAttribute("loginUser");
		if(loginUser == null){
			//未登录，返回登录页面
			request.setAttribute("msg","没有权限，请先登录");
			request.getRequestDispatcher("/index.html").forward(request,response);
			return false;
		} else {
			//已登录，请求放行
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
