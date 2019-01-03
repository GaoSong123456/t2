package com.gs.vo;

import java.util.List;

import com.gs.pojo.Employee;

public class DepartmentVo {
	private String Id;
	private String name;
	private List<Employee> list;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

	public DepartmentVo(String id, String name, List<Employee> list) {
		super();
		Id = id;
		this.name = name;
		this.list = list;
	}

	public DepartmentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
