package com.ecos.service;

import com.ecos.model.Student;
import com.ecos.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Optional<Student> getStudentById(long id) {
        return studentRepository.findById(id);
    }

    public ResponseEntity<String> deleteStudentById (@PathVariable("id") long id) {
        studentRepository.deleteById(id);
        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(new Student(student.getFirstName(), student.getLastName(), student.getPeselNumber(), student.getCollegeId(), student.getFieldOfStudy()));
    }

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
