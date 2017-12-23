package com.oper.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author yemingfeng
 */
@Slf4j
@Component
public class CoderHelper {

  public static String generateToken() {
    return UUID.randomUUID().toString();
  }

  public static String md5(String password) {
    try {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      byte[] bytes = md5.digest(password.getBytes());
      return toHexString(bytes);
    } catch (NoSuchAlgorithmException e) {
      log.error("", e);
      throw new RuntimeException(e);
    }
  }

  private static String toHexString(byte[] bytes) {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b : bytes) {
      int bt = b & 0xFF;
      if (bt < 16) {
        stringBuilder.append(0);
      }
      stringBuilder.append(Integer.toHexString(bt));
    }
    return stringBuilder.toString();
  }
}