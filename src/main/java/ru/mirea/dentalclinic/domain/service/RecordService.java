package ru.mirea.dentalclinic.domain.service;

import ru.mirea.dentalclinic.domain.models.Record;
import ru.mirea.dentalclinic.domain.models.RecordCreateModel;
import ru.mirea.dentalclinic.utils.result.Result;

import java.util.Date;
import java.util.List;

public interface RecordService {
    Result<Record> createNewRecord(RecordCreateModel record);

    Result<Record> bookRecord(Long recordId);

    Result<List<Record>> getRecordByDateAndDoctorId(Date date, Long doctorId);

    List<Record> getRecords();
}
