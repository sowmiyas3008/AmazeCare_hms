package com.hexaware.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.hms.entity.User;

public interface IUserDAO extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    List<User> findByRole(String role);
}