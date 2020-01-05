package com.ecos.service;

import com.ecos.common.TeacherConverter;
import com.ecos.dto.TeacherDto;
import com.ecos.model.TeacherEntity;
import com.ecos.repository.TeacherRepository;
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
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherConverter teacherConverter;

    public TeacherService(TeacherRepository teacherRepository, TeacherConverter teacherConverter) {
        this.teacherRepository = teacherRepository;
        this.teacherConverter = teacherConverter;
    }

    public List<TeacherDto> getAllTeachers() {
        List<TeacherEntity> teachers = new ArrayList<>(teacherRepository.findAll());

        return teachers.stream()
                .map(teacherConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<TeacherDto> getTeacherById(long id) {
        Optional<TeacherEntity> teacher = teacherRepository.findById(id);
        return teacher.map(teacherConverter::convertToDto);
    }

    public ResponseEntity<String> deleteTeacherById(@PathVariable("id") long id) {
        teacherRepository.deleteById(id);
        return new ResponseEntity<>("Teacher has been deleted successfully", HttpStatus.OK);
    }

    public TeacherDto createTeacher(@RequestBody TeacherDto teacherDto) {
        TeacherEntity teacher = teacherConverter.convertToEntity(teacherDto);
        return teacherConverter.convertToDto(teacherRepository.save(new TeacherEntity(teacher.getFirstName(), teacher.getLastName(), teacher.getPeselNumber(), teacher.isActive(), teacher.getFieldOfStudy())));
    }

    public ResponseEntity<TeacherDto> updateTeacherById(@PathVariable("id") long id, @RequestBody TeacherDto teacherDto) {
        System.out.println("Updating teacher ID: " + id + "..." + teacherDto.toString());
        TeacherEntity teacherEntity = teacherConverter.convertToEntity(teacherDto);
        Optional<TeacherEntity> teacherData = teacherRepository.findById(id);

        return getTeacherResponseEntity(teacherEntity, teacherData);
    }

    private ResponseEntity<TeacherDto> getTeacherResponseEntity(@RequestBody TeacherEntity teacherEntity, Optional<TeacherEntity> teacherData) {
        if (teacherData.isPresent()) {
            log.info("Teacher found");

            TeacherEntity _teacherEntity = teacherData.get();
            _teacherEntity.setFirstName(teacherEntity.getFirstName());
            _teacherEntity.setLastName(teacherEntity.getLastName());
            _teacherEntity.setPeselNumber(teacherEntity.getPeselNumber());
            _teacherEntity.setActive(teacherEntity.isActive());

            TeacherDto teacherDto = teacherConverter.convertToDto(teacherRepository.save(_teacherEntity));

            return new ResponseEntity<>(teacherDto, HttpStatus.OK);
        } else {
            log.error("Teacher not found");

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
