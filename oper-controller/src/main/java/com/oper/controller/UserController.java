package com.oper.controller;

import com.oper.entity.User;
import com.oper.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yemingfeng
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "")
  public List<User> findAll() {
    return userService.findAll();
  }

  @PostMapping(value = "")
  public User register(@RequestBody @Valid User user) {
    return userService.register(user);
  }

}