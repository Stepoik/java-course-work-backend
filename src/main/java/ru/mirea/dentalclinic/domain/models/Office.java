package ru.mirea.dentalclinic.domain.models;

public record Office(
        Long id,
        Integer number,
        Clinic clinic
) {
}
