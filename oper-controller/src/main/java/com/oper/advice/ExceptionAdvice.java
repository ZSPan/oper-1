package com.oper.advice;

import com.oper.bean.ApiResultBean;
import com.oper.constants.Constants;
import com.oper.exception.DeprecatedException;
import com.oper.exception.UnAuthorizedException;
import java.util.List;
import javax.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yemingfeng
 */
@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public ApiResultBean getApiResultBean(Exception e) {
    if (e instanceof DeprecatedException || e instanceof UnAuthorizedException
        || e instanceof IllegalArgumentException) {
      return ApiResultBean.failed(e.getMessage());
    }

    if (e instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException validException = (MethodArgumentNotValidException) e;
      BindingResult bindingResult = validException.getBindingResult();
      List<ObjectError> errors = bindingResult.getAllErrors();
      if (!CollectionUtils.isEmpty(errors)) {
        return ApiResultBean.failed(errors.get(0).getDefaultMessage());
      }
    }

    if (e instanceof ValidationException) {
      if (e.getCause() instanceof IllegalArgumentException) {
        return ApiResultBean.failed(e.getCause().getMessage());
      }
    }

    log.error("", e);
    return ApiResultBean.failed(Constants.Exception.UNKNOWN_EXCEPTION);
  }
}