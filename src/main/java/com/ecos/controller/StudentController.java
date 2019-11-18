package com.ecos.controller;

import com.ecos.model.Student;
import com.ecos.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class StudentController  {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public Student postStudent(@RequestBody Student student) {
        log.info("New student: " + student);
        return studentService.createStudent(student);
    }

    @DeleteMapping("/students/id/{id}")
    public ResponseEntity<String> deleteStudentById (@PathVariable("id") long id) {
        log.info("Removing student: " + id);
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        log.info("Fetching all students...");
        return studentService.getAllStudents();
    }

    @GetMapping("/students/id/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") long id) {
        log.info("Fetching student with ID: " + id);
        return studentService.getStudentById(id);
    }

    @PutMapping("/students/id/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("id") long id, @RequestBody Student student) {
        log.info("Updating student: " + id + "\nData: " + student);
        return studentService.updateStudentById(id, student);
    }
}
