package com.oper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

/**
 * @author yemingfeng
 */
@Configuration
public class HibernateConfig {

  @Bean
  public HibernateJpaSessionFactoryBean getSessionFactory() {
    return new HibernateJpaSessionFactoryBean();
  }

}