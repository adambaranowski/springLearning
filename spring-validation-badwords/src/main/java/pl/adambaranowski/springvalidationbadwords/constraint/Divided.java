package pl.adambaranowski.springvalidationbadwords.constraint;

import pl.adambaranowski.springvalidationbadwords.validator.NumberDivideValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumberDivideValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Divided {
    String message() default "Number ${validatedValue} has to be divided by {by}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int by() default 1;
}
