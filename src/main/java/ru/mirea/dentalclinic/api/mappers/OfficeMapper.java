package ru.mirea.dentalclinic.api.mappers;

import ru.mirea.dentalclinic.api.dtos.OfficeDto;
import ru.mirea.dentalclinic.domain.models.Office;

public class OfficeMapper {
    public static OfficeDto mapFromDomain(Office office) {
        return new OfficeDto(
                office.id(),
                office.number(),
                ClinicMapper.mapFromDomain(office.clinic())
        );
    }
}
