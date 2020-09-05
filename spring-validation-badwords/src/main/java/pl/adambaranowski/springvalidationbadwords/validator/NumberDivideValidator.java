package pl.adambaranowski.springvalidationbadwords.validator;

import pl.adambaranowski.springvalidationbadwords.constraint.Divided;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberDivideValidator implements ConstraintValidator<Divided, Integer> {

    private int number;

    @Override
    public void initialize(Divided constraintAnnotation) {
        this.number = constraintAnnotation.by();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value%number==0;
    }
}
