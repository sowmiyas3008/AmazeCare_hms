package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hexaware.hms.entity.Role;
import com.hexaware.hms.entity.User;

class UserServiceImplTest {

	static UserServiceImpl service;

	@BeforeAll
	static void setUpBeforeClass() {
		service = new UserServiceImpl();
	}

	@Test
	void testAddUser() {

		User user = new User();
		user.setEmail("testuser@gmail.com");
		user.setPassword("12345");
		user.setRole(Role.ADMIN);

		User result = service.addUser(user);

		assertNotNull(result);
	}

	@Test
	void testUpdateUser() {

		User user = service.getUserById(1);

		if (user != null) {
			user.setRole(Role.DOCTOR);
			User result = service.updateUser(1,user);
			assertEquals("DOCTOR",result.getRole());
		} else {
			fail("User not found");
		}
	}

	@Test
	void testGetUserById() {

		User user = service.getUserById(1);

		assertNotNull(user);
	}

	@Test
	void testGetUserByEmail() {

		User user = service.getUserByEmail("testuser@gmail.com");

		assertNotNull(user);
	}

	@Test
	void testLogin() {

		User user = service.Login("testuser@gmail.com", "12345");

		assertNotNull(user);
	}

	@Test
	void testChangePassword() {

		boolean result = service.changePassword(1, "newpassword","12345");

		assertTrue(result);
	}



	@Test
	void testGetUsersByRole() {

		List<User> users = service.getUsersByRole("DOCTOR");

		assertNotNull(users);
	}

}