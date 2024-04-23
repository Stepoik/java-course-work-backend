package ru.mirea.dentalclinic.api.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.dentalclinic.api.dtos.ProcedureDto;
import ru.mirea.dentalclinic.api.dtos.ProcedureWithDocCounterDto;
import ru.mirea.dentalclinic.api.dtos.reponses.ErrorResponse;
import ru.mirea.dentalclinic.api.dtos.reponses.ProcedureWithDocCounterResponse;
import ru.mirea.dentalclinic.api.dtos.reponses.ProceduresResponse;
import ru.mirea.dentalclinic.api.mappers.ProcedureMapper;
import ru.mirea.dentalclinic.domain.models.Procedure;
import ru.mirea.dentalclinic.domain.models.ProcedureWithDocCount;
import ru.mirea.dentalclinic.domain.service.ProcedureService;
import ru.mirea.dentalclinic.utils.result.Result;

import java.util.List;

@RestController
@RequestMapping("/procedure")
@RequiredArgsConstructor
public class ProcedureController {
    private final ProcedureService procedureService;

    @GetMapping
    public ResponseEntity<Object> getProcedures() {
        Result<List<ProcedureWithDocCount>> procedureResult = procedureService.getProceduresWithCount();
        if (procedureResult.isFailure()) {
            return ResponseEntity.badRequest().body(new ErrorResponse(procedureResult.getException().getMessage()));
        }
        List<ProcedureWithDocCount> procedures = procedureResult.getValue();
        return ResponseEntity.ok().body(
                new ProcedureWithDocCounterResponse(
                        procedures.stream()
                                .map((procedure) -> new ProcedureWithDocCounterDto(
                                        procedure.name(),
                                        procedure.count()
                                )).toList()
                )
        );
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<Object> getProceduresByDoctorId(
            @PathVariable("doctorId") Long doctorId
    ) {
        List<ProcedureDto> procedures = procedureService.getProceduresByDoctorId(doctorId).stream().map(ProcedureMapper::mapFromDomain).toList();
        return ResponseEntity.ok().body(new ProceduresResponse(procedures));
    }
}
