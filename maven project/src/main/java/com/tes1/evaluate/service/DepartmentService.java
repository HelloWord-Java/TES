package com.tes1.evaluate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tes1.evaluate.domain.Classinfo;
import com.tes1.evaluate.domain.Department;
import com.tes1.evaluate.mapper.DepartmentMapper;

@Service
public class DepartmentService {
	// TODO Auto-generated constructor stub
	@Autowired
	private DepartmentMapper  departmentmapper;
	//查找所有院系

	public List<Department> finddepartmentlist(){return departmentmapper.finddepartmentlist();}

	public List<Department> findalldepartment(Department department) {
		return departmentmapper.findalldepartment(department);
	}
	//增加
	public boolean addDepartment(Department department) {
		return departmentmapper.addDepartment(department);
	}
	
	//获取所有数据总条数
	public int getDepartmentListTotal(String filter) {
		return departmentmapper.getDepartmentListTotal(filter);
	}
	//获取所有数据行数和页数
	public List<Department> getDepartmentList(int page, int rows, String filter) {
		return departmentmapper.getDepartmentList(page,rows,filter);
	}
	public List<Department> findDepartment(Department department) {
		return departmentmapper.findDepartment(department);
	}
	//根据id获取院系
		public List<Department> findDepartmentById(Integer Id) {
			return departmentmapper.findDepartmentById(Id);
		}
	//修改院系
	public boolean updateDepartment(Department department) {
		return departmentmapper.updateDepartment(department);
	}
	//删除
	public int deleteDepartmentById(List<Integer> list) {
		return departmentmapper.deleteDepartmentById(list);
	}
	
}

