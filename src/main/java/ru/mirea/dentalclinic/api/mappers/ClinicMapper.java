package ru.mirea.dentalclinic.api.mappers;

import ru.mirea.dentalclinic.api.dtos.ClinicDto;
import ru.mirea.dentalclinic.domain.models.Clinic;

public class ClinicMapper {
    public static ClinicDto mapFromDomain(Clinic clinic) {
        return new ClinicDto(
                clinic.id(),
                clinic.address(),
                clinic.latitude(),
                clinic.longitude()
        );
    }
}
