package ru.mirea.dentalclinic.data.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.dentalclinic.data.entities.DoctorEntity;
import ru.mirea.dentalclinic.data.mappers.DoctorMapper;
import ru.mirea.dentalclinic.data.repositories.DoctorRepository;
import ru.mirea.dentalclinic.domain.models.Doctor;
import ru.mirea.dentalclinic.domain.models.DoctorSpecialization;
import ru.mirea.dentalclinic.domain.models.Procedure;
import ru.mirea.dentalclinic.domain.service.DoctorService;
import ru.mirea.dentalclinic.domain.service.ProcedureService;
import ru.mirea.dentalclinic.exceptions.Constants;
import ru.mirea.dentalclinic.exceptions.ProcedureNotExist;
import ru.mirea.dentalclinic.exceptions.TableEntryNotExist;
import ru.mirea.dentalclinic.utils.result.Result;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final ProcedureService procedureService;
    @Override
    public List<Doctor> getDoctors() {
        return List.of();
    }

    @Override
    public List<Doctor> getDoctorByName(String query) {
        return doctorRepository.findByFirstNameContaining(query)
                .stream()
                .map(DoctorMapper::mapToDomain)
                .toList();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        Optional<DoctorEntity> doctor = doctorRepository.findById(id);
        if (doctor.isEmpty()) {
            throw new TableEntryNotExist(Constants.DOCTOR_NOT_EXIST);
        }
        return DoctorMapper.mapToDomain(doctor.get());
    }

    @Override
    public List<Doctor> getDoctorBySpecialization(DoctorSpecialization doctorSpecialization) {
        return null;
    }

    @Override
    public List<Doctor> getDoctorBySpecializationAndClinicId(DoctorSpecialization doctorSpecialization, Long clinicId) {
        return doctorRepository
                .getDoctorEntitiesBySpecAndClinicId(doctorSpecialization.name(), clinicId)
                .stream()
                .map(DoctorMapper::mapToDomain)
                .toList();
    }

    @Override
    public List<Doctor> getDoctorByProcedureName(String procedureName) {
        Procedure procedure = getProcedure(procedureName);
        return doctorRepository
                .getDoctorEntitiesByProceduresId(procedure.id())
                .stream().map(DoctorMapper::mapToDomain)
                .toList();
    }

    @Override
    public List<Doctor> getDoctorByProcedureAndClinicId(String procedureName, Long clientId) {
        Procedure procedure = getProcedure(procedureName);
        return doctorRepository
                .getDoctorEntitiesByProceduresIdAndClinicId(procedure.id(), clientId)
                .stream().map(DoctorMapper::mapToDomain)
                .toList();
    }

    private Procedure getProcedure(String procedureName) throws ProcedureNotExist {
        Result<Procedure> foundProcedure = procedureService.getProcedureByName(procedureName);
        if (foundProcedure.getResultType() == Result.ResultType.FAILURE) {
            throw new ProcedureNotExist();
        }
        return foundProcedure.getValue();
    }
}
