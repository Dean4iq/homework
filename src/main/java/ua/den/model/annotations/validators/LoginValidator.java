package ua.den.model.annotations.validators;

import ua.den.model.annotations.ValidLogin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator implements ConstraintValidator<ValidLogin, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String LOGIN_PATTERN = "^[A-z0-9._]{6,18}$";

    @Override
    public void initialize(ValidLogin constraintAnnotation) {
    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        return validateLogin(login);
    }

    private boolean validateLogin(String login) {
        pattern = Pattern.compile(LOGIN_PATTERN);
        matcher = pattern.matcher(login);
        return matcher.matches();
    }
}
