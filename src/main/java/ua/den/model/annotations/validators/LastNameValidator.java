package ua.den.model.annotations.validators;

import ua.den.model.annotations.ValidLastName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastNameValidator implements ConstraintValidator<ValidLastName, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String NAME_PATTERN = "^[A-Z]{1}[a-z]{1,44}$";

    @Override
    public void initialize(ValidLastName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String lastName, ConstraintValidatorContext constraintValidatorContext) {
        return validateLastName(lastName);
    }

    private boolean validateLastName(String lastName) {
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(lastName);
        return matcher.matches();
    }
}
