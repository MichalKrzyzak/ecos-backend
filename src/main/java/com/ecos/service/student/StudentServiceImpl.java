package com.ecos.service.student;

import com.ecos.dao.StudentRepository;
import com.ecos.dto.StudentDto;
import com.ecos.model.StudentEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
public class StudentServiceImpl implements StudentService<StudentDto, StudentEntity> {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentEntity> students = new ArrayList<>(studentRepository.findAll());

        return students.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDto> getById(Long id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        return student.map(this::convertToDto);
    }

    @Override
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);
    }

    @Override
    public StudentDto create(@RequestBody StudentDto studentDto) {
        StudentEntity student = convertToEntity(studentDto);
        return convertToDto(studentRepository.save(student));
    }

    @Override
    public ResponseEntity<StudentDto> updateById(@PathVariable("id") Long id, @RequestBody StudentDto studentDto) {
        System.out.println("Updating student ID: " + id + "..." + studentDto.toString());
        StudentEntity studentEntity = convertToEntity(studentDto);
        Optional<StudentEntity> studentData = studentRepository.findById(id);

        return getResponseEntity(studentEntity, studentData);
    }

    @Override
    public ResponseEntity<StudentDto> getResponseEntity(@RequestBody StudentEntity studentEntity, Optional<StudentEntity> studentData) {
        if (studentData.isPresent()) {
            log.info("Student found");

            StudentEntity _studentEntity = studentData.get();
            _studentEntity.setPersonalData(studentEntity.getPersonalData());
            _studentEntity.setEmail(studentEntity.getEmail());
            _studentEntity.setCorrespondenceAddress(studentEntity.getCorrespondenceAddress());
            _studentEntity.setCollegeId(studentEntity.getCollegeId());
            _studentEntity.setYearOfStudy(studentEntity.getYearOfStudy());
            _studentEntity.setStudentsGroup(studentEntity.getStudentsGroup());
            _studentEntity.setFieldsOfStudy(studentEntity.getFieldsOfStudy());
            _studentEntity.setClasses(studentEntity.getClasses());
            _studentEntity.setGrades(studentEntity.getGrades());
            _studentEntity.setActive(studentEntity.isActive());

            StudentDto studentDto = convertToDto(studentRepository.save(_studentEntity));

            return new ResponseEntity<>(studentDto, HttpStatus.OK);
        } else {
            log.error("Student not found");

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public StudentEntity convertToEntity(StudentDto studentDto) {
        return modelMapper.map(studentDto, StudentEntity.class);
    }

    @Override
    public StudentDto convertToDto(StudentEntity studentEntity) {
        return modelMapper.map(studentEntity, StudentDto.class);
    }
}
