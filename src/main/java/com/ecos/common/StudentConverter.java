package com.ecos.common;

import com.ecos.dto.StudentDto;
import com.ecos.model.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentConverter implements BaseConverter<StudentEntity, StudentDto> {
    private FieldOfStudyConverter fieldOfStudyConverter;
    private GradeConverter gradeConverter;

    public StudentConverter(FieldOfStudyConverter fieldOfStudyConverter, GradeConverter gradeConverter) {
        this.fieldOfStudyConverter = fieldOfStudyConverter;
        this.gradeConverter = gradeConverter;
    }

    @Override
    public StudentDto convertToDto(StudentEntity entity) {
        StudentDto studentDto = new StudentDto();

        studentDto.setId(entity.getId());
        studentDto.setFirstName(entity.getFirstName());
        studentDto.setLastName(entity.getLastName());
        studentDto.setPeselNumber(entity.getPeselNumber());
        studentDto.setCollegeId(entity.getCollegeId());
        studentDto.setFieldOfStudy(fieldOfStudyConverter.convertToDto(entity.getFieldOfStudy()));
        studentDto.setGrades(entity.getGrades().stream()
                .map(gradeConverter::convertToDto)
                .collect(Collectors.toList()));
        studentDto.setActive(entity.isActive());
        return studentDto;
    }

    @Override
    public StudentEntity convertToEntity(StudentDto dto) {
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId(dto.getId());
        studentEntity.setFirstName(dto.getFirstName());
        studentEntity.setLastName(dto.getLastName());
        studentEntity.setPeselNumber(dto.getPeselNumber());
        studentEntity.setCollegeId(dto.getCollegeId());
        studentEntity.setFieldOfStudy(fieldOfStudyConverter.convertToEntity(dto.getFieldOfStudy()));
        studentEntity.setGrades(dto.getGrades().stream()
                .map(gradeConverter::convertToEntity)
                .collect(Collectors.toList()));
        studentEntity.setActive(dto.isActive());
        return studentEntity;
    }
}
