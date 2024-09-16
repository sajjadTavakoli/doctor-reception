package ir.stdev.reception.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import ir.stdev.reception.api.annotation.ValidateNationalCode;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "DoctorRequest", description = "درخواست ایجاد دکتر")
public class DoctorRequest {
    @Schema(description = "نام")
    @NotNull
    @NotEmpty
    private String name;
    @Schema(description = "نام خانوادگی")
    @NotNull
    @NotEmpty
    private String family;
    @Schema(description = "کد ملی")
    @NotNull
    @ValidateNationalCode(message = "کد ملی وارد شده نامعتبر است")
    private String nationalCode;
    @Schema(description = "رتبه")
    @NotNull
    @NotEmpty
    private Grade grade;
    @Schema(description = "تاریخ تولد")
    private Date birthDate;
    @Schema(description = "تخصص")
    @NotNull
    @NotEmpty
    private String expertise;

}
