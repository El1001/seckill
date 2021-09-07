package com.example.seckill.validator;

import com.example.seckill.util.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号验证器
 *
 * @author admin
 * @date 2021年 09月07日 14:29:20
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {
    private boolean required = false;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       if(required) {
           return ValidatorUtil.isMobile(s);
       } else {
           if(StringUtils.isEmpty(s)){
               return true;
           } else {
               return ValidatorUtil.isMobile(s);
           }
       }
    }

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }
}
