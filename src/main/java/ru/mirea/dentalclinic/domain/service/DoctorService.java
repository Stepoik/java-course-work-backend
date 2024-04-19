package ru.mirea.dentalclinic.domain.service;

import ru.mirea.dentalclinic.api.dtos.DoctorSpecializationDto;
import ru.mirea.dentalclinic.domain.models.Doctor;
import ru.mirea.dentalclinic.domain.models.DoctorSpecialization;
import ru.mirea.dentalclinic.domain.models.Procedure;
import ru.mirea.dentalclinic.exceptions.ProcedureNotExist;

import java.util.List;

public interface DoctorService {
    List<Doctor> getDoctors();

    List<Doctor> getDoctorByName(String query);

    Doctor getDoctorById(Long id);

    List<Doctor> getDoctorBySpecialization(DoctorSpecialization doctorSpecialization);

    List<Doctor> getDoctorBySpecializationAndClinicId(DoctorSpecialization doctorSpecialization, Long clinicId);

    List<Doctor> getDoctorByProcedureName(String procedureName);

    List<Doctor> getDoctorByProcedureAndClinicId(String procedureName, Long clientId);
}
