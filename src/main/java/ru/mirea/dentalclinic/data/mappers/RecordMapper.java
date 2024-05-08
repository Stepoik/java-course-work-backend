package ru.mirea.dentalclinic.data.mappers;

import jakarta.validation.constraints.NotNull;
import ru.mirea.dentalclinic.data.entities.RecordEntity;
import ru.mirea.dentalclinic.domain.models.Doctor;
import ru.mirea.dentalclinic.domain.models.Office;
import ru.mirea.dentalclinic.domain.models.Record;
import ru.mirea.dentalclinic.domain.models.RecordCreateModel;

import java.sql.Date;

public class RecordMapper {
    public static RecordEntity mapFromCreateModel(@NotNull RecordCreateModel record) {
        return new RecordEntity(
                record.id(),
                record.start(),
                record.end(),
                new Date(record.day().getTime()),
                record.isBooked()
        );
    }

    public static Record mapToDomain(@NotNull RecordEntity record) {
        Doctor doctor = null;
        Office office = null;
        if (record.getDoctor() != null) {
            doctor = DoctorMapper.mapToDomain(record.getDoctor());
        }
        if (record.getOffice() != null) {
            office = OfficeMapper.mapToDomain(record.getOffice());
        }
        return new Record(
                record.getId(),
                doctor,
                office,
                record.getStart(),
                record.getFinish(),
                record.getIsBooked(),
                record.getDate()
        );
    }
}
