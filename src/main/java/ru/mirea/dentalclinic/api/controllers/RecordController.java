package ru.mirea.dentalclinic.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.dentalclinic.api.dtos.RecordDto;
import ru.mirea.dentalclinic.api.dtos.reponses.ErrorResponse;
import ru.mirea.dentalclinic.api.dtos.reponses.RecordsResponse;
import ru.mirea.dentalclinic.domain.models.Record;
import ru.mirea.dentalclinic.domain.service.RecordService;
import ru.mirea.dentalclinic.utils.result.Result;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;
    @PostMapping("/book/{id}")
    public ResponseEntity<Object> bookRecordById(@PathVariable("id") Long id) {
        Result<Record> record = Result.runCatching(() -> recordService.bookRecord(id));
        if (record.getResultType() == Result.ResultType.FAILURE) {
            return ResponseEntity.badRequest().body(new ErrorResponse(record.getException().getMessage()));
        }
        return ResponseEntity.ok(
                new RecordDto(

                )
        );
    }
}
