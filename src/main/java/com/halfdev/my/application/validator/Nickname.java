package com.halfdev.my.application.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NicknameValidator.class)
public @interface Nickname {

    String message() default "{com.halfdev.my.validate.nickname.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
