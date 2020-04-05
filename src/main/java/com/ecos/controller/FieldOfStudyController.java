package com.ecos.controller;

import com.ecos.dto.FieldOfStudyDto;
import com.ecos.service.fieldofstudy.FieldOfStudyService;
import com.ecos.service.fieldofstudy.FieldOfStudyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/fieldOfStudy")
@RestController
@Slf4j
public class FieldOfStudyController {

    private final FieldOfStudyServiceImpl fieldOfStudyServiceImpl;

    public FieldOfStudyController(FieldOfStudyServiceImpl fieldOfStudyServiceImpl) {
        this.fieldOfStudyServiceImpl = fieldOfStudyServiceImpl;
    }

    @GetMapping
    public List<FieldOfStudyDto> getAllFieldsOfStudy() {
        log.info("Fetching all fields of study...");

        return fieldOfStudyServiceImpl.getAll();
    }

    @PostMapping
    public FieldOfStudyDto addFieldOfStudy (@RequestBody FieldOfStudyDto fieldOfStudyDto) {
        log.info("Creating new field of study..." + fieldOfStudyDto);
        return fieldOfStudyServiceImpl.create(fieldOfStudyDto);
    }
}
