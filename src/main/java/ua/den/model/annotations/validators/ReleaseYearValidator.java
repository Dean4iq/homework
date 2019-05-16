package ua.den.model.annotations.validators;

import ua.den.model.annotations.ValidReleaseYear;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class ReleaseYearValidator implements ConstraintValidator<ValidReleaseYear, Integer> {
    @Override
    public void initialize(ValidReleaseYear constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer releaseYear, ConstraintValidatorContext constraintValidatorContext) {
        return releaseYear == null || ((releaseYear >= 1960) && (releaseYear <= Calendar.getInstance().get(Calendar.YEAR)));
    }
}
