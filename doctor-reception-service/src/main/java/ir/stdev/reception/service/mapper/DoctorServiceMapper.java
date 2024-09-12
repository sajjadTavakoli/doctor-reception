package ir.stdev.reception.service.mapper;

import ir.stdev.reception.api.dto.DoctorRequest;
import ir.stdev.reception.api.dto.DoctorResponse;
import ir.stdev.reception.api.dto.UpdateDoctorRequest;
import ir.stdev.reception.service.dto.DoctorDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorServiceMapper {

    DoctorResponse toDoctorResponse (DoctorDTO doctorDTO);

    List<DoctorResponse> toResponseList (List<DoctorDTO> doctorDTOList);

    DoctorDTO toDoctorDto (DoctorRequest request);

    DoctorDTO toDoctorDto (UpdateDoctorRequest updateDoctorRequest);
}
