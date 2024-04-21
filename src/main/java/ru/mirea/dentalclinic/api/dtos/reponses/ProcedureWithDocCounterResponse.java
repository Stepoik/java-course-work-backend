package ru.mirea.dentalclinic.api.dtos.reponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.mirea.dentalclinic.api.dtos.ProcedureWithDocCounterDto;

import java.util.List;

public record ProcedureWithDocCounterResponse(
        @JsonProperty("procedures")
        List<ProcedureWithDocCounterDto> procedures
) {
}
