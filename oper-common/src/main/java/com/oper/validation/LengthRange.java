package com.oper.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author yemingfeng
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = LengthRangeValidator.class)
public @interface LengthRange {

  String message() default "";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  int minLength() default 0;

  int maxLength() default Integer.MAX_VALUE;

  String lessThan() default "小于";

  String greaterThan() default "大于";

  String fieldName();

  String length() default "长度";

}