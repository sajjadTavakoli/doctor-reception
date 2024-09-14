package ir.stdev.reception.test.unit;

import ir.stdev.reception.api.dto.DoctorRequest;
import ir.stdev.reception.api.dto.DoctorResponse;
import ir.stdev.reception.api.dto.Grade;
import ir.stdev.reception.persistence.entity.DoctorEntity;
import ir.stdev.reception.persistence.repository.DoctorRepository;
import ir.stdev.reception.service.impl.DoctorServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CreateDoctorTest {

    @Mock
    DoctorRepository doctorRepository;

    @InjectMocks
    DoctorServiceImpl service;

    private DoctorEntity doctor;
    private DoctorEntity findByNationalCode;

    @BeforeEach
    void save() {
        doctor = DoctorEntity.builder()
                .id(1L)
                .name("sajjad")
                .family("tavakoli")
                .nationalCode("1272432173")
                .birthDate(new Date())
                .grade("ACADEMIC_DOCTOR")
                .expertise("General")
                .build();

    }
    @Before("saveDoctor")
    void findByNationalCode(){
        findByNationalCode = null;
    }

    @Test
    void saveDoctor() {
        Mockito.when(doctorRepository.save(any(DoctorEntity.class))).thenReturn(doctor);
        Mockito.when(doctorRepository.findByNationalCode(doctor.getNationalCode())).thenReturn(Optional.ofNullable(findByNationalCode));
        DoctorResponse doctorResponse = service.create(DoctorRequest.builder()
                .name("sajjad")
                .family("tavakoli")
                .nationalCode("1272432173")
                .birthDate(new Date())
                .grade(Grade.ACADEMIC_DOCTOR)
                .expertise("General")
                .build());

        Assertions.assertNotNull(doctorResponse);
    }
}
