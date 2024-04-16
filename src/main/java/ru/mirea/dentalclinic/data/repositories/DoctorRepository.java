package ru.mirea.dentalclinic.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.dentalclinic.data.entities.DoctorEntity;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

}
