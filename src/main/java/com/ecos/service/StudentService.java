package com.ecos.service;

import com.ecos.model.Student;
import com.ecos.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    protected ResponseEntity<Student> getStudentResponseEntity(@RequestBody Student student, Optional<Student> studentData) {
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
