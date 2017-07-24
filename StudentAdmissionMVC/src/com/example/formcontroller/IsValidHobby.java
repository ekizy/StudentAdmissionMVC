package com.example.formcontroller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint (validatedBy=HobbyValidator.class)
@Target ({ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)

//HobbyValidator'ın interface'i. Annotation class'ı da denebilir. Bu adla annotation acilir.

public @interface IsValidHobby {
	 String message();

	 String listOfValidValues();

	 Class <?>[] groups() default {};

	 Class <? extends Payload>[] payload() default {};
}
