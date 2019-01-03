package com.gs.pojo;

import java.util.Date;

public class Employee {
	private String id;
	private String Name;
	private String Gender;
	private Date Birthday;
	private String Address;
	private String Did;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDid() {
		return Did;
	}

	public void setDid(String did) {
		Did = did;
	}

	public Employee(String id, String name, String gender, Date birthday,
			String address, String did) {
		super();
		id = id;
		Name = name;
		Gender = gender;
		Birthday = birthday;
		Address = address;
		Did = did;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
