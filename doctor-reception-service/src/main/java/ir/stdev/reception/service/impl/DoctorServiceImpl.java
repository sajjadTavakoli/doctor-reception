package ir.stdev.reception.service.impl;

import ir.stdev.reception.api.dto.DoctorRequest;
import ir.stdev.reception.api.dto.DoctorResponse;
import ir.stdev.reception.api.dto.UpdateDoctorRequest;
import ir.stdev.reception.api.exception.DoctorReceptionRunTimeException;
import ir.stdev.reception.service.api.persistence.DoctorService;
import ir.stdev.reception.service.api.persistence.DoctorStorage;
import ir.stdev.reception.service.dto.DoctorDTO;
import ir.stdev.reception.service.exception.DoctorEntityNotFundException;
import ir.stdev.reception.service.mapper.DoctorServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorServiceMapper mapper;
    private final DoctorStorage doctorStorage;


    @Override
    public DoctorResponse create(DoctorRequest request) {
        if (doctorStorage.findByNationalCode(request.getNationalCode()).isEmpty())
            return doctorStorage.addDoctor(mapper.toDoctorDto(request));
        else throw new DoctorReceptionRunTimeException("دکتر با مشخصات وارد شده تکراری است");
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
            return mapper.toDoctorResponse(doctorStorage.findByNameAndFamily(name, family));
        } catch (DoctorEntityNotFundException e) {
            throw new DoctorReceptionRunTimeException(e.getMessage());
        }
    }

    @Override
    public DoctorResponse getByNationalCode(String nationalCode) {
        Optional<DoctorDTO> doctor = doctorStorage.findByNationalCode(nationalCode);
        if (doctor.isPresent()) return mapper.toDoctorResponse(doctor.get());
        else throw new DoctorReceptionRunTimeException("دکتر با مشخصات وارد شده یافت نشد");
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
