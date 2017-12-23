package com.oper.service.impl;

import com.oper.dao.TokenDao;
import com.oper.entity.Token;
import com.oper.entity.User;
import com.oper.helper.CoderHelper;
import com.oper.service.TokenService;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yemingfeng
 */
@Service
public class TokenServiceImpl implements TokenService {

  @Autowired
  private TokenDao tokenDao;

  @Override
  public void save(Token token) {
    tokenDao.save(token);
  }

  @Override
  public Token generateToken(User user) {
    Token token = new Token();
    token.setCreation(new Date());
    token.setExpire(DateUtils.addDays(new Date(), 7));
    token.setToken(CoderHelper.generateToken());
    token.setUser(user);
    return token;
  }
}
