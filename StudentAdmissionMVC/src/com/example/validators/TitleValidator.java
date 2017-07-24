package com.example.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TitleValidator implements ConstraintValidator<IsValidTitle,String> {


	private String titleList;

	@Override
	public void initialize(IsValidTitle isValidTitle){
			this.setTitleList(isValidTitle.titleList());
	}


	@Override
	public boolean isValid(String instructorTitle,ConstraintValidatorContext cont) {

		if(instructorTitle==null) return false;

		if (instructorTitle.matches(getTitleList())) return true;

		else return false;
	}


	private String getTitleList() {
		return titleList;
	}


	private void setTitleList(String titleList) {
		this.titleList = titleList;
	}

}
