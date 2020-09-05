package pl.adambaranowski.springvalidation.ownrestrictions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OddNumberValidator implements ConstraintValidator<OddNumber, Integer> {
    @Override
    public void initialize(OddNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer % 2 == 0;
    }
}
