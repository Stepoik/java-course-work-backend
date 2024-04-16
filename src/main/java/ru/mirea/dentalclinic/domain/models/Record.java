package ru.mirea.dentalclinic.domain.models;

import java.util.Date;

public record Record(
        Integer id,
        Doctor doctor,
        Office office,
        Long start,
        Long end,
        Boolean isBooked,
        Date day
) {
}
