package ru.mirea.dentalclinic.api.dtos.reponses;

import ru.mirea.dentalclinic.api.dtos.DoctorDto;
import ru.mirea.dentalclinic.api.dtos.DoctorSpecializationDto;

import java.util.List;

public record DoctorsSpecResponse(
        List<DoctorDto> doctors,
        String specialization
) {
}
