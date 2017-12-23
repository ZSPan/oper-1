package com.oper.dao.impl;

import com.oper.dao.TokenDao;
import com.oper.entity.Token;
import com.oper.entity.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author yemingfeng
 */
@Repository
public class TokenDaoImpl extends AbsDaoImpl implements TokenDao {

  @Autowired
  public TokenDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @Override
  public void save(Token token) {
    getSession().persist(token);
  }

  @Override
  public Token getByToken(String token) {
    return (Token) getSession()
        .createQuery("FROM Token t WHERE t.token = :token")
        .setParameter("token", token)
        .uniqueResult();
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Token> listByUser(User user) {
    return getSession()
        .createQuery("FROM Token t WHERE t.user = :user")
        .setParameter("user", user)
        .list();
  }
}