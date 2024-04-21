package ru.mirea.dentalclinic.domain.models;

public record ProcedureWithDocCount(
        String name,
        Integer count
) {
}
