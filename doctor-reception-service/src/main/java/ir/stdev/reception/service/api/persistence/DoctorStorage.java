package ir.stdev.reception.service.api.persistence;

import ir.stdev.reception.api.dto.DoctorResponse;
import ir.stdev.reception.service.dto.DoctorDTO;
import ir.stdev.reception.service.exception.DoctorEntityNotFundException;

import java.util.List;
import java.util.Optional;

public interface DoctorStorage {
    DoctorResponse addDoctor(DoctorDTO doctorDTO);

    DoctorResponse update(DoctorDTO doctorDTO);

    Optional<DoctorDTO> findByNationalCode(String nationalCode);

    DoctorDTO findById(String id) throws DoctorEntityNotFundException;

    DoctorDTO findByNameAndFamily(String name, String family) throws DoctorEntityNotFundException;

    List<DoctorDTO> findByExpertise(String expertise) throws DoctorEntityNotFundException;

    List<DoctorDTO> getAll();

    boolean deleteById(Long id);
}
