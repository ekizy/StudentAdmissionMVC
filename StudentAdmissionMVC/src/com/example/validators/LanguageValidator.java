package com.example.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LanguageValidator implements ConstraintValidator<IsValidLanguage,String> {

	private String languageList;
	@Override
	public void initialize(IsValidLanguage isValidLanguage){
			this.setLanguageList(isValidLanguage.languageList());
	}

	@Override
	public boolean isValid(String instructionLanguage, ConstraintValidatorContext cont) {
		if(instructionLanguage==null) return false;

		if (instructionLanguage.matches(getLanguageList())) return true;

		else return false;
	}

	public String getLanguageList() {
		return languageList;
	}

	public void setLanguageList(String languageList) {
		this.languageList = languageList;
	}



}
