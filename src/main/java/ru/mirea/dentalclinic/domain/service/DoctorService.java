package ru.mirea.dentalclinic.domain.service;

import ru.mirea.dentalclinic.domain.models.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getDoctors();

    List<Doctor> getDoctorByName(String query);

    Doctor getDoctorById(Integer id);
}
