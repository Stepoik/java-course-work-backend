package ru.mirea.dentalclinic.api.mappers;

import ru.mirea.dentalclinic.api.dtos.PatientDto;
import ru.mirea.dentalclinic.domain.models.Patient;

public class PatientMapper {
    public static PatientDto mapToDto(Patient patient) {
        return new PatientDto(
                patient.id(),
                patient.firstName(),
                patient.lastName()
        );
    }
}
