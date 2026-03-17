package com.hexaware.hms.dao;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.hms.entity.Role;
import com.hexaware.hms.entity.User;

public interface IUserDAO extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    List<User> findByRole(Role role);  // ← FIXED: String → Role
}