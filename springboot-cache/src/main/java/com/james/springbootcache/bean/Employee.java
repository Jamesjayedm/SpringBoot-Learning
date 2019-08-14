package com.james.springbootcache.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class Employee implements Serializable {

	@JSONField(ordinal = 1)
	private Integer id;
	@JSONField(ordinal = 2)
	private String lastName;
	@JSONField(ordinal = 3)
	private String email;
	@JSONField(ordinal = 4)
	private Integer gender;
	@JSONField(ordinal = 5)//性别 1男  0女
	private Integer dId;
	
	
	public Employee() {
		super();
	}

	
	public Employee(Integer id, String lastName, String email, Integer gender, Integer dId) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.dId = dId;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", dId="
				+ dId + "]";
	}
	
	

}
