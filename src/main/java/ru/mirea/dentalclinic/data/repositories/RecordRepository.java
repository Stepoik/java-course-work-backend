package ru.mirea.dentalclinic.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.dentalclinic.data.entities.RecordEntity;

@Repository
public interface RecordRepository extends JpaRepository<RecordEntity, Long> {

}
