package com.gs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gs.pojo.Department;
import com.gs.pojo.Employee;
import com.gs.service.DepartmentService;
import com.gs.vo.DepartmentVo;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private Department department = new Department();

	@RequestMapping(value = "/Department/toAdd")
	public String toAdd() {
		return "/department/addDepartment";
	}

	@RequestMapping(value = "/Department/add", method = RequestMethod.POST)
	public String add(Department department) {
		department.setId(UUID.randomUUID().toString());
		departmentService.addDepartment(department);
		return "redirect:/Department/getList.action";
	}

	@RequestMapping(value = "/Department/getList")
	public String getList(Model model) {
		List<Department> list = departmentService.selectAll();
		model.addAttribute("list", list);
		return "/department/list";
	}

	@RequestMapping(value = "/Department/toUpdate")
	public String toUpdate(String id, Model model) {
		department = departmentService.getDepartment(id);
		model.addAttribute("department", department);
		return "/department/updateDepartment";

	}

	@RequestMapping(value = "/Department/update")
	public String update(Department department) {
		departmentService.updateDepartment(department);
		return "redirect:/Department/getList.action";
	}

	@RequestMapping(value = "/Department/deleteById", method = RequestMethod.GET)
	public String deleteById(String id) {
		departmentService.delDepartmentById(id);
		return "redirect:/Department/getList.action";
	}

	/*
	 * @RequestMapping(value = "/Department/toUpdate") public String
	 * deleteByIds(String ids[]) { for (int i = 0; i < Ids.length; i++) {
	 * departmentService.delDepartment(ids[i]); }
	 * 
	 * return "redirect:/Department/getList.action"; }
	 */

	@RequestMapping(value = "/Department/getAllEmployeeInDepartment")
	public String getAllEmployeeInDepartment(Model model) {
		List<DepartmentVo> list = departmentService
				.getAllEmployeeInDepartment();
		model.addAttribute("list", list);
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			employees.addAll(list.get(i).getList());
		}
		model.addAttribute("elist", employees);
		return "/department/getAllEmployeeInDepartment";
	}
}
