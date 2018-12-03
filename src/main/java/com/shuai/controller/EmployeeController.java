package com.shuai.controller;

import com.shuai.dao.DepartmentDao;
import com.shuai.dao.EmployeeDao;
import com.shuai.entities.Department;
import com.shuai.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * EmployeeController
 *
 * @author shuai
 * @date 2018/11/29
 */
@Controller
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	DepartmentDao departmentDao;

	/**
	 * 查询所有员工返回列表页面
	 *
	 * @param modelMap
	 * @return
	 */
	@GetMapping("/emps")
	public String list(ModelMap modelMap) {
		Collection<Employee> all = employeeDao.getAll();
		modelMap.put("emps", all);
		return "emp/list";
	}

	/**
	 * 跳转到添加页面
	 *
	 * @return
	 */
	@GetMapping("/emp")
	public String toAddPage(ModelMap modelMap) {
		//查询所有部门
		Collection<Department> departments = departmentDao.getDepartments();
		modelMap.put("depts", departments);
		return "emp/add";
	}

	/**
	 * 员工添加
	 *
	 * @return
	 */
	@PostMapping("/emp")
	public String addEmp(Employee employee) {
		logger.info("添加员工");
		logger.debug("员工信息：{}", employee);
		employeeDao.save(employee);
		//来到员工列表页面
		//redirect：表示重定向到一个地址
		//forward：表示转发到一个地址
		return "redirect:/emps";
	}

	/**
	 * 查出当前员工，跳转到修改页面，回显
	 *
	 * @return
	 */
	@GetMapping("/emp/{id}")
	public String toEditPage(ModelMap modelMap, @PathVariable("id") Integer id) {
		logger.info("修改员工跳转");
		Employee employee = employeeDao.get(id);
		logger.debug("当前员工：{}", employee);
		//查询所有部门
		Collection<Department> departments = departmentDao.getDepartments();
		modelMap.put("depts", departments);
		modelMap.put("emp", employee);
		//回到修改页面（add是一个修改添加二合一的页面）
		return "emp/add";
	}

	/**
	 * 员工修改
	 *
	 * @param employee
	 * @return
	 */
	@PutMapping("/emp")
	public String updateEmployee(Employee employee) {
		logger.info("员工修改");
		logger.debug("修改后员工信息：{}", employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}

	/**
	 * 员工删除
	 *
	 * @return
	 */
	@DeleteMapping("/emp/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		logger.info("员工删除");
		logger.debug("员工id={}", id);
		employeeDao.delete(id);
		return "redirect:/emps";
	}
}
