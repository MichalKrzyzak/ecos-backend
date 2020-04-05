package com.ecos.controller;

import com.ecos.dto.AssignmentDto;
import com.ecos.service.assignment.AssignmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/assignment")
@RestController
@Slf4j
public class AssignmentController {
    private final AssignmentServiceImpl assignmentServiceImpl;

    public AssignmentController(AssignmentServiceImpl assignmentServiceImpl) {
        this.assignmentServiceImpl = assignmentServiceImpl;
    }

    @GetMapping
    public List<AssignmentDto> getAllAssignments() {
        log.info("Fetching all assignments...");

        return assignmentServiceImpl.getAll();
    }

    @PostMapping
    public AssignmentDto addAssignment (@RequestBody AssignmentDto assignmentDto) {
        log.info("Creating new assignment..." + assignmentDto);
        return assignmentServiceImpl.create(assignmentDto);
    }
}
