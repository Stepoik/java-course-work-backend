package ru.mirea.dentalclinic.api.dtos.reponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.mirea.dentalclinic.api.dtos.ProcedureDto;

import java.util.List;

public record ProceduresResponse(
        @JsonProperty("procedures")
        List<ProcedureDto> procedures
) {
}
