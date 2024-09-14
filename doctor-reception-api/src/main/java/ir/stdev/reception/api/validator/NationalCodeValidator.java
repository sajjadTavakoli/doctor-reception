package ir.stdev.reception.api.validator;

import ir.stdev.reception.api.annotation.ValidateNationalCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class NationalCodeValidator implements ConstraintValidator<ValidateNationalCode,String> {

    @Override
    public boolean isValid(String nationalCode, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "[0-9]\\d{9}";
        Pattern pattern =Pattern.compile(regex);
        return pattern.matcher(nationalCode).matches();
    }
}
