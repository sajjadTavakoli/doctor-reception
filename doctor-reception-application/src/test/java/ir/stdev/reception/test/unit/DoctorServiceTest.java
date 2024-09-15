package ir.stdev.reception.test.unit;

import ir.stdev.reception.api.dto.DoctorRequest;
import ir.stdev.reception.api.dto.DoctorResponse;
import ir.stdev.reception.api.dto.Grade;
import ir.stdev.reception.application.DoctorReceptionApplication;
import ir.stdev.reception.service.api.persistence.DoctorService;
import ir.stdev.reception.service.api.persistence.DoctorStorage;
import ir.stdev.reception.service.dto.DoctorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = DoctorReceptionApplication.class)
class DoctorServiceTest {
    @Mock
    DoctorStorage doctorStorage;

    @Autowired
    private DoctorService service;
    private DoctorResponse doctor;

    @BeforeEach
    void save() {
        doctor = DoctorResponse.builder().id(1L).name("sajjad").family("tavakoli").nationalCode("1272432173").birthDate(new Date()).grade(Grade.ACADEMIC_DOCTOR).expertise("General").build();
    }

    @Test
    void saveDoctorUnitTest() {
        Mockito.when(doctorStorage.addDoctor(any(DoctorDTO.class))).thenReturn(doctor);
        Mockito.when(doctorStorage.findByNationalCode(doctor.getNationalCode())).thenReturn(Optional.empty());
        DoctorResponse doctorResponse = service.create(DoctorRequest.builder().name("sajjad").family("tavakoli").nationalCode("1272432173").birthDate(new Date()).grade(Grade.ACADEMIC_DOCTOR).expertise("General").build());
        Assertions.assertNotNull(doctorResponse);
        Assertions.assertEquals(doctorResponse.getName(), "sajjad");
    }
}
