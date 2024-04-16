package ru.mirea.dentalclinic.domain.models;

public record Office(
        Integer id,
        Integer number,
        Clinic clinic
) {
}
