package com.oper.bean;

import lombok.Data;

/**
 * @author yemingfeng
 */
@Data
public class ApiResultBean {

  private Boolean succeed;
  private String message;
  private Object data;

  public static ApiResultBean succeed(Object data) {
    ApiResultBean apiResultBean = new ApiResultBean();
    apiResultBean.setSucceed(true);
    apiResultBean.setData(data);
    return apiResultBean;
  }

  public static ApiResultBean failed(String message) {
    ApiResultBean apiResultBean = new ApiResultBean();
    apiResultBean.setSucceed(false);
    apiResultBean.setMessage(message);
    return apiResultBean;
  }
}