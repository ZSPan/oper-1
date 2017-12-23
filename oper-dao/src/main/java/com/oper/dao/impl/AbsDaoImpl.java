package com.oper.dao.impl;

import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author yemingfeng
 */
@Slf4j
@Transactional
@AllArgsConstructor
public class AbsDaoImpl {

  private SessionFactory sessionFactory;

  Session getSession() {
    Session session = null;
    try {
      session = sessionFactory.getCurrentSession();
    } catch (Exception e) {
      log.error("", e);
    }
    if (session == null) {
      session = sessionFactory.openSession();
    }
    return session;
  }
}