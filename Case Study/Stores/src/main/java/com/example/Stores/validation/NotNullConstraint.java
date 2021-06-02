package com.example.Stores.validation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;  
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ValidatorClass.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullConstraint 
{
	String message() default "Cannot be Empty/Null";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
