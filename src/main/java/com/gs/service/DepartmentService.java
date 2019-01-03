package com.gs.service;

import java.util.List;

import com.gs.pojo.Department;
import com.gs.vo.DepartmentVo;
import com.gs.vo.DepartmentchartVo;

public interface DepartmentService {
	public void addDepartment(Department department);

	public List<Department> selectAll();

	public Department getDepartment(String id);

	public void updateDepartment(Department department);

	public void delDepartmentById(String id);

	public List<DepartmentVo> getAllEmployeeInDepartment();

	public List<DepartmentchartVo> getSumForDepartment();
}
