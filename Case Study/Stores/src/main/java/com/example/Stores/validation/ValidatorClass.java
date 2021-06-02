package com.example.Stores.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorClass implements ConstraintValidator<NotNullConstraint, String> 
{

	public boolean isValid(String value, ConstraintValidatorContext context)
	{
		return value != ("") && value!=(" ") && value!=null;
	}
}