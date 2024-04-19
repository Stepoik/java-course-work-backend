package ru.mirea.dentalclinic.api.mappers;

import ru.mirea.dentalclinic.api.dtos.ProcedureDto;
import ru.mirea.dentalclinic.domain.models.Procedure;

public class ProcedureMapper {
    public static ProcedureDto mapFromDomain(Procedure procedure) {
        return new ProcedureDto(
                procedure.name()
        );
    }
}
