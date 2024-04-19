package ru.mirea.dentalclinic.api.dtos.reponses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorResponse(
        @JsonProperty("error")
        String error
) {
}
