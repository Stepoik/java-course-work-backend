package ru.mirea.dentalclinic.data.mappers;

import jakarta.validation.constraints.NotNull;
import ru.mirea.dentalclinic.data.entities.ClinicEntity;
import ru.mirea.dentalclinic.data.entities.OfficeEntity;
import ru.mirea.dentalclinic.domain.models.Clinic;
import ru.mirea.dentalclinic.domain.models.Office;

public class OfficeMapper {
    public static Office mapToDomain(@NotNull OfficeEntity office) {

        Clinic clinic = null;
        if (office.getClinic() != null) {
            clinic = ClinicEntityMapper.mapToDomain(office.getClinic());
        }
        return new Office(
                office.getId(),
                office.getNumber(),
                clinic
        );
    }
}
