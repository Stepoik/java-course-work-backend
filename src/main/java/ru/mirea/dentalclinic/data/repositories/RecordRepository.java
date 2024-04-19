package ru.mirea.dentalclinic.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.dentalclinic.data.entities.RecordEntity;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<RecordEntity, Long> {
    Optional<RecordEntity> getRecordEntityByDateAndStartAndOfficeId(Date date, Integer start, Long officeId);
}
