package ru.mirea.dentalclinic.domain.service;

import ru.mirea.dentalclinic.domain.models.Procedure;
import ru.mirea.dentalclinic.utils.result.Result;

import java.util.List;

public interface ProcedureService {
    Result<Procedure> getProcedureByName(String procedureName);

    List<Procedure> getProceduresByClinicId(Long clinicId);

    Boolean isProcedureExist(Long procedureId);
}
