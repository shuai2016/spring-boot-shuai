package com.shuai.vo;

import java.util.Date;

/**
 * PlanVO
 *
 * @author shuai
 * @date 2019/3/11
 */
public class PlanVO {
	private int id;
	private Date date;
	private String week;
	private String username;
	private String plan;
	private String finish;

	public PlanVO(int id, Date date, String week, String username, String plan, String finish) {
		this.id = id;
		this.date = date;
		this.week = week;
		this.username = username;
		this.plan = plan;
		this.finish = finish;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "PlanVO{" +
				"id=" + id +
				", date=" + date +
				", week='" + week + '\'' +
				", username='" + username + '\'' +
				", plan='" + plan + '\'' +
				", finish='" + finish + '\'' +
				'}';
	}
}
