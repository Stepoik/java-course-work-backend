package ru.mirea.dentalclinic.data.mappers;

import ru.mirea.dentalclinic.data.entities.ProcedureEntity;
import ru.mirea.dentalclinic.domain.models.Procedure;

public class ProcedureMapper {
    public static Procedure mapToDomain(ProcedureEntity procedure) {
        return new Procedure(
                procedure.getId(),
                procedure.getName()
        );
    }
}
