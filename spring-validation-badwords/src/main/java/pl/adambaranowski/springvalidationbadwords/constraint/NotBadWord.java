package pl.adambaranowski.springvalidationbadwords.constraint;

import pl.adambaranowski.springvalidationbadwords.common.Lang;
import pl.adambaranowski.springvalidationbadwords.validator.BadWordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {BadWordValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBadWord {
    String message() default "You cannot use bad words in your messages";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Lang[] lang() default Lang.PL;
}
