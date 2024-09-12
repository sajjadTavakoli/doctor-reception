package ir.stdev.reception.controller.doctor;


import ir.stdev.reception.api.dto.DoctorRequest;
import ir.stdev.reception.api.dto.DoctorResponse;
import ir.stdev.reception.api.dto.UpdateDoctorRequest;
import ir.stdev.reception.api.facade.DoctorFacade;
import ir.stdev.reception.service.api.persistence.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = DoctorFacade.PATH)
@RequiredArgsConstructor
public class DoctorController implements DoctorFacade {
    private final DoctorService doctorService;

    @Override
    public DoctorResponse createDoctor(DoctorRequest request) {
        return doctorService.create(request);
    }

    @Override
    public DoctorResponse updateDoctor(UpdateDoctorRequest request) {
        return doctorService.update(request);
    }

    @Override
    public boolean delete(String id) {
        return doctorService.delete(id);
    }

    @Override
    public List<DoctorResponse> getAllDoctors() {
        return doctorService.getAll();
    }

    @Override
    public DoctorResponse getDoctor(String id) {
        return doctorService.getById(id);
    }

    @Override
    public DoctorResponse getDoctor(String name, String family) {
        return doctorService.getByNameAndFamily(name, family);
    }

    @Override
    public DoctorResponse getDoctorByNationalCode(String nationalCode) {
        return doctorService.getByNationalCode(nationalCode);
    }

    @Override
    public List<DoctorResponse> getDoctorsByExpertise(String expertise) {
        return doctorService.getByExpertise(expertise);
    }
}

