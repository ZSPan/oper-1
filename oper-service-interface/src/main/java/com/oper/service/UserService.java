package com.oper.service;

import com.oper.entity.Token;
import com.oper.entity.User;
import java.util.List;

/**
 * @author yemingfeng
 */
public interface UserService {

  User register(User user);

  Token login(User user);

  List<User> findAll();

}