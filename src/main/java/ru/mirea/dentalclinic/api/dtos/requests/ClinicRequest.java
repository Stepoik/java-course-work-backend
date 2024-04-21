package ru.mirea.dentalclinic.api.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClinicRequest(
        @JsonProperty("address")
        String address,
        @JsonProperty("latitude")
        Float latitude,
        @JsonProperty("longitude")
        Float longitude
) {
}
