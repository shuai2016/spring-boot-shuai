package com.shuai.controller;

import com.shuai.service.PlanService;
import com.shuai.vo.PlanVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * PlanController
 *
 * @author shuai
 * @date 2019/3/11
 */
@Controller
@RequestMapping("/plan")
public class PlanController {

	private final Logger log = LoggerFactory.getLogger(PlanController.class);
	@Autowired
	private PlanService planService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(HttpSession session, String username) {
		session.setAttribute("username", username);
		return "forward:/plan/list";
	}

	@RequestMapping("/addPlan")
	public String addPlan(ModelMap map, Integer year, Integer month, String username) {
		map.put("year", year);
		map.put("month", month);
		map.put("username", username);
		return "addPlan";
	}

	@RequestMapping("/addPlanDo")
	public String addPlanDo(ModelMap map, Integer year, Integer month, String username) {
		log.info("year->{}", year);
		log.info("month->{}", month);
		log.info("username->{}", username);
		boolean flag = true;
		if (year == null || month == null || username == null || "".equals(username)) {
			map.put("message", "生成失败，参数错误");
			map.put("type", 1);
			flag = false;
		}
		if (flag) {
			List<PlanVO> list = planService.query(year, month, username);
			if (list == null || list.size() == 0) {
				boolean add = planService.add(year, month, username);
				System.out.println(add);
				map.put("type", 0);
			} else {
				map.put("message", "生成失败，已存在记录");
				map.put("type", 1);
			}
		}
		map.put("year", year);
		map.put("month", month);
		map.put("username", username);
		return "addPlan";
	}

	@RequestMapping("/list")
	public String list(ModelMap map, Integer year, Integer month, String username) {
		if (year == null || month == null) {
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH) + 1;
		}
		List<PlanVO> list = planService.query(year, month, username);
		map.put("list", list);
		map.put("username", username);
		map.put("year", year);
		map.put("month", month);
		if (list == null || list.size() == 0) {
			map.put("type", 0);
			map.put("message", "当前月没有您的记录");
		} else {
			map.put("type", 1);
		}
		return "list";
	}

	@ResponseBody
	@RequestMapping("/update")
	public int update(int id, String plan, String finish) {

		int type = 1;

		boolean b = planService.update(id, plan, finish);
		if (b) {
			type = 0;
		}

		return type;
	}
}
