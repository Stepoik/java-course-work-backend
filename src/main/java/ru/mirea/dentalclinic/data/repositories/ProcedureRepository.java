package ru.mirea.dentalclinic.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mirea.dentalclinic.data.entities.ProcedureEntity;
import ru.mirea.dentalclinic.domain.models.Procedure;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Long> {
    List<ProcedureEntity> findByClinicsId(Long clinicId);

    Optional<ProcedureEntity> findByName(String name);

    @Query("select p.name, count(p) from ProcedureEntity p inner join p.doctors group by p.name")
    List<Object[]> getProcedures();
}
