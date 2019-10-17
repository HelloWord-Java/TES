package com.tes1.evaluate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tes1.evaluate.domain.Department;


public interface DepartmentMapper {
    List<Department> finddepartmentlist();
	List<Department> findalldepartment(Department department);

	boolean addDepartment(Department department);

	Department findallDepartmentById(Integer id);

	
	
	
	int getDepartmentListTotal(String filter);
	List<Department> getDepartmentList(@Param("page")int page, @Param("rows")int rows, @Param("filter")String filter);
	List<Department> findDepartmentById(Integer id);
	boolean updateDepartment(Department department);
	List<Department> findDepartment(Department department);
	int deleteDepartmentById(List<Integer> list);
}