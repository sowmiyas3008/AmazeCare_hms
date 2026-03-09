package com.hexaware.hms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="users")
public class User {

	
	@Id                                               //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //for auto_increment
	@Column(name="user_id")
    private int userId;
	
	
	@Column(name="email")
    private String email;
	
	@Column(name="password")
    private String password;
	
	@Column(name="role")
    private Role role;
	

    // Default constructor
    public User() {}

    // Parameterized constructor
    public User(int userId, String email, String password, Role role) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getter & Setter methods

    public void setUserId(int userId) { 
        this.userId = userId; 
    }

    public int getUserId() { 
        return userId; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getEmail() { 
        return email; 
    }

    public void setPassword(String password) { 
        this.password = password; 
    }

    public String getPassword() { 
        return password; 
    }

    public void setRole(Role role) { 
        this.role = role; 
    }

    public Role getRole() { 
        return role; 
    }

}