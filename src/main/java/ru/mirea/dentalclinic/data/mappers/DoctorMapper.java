package ru.mirea.dentalclinic.data.mappers;

import jakarta.validation.constraints.NotNull;
import ru.mirea.dentalclinic.data.entities.DoctorEntity;
import ru.mirea.dentalclinic.domain.models.Doctor;

public class DoctorMapper {
    public static Doctor mapToDomain(@NotNull DoctorEntity doctor) {
        return new Doctor(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getMiddleName(),
                SpecializationMapper.mapToDomain(doctor.getSpec()),
                doctor.getImage()
        );
    }

    public static DoctorEntity mapFromDomain(@NotNull Doctor doctor) {
        return new DoctorEntity(
                doctor.id(),
                doctor.firstName(),
                doctor.lastName(),
                doctor.middleName(),
                doctor.doctorSpec().name(),
                doctor.image()
        );
    }
}
