package ru.mirea.dentalclinic.domain.models;

import java.util.Date;

public record Record(
        Long id,
        Doctor doctor,
        Office office,
        Integer start,
        Integer end,
        Boolean isBooked,
        Date day
) {
}
