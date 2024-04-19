package ru.mirea.dentalclinic.api.mappers;

import ru.mirea.dentalclinic.api.dtos.RecordDto;
import ru.mirea.dentalclinic.api.dtos.requests.RecordRequest;
import ru.mirea.dentalclinic.domain.models.Record;
import ru.mirea.dentalclinic.domain.models.RecordCreateModel;

public class RecordMapper {
    public static RecordDto mapFromDomain(Record record) {
        return new RecordDto(
                record.id(),
                DoctorMapper.mapFromDomain(record.doctor()),
                OfficeMapper.mapFromDomain(record.office()),
                record.start(),
                record.end(),
                record.isBooked(),
                record.day()
        );
    }

    public static RecordCreateModel mapToCreateModel(RecordRequest record) {
        return new RecordCreateModel(
                null,
                record.doctorId(),
                record.officeId(),
                record.start(),
                record.end(),
                record.isBooked(),
                record.day()
        );
    }
}
