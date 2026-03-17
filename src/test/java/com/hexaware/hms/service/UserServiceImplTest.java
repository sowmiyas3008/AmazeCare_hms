package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.dto.UserRequestDTO;
import com.hexaware.hms.dto.UserResponseDTO;
import com.hexaware.hms.entity.Role;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private IUserService service;

    @Test
    void testAddUser() {

        UserRequestDTO user = new UserRequestDTO();

        user.setEmail("testuser@gmail.com");
        user.setPassword("12345");
        user.setRole(Role.ADMIN);

        UserResponseDTO result = service.addUser(user);

        assertNotNull(result);
    }

    @Test
    void testUpdateUser() {

        UserRequestDTO user = new UserRequestDTO();
        user.setRole(Role.DOCTOR);

        UserResponseDTO result = service.updateUser(1, user);

        assertEquals("DOCTOR", result.getRole());
    }

    @Test
    void testGetUserById() {

        UserResponseDTO user = service.getUserById(1);

        assertNotNull(user);
    }

    @Test
    void testGetUserByEmail() {

        UserResponseDTO user = service.getUserByEmail("testuser@gmail.com");

        assertNotNull(user);
    }

    @Test
    void testLogin() {

        UserResponseDTO user = service.Login("testuser@gmail.com", "12345");

        assertNotNull(user);
    }

    @Test
    void testChangePassword() {

        boolean result = service.changePassword(1, "12345", "newpassword");

        assertTrue(result);
    }

    @Test
    void testGetUsersByRole() {

        List<UserResponseDTO> users = service.getUsersByRole("DOCTOR");

        assertNotNull(users);
    }

}