package com.miscproject.contactApp.Domain;

import java.io.Serializable;

public class User implements Serializable{

	private Integer userId;
	private String name;
	private String phoneNo;
	private String email;
	private String address;
	private String loginName;
	private String password;
	private Integer role;
	private Integer loginState;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getLoginState() {
		return loginState;
	}

	public void setLoginState(Integer loginState) {
		this.loginState = loginState;
	}

}
