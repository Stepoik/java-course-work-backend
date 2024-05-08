package ru.mirea.dentalclinic.domain.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.mirea.dentalclinic.data.entities.UserEntity;
import ru.mirea.dentalclinic.domain.models.Patient;
import ru.mirea.dentalclinic.utils.result.Result;

public interface PatientService {
    Patient getCurrentPatient();

    void createPatient(String firstName, String lastName, UserEntity user);
}
