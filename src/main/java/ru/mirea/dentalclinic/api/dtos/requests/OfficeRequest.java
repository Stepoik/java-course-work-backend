package ru.mirea.dentalclinic.api.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OfficeRequest(
        @JsonProperty("number")
        Integer number,
        @JsonProperty("clinic_id")
        Long clinic_id
) {
}
