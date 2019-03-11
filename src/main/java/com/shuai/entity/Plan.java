package com.shuai.entity;

import java.util.Date;

/**
 * Plan
 *
 * @author shuai
 * @date 2019/3/11
 */
public class Plan {

	private int id;
	private int year;
	private int month;
	private int day;
	private Date date;
	private String week;
	private String username;
	private String plan;
	private String finish;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	@Override
	public String toString() {
		return "Plan{" +
				"id=" + id +
				", year=" + year +
				", month=" + month +
				", day=" + day +
				", date=" + date +
				", week='" + week + '\'' +
				", username='" + username + '\'' +
				", plan='" + plan + '\'' +
				", finish='" + finish + '\'' +
				'}';
	}
}
