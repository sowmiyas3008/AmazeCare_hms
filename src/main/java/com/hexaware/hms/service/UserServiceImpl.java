package com.hexaware.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IUserDAO;
import com.hexaware.hms.dto.UserRequestDTO;
import com.hexaware.hms.dto.UserResponseDTO;
import com.hexaware.hms.entity.Role;
import com.hexaware.hms.entity.User;
import com.hexaware.hms.exception.UserNotFoundException;
import com.hexaware.hms.service.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private UserResponseDTO convertToDTO(User user) {
    	UserResponseDTO dto = new UserResponseDTO();
    	dto.setUserId(user.getUserId());
    	dto.setEmail(user.getEmail());
    	dto.setRole(user.getRole());
    	
    	return dto;
    }

    @Override
    public UserResponseDTO addUser(UserRequestDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
//        user.setPassword(dto.getPassword());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        User saved = userDAO.save(user);

        return convertToDTO(saved);
    }

    @Override
    public UserResponseDTO updateUser(int id, UserRequestDTO dto) {

        Optional<User> existing = userDAO.findById(id);

        if (existing.isPresent()) {

            User u = existing.get();
            u.setEmail(dto.getEmail());
            u.setRole(dto.getRole());

            User updated = userDAO.save(u);

            return convertToDTO(updated);
        }

        return null;
    }

    @Override
    public UserResponseDTO getUserById(int id) {

    	User user = userDAO.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));

        
    	UserResponseDTO dto = convertToDTO(user);
    	return dto;
        

    }

    @Override
    public UserResponseDTO getUserByEmail(String email) {

        User user = userDAO.findByEmail(email).orElseThrow(() -> new UserNotFoundException("email not found"));

        if (user != null) {
            return convertToDTO(user);
        }

        return null;
    }

    @Override
    public UserResponseDTO Login(String email, String password) {

        User user = userDAO.findByEmail(email).orElseThrow(() -> new UserNotFoundException("user not found"));

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return convertToDTO(user);
        }

        return null;
    }

    @Override
    public boolean changePassword(int userId, String oldp, String newp) {

        Optional<User> existing = userDAO.findById(userId);

        if (existing.isPresent()) {

            User user = existing.get();

            if (passwordEncoder.matches(oldp, user.getPassword())) {
                user.setPassword(passwordEncoder.encode(newp));
                userDAO.save(user);
                return true;
            }
        }

        return false;
    }

    @Override
    public void deleteUser(int id) {

        userDAO.deleteById(id);
    }

    @Override
    public List<UserResponseDTO> viewAllUsers() {

        List<User> users = userDAO.findAll();
        List<UserResponseDTO> list = new ArrayList<>();

        for (User u : users) {
            list.add(convertToDTO(u));
        }

        return list;
    }

    @Override
    public List<UserResponseDTO> getUsersByRole(Role role) {
        List<User> users = userDAO.findByRole(role);
        List<UserResponseDTO> list = new ArrayList<>();

        for (User u : users) {
            list.add(convertToDTO(u));
        }

        return list;
    }


    
}