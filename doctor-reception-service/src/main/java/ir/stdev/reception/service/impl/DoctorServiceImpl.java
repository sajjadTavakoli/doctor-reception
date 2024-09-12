package ir.stdev.reception.service.impl;

import ir.stdev.reception.api.dto.DoctorRequest;
import ir.stdev.reception.api.dto.DoctorResponse;
import ir.stdev.reception.api.dto.UpdateDoctorRequest;
import ir.stdev.reception.api.exception.DoctorReceptionRunTimeException;
import ir.stdev.reception.service.api.persistence.DoctorService;
import ir.stdev.reception.service.api.persistence.DoctorStorage;
import ir.stdev.reception.service.exception.DoctorEntityNotFundException;
import ir.stdev.reception.service.mapper.DoctorServiceMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorServiceMapper mapper;
    private final DoctorStorage doctorStorage;


    @Override
    public DoctorResponse create(DoctorRequest request) {
        try {
            doctorStorage.findByNationalCode(request.getNationalCode());
            throw new DoctorReceptionRunTimeException("دکتر با مشخصات وارد شده تکراری است");
        } catch (DoctorEntityNotFundException e) {
            return doctorStorage.addDoctor(mapper.toDoctorDto(request));
        }
    }

    @Override
    public DoctorResponse update(UpdateDoctorRequest request) {
        try {
            doctorStorage.findById(request.getId());
        } catch (DoctorEntityNotFundException e) {
            throw new DoctorReceptionRunTimeException(e.getMessage());
        }
        return doctorStorage.update(mapper.toDoctorDto(request));
    }

    @Override
    public boolean delete(String id) {
        return doctorStorage.deleteById(Long.parseLong(id));
    }

    @Override
    public List<DoctorResponse> getAll() {
        return mapper.toResponseList(doctorStorage.getAll());
    }

    @Override
    public DoctorResponse getById(String id) {
        try {
            return mapper.toDoctorResponse(doctorStorage.findById(id));
        } catch (DoctorEntityNotFundException e) {
            throw new DoctorReceptionRunTimeException(e.getMessage());
        }
    }

    @Override
    public DoctorResponse getByNameAndFamily(String name, String family) {
        try {
            return mapper.toDoctorResponse(doctorStorage.findByNameAndFamily(name,family));
        } catch (DoctorEntityNotFundException e) {
            throw new DoctorReceptionRunTimeException(e.getMessage());
        }
    }

    @Override
    public DoctorResponse getByNationalCode(String nationalCode) {
        try {
            return mapper.toDoctorResponse(doctorStorage.findByNationalCode(nationalCode));
        } catch (DoctorEntityNotFundException e) {
            throw new DoctorReceptionRunTimeException(e.getMessage());
        }
    }

    @Override
    public List<DoctorResponse> getByExpertise(String expertise) {
        try {
            return mapper.toResponseList(doctorStorage.findByExpertise(expertise));
        } catch (DoctorEntityNotFundException e) {
            throw new DoctorReceptionRunTimeException(e.getMessage());
        }
    }
}
