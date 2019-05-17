package ua.den.model.annotations.validators;

import ua.den.model.annotations.PasswordMatches;
import ua.den.model.dto.SensitiveUserData;
import ua.den.model.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (obj instanceof UserDto) {
            UserDto userDto = (UserDto) obj;
            return userDto.getPassword().equals(userDto.getRepeatedPassword());
        } else if (obj instanceof SensitiveUserData) {
            SensitiveUserData userData = (SensitiveUserData) obj;
            return userData.getNewPassword().equals(userData.getRepeatedPassword());
        }

        return false;
    }
}
