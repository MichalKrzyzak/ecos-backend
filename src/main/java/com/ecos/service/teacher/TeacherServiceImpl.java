package com.ecos.service.teacher;

import com.ecos.dao.TeacherRepository;
import com.ecos.dto.TeacherDto;
import com.ecos.model.TeacherEntity;
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
public class TeacherServiceImpl implements TeacherService<TeacherDto, TeacherEntity>{
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
    }

    public List<TeacherDto> getAll() {
        List<TeacherEntity> teachers = new ArrayList<>(teacherRepository.findAll());

        return teachers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<TeacherDto> getById(Long id) {
        Optional<TeacherEntity> teacher = teacherRepository.findById(id);
        return teacher.map(this::convertToDto);
    }

    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        teacherRepository.deleteById(id);
        return new ResponseEntity<>("Teacher has been deleted successfully", HttpStatus.OK);
    }

    public TeacherDto create(@RequestBody TeacherDto teacherDto) {
        TeacherEntity teacher = convertToEntity(teacherDto);
        return convertToDto(teacherRepository.save(teacher));
    }

    public ResponseEntity<TeacherDto> updateById(@PathVariable("id") Long id, @RequestBody TeacherDto teacherDto) {
        System.out.println("Updating teacher ID: " + id + "..." + teacherDto.toString());
        TeacherEntity teacherEntity = convertToEntity(teacherDto);
        Optional<TeacherEntity> teacherData = teacherRepository.findById(id);

        return getResponseEntity(teacherEntity, teacherData);
    }

    @Override
    public ResponseEntity<TeacherDto> getResponseEntity(@RequestBody TeacherEntity teacherEntity, Optional<TeacherEntity> teacherData) {
        if (teacherData.isPresent()) {
            log.info("Teacher found");

            TeacherEntity _teacherEntity = teacherData.get();
            _teacherEntity.setPersonalData(teacherEntity.getPersonalData());
            _teacherEntity.setEmail(teacherEntity.getEmail());
            _teacherEntity.setCorrespondenceAddress(teacherEntity.getCorrespondenceAddress());
            _teacherEntity.setClasses(teacherEntity.getClasses());
            _teacherEntity.setActive(teacherEntity.isActive());

            TeacherDto teacherDto = convertToDto(teacherRepository.save(_teacherEntity));

            return new ResponseEntity<>(teacherDto, HttpStatus.OK);
        } else {
            log.error("Teacher not found");

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public TeacherEntity convertToEntity(TeacherDto teacherDto) {
        return modelMapper.map(teacherDto, TeacherEntity.class);
    }

    @Override
    public TeacherDto convertToDto(TeacherEntity teacherEntity) {
        return modelMapper.map(teacherEntity, TeacherDto.class);
    }
}
