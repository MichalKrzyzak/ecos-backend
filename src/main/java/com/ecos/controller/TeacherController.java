package com.ecos.controller;

import com.ecos.dto.TeacherDto;
import com.ecos.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<TeacherDto> getAllTeachers() {
        log.info("Fetching all teachers...");
        return teacherService.getAllTeachers();
    }

    @GetMapping("/teachers/id/{id}")
    public Optional<TeacherDto> getTeacherById(@PathVariable("id") long id) {
        log.info("Fetching teacher with ID: " + id);
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/teachers")
    public TeacherDto addTeacher(@RequestBody TeacherDto teacherDto) {
        log.info("New teacher: " + teacherDto);
        return teacherService.createTeacher(teacherDto);
    }

    @DeleteMapping("/teachers/id/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable("id") long id) {
        log.info("Removing teacher: " + id);
        return teacherService.deleteTeacherById(id);
    }

    @PutMapping("/teachers/id/{id}")
    public ResponseEntity<TeacherDto> updateTeacherById(@PathVariable("id") long id, @RequestBody TeacherDto teacherDto) {
        log.info("Updating teacher: " + id + "\nData: " + teacherDto.toString());
        return teacherService.updateTeacherById(id, teacherDto);
    }
}
