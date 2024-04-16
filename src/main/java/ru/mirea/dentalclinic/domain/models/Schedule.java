package ru.mirea.dentalclinic.domain.models;

public record Schedule(
        Integer id,
        Doctor doctor,
        Office office,
        Long start,
        Long end
) {
}
