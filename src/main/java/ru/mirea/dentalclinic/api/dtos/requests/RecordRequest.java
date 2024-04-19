package ru.mirea.dentalclinic.api.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record RecordRequest(
        @JsonProperty("doctor_id")
        Long doctorId,
        @JsonProperty("office_id")
        Long officeId,
        @JsonProperty("start")
        Integer start,
        @JsonProperty("end")
        Integer end,
        @JsonProperty("is_booked")
        Boolean isBooked,
        @JsonProperty("day")
        Date day
) {
}
