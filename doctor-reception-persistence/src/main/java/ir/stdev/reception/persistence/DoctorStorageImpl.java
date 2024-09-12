package ir.stdev.reception.persistence;

import ir.stdev.reception.api.dto.DoctorResponse;
import ir.stdev.reception.api.exception.DoctorReceptionRunTimeException;
import ir.stdev.reception.persistence.entity.DoctorEntity;
import ir.stdev.reception.service.exception.DoctorEntityNotFundException;
import ir.stdev.reception.persistence.mapper.DoctorMapper;
import ir.stdev.reception.persistence.repository.DoctorRepository;
import ir.stdev.reception.service.api.persistence.DoctorStorage;
import ir.stdev.reception.service.dto.DoctorDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class DoctorStorageImpl implements DoctorStorage {

    private final DoctorRepository repository;
    private final DoctorMapper mapper;

    @Override
    public DoctorResponse addDoctor(DoctorDTO doctorDTO) {
        return mapper.toResponseApi(repository.save(mapper.toEntity(doctorDTO)));
    }

    @Override
    public DoctorResponse update(DoctorDTO doctorDTO) {
        return mapper.toResponseApi(repository.save(mapper.toEntity(doctorDTO)));
    }

    @Override
    public DoctorDTO findByNationalCode(String nationalCode) throws DoctorEntityNotFundException {
        return mapper.toDto(repository.findByNationalCode(nationalCode).orElseThrow(() -> new DoctorEntityNotFundException("دکتر با این مشخصات پیدا نشد")));
    }

    @Override
    public DoctorDTO findById(String id) throws DoctorEntityNotFundException {
        return mapper.toDto(repository.findById(Long.parseLong(id)).orElseThrow(() -> new DoctorEntityNotFundException("مشخصات دکتر با این شناسه یافت نشد")));
    }

    @Override
    public DoctorDTO findByNameAndFamily(String name, String family) throws DoctorEntityNotFundException {
        return mapper.toDto(repository.findByNameAndFamily(name,family).orElseThrow(() -> new DoctorEntityNotFundException("دکتر با این مشخصات یافت نشد")));
    }

    @Override
    public List<DoctorDTO> findByExpertise(String expertise) throws DoctorEntityNotFundException{
        return mapper.toDots(repository.findByExpertise(expertise).orElseThrow(()-> new DoctorEntityNotFundException("هیچ دکتری با این تخصص یافت نشد")));
    }

    @Override
    public List<DoctorDTO> getAll() {
        return mapper.toDots(repository.findAll());
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            Optional<DoctorEntity> doctor = repository.findById(id);
            if (doctor.isPresent()) {
                repository.deleteById(id);
                return true;
            }else
                return false;
        }catch (Exception e){
            return false;
        }
    }
}
