package com.oper.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yemingfeng
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

  @RequestMapping("")
  @ResponseBody
  public String hello() {
    return "hello world!";
  }
}