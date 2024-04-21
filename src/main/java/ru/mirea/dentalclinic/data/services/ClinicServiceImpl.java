package ru.mirea.dentalclinic.data.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.dentalclinic.data.entities.ClinicEntity;
import ru.mirea.dentalclinic.data.entities.ProcedureEntity;
import ru.mirea.dentalclinic.data.mappers.ClinicEntityMapper;
import ru.mirea.dentalclinic.data.repositories.ClinicRepository;
import ru.mirea.dentalclinic.data.repositories.ProcedureRepository;
import ru.mirea.dentalclinic.domain.models.Clinic;
import ru.mirea.dentalclinic.domain.models.Procedure;
import ru.mirea.dentalclinic.domain.service.ClinicService;
import ru.mirea.dentalclinic.domain.service.ProcedureService;
import ru.mirea.dentalclinic.utils.result.Result;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicServiceImpl implements ClinicService {
    private final ClinicRepository clinicRepository;
    private final ProcedureService procedureService;


    @Override
    public List<Clinic> getClinics() {
        return clinicRepository
                .findAll()
                .stream()
                .map(ClinicEntityMapper::mapToDomain)
                .toList();
    }

    @Override
    public Clinic getClinicById(Long id) {
        return clinicRepository
                .findById(id)
                .stream()
                .map(ClinicEntityMapper::mapToDomain)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Clinic> getClinicsByAddress(String query) {
        return null;
    }

    @Override
    public List<Procedure> getProcedures(Long clinicId) {
        return procedureService.getProceduresByClinicId(clinicId);
    }

    @Override
    public Result<Clinic> createClinic(Clinic clinic) {
        return Result.runCatching(() -> ClinicEntityMapper.mapToDomain(clinicRepository.save(ClinicEntityMapper.mapFromDomain(clinic))));
    }
}
