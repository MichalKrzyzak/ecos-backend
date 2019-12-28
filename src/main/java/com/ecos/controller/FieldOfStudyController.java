package com.ecos.controller;

import com.ecos.dto.FieldOfStudyDto;
import com.ecos.service.FieldOfStudyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class FieldOfStudyController {

    private final FieldOfStudyService fieldOfStudyService;

    public FieldOfStudyController(FieldOfStudyService fieldOfStudyService) {
        this.fieldOfStudyService = fieldOfStudyService;
    }

    @GetMapping("/fieldOfStudy")
    public List<FieldOfStudyDto> getAllFieldsOfStudy() {
        log.info("Fetching all fields of study...");

        return fieldOfStudyService.getAllFieldsOfStudy();
    }

    @PostMapping("/fieldOfStudy")
    public FieldOfStudyDto addFieldOfStudy (@RequestBody FieldOfStudyDto fieldOfStudyDto) {
        log.info("Creating new field of study...");
        return fieldOfStudyService.createFieldOfStudy(fieldOfStudyDto);
    }

}
