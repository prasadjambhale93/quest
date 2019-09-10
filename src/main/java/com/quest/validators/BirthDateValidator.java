package com.quest.validators;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BirthDateValidator implements ConstraintValidator<BirthDateConstraint, Date>{

	@Override
	public void initialize(BirthDateConstraint birthDate) {
		
	}
	
	@Override
	public boolean isValid(Date dob, ConstraintValidatorContext context) {
		
		if(null!=dob) {
			Calendar today = Calendar.getInstance();
		    Calendar birthDate = Calendar.getInstance();
		    int age = 0;
		    birthDate.setTime(dob);
		    age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
			return age > 16;
		} else {
			return false;
		}
		
	}

}
