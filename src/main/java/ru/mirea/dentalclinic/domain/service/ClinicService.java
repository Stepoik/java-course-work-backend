package ru.mirea.dentalclinic.domain.service;

import ru.mirea.dentalclinic.domain.models.Clinic;
import ru.mirea.dentalclinic.domain.models.Procedure;

import java.util.List;

public interface ClinicService {
    List<Clinic> getClinics();

    Clinic getClinicById(Long id);

    List<Clinic> getClinicsByAddress(String query);

    List<Procedure> getProcedures(Long clinicId);
}
