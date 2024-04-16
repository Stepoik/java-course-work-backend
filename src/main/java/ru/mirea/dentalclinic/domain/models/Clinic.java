package ru.mirea.dentalclinic.domain.models;

public record Clinic(
        Long id,
        String address,
        Float latitude,
        Float longitude
) {
}
