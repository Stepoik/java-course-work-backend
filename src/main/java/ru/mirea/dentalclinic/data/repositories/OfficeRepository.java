package ru.mirea.dentalclinic.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.dentalclinic.data.entities.OfficeEntity;

public interface OfficeRepository extends JpaRepository<OfficeEntity, Long> {

}
