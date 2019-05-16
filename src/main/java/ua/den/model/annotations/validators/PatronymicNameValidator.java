package ua.den.model.annotations.validators;

import ua.den.model.annotations.ValidPatronymicName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatronymicNameValidator  implements ConstraintValidator<ValidPatronymicName, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PATRONYMIC_NAME_PATTERN = "^[A-Z]{1}[a-z]{1,44}$";

    @Override
    public void initialize(ValidPatronymicName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        return validateLogin(login);
    }

    private boolean validateLogin(String login) {
        pattern = Pattern.compile(PATRONYMIC_NAME_PATTERN);
        matcher = pattern.matcher(login);
        return matcher.matches();
    }
}
