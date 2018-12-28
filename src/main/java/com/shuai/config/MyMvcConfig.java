package com.shuai.config;

import com.shuai.component.LoginHandlerInercepter;
import com.shuai.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * MyMvcConfig
 *
 * @author shuai
 * @date 2018/11/28
 */
@Configuration
//@EnableWebMvc 全面接管SpringMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/hi").setViewName("success");
	}

	// 所有的WebMvcConfigurerAdapter组件都会一起起作用
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/main.html").setViewName("dashboard");
			}

			//注册拦截器
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				//SpringBoot已经做好了静态资源映射，不用手动排除对静态资源的拦截
				registry.addInterceptor(new LoginHandlerInercepter()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/json/*","/cardiogram/*");
			}
		};
		return adapter;
	}

	@Bean
	public LocaleResolver localeResolver(){
	    return new MyLocaleResolver();
    }
}
