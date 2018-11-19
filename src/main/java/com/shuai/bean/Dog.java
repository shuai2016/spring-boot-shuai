package com.shuai.bean;

/**
 * Dog
 *
 * @author shuai
 * @date 2018/11/19
 */
public class Dog {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
