package com.oper.entity;

import com.oper.constants.Constants;
import com.oper.validation.LengthRange;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author yemingfeng
 */
@Data
@Table(name = "user")
@Entity
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull(message = Constants.User.NICKNAME_EMPTY)
  @Column(unique = true)
  @LengthRange(minLength = 6, maxLength = 18, fieldName = "用户名")
  private String nickname;

  @NotNull(message = Constants.User.EMAIL_EMPTY)
  @Column(unique = true)
  private String email;

  @NotNull(message = Constants.User.PASSWORD_EMPTY)
  @LengthRange(minLength = 6, maxLength = 18, fieldName = "密码")
  private String password;

  private String lastLoginTime;
  private String lastLoginIp;

}