package ir.stdev.reception.persistence.repository;

import ir.stdev.reception.persistence.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    Optional<DoctorEntity> findByNationalCode(String nationalCode);
    Optional<DoctorEntity> findByNameAndFamily(String name , String family);
    Optional<List<DoctorEntity>> findByExpertise (String expertise);

}
