package ru.mirea.dentalclinic.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record RecordDto(
        @JsonProperty("id")
        Long id,
        @JsonProperty("doctor")
        DoctorDto doctor,
        @JsonProperty("office")
        OfficeDto office,
        @JsonProperty("start_time")
        Integer start,
        @JsonProperty("end_time")
        Integer end,
        @JsonProperty("is_booked")
        Boolean isBooked,
        @JsonProperty("day")
        Date day
) {
}
