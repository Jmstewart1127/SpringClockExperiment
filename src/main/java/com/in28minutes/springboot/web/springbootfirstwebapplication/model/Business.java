package com.in28minutes.springboot.web.springbootfirstwebapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Business {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    @Column(name = "biz_name")
	private String bizName;
    @Column(name = "admin_name")
	private String adminName;
    @Column(name = "password")
	private String password;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBizName() {
		return bizName;
	}
	public void setBizName(String bizName) {
		this.bizName = bizName;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    
}
