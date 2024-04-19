package ru.mirea.dentalclinic.api.dtos.reponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.mirea.dentalclinic.api.dtos.DoctorDto;

import java.util.List;

public record DoctorsResponse(
        @JsonProperty("doctors")
        List<DoctorDto> doctors
) {
}
