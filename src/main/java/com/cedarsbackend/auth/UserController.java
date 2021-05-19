package com.cedarsbackend.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private MySQLUserDetailsService userService;

  @PostMapping("/register")
  public void register(@RequestBody UserLogin newUser) {
    userService.Save(newUser);
  }
}
