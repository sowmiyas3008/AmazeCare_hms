package com.hexaware.hms.dto;

import com.hexaware.hms.entity.Role;

public class UserRequestDTO {
	private String email;
	private String password;
	private Role role;
	
	
	public UserRequestDTO() {}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
