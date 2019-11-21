package com.ecos.controller;

import com.ecos.dto.StudentDto;
import com.ecos.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentDto> getAllStudents() {
        log.info("Fetching all students...");
        return studentService.getAllStudents();
    }

    @GetMapping("/students/id/{id}")
    public Optional<StudentDto> getStudentById(@PathVariable("id") long id) {
        log.info("Fetching student with ID: " + id);
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        log.info("New student: " + studentDto);
        return studentService.createStudent(studentDto);
    }

    @DeleteMapping("/students/id/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") long id) {
        log.info("Removing student: " + id);
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/students/id/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable("id") long id, @RequestBody StudentDto studentDto) {
        log.info("Updating student: " + id + "\nData: " + studentDto);
        return studentService.updateStudentById(id, studentDto);
    }
}
