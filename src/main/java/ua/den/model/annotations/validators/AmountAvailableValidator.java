package ua.den.model.annotations.validators;

import ua.den.model.annotations.ValidAmountAvailable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AmountAvailableValidator implements ConstraintValidator<ValidAmountAvailable, Integer> {
    @Override
    public void initialize(ValidAmountAvailable constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer amount, ConstraintValidatorContext constraintValidatorContext) {
        return amount > 0;
    }
}
