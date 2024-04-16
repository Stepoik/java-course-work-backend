package ru.mirea.dentalclinic.api.dtos;

public record ClinicDto(
        Long id,
        String address,
        Float latitude,
        Float longitude
) {
}
