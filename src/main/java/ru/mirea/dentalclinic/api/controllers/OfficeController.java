package ru.mirea.dentalclinic.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.dentalclinic.api.dtos.OfficeDto;
import ru.mirea.dentalclinic.api.dtos.requests.OfficeRequest;
import ru.mirea.dentalclinic.api.mappers.OfficeMapper;
import ru.mirea.dentalclinic.domain.models.Office;
import ru.mirea.dentalclinic.domain.service.OfficeService;
import ru.mirea.dentalclinic.utils.result.Result;

@RestController
@RequestMapping("/office")
@RequiredArgsConstructor
public class OfficeController {
    private final OfficeService officeService;
    @PostMapping("create")
    public ResponseEntity<OfficeDto> createOffice(@RequestBody OfficeRequest officeRequest) {
        System.out.println(officeRequest);
        Result<Office> officeResult = officeService.create(officeRequest);
        if (officeResult.isFailure()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(OfficeMapper.mapFromDomain(officeResult.getValue()));
    }
}
