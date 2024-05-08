package ru.mirea.dentalclinic.data.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.dentalclinic.data.entities.PatientEntity;
import ru.mirea.dentalclinic.data.entities.UserEntity;
import ru.mirea.dentalclinic.data.mappers.PatientMapper;
import ru.mirea.dentalclinic.data.repositories.PatientRepository;
import ru.mirea.dentalclinic.domain.models.Patient;
import ru.mirea.dentalclinic.domain.models.User;
import ru.mirea.dentalclinic.domain.service.PatientService;
import ru.mirea.dentalclinic.domain.service.UserService;
import ru.mirea.dentalclinic.utils.JwtService;
import ru.mirea.dentalclinic.utils.result.Result;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final UserService userService;
    private final PatientRepository patientRepository;

    @Override
    public Patient getCurrentPatient() {
        Result<UserEntity> userResult = userService.getCurrentUser();
        if (userResult.isFailure()) {
            throw new RuntimeException(userResult.getException());
        }
        UserEntity user = userResult.getValue();
        Optional<PatientEntity> patient = patientRepository.getPatientEntityByUserId(user.getId());
        if (patient.isEmpty()) {
            throw new RuntimeException();
        }
        return PatientMapper.mapToDomain(patient.get());
    }

    @Override
    public void createPatient(String firstName, String lastName, UserEntity user) {
        PatientEntity patient = new PatientEntity(
                null,
                firstName,
                lastName,
                user
        );
        patientRepository.save(patient);
    }
}
