package ru.mirea.dentalclinic.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DoctorDto(
        @JsonProperty("id")
        Long id,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("middle_name")
        String middleName,
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("image")
        String image,
        @JsonProperty("specialization")
        DoctorSpecializationDto doctorSpecializationDto

) {
}
