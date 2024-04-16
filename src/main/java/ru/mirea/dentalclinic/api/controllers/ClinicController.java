package ru.mirea.dentalclinic.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.dentalclinic.api.dtos.ClinicDto;
import ru.mirea.dentalclinic.api.dtos.reponses.ClinicResponse;
import ru.mirea.dentalclinic.api.mappers.ClinicMapper;
import ru.mirea.dentalclinic.domain.models.Clinic;
import ru.mirea.dentalclinic.domain.service.ClinicService;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {

    private final ClinicMapper clinicMapper;

    private final ClinicService clinicService;

    public ClinicController(ClinicMapper clinicMapper, ClinicService clinicService) {
        this.clinicMapper = clinicMapper;
        this.clinicService = clinicService;
    }

    @GetMapping
    @ResponseBody
    public ClinicResponse getClinics() {
        List<ClinicDto> clinics = clinicService.getClinics().stream().map(
                clinicMapper::mapFromDomain
        ).toList();
        return new ClinicResponse(
                clinics
        );
    }
}
