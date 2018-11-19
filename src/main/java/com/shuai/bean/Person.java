package com.shuai.bean;

import org.hibernate.validator.constraints.Email;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Person
 *
 * @author shuai
 * @date 2018/11/19
 */
@Component
//加载指定配置文件
@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {
	/**
	 * @Value
	 * 字面量、${key}从环境变量、配置文件获取值、#{SpEL}
	 * 不支持复杂类型封装
	 */

	/**
	 * 必须是邮箱格式，使用@ConfigurationProperties可以校验(JSR303数据校验)
	 * 使用@Value校验不起作用
	 */
//	@Email
//	@Value("${person.last-name}")
	private String lastName;
	//	@Value("#{11*2}")
	private Integer age;
	//	@Value("true")
	private Boolean boss;
	private Date birth;
	private Map<String, Object> maps;
	private List<Object> lists;
	private Dog dog;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getBoss() {
		return boss;
	}

	public void setBoss(Boolean boss) {
		this.boss = boss;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public List<Object> getLists() {
		return lists;
	}

	public void setLists(List<Object> lists) {
		this.lists = lists;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	@Override
	public String toString() {
		return "Person{" +
				"lastName='" + lastName + '\'' +
				", age=" + age +
				", boss=" + boss +
				", birth=" + birth +
				", maps=" + maps +
				", lists=" + lists +
				", dog=" + dog +
				'}';
	}
}
