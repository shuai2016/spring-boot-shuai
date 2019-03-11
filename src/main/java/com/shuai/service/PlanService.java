package com.shuai.service;

import com.shuai.vo.PlanVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PlanService
 *
 * @author shuai
 * @date 2019/3/11
 */
@Service
public class PlanService {
	Logger log = LoggerFactory.getLogger(PlanService.class);
	public static final String url = "jdbc:mysql:///test";
	public static final String user = "root";
	public static final String password = "root";

	public Connection getConnection(String url, String user, String password) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	public List<PlanVO> query() {
		List<PlanVO> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection(url, user, password);
			String sql = "select id,date,week,username,plan,finish from plan";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				Date date = resultSet.getDate(2);
				String week = resultSet.getString(3);
				String username = resultSet.getString(4);
				String plan = resultSet.getString(5);
				String finish = resultSet.getString(6);
				list.add(new PlanVO(id, date, week, username, plan, finish));
			}
		} catch (Exception e) {

		} finally {
			try{
				preparedStatement.close();
				connection.close();
			} catch (Exception e){}
		}
		return list;
	}

	public List<PlanVO> add(int year,int month,String username) {



		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection(url, user, password);
			connection.setAutoCommit(false);
			String sql = "INSERT INTO `plan`(year,month,day,date,week,username) VALUES (?,?,?,?,?);";
			preparedStatement = connection.prepareStatement(sql);

		} catch (Exception e) {

		} finally {
			try{
				preparedStatement.close();
				connection.close();
			} catch (Exception e){}
		}
		return null;
	}

}
