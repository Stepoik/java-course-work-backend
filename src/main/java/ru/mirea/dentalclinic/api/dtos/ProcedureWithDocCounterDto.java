package ru.mirea.dentalclinic.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProcedureWithDocCounterDto(
        @JsonProperty("name")
        String name,
        @JsonProperty("doctor_count")
        Integer count
) {
}
