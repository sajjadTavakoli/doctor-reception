package ir.stdev.reception.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDTO {

    private Long id;
    private String name;
    private String family;
    private String nationalCode;
    private String grade;
    private Date birthDate;
    private String expertise;
}
