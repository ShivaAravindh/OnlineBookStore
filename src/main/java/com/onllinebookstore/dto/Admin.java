package com.onllinebookstore.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String adminName;
	private String adminPass;
	private String email;
	public Admin( int id, String name,String pass,String email){
		this.adminId=id;
		this.adminName=name;
		this.adminPass=pass;
		this.email=email;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return adminId;
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	public String getAdminPass() {
		return adminPass;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	
}
