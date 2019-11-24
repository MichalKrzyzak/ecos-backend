package com.ecos.service;

import com.ecos.common.BaseConverter;
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
public class StudentService implements BaseConverter<StudentEntity, StudentDto> {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudents() {
        List<StudentEntity> studentEntities = new ArrayList<>(studentRepository.findAll());

        return studentEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<StudentDto> getStudentById(long id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        return studentEntity.map(this::convertToDto);
    }

    public ResponseEntity<String> deleteStudentById(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        StudentEntity studentEntity = convertToEntity(studentDto);
        return convertToDto(studentRepository.save(new StudentEntity(studentEntity.getFirstName(), studentEntity.getLastName(), studentEntity.getPeselNumber(), studentEntity.getCollegeId(), studentEntity.getFieldOfStudy(), studentEntity.isActive(), studentEntity.getYearOfStudy())));
    }

    public ResponseEntity<StudentDto> updateStudentById(@PathVariable("id") long id, @RequestBody StudentDto studentDto) {
        System.out.println("Updating student ID: " + id + "..." + studentDto.toString());
        StudentEntity studentEntity = convertToEntity(studentDto);
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
            _studentEntity.setActive(studentEntity.isActive());
            _studentEntity.setYearOfStudy(studentEntity.getYearOfStudy());

            StudentDto studentDto = convertToDto(studentRepository.save(_studentEntity));

            return new ResponseEntity<>(studentDto, HttpStatus.OK);
        } else {
            log.error("Student not found");

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public StudentDto convertToDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setFirstName(studentEntity.getFirstName());
        studentDto.setLastName(studentEntity.getLastName());
        studentDto.setFieldOfStudy(studentEntity.getFieldOfStudy());
        studentDto.setPeselNumber(studentEntity.getPeselNumber());
        studentDto.setCollegeId(studentEntity.getCollegeId());
        studentDto.setActive(studentEntity.isActive());
        studentDto.setYearOfStudy(studentEntity.getYearOfStudy());
        return studentDto;
    }

    @Override
    public StudentEntity convertToEntity(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDto.getId());
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setFieldOfStudy(studentDto.getFieldOfStudy());
        studentEntity.setPeselNumber(studentDto.getPeselNumber());
        studentEntity.setCollegeId(studentDto.getCollegeId());
        studentEntity.setActive(studentDto.isActive());
        studentEntity.setYearOfStudy(studentDto.getYearOfStudy());
        return studentEntity;
    }
}
