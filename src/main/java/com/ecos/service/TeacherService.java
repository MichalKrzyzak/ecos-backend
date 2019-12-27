package com.ecos.service;

import com.ecos.common.BaseConverter;
import com.ecos.dto.FieldOfStudyDto;
import com.ecos.dto.TeacherDto;
import com.ecos.model.FieldOfStudyEntity;
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
public class TeacherService implements BaseConverter<TeacherEntity, TeacherDto> {
    private final TeacherRepository teacherRepository;
    private final FieldOfStudyService fieldOfStudyService;

    public TeacherService(TeacherRepository teacherRepository, FieldOfStudyService fieldOfStudyService) {
        this.teacherRepository = teacherRepository;
        this.fieldOfStudyService = fieldOfStudyService;
    }

    public List<TeacherDto> getAllTeachers() {
        List<TeacherEntity> teachers = new ArrayList<>(teacherRepository.findAll());

        return teachers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<TeacherDto> getTeacherById(long id) {
        Optional<TeacherEntity> teacher = teacherRepository.findById(id);
        return teacher.map(this::convertToDto);
    }

    public ResponseEntity<String> deleteTeacherById(@PathVariable("id") long id) {
        teacherRepository.deleteById(id);
        return new ResponseEntity<>("Teacher has been deleted successfully", HttpStatus.OK);
    }

    public TeacherDto createTeacher(@RequestBody TeacherDto teacherDto) {
        TeacherEntity teacher = convertToEntity(teacherDto);
        return convertToDto(teacherRepository.save(new TeacherEntity(teacher.getFirstName(), teacher.getLastName(), teacher.getPeselNumber(), teacher.getTeacherRole(), teacher.getFieldOfStudy())));
    }

    public ResponseEntity<TeacherDto> updateTeacherById(@PathVariable("id") long id, @RequestBody TeacherDto teacherDto) {
        System.out.println("Updating teacher ID: " + id + "..." + teacherDto.toString());
        TeacherEntity teacherEntity = convertToEntity(teacherDto);
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
            _teacherEntity.setFieldOfStudy(teacherEntity.getFieldOfStudy());
            _teacherEntity.setActive(teacherEntity.isActive());

            TeacherDto teacherDto = convertToDto(teacherRepository.save(_teacherEntity));

            return new ResponseEntity<>(teacherDto, HttpStatus.OK);
        } else {
            log.error("Teacher not found");

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public TeacherDto convertToDto(TeacherEntity teacherEntity) {
        FieldOfStudyDto fieldOfStudyDto = fieldOfStudyService.convertToDto(teacherEntity.getFieldOfStudy());

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacherEntity.getId());
        teacherDto.setFirstName(teacherEntity.getFirstName());
        teacherDto.setLastName(teacherEntity.getLastName());
        teacherDto.setPeselNumber(teacherEntity.getPeselNumber());
        teacherDto.setTeacherRole(teacherEntity.getTeacherRole());
        teacherDto.setFieldOfStudy(fieldOfStudyDto);
        teacherDto.setActive(teacherEntity.isActive());
        return teacherDto;
    }

    @Override
    public TeacherEntity convertToEntity(TeacherDto teacherDto) {
        FieldOfStudyEntity fieldOfStudyEntity = fieldOfStudyService.convertToEntity(teacherDto.getFieldOfStudy());

        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(teacherDto.getId());
        teacherEntity.setFirstName(teacherDto.getFirstName());
        teacherEntity.setLastName(teacherDto.getLastName());
        teacherEntity.setPeselNumber(teacherDto.getPeselNumber());
        teacherEntity.setTeacherRole(teacherDto.getTeacherRole());
        teacherEntity.setFieldOfStudy(fieldOfStudyEntity);
        teacherEntity.setActive(teacherDto.isActive());
        return teacherEntity;
    }
}
