package com.api.requiredremainder.controller;

import java.security.Principal;
import java.util.Base64;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.requiredremainder.model.User;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public interface UserController {

    @PostMapping("/login")
    public boolean login(@RequestBody User user);
	
    @GetMapping("/user")
    public Principal user(HttpServletRequest request);
}
