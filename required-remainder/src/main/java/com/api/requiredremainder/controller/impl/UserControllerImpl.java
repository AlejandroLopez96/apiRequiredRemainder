package com.api.requiredremainder.controller.impl;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.requiredremainder.controller.UserController;
import com.api.requiredremainder.model.User;

@RestController
public class UserControllerImpl implements UserController {

  @Override
  public boolean login(@RequestBody User user) {
      return
        user.getUsername().equals("admin") && user.getPassword().equals("password");
  }
}
