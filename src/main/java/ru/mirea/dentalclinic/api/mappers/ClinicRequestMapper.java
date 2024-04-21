package ru.mirea.dentalclinic.api.mappers;

import ru.mirea.dentalclinic.api.dtos.requests.ClinicRequest;
import ru.mirea.dentalclinic.domain.models.Clinic;

public class ClinicRequestMapper {
    public static Clinic mapToDomain(ClinicRequest clinicRequest) {
        return new Clinic(
            null,
                clinicRequest.address(),
                clinicRequest.latitude(),
                clinicRequest.longitude()
        );
    }
}
