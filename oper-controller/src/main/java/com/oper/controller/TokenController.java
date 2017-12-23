package com.oper.controller;

import com.oper.entity.Token;
import com.oper.entity.User;
import com.oper.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yemingfeng
 */
@RestController
@RequestMapping("/token")
public class TokenController {

  @Autowired
  private UserService userService;

  @PostMapping(value = "")
  public Token login(@RequestBody @Valid User user) {
    return userService.login(user);
  }

}