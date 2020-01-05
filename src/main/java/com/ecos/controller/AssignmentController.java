package com.ecos.controller;

import com.ecos.dto.AssignmentDto;
import com.ecos.service.AssignmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/assignment")
    public List<AssignmentDto> getAllAssignments() {
        log.info("Fetching all assignments...");

        return assignmentService.getAllAssignments();
    }

    @PostMapping("/assignment")
    public AssignmentDto addAssignment (@RequestBody AssignmentDto assignmentDto) {
        log.info("Creating new assignment..." + assignmentDto);
        return assignmentService.createAssignment(assignmentDto);
    }
}
