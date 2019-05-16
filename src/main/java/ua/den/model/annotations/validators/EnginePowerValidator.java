package ua.den.model.annotations.validators;

import ua.den.model.annotations.ValidEnginePower;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnginePowerValidator implements ConstraintValidator<ValidEnginePower, Integer> {
    @Override
    public void initialize(ValidEnginePower constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer power, ConstraintValidatorContext constraintValidatorContext) {
        return (power == null) || power > 0;
    }
}
