package com.example.Authorization.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userdata")
public class User 
{
	private String fname;
	private String lname;
	private String emailId;
	private String mobile;
	private String password;
	private String role;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(String fname, String lname, String emailId, String mobile, String password, String role) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.emailId = emailId;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
