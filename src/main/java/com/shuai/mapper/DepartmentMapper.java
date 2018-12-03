package com.shuai.mapper;

import com.shuai.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * DepartmentMapper
 *
 * @author shuai
 * @date 2018/12/3
 */
//@Mapper  //这是一个操作数据库的mapper
public interface DepartmentMapper {

	@Select("select * from department where id=#{id}")
	Department getDeptById(Integer id);

	@Delete("delete from department where id=#{id}")
	int deleteDeptById(Integer id);

	@Options(useGeneratedKeys = true,keyProperty = "id")
	@Insert("insert into department(department_name) values(#{departmentName})")
	int insertDept(Department department);

	@Update("update department set department_name=#{departmentName} where id=#{id}")
	int updateDept(Department department);
}
