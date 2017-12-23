package com.oper.dao;

import com.oper.entity.Token;
import com.oper.entity.User;
import java.util.List;

/**
 * @author yemingfeng
 */
public interface TokenDao {

  void save(Token token);

  Token getByToken(String token);

  List<Token> listByUser(User user);

}