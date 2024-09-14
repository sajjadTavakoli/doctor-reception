package ir.stdev.reception.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponse {

    @Schema(description = "شناسه")
    private Long id;
    @Schema(description = "نام")
    private String name;
    @Schema(description = "نام خانوادگی")
    private String family;
    @Schema(description = "کد ملی")
    private String nationalCode;
    @Schema(description = "رتبه")
    private Grade grade;
    @Schema(description = "تاریخ تولد")
    private Date birthDate;
    @Schema(description = "تخصص")
    private String expertise;
}
