package ru.mirea.dentalclinic.api.dtos.reponses;

import ru.mirea.dentalclinic.api.dtos.ClinicDto;

import java.util.List;

public record ClinicResponse(
        List<ClinicDto> clinics
) {
}
