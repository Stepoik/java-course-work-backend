package ru.mirea.dentalclinic.domain.models;

import java.util.Date;

public record RecordCreateModel(
        Long id,
        Long doctorId,
        Long officeId,
        Integer start,
        Integer end,
        Boolean isBooked,
        Date day
) {
}
