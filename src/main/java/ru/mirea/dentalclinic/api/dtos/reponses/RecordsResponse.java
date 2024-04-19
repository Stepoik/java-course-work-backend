package ru.mirea.dentalclinic.api.dtos.reponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.mirea.dentalclinic.api.dtos.RecordDto;

import java.util.List;

public record RecordsResponse(
        @JsonProperty("records")
        List<RecordDto> records
) {
}
