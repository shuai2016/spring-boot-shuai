package com.shuai.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * MyBatisConfig
 *
 * @author shuai
 * @date 2018/12/3
 */
@MapperScan("com.shuai.mapper") //批量扫描mapper
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

	@Bean
	public ConfigurationCustomizer configurationCustomizer() {
		return new ConfigurationCustomizer(){
			@Override
			public void customize(Configuration configuration) {
				//驼峰命名法
				configuration.setMapUnderscoreToCamelCase(true);
			}
		};
	}
}
