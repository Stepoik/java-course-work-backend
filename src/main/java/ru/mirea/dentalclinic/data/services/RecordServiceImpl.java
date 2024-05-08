package ru.mirea.dentalclinic.data.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.dentalclinic.data.entities.*;
import ru.mirea.dentalclinic.data.mappers.DoctorMapper;
import ru.mirea.dentalclinic.data.mappers.RecordMapper;
import ru.mirea.dentalclinic.data.repositories.OfficeRepository;
import ru.mirea.dentalclinic.data.repositories.PatientRepository;
import ru.mirea.dentalclinic.data.repositories.RecordRepository;
import ru.mirea.dentalclinic.domain.models.Record;
import ru.mirea.dentalclinic.domain.models.RecordCreateModel;
import ru.mirea.dentalclinic.domain.service.DoctorService;
import ru.mirea.dentalclinic.domain.service.ProcedureService;
import ru.mirea.dentalclinic.domain.service.RecordService;
import ru.mirea.dentalclinic.domain.service.UserService;
import ru.mirea.dentalclinic.exceptions.*;
import ru.mirea.dentalclinic.utils.result.Result;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    private final DoctorService doctorService;
    private final UserService userService;
    private final PatientRepository patientRepository;
    private final OfficeRepository officeRepository;

    @Override
    public Result<Record> createNewRecord(RecordCreateModel record) {
        return Result.runCatching(() -> {
            Optional<RecordEntity> foundRecord = recordRepository.getRecordEntityByDateAndStartAndOfficeId(
                    new Date(record.day().getTime()),
                    record.start(),
                    record.officeId()
            );
            if (foundRecord.isPresent()) {
                throw new RecordAlreadyExits();
            }
            DoctorEntity doctor = DoctorMapper.mapFromDomain(doctorService.getDoctorById(record.doctorId()));
            OfficeEntity office = officeRepository.findById(record.officeId()).orElseThrow();
            RecordEntity newRecord = RecordMapper.mapFromCreateModel(record);
            newRecord.setDoctor(doctor);
            newRecord.setOffice(office);
            return RecordMapper.mapToDomain(recordRepository.save(newRecord));
        });
    }

    @Override
    public Result<Record> bookRecord(Long recordId) {
        return Result.runCatching(() -> {
            Optional<RecordEntity> foundRecord = recordRepository.findById(recordId);
            if (foundRecord.isEmpty()) {
                throw new TableEntryNotExist(Constants.RECORD_NOT_EXIST);
            }
            RecordEntity record = foundRecord.get();
            if (record.getIsBooked()) {
                throw new TableEntryAlreadyExist(Constants.RECORD_ALREADY_BOOKED);
            }
            Result<UserEntity> currentUser = userService.getCurrentUser();
            if (currentUser.getResultType() == Result.ResultType.FAILURE) {
                throw new UnauthorizedException();
            }
            Optional<PatientEntity> patient = patientRepository.getPatientEntityByUserId(currentUser.getValue().getId());
            if (patient.isEmpty()) {
                throw new UnauthorizedException();
            }
            record.setPatient(patient.get());
            record.setIsBooked(true);
            return RecordMapper.mapToDomain(recordRepository.save(record));
        });
    }

    @Override
    public Result<List<Record>> getRecordByDateAndDoctorId(java.util.Date date, Long doctorId) {
        return Result.runCatching(() -> {
            List<RecordEntity> doctors = recordRepository.getRecordEntitiesByDateAndDoctorIdOrderByStart(new Date(date.getTime()), doctorId);
            return doctors.stream().map(RecordMapper::mapToDomain).toList();
        });
    }

    @Override
    public List<Record> getRecords() {
        Result<UserEntity> currentUserResult = userService.getCurrentUser();
        if (currentUserResult.isFailure()) {
            throw new RuntimeException(currentUserResult.getException());
        }
        UserEntity currentUser = currentUserResult.getValue();
        Optional<PatientEntity> patient = patientRepository.getPatientEntityByUserId(currentUser.getId());
        if (patient.isEmpty()) {
            throw new RuntimeException();
        }
        List<RecordEntity> records = recordRepository.getRecordEntitiesByPatientIdOrderByDate(patient.get().getId());
        return records.stream().map(RecordMapper::mapToDomain).toList();
    }
}
