package com.shuai.controller;

import com.shuai.service.PlanService;
import com.shuai.vo.PlanVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/addPlan")
	public String addPlan() {
		return "addPlan";
	}

	@RequestMapping("/addPlanDo")
	public String addPlanDo(int year, int month, String username) {
		log.info("year->{}", year);
		log.info("month->{}", month);
		log.info("username->{}", username);
		List<PlanVO> list = planService.query(year, month, username);
		if (list == null || list.size() == 0) {
			boolean add = planService.add(year, month, username);
			System.out.println(add);
		}

		return "addPlan";
	}

	@RequestMapping("/list")
	public String list(ModelMap map,Integer year, Integer month,String username) {
		if(year == null || month == null){
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH);
		}
		List<PlanVO> list = planService.query(year, month + 1, username);
		map.put("list",list);
		map.put("username",username);
		if(list == null || list.size() == 0){
			map.put("type",0);
			map.put("message",username+",当前月没有您的记录");
		} else {
			map.put("type",1);
		}
		return "list";
	}
}
