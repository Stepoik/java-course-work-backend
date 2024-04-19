package ru.mirea.dentalclinic.api.controllers;

import org.springframework.web.bind.annotation.*;
import ru.mirea.dentalclinic.api.dtos.ClinicDto;
import ru.mirea.dentalclinic.api.dtos.reponses.ClinicResponse;
import ru.mirea.dentalclinic.api.dtos.reponses.ProceduresResponse;
import ru.mirea.dentalclinic.api.mappers.ClinicMapper;
import ru.mirea.dentalclinic.api.mappers.ProcedureMapper;
import ru.mirea.dentalclinic.domain.models.Procedure;
import ru.mirea.dentalclinic.domain.service.ClinicService;

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
    public ClinicResponse getClinics() {
        List<ClinicDto> clinics = clinicService.getClinics().stream().map(
                ClinicMapper::mapFromDomain
        ).toList();
        return new ClinicResponse(
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
}
