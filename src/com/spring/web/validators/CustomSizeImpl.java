/**
 * 
 */
package com.spring.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * @author triptibishnoi
 *
 */
public class CustomSizeImpl implements ConstraintValidator<CustomSize, String>{
	
	private int min;
	private int max;
	
	@Override
	public void initialize(CustomSize constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
	}
	
	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		if(userName.length() >= min && userName.length() <= max)// && EmailValidator.getInstance(false).isValid(userName))
			return true;
		else
			return false;
	}

}
