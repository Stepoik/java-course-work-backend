package ru.mirea.dentalclinic.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PatientDto(
        @JsonProperty("id")
        Long id,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName
) {
}
