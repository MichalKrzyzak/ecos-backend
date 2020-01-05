package com.ecos.service;

import com.ecos.common.StudentConverter;
import com.ecos.dto.StudentDto;
import com.ecos.model.StudentEntity;
import com.ecos.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    public StudentService(StudentRepository studentRepository, StudentConverter studentConverter) {
        this.studentRepository = studentRepository;
        this.studentConverter = studentConverter;
    }

    public List<StudentDto> getAllStudents() {
        List<StudentEntity> students = new ArrayList<>(studentRepository.findAll());

        return students.stream()
                .map(studentConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<StudentDto> getStudentById(long id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        return student.map(studentConverter::convertToDto);
    }

    public ResponseEntity<String> deleteStudentById(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        StudentEntity student = studentConverter.convertToEntity(studentDto);
        return studentConverter.convertToDto(studentRepository.save(new StudentEntity(student.getFirstName(), student.getLastName(), student.getPeselNumber(), student.getCollegeId(), student.getFieldOfStudy(), student.getGrades(), student.isActive())));
    }

    public ResponseEntity<StudentDto> updateStudentById(@PathVariable("id") long id, @RequestBody StudentDto studentDto) {
        System.out.println("Updating student ID: " + id + "..." + studentDto.toString());
        StudentEntity studentEntity = studentConverter.convertToEntity(studentDto);
        Optional<StudentEntity> studentData = studentRepository.findById(id);

        return getStudentResponseEntity(studentEntity, studentData);
    }

    private ResponseEntity<StudentDto> getStudentResponseEntity(@RequestBody StudentEntity studentEntity, Optional<StudentEntity> studentData) {
        if (studentData.isPresent()) {
            log.info("Student found");

            StudentEntity _studentEntity = studentData.get();
            _studentEntity.setFirstName(studentEntity.getFirstName());
            _studentEntity.setLastName(studentEntity.getLastName());
            _studentEntity.setPeselNumber(studentEntity.getPeselNumber());
            _studentEntity.setCollegeId(studentEntity.getCollegeId());
            _studentEntity.setFieldOfStudy(studentEntity.getFieldOfStudy());
            _studentEntity.setGrades(studentEntity.getGrades());
            _studentEntity.setActive(studentEntity.isActive());

            StudentDto studentDto = studentConverter.convertToDto(studentRepository.save(_studentEntity));

            return new ResponseEntity<>(studentDto, HttpStatus.OK);
        } else {
            log.error("Student not found");

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
