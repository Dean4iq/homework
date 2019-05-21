package ua.den.model.annotations.validators;

import ua.den.model.annotations.ValidFuelTankCapacity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FuelTankCapacityValidator implements ConstraintValidator<ValidFuelTankCapacity, Integer> {
    @Override
    public void initialize(ValidFuelTankCapacity constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer capacity, ConstraintValidatorContext constraintValidatorContext) {
        return capacity == null || capacity >= 0;
    }
}
