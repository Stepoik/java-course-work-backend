package ru.mirea.dentalclinic.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.dentalclinic.api.mappers.PatientMapper;
import ru.mirea.dentalclinic.domain.models.Patient;
import ru.mirea.dentalclinic.domain.service.PatientService;
import ru.mirea.dentalclinic.utils.result.Result;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @GetMapping
    public ResponseEntity<?> getPatient() {
        Result<Patient> patientResult = Result.runCatching(patientService::getCurrentPatient);
        if (patientResult.isFailure()) {
            return ResponseEntity.status(HttpStatusCode.valueOf(403)).build();
        }
        return ResponseEntity.ok(PatientMapper.mapToDto(patientResult.getValue()));
    }
}
