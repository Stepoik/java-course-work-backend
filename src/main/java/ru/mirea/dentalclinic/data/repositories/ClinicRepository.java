package ru.mirea.dentalclinic.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mirea.dentalclinic.data.entities.ClinicEntity;

import java.util.List;

@Repository
public interface ClinicRepository extends JpaRepository<ClinicEntity, Long> {
}
