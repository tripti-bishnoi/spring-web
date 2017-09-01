package com.spring.web.validators;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {com.spring.web.validators.CustomSizeImpl.class })
public @interface CustomSize {

	String message() default "User Name doesn't appear to be valid.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	int min() default 5;
	
	int max() default 50;
}
