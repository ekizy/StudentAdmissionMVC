package com.example.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint (validatedBy=LanguageValidator.class)
@Target ({ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)

//HobbyValidator'ın interface'i. Annotation class'ı da denebilir. Bu adla annotation acilir.

public @interface IsValidLanguage {
	 String message() default "Please provide a valid language";

	 String languageList() default "Turkish|German|English";

	 Class <?>[] groups() default {};

	 Class <? extends Payload>[] payload() default {};
}

