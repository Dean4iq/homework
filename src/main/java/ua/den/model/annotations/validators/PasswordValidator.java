package ua.den.model.annotations.validators;

import ua.den.model.annotations.ValidPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String NAME_PATTERN = "^.{5,28}$";

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return validateLogin(password);
    }

    private boolean validateLogin(String password) {
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
