package com.quest.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = BirthDateValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface BirthDateConstraint {
	String message() default "Age cannot be below";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
