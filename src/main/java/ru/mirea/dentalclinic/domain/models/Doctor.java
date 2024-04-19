package ru.mirea.dentalclinic.domain.models;

public record Doctor(
        Long id,
        String firstName,
        String lastName,
        String middleName,
        DoctorSpecialization doctorSpec,
        String image
) {
}
