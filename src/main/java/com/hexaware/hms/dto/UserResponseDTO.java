package com.hexaware.hms.dto;

import com.hexaware.hms.entity.Role;

public class UserResponseDTO {
	private int userId;
	private String email;
	private Role role;
	
	public UserResponseDTO() {}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
    
}
