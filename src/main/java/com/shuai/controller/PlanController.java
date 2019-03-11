package com.shuai.controller;

import com.shuai.service.PlanService;
import com.shuai.vo.PlanVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	Logger log = LoggerFactory.getLogger(PlanController.class);

	@Autowired
	private PlanService planService;

	@RequestMapping("/addPlan")
	public String addPlan() {
		return "addPlan";
	}

	@RequestMapping("/addPlanDo")
	public String addPlanDo(int year, int month, String username) {
		List<PlanVO> query = planService.query();
		System.out.println(query);
		log.info("year->{}",year);
		log.info("month->{}",month);
		log.info("username->{}",username);
		return "addPlan";
	}
}
