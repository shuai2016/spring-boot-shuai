package com.shuai.controller;

import com.shuai.dao.DepartmentDao;
import com.shuai.dao.EmployeeDao;
import com.shuai.entities.Department;
import com.shuai.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * EmployeeController
 *
 * @author shuai
 * @date 2018/11/29
 */
@Controller
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	DepartmentDao departmentDao;

	/**
	 * 查询所有员工返回列表页面
	 * @param modelMap
	 * @return
	 */
	@GetMapping("/emps")
	public String list(ModelMap modelMap){
		Collection<Employee> all = employeeDao.getAll();
		modelMap.put("emps",all);
		return "emp/list";
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@GetMapping("/emp")
	public String toAddPage(ModelMap modelMap){
		//查询所有部门
		Collection<Department> departments = departmentDao.getDepartments();
		modelMap.put("depts",departments);
		return "emp/add";
	}

	/**
	 * 员工添加
	 * @return
	 */
	@PostMapping("/emp")
	public String addEmp(Employee employee){

		//来到员工列表页面
		//redirect：表示重定向到一个地址
		//forward：表示转发到一个地址
		return "redirect:/emps";
	}
}
