package com.oper.dao;


import com.oper.entity.User;
import java.util.List;

/**
 * @author yemingfeng
 */
public interface UserDao {

  User save(User user);

  User getByEmail(String email);

  User getByNickname(String nickname);

  List<User> findAll();

}