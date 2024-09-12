package ir.stdev.reception.api.dto;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Grade {
    MEDICAL_STUDENT("medical_student"),
    JUNIOR_DOCTOR("junior_doctor"),
    CONSULTANT("consultant"),
    SPECIALIST("specialist"),
    GENERAL_PRACTITIONER("general_practitioner"),
    ACADEMIC_DOCTOR("academic_doctor");

    private final String value;

    Grade(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Grade formValue (String value){
        return lookup.get(value);
    }

    private static final Map<String, Grade> lookup = Arrays.stream(Grade.values()).collect(Collectors.toMap(Grade::getValue, e -> e));
}
