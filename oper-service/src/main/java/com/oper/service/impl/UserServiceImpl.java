package com.oper.service.impl;

import com.oper.constants.Constants;
import com.oper.dao.UserDao;
import com.oper.entity.Token;
import com.oper.entity.User;
import com.oper.exception.DeprecatedException;
import com.oper.exception.UnAuthorizedException;
import com.oper.helper.CoderHelper;
import com.oper.service.TokenService;
import com.oper.service.UserService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yemingfeng
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private TokenService tokenService;

  @Override
  public User register(User user) {
    if (userDao.getByEmail(user.getEmail()) != null) {
      throw new DeprecatedException(Constants.User.EMAIL_EXIST);
    }
    if (userDao.getByNickname(user.getNickname()) != null) {
      throw new DeprecatedException(Constants.User.NICKNAME_EXIST);
    }
    return userDao.save(user);
  }

  @Override
  public Token login(User user) {
    User dbUser = userDao.getByEmail(user.getEmail());
    if (dbUser == null) {
      throw new UnAuthorizedException(Constants.User.EMAIL_NOT_EXIST);
    } else if (!StringUtils.equals(CoderHelper.md5(user.getPassword()), dbUser.getPassword())) {
      throw new UnAuthorizedException(Constants.User.PASSWORD_INVALID);
    }

    Token token = tokenService.generateToken(user);
    tokenService.save(token);
    return token;
  }

  @Override
  public List<User> findAll() {
    return userDao.findAll();
  }
}