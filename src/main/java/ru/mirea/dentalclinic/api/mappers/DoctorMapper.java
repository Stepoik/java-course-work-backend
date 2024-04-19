package ru.mirea.dentalclinic.api.mappers;

import ru.mirea.dentalclinic.api.dtos.DoctorDto;
import ru.mirea.dentalclinic.api.dtos.DoctorSpecializationDto;
import ru.mirea.dentalclinic.domain.models.Doctor;

public class DoctorMapper {
    public static DoctorDto mapFromDomain(Doctor doctor) {
        return new DoctorDto(
                doctor.id(),
                doctor.firstName(),
                doctor.middleName(),
                doctor.lastName(),
                doctor.image(),
                DoctorSpecializationDto.mapFromDomain(doctor.doctorSpec())
        );
    }
}
