package com.helloworld.quickstart.controller;

import com.helloworld.quickstart.controller.validator.DifferentIdAndNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DifferentIdAndNameValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DifferentIdAndName {
    String message() default "id and name must be different";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
