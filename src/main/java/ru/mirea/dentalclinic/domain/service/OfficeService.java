package ru.mirea.dentalclinic.domain.service;

import ru.mirea.dentalclinic.api.dtos.requests.OfficeRequest;
import ru.mirea.dentalclinic.domain.models.Office;
import ru.mirea.dentalclinic.utils.result.Result;

public interface OfficeService {
    Result<Office> create(OfficeRequest officeRequest);
}
