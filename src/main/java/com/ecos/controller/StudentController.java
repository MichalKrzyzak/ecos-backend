package com.ecos.controller;

import com.ecos.model.Student;
import com.ecos.repository.StudentRepository;
import com.ecos.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController extends StudentService {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        super(studentRepository);
        this.studentRepository = studentRepository;
    }

    @PostMapping()
    public Student postStudent(@RequestBody Student student) {
        return studentRepository.save(new Student(student.getFirstName(), student.getLastName(), student.getPeselNumber(), student.getCollegeId(), student.getFieldOfStudy()));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteStudentById (@PathVariable("id") long id) {
        System.out.println("Deleting student ID: " + id + "...");

        studentRepository.deleteById(id);

        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        System.out.println("Getting all students...");

        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);

        return students;
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("id") long id, @RequestBody Student student) {
        System.out.println("Updating student ID: " + id + "...");
        Optional<Student> studentData = studentRepository.findById(id);

        return getStudentResponseEntity(student, studentData);
    }
}
