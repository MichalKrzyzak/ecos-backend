package com.ecos.controller;

import com.ecos.model.Student;
import com.ecos.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController  {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public Student postStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/students/id/{id}")
    public ResponseEntity<String> deleteStudentById (@PathVariable("id") long id) {
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/students/id/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("id") long id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }
}
