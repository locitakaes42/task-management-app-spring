package com.bni.taskmgtapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bni.taskmgtapp.util.JwtUtil;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthController {
    // This class will handle authentication and authorization
    // It will use JWT for token generation and validation
    // It will also handle user registration and login
    private final JwtUtil jwtService;
    public AuthController(JwtUtil jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/get-token/{username}")
    public String getToken(@PathVariable String username) {
        return jwtService.createToken(username);
    }

    @PostMapping("/validate-token")
    public String postMethodName(@RequestBody String token) {
        //TODO: process POST request
        try{
            return "token is valid" + jwtService.ValidateToken(token);
        }
        catch (Exception e){
            return "token is invalid";
        }   
      
    }

    
    
}