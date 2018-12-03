package com.shuai.mapper;

import com.shuai.bean.Employee;

/**
 * EmployeeMapper
 *
 * @author shuai
 * @date 2018/12/3
 */
public interface EmployeeMapper {
	Employee getEmpById(Integer id);

	void insertEmp(Employee employee);
}
