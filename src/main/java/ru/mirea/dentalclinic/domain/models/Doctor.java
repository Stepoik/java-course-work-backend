package ru.mirea.dentalclinic.domain.models;

public record Doctor(
        Integer id,
        String firstName,
        String lastName,
        String middleName,
        DoctorSpecialization doctorSpec,
        String image
) {
}
