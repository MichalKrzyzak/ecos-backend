package com.ecos.controller;

import com.ecos.dto.GradeDto;
import com.ecos.service.GradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/grade")
    public List<GradeDto> getAllGrades() {
        log.info("Fetching all grades...");

        return gradeService.getAllGrades();
    }

    @PutMapping("/grade")
    public GradeDto addGrade(@RequestBody GradeDto gradeDto) {
        log.info("Creating new grade..." + gradeDto);

        return gradeService.createGrade(gradeDto);
    }
}
