package com.api.requiredremainder.controller.impl;

import java.security.Principal;
import java.util.Base64;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.requiredremainder.controller.UserController;
import com.api.requiredremainder.model.User;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class UserControllerImpl implements UserController {

  @Override
  public boolean login(@RequestBody User user) {
      return
        user.getUsername().equals("admin") && user.getPassword().equals("password");
  }

  @Override
  public Principal user(HttpServletRequest request) {
      String authToken = request.getHeader("Authorization")
        .substring("Basic".length()).trim();
      return () ->  new String(Base64.getDecoder()
        .decode(authToken)).split(":")[0];
  }
}
