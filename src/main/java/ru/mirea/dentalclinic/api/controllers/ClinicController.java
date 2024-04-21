package ru.mirea.dentalclinic.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.dentalclinic.api.dtos.ClinicDto;
import ru.mirea.dentalclinic.api.dtos.reponses.ClinicsResponse;
import ru.mirea.dentalclinic.api.dtos.reponses.ErrorResponse;
import ru.mirea.dentalclinic.api.dtos.reponses.ProceduresResponse;
import ru.mirea.dentalclinic.api.dtos.requests.ClinicRequest;
import ru.mirea.dentalclinic.api.mappers.ClinicMapper;
import ru.mirea.dentalclinic.api.mappers.ClinicRequestMapper;
import ru.mirea.dentalclinic.api.mappers.ProcedureMapper;
import ru.mirea.dentalclinic.domain.models.Clinic;
import ru.mirea.dentalclinic.domain.models.Procedure;
import ru.mirea.dentalclinic.domain.service.ClinicService;
import ru.mirea.dentalclinic.utils.result.Result;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {

    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping
    @ResponseBody
    public ClinicsResponse getClinics() {
        List<ClinicDto> clinics = clinicService.getClinics().stream().map(
                ClinicMapper::mapFromDomain
        ).toList();
        return new ClinicsResponse(
                clinics
        );
    }

    @GetMapping("/{clinicId}/procedures")
    public ProceduresResponse getClinicProcedures(@PathVariable("clinicId") Long clinicId) {
        List<Procedure> procedures = clinicService.getProcedures(clinicId);
        return new ProceduresResponse(
                procedures
                        .stream()
                        .map(ProcedureMapper::mapFromDomain)
                        .toList()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createClinic(@RequestBody ClinicRequest clinic) {
        Result<Clinic> newClinic = clinicService.createClinic(ClinicRequestMapper.mapToDomain(clinic));
        if (newClinic.getResultType() == Result.ResultType.FAILURE) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Ошибка"));
        }
        return ResponseEntity.ok().body(ClinicMapper.mapFromDomain(newClinic.getValue()));
    }
}
