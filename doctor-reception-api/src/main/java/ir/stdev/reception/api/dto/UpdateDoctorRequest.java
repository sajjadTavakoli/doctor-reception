package ir.stdev.reception.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDoctorRequest extends DoctorRequest {

    //    @Schema(description = "شناسه")
    private String id;
}
