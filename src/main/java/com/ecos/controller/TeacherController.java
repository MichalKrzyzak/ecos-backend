package com.ecos.controller;

import com.ecos.dto.TeacherDto;
import com.ecos.service.teacher.TeacherServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/teachers")
@RestController
@Slf4j
public class TeacherController {
    private final TeacherServiceImpl teacherServiceImpl;

    public TeacherController(TeacherServiceImpl teacherServiceImpl) {
        this.teacherServiceImpl = teacherServiceImpl;
    }

    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        log.info("Fetching all teachers...");
        return teacherServiceImpl.getAll();
    }

    @GetMapping("/id/{id}")
    public Optional<TeacherDto> getTeacherById(@PathVariable("id") long id) {
        log.info("Fetching teacher with ID: " + id);
        return teacherServiceImpl.getById(id);
    }

    @PostMapping
    public TeacherDto addTeacher(@RequestBody TeacherDto teacherDto) {
        log.info("New teacher: " + teacherDto);
        return teacherServiceImpl.create(teacherDto);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable("id") long id) {
        log.info("Removing teacher: " + id);
        return teacherServiceImpl.deleteById(id);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<TeacherDto> updateTeacherById(@PathVariable("id") long id, @RequestBody TeacherDto teacherDto) {
        log.info("Updating teacher: " + id + "\nData: " + teacherDto.toString());
        return teacherServiceImpl.updateById(id, teacherDto);
    }
}
