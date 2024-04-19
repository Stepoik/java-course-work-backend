package ru.mirea.dentalclinic.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OfficeDto(
        @JsonProperty("id")
        Long id,
        @JsonProperty("number")
        Integer number,
        @JsonProperty("clinic")
        ClinicDto clinic
) {
}
