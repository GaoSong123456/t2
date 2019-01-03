package com.gs.vo;

public class DepartmentchartVo {
	private String id;
	private String name;
	private String did;
	private Integer sum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public DepartmentchartVo(String id, String name, String did, Integer sum) {
		super();
		this.id = id;
		this.name = name;
		this.did = did;
		this.sum = sum;
	}

	public DepartmentchartVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
