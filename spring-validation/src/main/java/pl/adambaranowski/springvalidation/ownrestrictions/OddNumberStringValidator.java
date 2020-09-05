package pl.adambaranowski.springvalidation.ownrestrictions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OddNumberStringValidator implements ConstraintValidator<OddNumber, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Integer.parseInt(s) % 2 == 0;
    }

    @Override
    public void initialize(OddNumber constraintAnnotation) {
//tutaj wyciągamy informacje z adnotacji, np. wartości min/max
    }
}
