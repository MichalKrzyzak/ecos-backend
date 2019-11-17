package com.ecos.controller;

import com.ecos.model.Student;
import com.ecos.repository.StudentRepository;
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
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/create")
    public Student postStudent(@RequestBody Student student) {
        return studentRepository.save(new Student(student.getFirstName(), student.getLastName(), student.getPeselNumber(), student.getCollegeId(), student.getFieldOfStudy()));
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<String> deleteStudentById (@PathVariable("id") long id) {
        System.out.println("Deleting student ID: " + id + "...");

        studentRepository.deleteById(id);

        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/peselNumber/{peselNumber}")
    public ResponseEntity<String> deleteStudentByPeselNumber (@PathVariable("peselNumber") long peselNumber) {
        System.out.println("Deleting student with PESEL number: " + peselNumber + "...");

        studentRepository.deleteByPeselNumber(peselNumber);

        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/collegeId/{collegeId}")
    public ResponseEntity<String> deleteStudentByCollegeId (@PathVariable("collegeId") int collegeId) {
        System.out.println("Deleting student with college ID: " + collegeId + "...");

        studentRepository.deleteByCollegeId(collegeId);

        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllStudents() {
        System.out.println("Deleting all students...");

        studentRepository.deleteAll();

        return new ResponseEntity<>("All students has been deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public List<Student> getAllStudents() {
        System.out.println("Getting all students...");

        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);

        return students;
    }

    @GetMapping("/get/peselNumber/{peselNumber}")
    public List<Student> findByPeselNumber(@PathVariable long peselNumber) {
        return studentRepository.findByPeselNumber(peselNumber);
    }

    @GetMapping("s/get/collegeId/{collegeId}")
    public List<Student> findByCollegeId(@PathVariable int collegeId) {
        return studentRepository.findByCollegeId(collegeId);
    }

    @GetMapping("/get/firstName/{firstName}")
    public List<Student> findByFirstName(@PathVariable String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @GetMapping("/get/lastName/{lastName}")
    public List<Student> findByLastName(@PathVariable String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @GetMapping("/get/fieldOfStudy/{fieldOfStudy}")
    public List<Student> findByFieldOfStudy(@PathVariable String fieldOfStudy) {
        return studentRepository.findByFieldOfStudy(fieldOfStudy);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("id") long id, @RequestBody Student student) {
        System.out.println("Updating student ID: " + id + "...");
        Optional<Student> studentData = studentRepository.findById(id);

        return getStudentResponseEntity(student, studentData);
    }

    private ResponseEntity<Student> getStudentResponseEntity(@RequestBody Student student, Optional<Student> studentData) {
        if (studentData.isPresent()) {
            Student _student = studentData.get();
            _student.setFirstName(student.getFirstName());
            _student.setLastName(student.getLastName());
            _student.setPeselNumber(student.getPeselNumber());
            _student.setCollegeId(student.getCollegeId());
            _student.setFieldOfStudy(student.getFieldOfStudy());

            return new ResponseEntity<>(studentRepository.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
