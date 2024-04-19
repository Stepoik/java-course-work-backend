package ru.mirea.dentalclinic.data.mappers;

import org.springframework.stereotype.Component;
import ru.mirea.dentalclinic.data.entities.ClinicEntity;
import ru.mirea.dentalclinic.domain.models.Clinic;

@Component
public class ClinicEntityMapper {
    public static Clinic mapToDomain(ClinicEntity clinic) {
        return new Clinic(
                clinic.getId(),
                clinic.getAddress(),
                clinic.getLatitude(),
                clinic.getLongitude()
        );
    }
}
