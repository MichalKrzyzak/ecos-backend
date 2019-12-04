package com.ecos.service;

import com.ecos.common.BaseConverter;
import com.ecos.dto.FieldOfStudyDto;
import com.ecos.dto.StudentDto;
import com.ecos.model.FieldOfStudyEntity;
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
    private final FieldOfStudyService fieldOfStudyService;

    public StudentService(StudentRepository studentRepository, FieldOfStudyService fieldOfStudyService) {
        this.studentRepository = studentRepository;
        this.fieldOfStudyService = fieldOfStudyService;
    }

    public List<StudentDto> getAllStudents() {
        List<StudentEntity> students = new ArrayList<>(studentRepository.findAll());

        return students.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<StudentDto> getStudentById(long id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        return student.map(this::convertToDto);
    }

    public ResponseEntity<String> deleteStudentById(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        StudentEntity student = convertToEntity(studentDto);
        return convertToDto(studentRepository.save(new StudentEntity(student.getFirstName(), student.getLastName(), student.getPeselNumber(), student.getCollegeId(), student.getFieldOfStudy(), student.isActive(), student.getYearOfStudy())));
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
        FieldOfStudyDto fieldOfStudyDto = fieldOfStudyService.convertToDto(studentEntity.getFieldOfStudy());

        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setFirstName(studentEntity.getFirstName());
        studentDto.setLastName(studentEntity.getLastName());
        studentDto.setFieldOfStudy(fieldOfStudyDto);
        studentDto.setPeselNumber(studentEntity.getPeselNumber());
        studentDto.setCollegeId(studentEntity.getCollegeId());
        studentDto.setActive(studentEntity.isActive());
        studentDto.setYearOfStudy(studentEntity.getYearOfStudy());
        return studentDto;
    }

    @Override
    public StudentEntity convertToEntity(StudentDto studentDto) {
        FieldOfStudyEntity fieldOfStudyEntity = fieldOfStudyService.convertToEntity(studentDto.getFieldOfStudy());

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDto.getId());
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setFieldOfStudy(fieldOfStudyEntity);
        studentEntity.setPeselNumber(studentDto.getPeselNumber());
        studentEntity.setCollegeId(studentDto.getCollegeId());
        studentEntity.setActive(studentDto.isActive());
        studentEntity.setYearOfStudy(studentDto.getYearOfStudy());
        return studentEntity;
    }
}
