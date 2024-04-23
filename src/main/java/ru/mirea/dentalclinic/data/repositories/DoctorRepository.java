package ru.mirea.dentalclinic.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;
import ru.mirea.dentalclinic.data.entities.DoctorEntity;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    @Query("select d from DoctorEntity d inner join RecordEntity r on r.doctor.id = d.id inner join ClinicEntity cl on cl.id = r.office.clinic.id " +
            "where d.spec = :spec and cl.id = :clinicId")
    List<DoctorEntity> getDoctorEntitiesBySpecAndClinicId(String spec, Long clinicId);

    @Query("select d from DoctorEntity d where concat(lower(d.lastName), lower(d.firstName), lower(d.middleName)) like CONCAT('%',lower(:query) ,'%') ")
    List<DoctorEntity> findByFirstNameContaining(String query, Pageable pageable);

    List<DoctorEntity> getDoctorEntitiesByProceduresId(Long procedureId);

    // TODO: 18.04.2024 Мб баг, мне лень пока фиксить
    @Query("select d from DoctorEntity d join d.procedures pr " +
            "inner join RecordEntity r on r.doctor = d " +
            "where r.office.clinic.id = :clinicId and pr.id = :procedureId")
    List<DoctorEntity> getDoctorEntitiesByProceduresIdAndClinicId(Long procedureId, Long clinicId);

    Page<DoctorEntity> findAll(Pageable pageable);
}
