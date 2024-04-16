package ru.mirea.dentalclinic.domain.service;

import ru.mirea.dentalclinic.domain.models.Clinic;

import java.util.List;

public interface ClinicService {
    List<Clinic> getClinics();

    Clinic getClinicById(Long id);

    List<Clinic> getClinicsByAddress(String query);
}
