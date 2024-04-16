package ru.mirea.dentalclinic.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.dentalclinic.data.entities.ClinicEntity;

@Repository
public interface ClinicRepository extends JpaRepository<ClinicEntity, Long> {
}
