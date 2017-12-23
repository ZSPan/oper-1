package com.oper.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

/**
 * @author yemingfeng
 */
@Component
public class LengthRangeValidator implements ConstraintValidator<LengthRange, String> {

  private LengthRange lengthRange;

  @Override
  public void initialize(LengthRange lengthRange) {
    this.lengthRange = lengthRange;
  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    int length = s.length();
    if (length < lengthRange.minLength()) {
      throw new IllegalArgumentException(lengthRange.fieldName() + lengthRange.length()
          + lengthRange.lessThan() + lengthRange.minLength());
    }
    if (length > lengthRange.maxLength()) {
      throw new IllegalArgumentException(lengthRange.fieldName() + lengthRange.length()
          + lengthRange.greaterThan() + lengthRange.maxLength());
    }
    return true;
  }
}