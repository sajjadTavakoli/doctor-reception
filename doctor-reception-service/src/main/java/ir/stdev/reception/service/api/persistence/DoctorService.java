package ir.stdev.reception.service.api.persistence;

import ir.stdev.reception.api.dto.DoctorRequest;
import ir.stdev.reception.api.dto.DoctorResponse;
import ir.stdev.reception.api.dto.UpdateDoctorRequest;

import java.util.List;

public interface DoctorService {
    DoctorResponse create(DoctorRequest request);

    DoctorResponse update(UpdateDoctorRequest request);

    boolean delete(String id);

    List<DoctorResponse> getAll();

    DoctorResponse getById(String id);

    DoctorResponse getByNameAndFamily(String name , String family);

    DoctorResponse getByNationalCode (String nationalCode);

    List<DoctorResponse> getByExpertise (String expertise);
}
