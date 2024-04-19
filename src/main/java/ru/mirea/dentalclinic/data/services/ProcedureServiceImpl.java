package ru.mirea.dentalclinic.data.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.dentalclinic.data.entities.ProcedureEntity;
import ru.mirea.dentalclinic.data.mappers.ProcedureMapper;
import ru.mirea.dentalclinic.data.repositories.ProcedureRepository;
import ru.mirea.dentalclinic.domain.models.Procedure;
import ru.mirea.dentalclinic.domain.service.ProcedureService;
import ru.mirea.dentalclinic.exceptions.ProcedureNotExist;
import ru.mirea.dentalclinic.utils.result.Result;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {
    private final ProcedureRepository procedureRepository;
    @Override
    public Result<Procedure> getProcedureByName(String procedureName) {
        Optional<ProcedureEntity> procedure = procedureRepository.findByName(procedureName);
        return procedure.map(p -> Result.success(ProcedureMapper.mapToDomain(p)))
                .orElseGet(() -> Result.failure(new ProcedureNotExist()));
    }

    @Override
    public List<Procedure> getProceduresByClinicId(Long clinicId) {
        List<ProcedureEntity> procedures = procedureRepository.findByClinicsId(clinicId);
        return procedures.stream()
                .map(ProcedureMapper::mapToDomain)
                .toList();
    }
}
