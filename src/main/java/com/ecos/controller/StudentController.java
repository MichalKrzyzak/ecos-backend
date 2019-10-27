package com.ecos.controller;

import com.ecos.model.Student;
import com.ecos.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/students/create")
    public Student postStudent(@RequestBody Student student) {
        return studentRepository.save(new Student(student.getFirstName(), student.getLastName(), student.getPeselNumber(), student.getCollegeId(), student.getFieldOfStudy()));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudentById (@PathVariable("id") long id) {
        System.out.println("Deleting student ID: " + id + "...");

        studentRepository.deleteById(id);

        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/students/{peselNumber}")
    public ResponseEntity<String> deleteStudentByPeselNumber (@PathVariable("peselNumber") int peselNumber) {
        System.out.println("Deleting student with PESEL number: " + peselNumber + "...");

        studentRepository.deleteByPeselNumber(peselNumber);

        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/students/{collegeId}")
    public ResponseEntity<String> deleteStudentByCollegeId (@PathVariable("collegeId") int collegeId) {
        System.out.println("Deleting student with college ID: " + collegeId + "...");

        studentRepository.deleteByCollegeId(collegeId);

        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/students/delete")
    public ResponseEntity<String> deleteAllStudents() {
        System.out.println("Deleting all students...");

        studentRepository.deleteAll();

        return new ResponseEntity<>("All students has been deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        System.out.println("Getting all students...");

        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);

        return students;
    }

    @GetMapping("students/peselNumber/{peselNumber}")
    public List<Student> findByPeselNumber(@PathVariable int peselNumber) {
        return studentRepository.findByPeselNumber(peselNumber);
    }

    @GetMapping("students/collegeId/{collegeId}")
    public List<Student> findByCollegeId(@PathVariable int collegeId) {
        return studentRepository.findByCollegeId(collegeId);
    }

    @GetMapping("students/firstName/{firstName}")
    public List<Student> findByFirstName(@PathVariable String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @GetMapping("students/lastName/{lastName}")
    public List<Student> findByLastName(@PathVariable String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @GetMapping("students/fieldOfStudy/{fieldOfStudy}")
    public List<Student> findByFieldOfStudy(@PathVariable String fieldOfStudy) {
        return studentRepository.findByFieldOfStudy(fieldOfStudy);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("id") long id, @RequestBody Student student) {
        System.out.println("Updating student ID: " + id + "...");
        Optional<Student> studentData = studentRepository.findById(id);

        return getStudentResponseEntity(student, studentData);
    }

    @PutMapping("/students/{collegeId}")
    public ResponseEntity<Student> updateStudentByCollegeId(@PathVariable("collegeId") int collegeId, @RequestBody Student student) {
        System.out.println("Updating student with college ID: " + collegeId + "...");
        Optional<Student> studentData = studentRepository.findByCollegeIdOptional(collegeId);

        return getStudentResponseEntity(student, studentData);
    }

    @PutMapping("/students/{peselNumber}")
    public ResponseEntity<Student> updateStudentByPeselNumber(@PathVariable("peselNumber") int peselNumber, @RequestBody Student student) {
        System.out.println("Updating student PESEL number: " + peselNumber + "...");
        Optional<Student> studentData = studentRepository.findByPeselNumberOptional(peselNumber);

        return getStudentResponseEntity(student, studentData);
    }

    @PutMapping("/students/{fieldOfStudy}")
    public ResponseEntity<Student> updateStudentByPeselNumber(@PathVariable("fieldOfStudy") String fieldOfStudy, @RequestBody Student student) {
        System.out.println("Updating student with field of study: " + fieldOfStudy + "...");
        Optional<Student> studentData = studentRepository.findByFieldOfStudyOptional(fieldOfStudy);

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
