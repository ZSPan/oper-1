package com.oper.exception;

/**
 * @author yemingfeng
 */
public class UnAuthorizedException extends RuntimeException {

  public UnAuthorizedException(String msg) {
    super(msg);
  }

}