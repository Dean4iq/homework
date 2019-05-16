package ua.den.model.annotations;

import ua.den.model.annotations.validators.PatronymicNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PatronymicNameValidator.class)
@Documented
public @interface ValidPatronymicName {
    String message() default "{field.error.patronymicName}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
