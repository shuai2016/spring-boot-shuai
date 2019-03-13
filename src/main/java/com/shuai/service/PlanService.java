package com.shuai.service;

import com.shuai.utils.DateUtils;
import com.shuai.vo.PlanVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * PlanService
 *
 * @author shuai
 * @date 2019/3/11
 */
@Service
public class PlanService {
	private final Logger log = LoggerFactory.getLogger(PlanService.class);
	private static final String url = "jdbc:mysql:///test?characterEncoding=utf-8";
	private static final String user = "root";
	private static final String password = "root";

	private Connection getConnection(String url, String user, String password) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	public List<PlanVO> query(Integer year, Integer month, String username0) {
		List<PlanVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection(url, user, password);
			StringBuffer buffer = new StringBuffer("select id,date,week,username,plan,finish from plan where 0 = 0 ");
			ArrayList<String> arrayList = new ArrayList();
			if(year != null){
				buffer.append(" and year = ?");
				arrayList.add("int-"+year);
			}
			if(month != null){
				buffer.append(" and month = ?");
				arrayList.add("int-"+month);
			}
			if(username0 != null){
				buffer.append(" and username = ?");
				arrayList.add("string-"+username0);
			}
			String sql = buffer.toString();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i<arrayList.size();i++) {
				String s = arrayList.get(i);
				String[] split = s.split("-");
				if("int".equals(split[0])){
					ps.setInt(i+1,Integer.parseInt(split[1]));
				} else if("string".equals(split[0])){
					ps.setString(i+1,split[1]);
				}
			}
			ResultSet resultSet = ps.executeQuery();
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
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

	public boolean add(int year, int month, String username) {
		boolean flag = false;

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, 0);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);


		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection(url, user, password);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO `plan`(year,month,day,date,week,username) VALUES (?,?,?,?,?,?);";
			ps = conn.prepareStatement(sql);

			for (int i = 1; i <= dayOfMonth; i++) {
				ps.setInt(1, year);
				ps.setInt(2, month);
				ps.setInt(3, i);
				Calendar c = Calendar.getInstance();
				c.set(year, month - 1, i);
				ps.setDate(4,new Date(c.getTimeInMillis()));
				ps.setString(5, DateUtils.getWeek(c.get(Calendar.DAY_OF_WEEK)));
				ps.setString(6, username);
				ps.addBatch();
			}
			ps.executeBatch();
			conn.commit();
			ps.clearBatch();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return flag;
	}
	public boolean update(int id,String plan,String finish) {
		boolean flag = false;

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection(url, user, password);
			String sql = "UPDATE plan SET plan=?,finish=? WHERE id=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1,plan);
			ps.setString(2,finish);
			ps.setInt(3,id);

			boolean execute = ps.execute();
			System.out.println(execute);

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return flag;
	}
}
