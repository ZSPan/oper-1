package com.oper.service;

import com.oper.entity.Token;
import com.oper.entity.User;

/**
 * @author yemingfeng
 */
public interface TokenService {

  void save(Token token);

  Token generateToken(User user);

}
