package com.oper.dao.impl;

import com.oper.dao.UserDao;
import com.oper.entity.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author yemingfeng
 */
@Repository
public class UserDaoImpl extends AbsDaoImpl implements UserDao {

  @Autowired
  public UserDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @Override
  public User save(User user) {
    getSession().persist(user);
    return user;
  }

  @Override
  public User getByEmail(String email) {
    return (User) getSession()
        .createQuery("FROM User user WHERE user.email = :email")
        .setParameter("email", email)
        .uniqueResult();
  }

  @Override
  public User getByNickname(String nickname) {
    return (User) getSession()
        .createQuery("FROM User user WHERE user.nickname = :nickname")
        .setParameter("nickname", nickname)
        .uniqueResult();
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<User> findAll() {
    return getSession().createQuery("FROM User user")
        .list();
  }
}