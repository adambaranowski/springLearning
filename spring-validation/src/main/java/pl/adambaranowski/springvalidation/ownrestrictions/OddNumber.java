package pl.adambaranowski.springvalidation.ownrestrictions;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
//If a type declaration is annotated with Documented,
// its annotations become part of the public API of the annotated elements.
@Constraint(validatedBy = {OddNumberValidator.class, OddNumberStringValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface OddNumber {
    String message() default "Number should be odd";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
