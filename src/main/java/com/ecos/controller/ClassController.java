package com.ecos.controller;

import com.ecos.dto.ClassDto;
import com.ecos.service.classes.ClassServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/class")
@RestController
@Slf4j
public class ClassController {
    private final ClassServiceImpl classService;

    public ClassController(ClassServiceImpl classService) {
        this.classService = classService;
    }

    @GetMapping
    public List<ClassDto> getAllFieldsOfStudy() {
        log.info("Fetching all classes...");

        return classService.getAll();
    }

    @PostMapping
    public ClassDto addFieldOfStudy (@RequestBody ClassDto classDto) {
        log.info("Creating class..." + classDto);
        return classService.create(classDto);
    }
}
