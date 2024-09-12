package ir.stdev.reception.api.facade;

import ir.stdev.reception.api.dto.DoctorRequest;
import ir.stdev.reception.api.dto.DoctorResponse;
import ir.stdev.reception.api.dto.UpdateDoctorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface DoctorFacade {

    String PATH = "/doctor";

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    DoctorResponse createDoctor(@RequestBody DoctorRequest request);

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    DoctorResponse updateDoctor(@RequestBody UpdateDoctorRequest request);

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    boolean delete(@PathVariable String id);

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<DoctorResponse> getAllDoctors();

    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    DoctorResponse getDoctor(@PathVariable String id);

    @GetMapping(value = "/{name},{family}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    DoctorResponse getDoctor(@PathVariable String name, @PathVariable String family);

    @GetMapping(value = "/getByNationalCode/{nationalCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    DoctorResponse getDoctorByNationalCode(@PathVariable String nationalCode);

    @GetMapping(value = "/getByExpertise/{expertise}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<DoctorResponse> getDoctorsByExpertise(@PathVariable String expertise);
}
