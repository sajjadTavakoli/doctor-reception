package ir.stdev.reception.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "UpdateDoctorRequest", description = "درخواست ویرایش دکتر")
public class UpdateDoctorRequest extends DoctorRequest {

    @Schema(description = "شناسه")
    private String id;
}
