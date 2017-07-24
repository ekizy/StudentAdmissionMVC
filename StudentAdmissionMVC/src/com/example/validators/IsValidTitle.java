package com.example.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint (validatedBy=TitleValidator.class)
@Target ({ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)

//HobbyValidator'ın interface'i. Annotation class'ı da denebilir. Bu adla annotation acilir.

public @interface IsValidTitle {
	 String message() default "Please provide a valid title for the instructor";

	 String titleList() default "Prof|Assos Prof|Asst Prof|Lecturer";

	 Class <?>[] groups() default {};

	 Class <? extends Payload>[] payload() default {};
}
