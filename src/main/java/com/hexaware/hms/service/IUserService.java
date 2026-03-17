package com.hexaware.hms.service;
import java.util.*;

import com.hexaware.hms.dto.UserRequestDTO;
import com.hexaware.hms.dto.UserResponseDTO;
import com.hexaware.hms.entity.Role;
import com.hexaware.hms.entity.User;

public interface IUserService {
	public UserResponseDTO addUser(UserRequestDTO user);
	public UserResponseDTO updateUser(int id, UserRequestDTO user);
	
	public UserResponseDTO getUserById(int id);
	public UserResponseDTO getUserByEmail(String email);
	
	public UserResponseDTO Login(String email, String password);
	boolean changePassword(int userId,String oldp,String newp);
	
	public void deleteUser(int id);
	
	public List<UserResponseDTO> viewAllUsers();
	public List<UserResponseDTO> getUsersByRole(Role role);
	

}
