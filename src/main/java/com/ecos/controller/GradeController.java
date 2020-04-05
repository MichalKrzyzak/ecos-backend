package com.ecos.controller;

import com.ecos.dto.GradeDto;
import com.ecos.service.grade.GradeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/grade")
@RestController
@Slf4j
public class GradeController {
    private final GradeServiceImpl gradeService;

    public GradeController(GradeServiceImpl gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<GradeDto> getAllGrades() {
        log.info("Fetching all grades...");

        return gradeService.getAll();
    }

    @PutMapping
    public GradeDto addGrade(@RequestBody GradeDto gradeDto) {
        log.info("Creating new grade..." + gradeDto);

        return gradeService.create(gradeDto);
    }
}
