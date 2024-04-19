package ru.mirea.dentalclinic.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.dentalclinic.data.entities.ProcedureEntity;
import ru.mirea.dentalclinic.domain.models.Procedure;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Long> {
    List<ProcedureEntity> findByClinicsId(Long clinicId);

    Optional<ProcedureEntity> findByName(String name);
}
