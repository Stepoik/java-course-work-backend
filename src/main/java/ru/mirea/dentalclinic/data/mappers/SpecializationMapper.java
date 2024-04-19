package ru.mirea.dentalclinic.data.mappers;

import ru.mirea.dentalclinic.domain.models.DoctorSpecialization;


public class SpecializationMapper {
    static DoctorSpecialization mapToDomain(String spec) {
        return DoctorSpecialization.valueOf(spec);
    }
}
