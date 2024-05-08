package ru.mirea.dentalclinic.data.mappers;

import ru.mirea.dentalclinic.data.entities.PatientEntity;
import ru.mirea.dentalclinic.domain.models.Patient;

public class PatientMapper {
    public static Patient mapToDomain(PatientEntity patient) {
        return new Patient(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName()
        );
    }
}
