package ir.stdev.reception.api.annotation;

import ir.stdev.reception.api.validator.NationalCodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NationalCodeValidator.class)
public @interface ValidateNationalCode {
    String message() default "National Code Invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
