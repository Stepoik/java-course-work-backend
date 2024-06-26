package ru.mirea.dentalclinic.api.mappers;

import org.springframework.stereotype.Component;
import ru.mirea.dentalclinic.api.dtos.ClinicDto;
import ru.mirea.dentalclinic.api.dtos.reponses.ClinicResponse;
import ru.mirea.dentalclinic.domain.models.Clinic;

@Component
public class ClinicMapper {
    public ClinicDto mapFromDomain(Clinic clinic) {
        return new ClinicDto(
                clinic.id(),
                clinic.address(),
                clinic.latitude(),
                clinic.longitude()
        );
    }
}
