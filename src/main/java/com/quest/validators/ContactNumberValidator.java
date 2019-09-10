package com.quest.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {

	@Override
	public void initialize(ContactNumberConstraint contactNumber) {

	}

	@Override
	public boolean isValid(String contactField, ConstraintValidatorContext context) {
		if (null != contactField) {
			if (!contactField.equals("")) {
				if (!(contactField.charAt(0) == '0' && contactField.charAt(1) == '8')) {
					return false;
				} 
			} else {
				return true;
			}
		} 
		return true;
	}

}
