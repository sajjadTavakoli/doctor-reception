package ir.stdev.reception.persistence.mapper;

import ir.stdev.reception.api.dto.DoctorResponse;
import ir.stdev.reception.persistence.entity.DoctorEntity;
import ir.stdev.reception.service.dto.DoctorDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorEntity toEntity(DoctorDTO doctorDTO);

    DoctorDTO toDto(DoctorEntity doctorEntity);

    List<DoctorDTO> toDots(List<DoctorEntity> doctorEntities);

    DoctorResponse toResponseApi(DoctorEntity doctorEntity);
}
