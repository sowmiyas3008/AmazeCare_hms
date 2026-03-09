package com.hexaware.hms.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.entity.User;
import com.hexaware.hms.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

  
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id,
                           @RequestBody User user) {
        return userService.updateUser(id, user);
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }


    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }


    @PostMapping("/login")
    public User login(@RequestParam String email,
                      @RequestParam String password) {
        return userService.Login(email, password);
    }


    @PutMapping("/change-password/{userId}")
    public String changePassword(@PathVariable int userId,
                                 @RequestParam String oldPassword,
                                 @RequestParam String newPassword) {

        boolean result = userService.changePassword(userId, oldPassword, newPassword);

        if (result)
            return "Password changed successfully";
        else
            return "Old password incorrect";
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }


    @GetMapping
    public List<User> viewAllUsers() {
        return userService.viewAllUsers();
    }


    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        return userService.getUsersByRole(role);
    }

}
