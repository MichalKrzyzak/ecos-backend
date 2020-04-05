package com.ecos.controller;

import com.ecos.dto.StudentDto;
import com.ecos.service.student.StudentService;
import com.ecos.service.student.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/students")
@RestController
@Slf4j
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        log.info("Fetching all students...");
        return studentService.getAll();
    }

    @GetMapping("/id/{id}")
    public Optional<StudentDto> getStudentById(@PathVariable("id") long id) {
        log.info("Fetching student with ID: " + id);
        return studentService.getById(id);
    }

    @PostMapping
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        log.info("New student: " + studentDto);
        return studentService.create(studentDto);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") long id) {
        log.info("Removing student: " + id);
        return studentService.deleteById(id);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable("id") long id, @RequestBody StudentDto studentDto) {
        log.info("Updating student: " + id + "\nData: " + studentDto.toString());
        return studentService.updateById(id, studentDto);
    }
}
