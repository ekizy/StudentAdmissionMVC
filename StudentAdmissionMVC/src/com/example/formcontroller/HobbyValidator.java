package com.example.formcontroller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//Validator class yapay bir annotation kullandığı için constraintvalidatora extend edildi.
//O validator ise gene yapay bir interface kullandı. Yapay olduğu için kendi methodları lazim.

public class HobbyValidator implements ConstraintValidator<IsValidHobby,String>{

	private String listOfValidValues;
	@Override
	public void initialize(IsValidHobby isValidHobby){
			this.listOfValidValues=isValidHobby.listOfValidValues();
	}

	@Override
	public boolean isValid (String studentHobby,ConstraintValidatorContext cont){

		if(studentHobby==null) return false;

		if (studentHobby.matches(listOfValidValues)) return true;

		else return false;
	}

	public String getListOfValidValues() {
		return listOfValidValues;
	}

	public void setListOfValidValues(String listOfValidValues) {
		this.listOfValidValues = listOfValidValues;
	}

}
