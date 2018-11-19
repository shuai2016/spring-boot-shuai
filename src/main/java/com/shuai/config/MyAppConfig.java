package com.shuai.config;

import com.shuai.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyAppConfig 指明当前类是一个配置类
 *
 * @author shuai
 * @date 2018/11/19
 */
@Configuration
public class MyAppConfig {

	/**
	 * 将方法的返回值添加到容器中；容器中这个组件的id就是方法名
	 *
	 * @return
	 */
	@Bean
	public HelloService helloService(){
		System.out.println("配置类@Bean给容器添加组件了...");
		return new HelloService();
	}
}
