package ru.mirea.dentalclinic.data.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.dentalclinic.api.dtos.requests.OfficeRequest;
import ru.mirea.dentalclinic.api.mappers.ClinicMapper;
import ru.mirea.dentalclinic.data.entities.ClinicEntity;
import ru.mirea.dentalclinic.data.entities.OfficeEntity;
import ru.mirea.dentalclinic.data.mappers.OfficeMapper;
import ru.mirea.dentalclinic.data.repositories.OfficeRepository;
import ru.mirea.dentalclinic.domain.models.Clinic;
import ru.mirea.dentalclinic.domain.models.Office;
import ru.mirea.dentalclinic.domain.service.ClinicService;
import ru.mirea.dentalclinic.domain.service.OfficeService;
import ru.mirea.dentalclinic.domain.service.UserService;
import ru.mirea.dentalclinic.utils.result.Result;

@RequiredArgsConstructor
@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository officeRepository;
    private final ClinicService clinicService;
    @Override
    public Result<Office> create(OfficeRequest officeRequest) {
        OfficeEntity newOffice = new OfficeEntity();
        newOffice.setNumber(officeRequest.number());
        Clinic currentClinic = clinicService.getClinicById(officeRequest.clinic_id());
        ClinicEntity clinic = new ClinicEntity();
        clinic.setId(currentClinic.id());
        clinic.setAddress(currentClinic.address());
        clinic.setLatitude(clinic.getLatitude());
        clinic.setLongitude(clinic.getLongitude());
        newOffice.setClinic(clinic);
        OfficeEntity office = officeRepository.save(newOffice);
        return Result.success(OfficeMapper.mapToDomain(office));
    }
}
