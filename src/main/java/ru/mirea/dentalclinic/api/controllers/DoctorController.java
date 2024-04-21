package ru.mirea.dentalclinic.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.dentalclinic.api.dtos.DoctorDto;
import ru.mirea.dentalclinic.api.dtos.DoctorSpecializationDto;
import ru.mirea.dentalclinic.api.dtos.reponses.DoctorsResponse;
import ru.mirea.dentalclinic.api.dtos.reponses.DoctorsSpecResponse;
import ru.mirea.dentalclinic.api.dtos.reponses.ErrorResponse;
import ru.mirea.dentalclinic.api.mappers.DoctorMapper;
import ru.mirea.dentalclinic.domain.models.Doctor;
import ru.mirea.dentalclinic.domain.service.DoctorService;
import ru.mirea.dentalclinic.utils.result.Result;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/specialization/{specialization}/{clinicId}")
    public DoctorsSpecResponse getDoctorsBySpecialization(
            @PathVariable(value = "clinicId") Long clinicId,
            @PathVariable(value = "specialization") DoctorSpecializationDto specialization
    ) {
        List<DoctorDto> doctors = doctorService
                .getDoctorBySpecializationAndClinicId(specialization.mapToDomain(), clinicId)
                .stream()
                .map(DoctorMapper::mapFromDomain)
                .toList();
        return new DoctorsSpecResponse(
                doctors,
                specialization
        );
    }

    @GetMapping("/procedure/{procedure}")
    public ResponseEntity<Object> getDoctorByProcedure(
            @PathVariable("procedure") String procedure,
            @RequestParam(value = "clinic_id", required = false) Long clinicId
    ) {
        Result<List<Doctor>> doctors;
        if (clinicId == null) {
            doctors = Result.runCatching(() -> doctorService.getDoctorByProcedureName(procedure));
        } else {
            doctors = Result.runCatching(() -> doctorService.getDoctorByProcedureAndClinicId(procedure, clinicId));
        }
        if (doctors.getResultType() == Result.ResultType.FAILURE) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Ошибка"));
        }
        return ResponseEntity.ok(new DoctorsResponse(
                doctors.getValue().stream()
                        .map(DoctorMapper::mapFromDomain)
                        .toList()
        ));
    }

    @GetMapping("/best/{page}")
    public ResponseEntity<Object> getDoctorsWithBestRate(
           @PathVariable("page") Integer page
    ) {
        Result<List<Doctor>> doctors = doctorService.getBestDoctors(page);
        if (doctors.getResultType() == Result.ResultType.FAILURE) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(doctors.getException().getMessage()));
        }
        return ResponseEntity.ok(new DoctorsResponse(
                doctors.getValue().stream()
                        .map(DoctorMapper::mapFromDomain)
                        .toList()
        ));
    }


    @GetMapping("/{name}")
    public DoctorsResponse getDoctorsByName(
            @PathVariable("name") String name
    ) {
        List<Doctor> doctors = doctorService.getDoctorByName(name);
        return new DoctorsResponse(
                doctors.stream()
                        .map(DoctorMapper::mapFromDomain)
                        .toList()
        );
    }

    @PostMapping("/create")
    public DoctorDto createDoctor(
            @RequestBody DoctorDto doctorDto
    ) {
        Result<Doctor> doctorResult = doctorService.createDoctor(DoctorMapper.mapToDomain(doctorDto));
        return DoctorMapper.mapFromDomain(doctorResult.getValue());
    }
}
