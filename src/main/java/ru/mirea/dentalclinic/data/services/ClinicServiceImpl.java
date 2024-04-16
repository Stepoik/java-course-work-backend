package ru.mirea.dentalclinic.data.services;

import org.springframework.stereotype.Service;
import ru.mirea.dentalclinic.data.mappers.ClinicEntityMapper;
import ru.mirea.dentalclinic.data.repositories.ClinicRepository;
import ru.mirea.dentalclinic.domain.models.Clinic;
import ru.mirea.dentalclinic.domain.service.ClinicService;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {
    private final ClinicRepository clinicRepository;
    private final ClinicEntityMapper clinicEntityMapper;

    public ClinicServiceImpl(ClinicRepository clinicRepository, ClinicEntityMapper clinicEntityMapper) {
        this.clinicRepository = clinicRepository;
        this.clinicEntityMapper = clinicEntityMapper;
    }

    @Override
    public List<Clinic> getClinics() {
        return clinicRepository
                .findAll()
                .stream()
                .map(clinicEntityMapper::mapToDomain)
                .toList();
    }

    @Override
    public Clinic getClinicById(Long id) {
        return clinicRepository
                .findById(id)
                .stream()
                .map(clinicEntityMapper::mapToDomain)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Clinic> getClinicsByAddress(String query) {
        return null;
    }
}
