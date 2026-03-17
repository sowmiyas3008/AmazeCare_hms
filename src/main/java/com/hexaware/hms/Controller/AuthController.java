package com.hexaware.hms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.dto.AuthRequest;
import com.hexaware.hms.exception.UserNotFoundException;
import com.hexaware.hms.security.JwtService;

@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request){

        org.springframework.security.core.Authentication authentication =
        authenticationManager.authenticate(

        new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()));

        if(authentication.isAuthenticated()){

            String token = jwtService.generateToken(request.getEmail());

            return "Login successful " + token;
        }

        throw new UserNotFoundException("Invalid login");
    }
}