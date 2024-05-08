package ru.mirea.dentalclinic.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.dentalclinic.api.dtos.reponses.ErrorResponse;
import ru.mirea.dentalclinic.api.dtos.reponses.RecordsResponse;
import ru.mirea.dentalclinic.api.dtos.requests.RecordRequest;
import ru.mirea.dentalclinic.api.mappers.RecordMapper;
import ru.mirea.dentalclinic.domain.models.Record;
import ru.mirea.dentalclinic.domain.service.RecordService;
import ru.mirea.dentalclinic.utils.result.Result;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @PostMapping("/book/{id}")
    public ResponseEntity<Object> bookRecordById(@PathVariable("id") Long id) {
        Result<Record> record = recordService.bookRecord(id);
        if (record.getResultType() == Result.ResultType.FAILURE) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Ошибка"));
        }
        Record recordValue = record.getValue();
        return ResponseEntity.ok().body(
                RecordMapper.mapFromDomain(recordValue)
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createRecord(@RequestBody RecordRequest recordRequest) {
        Result<Record> recordResult = recordService.createNewRecord(RecordMapper.mapToCreateModel(recordRequest));
        if (recordResult.getResultType() == Result.ResultType.FAILURE) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("Ошибка")
            );
        }
        Record record = recordResult.getValue();
        return ResponseEntity
                .ok()
                .body(RecordMapper.mapFromDomain(record));
    }

    @GetMapping("/date/{date}/{doctorId}")
    public ResponseEntity<Object> getRecordsByDate(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("date") Date date,
            @PathVariable("doctorId") Long doctorId
    ) {
        Result<List<Record>> records = recordService.getRecordByDateAndDoctorId(date, doctorId);
        if (records.isFailure()) {
            System.out.println(records.getException().getMessage());
            return ResponseEntity.badRequest().body(new ErrorResponse("Ошибка"));
        }
        return ResponseEntity.ok(new RecordsResponse(records.getValue().stream().map(RecordMapper::mapFromDomain).toList()));
    }

    @GetMapping
    public ResponseEntity<?> getRecords() {
        Result<List<Record>> recordResult = Result.runCatching(recordService::getRecords);
        if (recordResult.isFailure()) {
            return ResponseEntity.noContent().build();
        }
        List<Record> records = recordResult.getValue();
        return ResponseEntity.ok(new RecordsResponse(
                records.stream().map(RecordMapper::mapFromDomain).toList()
        ));
    }
}
