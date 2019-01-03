package com.gs.service.impl;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.mapper.DepartmentMapper;
import com.gs.pojo.Department;
import com.gs.service.DepartmentService;
import com.gs.vo.DepartmentVo;
import com.gs.vo.DepartmentchartVo;

@Service
@WebService
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;

	// 必须单独用set注入接口，webservice才能调用方法
	@WebMethod(exclude = true)
	public void setDepartmentMapper(DepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}

	@WebMethod(exclude = true)
	@Override
	public void addDepartment(Department department) {
		departmentMapper.addDepartment(department);
	}

	@Override
	public List<Department> selectAll() {

		return departmentMapper.selectAll();
	}

	@Override
	public void updateDepartment(Department department) {
		departmentMapper.updateDepartment(department);
	}

	@Override
	public Department getDepartment(String id) {

		return departmentMapper.getDepartment(id);
	}

	@Override
	public void delDepartmentById(String id) {
		departmentMapper.delDepartmentById(id);
	}

	@Override
	public List<DepartmentVo> getAllEmployeeInDepartment() {
		return departmentMapper.getAllEmployeeInDepartment();
	}

	@Override
	public List<DepartmentchartVo> getSumForDepartment() {

		return departmentMapper.getSumForDepartment();
	}

}
