package com.hexaware.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IUserDAO;
import com.hexaware.hms.dto.UserRequestDTO;
import com.hexaware.hms.dto.UserResponseDTO;
import com.hexaware.hms.entity.User;
import com.hexaware.hms.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;
    
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
        user.setPassword(dto.getPassword());
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

        Optional<User> user = userDAO.findById(id);

        if (user.isPresent()) {
            return convertToDTO(user.get());
        }

        return null;
    }

    @Override
    public UserResponseDTO getUserByEmail(String email) {

        User user = userDAO.findByEmail(email);

        if (user != null) {
            return convertToDTO(user);
        }

        return null;
    }

    @Override
    public UserResponseDTO login(String email, String password) {

        User user = userDAO.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return convertToDTO(user);
        }

        return null;
    }

    @Override
    public boolean changePassword(int userId, String oldp, String newp) {

        Optional<User> existing = userDAO.findById(userId);

        if (existing.isPresent()) {

            User user = existing.get();

            if (user.getPassword().equals(oldp)) {

                user.setPassword(newp);
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
    public List<UserResponseDTO> getUsersByRole(String role) {

        List<User> users = userDAO.findByRole(role);
        List<UserResponseDTO> list = new ArrayList<>();

        for (User u : users) {
            list.add(convertToDTO(u));
        }

        return list;
    }
    
}