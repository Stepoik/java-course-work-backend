package ru.mirea.dentalclinic.domain.service;

import ru.mirea.dentalclinic.domain.models.Record;

public interface RecordService {
    Record createNewRecord(Record record);

    Record bookRecord(Long recordId);
}
