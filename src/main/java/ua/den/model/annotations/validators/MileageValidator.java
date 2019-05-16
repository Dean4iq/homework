package ua.den.model.annotations.validators;

import ua.den.model.annotations.ValidMileage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MileageValidator implements ConstraintValidator<ValidMileage, Integer> {
    @Override
    public void initialize(ValidMileage constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer mileage, ConstraintValidatorContext constraintValidatorContext) {
        return mileage == null || ((mileage >= 0) && (mileage <= 999999));
    }
}
