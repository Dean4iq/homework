package ua.den.model.annotations;

import ua.den.model.annotations.validators.ReleaseYearValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ReleaseYearValidator.class)
@Documented
public @interface ValidReleaseYear {
    String message() default "{field.error.releaseYear}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
